package br.com.lab.impacta.investment.domain.service.impl;

import br.com.lab.impacta.investment.domain.exception.InvestmentAccountIsNotDebitedException;
import br.com.lab.impacta.investment.domain.exception.InvestmentProductNotFoundException;
import br.com.lab.impacta.investment.domain.model.Investment;
import br.com.lab.impacta.investment.domain.model.Product;
import br.com.lab.impacta.investment.domain.service.InvestmentService;
import br.com.lab.impacta.investment.infrastructure.repository.InvestmentRepository;
import br.com.lab.impacta.investment.infrastructure.repository.ProductRepository;
import br.com.lab.impacta.investment.integration.AccountIntegration;
import br.com.lab.impacta.investment.integration.valueobject.AccountBalanceVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InvestmentServceImpl implements InvestmentService {

    private final ProductRepository productRepository;

    private final InvestmentRepository investmentRepository;

    private final AccountIntegration accountIntegration;

    @Override
    public Investment invest(Long productId, Long accountId, Double valueOfInvestment) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new InvestmentProductNotFoundException());

        Investment investment = new Investment(productId, accountId, valueOfInvestment);

        AccountBalanceVO accountBalanceVO = accountIntegration.getAccountBalanceById(accountId);
        investment.checkSufficientBalanceForInvestment(accountBalanceVO.getBalance());
        investment.verifyProductPrivateOrDefaultForInvestment(accountBalanceVO.getBalance(), product);

        boolean isDebitted = accountIntegration.debitAccount(accountId, investment.getValue());

        if (!isDebitted) {
            throw new InvestmentAccountIsNotDebitedException();
        }

        return investmentRepository.save(investment);
    }
}
