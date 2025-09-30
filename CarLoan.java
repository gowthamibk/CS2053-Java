package edu.bank;

public class CarLoan implements Loan {
    private double rate;

    @Override
    public void getInterestRate(double rate) {
        this.rate = rate;
        System.out.println("Car Loan Interest Rate: " + this.rate + "%");
    }
}
