package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installments {
    private LocalDate duoDate;
    private Double amount;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Installments(){}
    
    public Installments(LocalDate duoDate, Double amount) {
        this.duoDate = duoDate;
        this.amount = amount;
    }

    public LocalDate getDuoDate() {
        return duoDate;
    }

    public void setDuoDate(LocalDate duoDate) {
        this.duoDate = duoDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString(){
        return duoDate.format(dtf) + " - " + amount;
    }
}
