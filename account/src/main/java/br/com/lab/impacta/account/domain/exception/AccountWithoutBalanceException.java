package br.com.lab.impacta.account.domain.exception;

import lombok.Getter;

public class AccountWithoutBalanceException extends RuntimeException {

    public AccountWithoutBalanceException() {
    }

}
