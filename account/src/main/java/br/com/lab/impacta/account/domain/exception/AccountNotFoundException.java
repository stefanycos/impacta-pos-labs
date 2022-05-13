package br.com.lab.impacta.account.domain.exception;

import lombok.Getter;

@Getter
public class AccountNotFoundException extends RuntimeException {

    private String description;

    public AccountNotFoundException() {
    }

    public AccountNotFoundException(String message, String description) {
        super(message);
        this.description = description;
    }
}