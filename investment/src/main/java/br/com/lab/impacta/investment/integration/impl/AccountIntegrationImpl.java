package br.com.lab.impacta.investment.integration.impl;

import br.com.lab.impacta.investment.infrastructure.http.AccountClient;
import br.com.lab.impacta.investment.integration.AccountIntegration;
import br.com.lab.impacta.investment.integration.dto.request.DebitAccountRequest;
import br.com.lab.impacta.investment.integration.valueobject.AccountBalanceVO;
import br.com.lab.impacta.investment.integration.valueobject.DebitAccountVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountIntegrationImpl implements AccountIntegration {

    private final AccountClient accountClient;

    @Override
    public AccountBalanceVO getAccountBalanceById(long accountId) {
        AccountBalanceVO accountBalanceVO = accountClient.getAccountBalance(accountId);

        return accountBalanceVO;
    }

    @Override
    public boolean debitAccount(Long accountId, Double valueOfDebit) {
        DebitAccountVO debitAccountVO = accountClient.debit(accountId, new DebitAccountRequest(valueOfDebit));
        return debitAccountVO.isDebited();
    }
}
