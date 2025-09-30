import edu.bank.HomeLoan;
import edu.bank.CarLoan;

public class BankMain {
    public static void main(String[] args) {
        HomeLoan hl = new HomeLoan();
        hl.getInterestRate(6.5);

        CarLoan cl = new CarLoan();
        cl.getInterestRate(9.0);
    }
}
