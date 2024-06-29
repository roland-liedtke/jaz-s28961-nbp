package me.rolandliedtke.jaz_s28961_nbp.service;

import me.rolandliedtke.jaz_s28961_nbp.exception.ExchangeNotFoundException;
import me.rolandliedtke.jaz_s28961_nbp.model.Exchange;
import me.rolandliedtke.jaz_s28961_nbp.repository.ExchangeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Currency;

@Service
public class ExchangeService {
    private final ExchangeRepository exchangeRepository;
    private final RestTemplate restTemplate;

    public ExchangeService(ExchangeRepository exchangeRepository, RestTemplate restTemplate) {
        this.exchangeRepository = exchangeRepository;
        this.restTemplate = restTemplate;
    }

    public Exchange getExchangeRate(Currency currency, LocalDate startDate, LocalDate endDate) {
        String currencyCode = currency.getCurrencyCode();
        exchangeRepository.save(new Exchange(currency, startDate, endDate));
        return restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/A/" + currencyCode + "/" + startDate + "/" + endDate, Exchange.class);
    }
}