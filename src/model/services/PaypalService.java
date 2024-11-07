package model.services;

public class PaypalService implements OnlinePaymenteService{

    public Double paymentFee(Double amount) {
        return amount + (amount * 0.02);
    }

    public Double interest(Double amount, Integer month) {
        return amount + (amount * (month * 0.01));
    }

}
