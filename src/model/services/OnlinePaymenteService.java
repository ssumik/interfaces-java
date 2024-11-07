package model.services;

public interface OnlinePaymenteService {
    public Double paymentFee(Double amount);
    public Double interest(Double amount, Integer month);
}
