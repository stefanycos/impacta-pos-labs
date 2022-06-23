package br.com.lab.impacta.investment.integration.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class DebitAccountRequest {

    private double valueOfDebit;
}
