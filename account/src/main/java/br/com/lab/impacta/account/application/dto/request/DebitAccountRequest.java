package br.com.lab.impacta.account.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
public class DebitAccountRequest {

    @NonNull
    private Double valueOfDebit;

}
