import com.sg.bank.BankAccount;
import com.sg.bank.Transaction;

public class Main {
    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        System.out.println("Solde actuel: " + account.getBalance());
        account.deposit(1000);
        System.out.println("Solde actuel: " + account.getBalance());
        account.withdraw(500);
        System.out.println("Solde actuel: " + account.getBalance());

        System.out.println("Historique des transactions:");
        for (Transaction transaction : account.getTransactionHistory()) {
            System.out.println(transaction);
        }
    }
}