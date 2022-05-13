package br.com.lab.impacta.account.api;

import br.com.lab.impacta.account.application.AccountApplication;
import br.com.lab.impacta.account.application.dto.request.DebitAccountRequest;
import br.com.lab.impacta.account.application.dto.response.DebitAccountResponse;
import io.swagger.models.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/accounts")
public class DebitController {

    private final AccountApplication accountApplication;

    @PostMapping("/{accountId}/debit")
    public ResponseEntity<DebitAccountResponse> debit(@PathVariable long accountId, @Validated @RequestBody DebitAccountRequest debitAccountRequest) {
        DebitAccountResponse debitAccountResponse = accountApplication.debit(accountId, debitAccountRequest);
        return ResponseEntity.ok(debitAccountResponse);
    }
}
