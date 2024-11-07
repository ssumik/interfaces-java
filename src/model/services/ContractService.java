package model.services;

import java.time.LocalDate;
import model.entities.Contract;
import model.entities.Installments;

public class ContractService {
    private OnlinePaymenteService onlinePaymenteService;
    private LocalDate date;
    private Double amountWithFee;

    public ContractService(OnlinePaymenteService onlinePaymenteService) {
        this.onlinePaymenteService = onlinePaymenteService;
    }

    public void contractProcess(Contract contract, Integer month){
        for(int i = 1; i<=month; i++){
            date = contract.getDate().plusMonths(i);
            amountWithFee = onlinePaymenteService.paymentFee(onlinePaymenteService.interest(contract.getTotalAmount() / month, i));
            contract.getInstallments().add(new Installments(date, amountWithFee));
        }
    }
}
