package model.application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installments;
import model.services.ContractService;
import model.services.PaypalService;


public class Program {
    public static void main(String[] args) {       
        Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Enter the contract data:");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.next(), fmt);
		System.out.print("Contract value: ");
		double totalValue = sc.nextDouble();

        Contract contract = new Contract(number, date, totalValue);
		System.out.print("Enter the number of installments: ");
		ContractService contractService = new ContractService(new PaypalService());
		contractService.contractProcess(contract, sc.nextInt());
		sc.nextLine();
		System.out.println("Instalments:");
		for (Installments installments : contract.getInstallments()) {
			System.out.println(installments);
		}
		sc.close();
    }
}
