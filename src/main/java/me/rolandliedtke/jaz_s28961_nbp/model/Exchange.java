package me.rolandliedtke.jaz_s28961_nbp.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Currency;
import java.util.Date;

@Entity
public class Exchange {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID kursu", example = "1")
    @Id
    private Long id;
    @Schema(description = "Waluta", example = "PLN")
    private Currency currency;
    @Schema(description = "Początek przedziału", example = "2022-04-19")
    private LocalDate dataStart;
    @Schema(description = "Koniec przedziału", example = "2022-04-25")
    private LocalDate dataStop;
    @Schema(description = "Wyliczony kurs", example = "4.55")
    private Double rate;
    @Schema(description = "Data i czas zapytania", example = "2024-06-29T16:46:57.886662")
    private LocalDateTime localDateTime = LocalDateTime.now();

    public Exchange(Currency currency, LocalDate dataStart, LocalDate dataStop) {
        this.currency = currency;
        this.dataStart = dataStart;
        this.dataStop = dataStop;
    }

    public Exchange() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public LocalDate getDataStart() {
        return dataStart;
    }

    public void setDataStart(LocalDate dataStart) {
        this.dataStart = dataStart;
    }

    public LocalDate getDataStop() {
        return dataStop;
    }

    public void setDataStop(LocalDate dataStop) {
        this.dataStop = dataStop;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
