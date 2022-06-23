package br.com.lab.impacta.investment.integration;

import br.com.lab.impacta.investment.integration.valueobject.AccountBalanceVO;

public interface AccountIntegration {

    AccountBalanceVO getAccountBalanceById(long accountId);

    boolean debitAccount(Long accountId, Double valueOfDebit);
}
