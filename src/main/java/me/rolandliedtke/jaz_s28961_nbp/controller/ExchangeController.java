package me.rolandliedtke.jaz_s28961_nbp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.rolandliedtke.jaz_s28961_nbp.service.ExchangeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Currency;

@RestController
@Tag(name = "jaz-s28961-nbp", description = "Projekt zaliczeniowy z przedmiotu JAZ")
public class ExchangeController {

    private final ExchangeService exchangeService;

    public ExchangeController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @Operation(summary = "Oblicza średni kurs waluty z podanego przedziału")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Exchange was returned"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
            @ApiResponse(responseCode = "404", description = "Exchange not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping("/{currency}")
    public ResponseEntity<Currency> getString(@PathVariable Currency currency) {
        return ResponseEntity.ok(currency);
    }

}
