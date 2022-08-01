import builders.*;

import java.math.BigDecimal;

public class BankClasses {
    public static void main (String[] args){
        Transactions transactions = new Transactions();
        Transaction transaction1 = new DepositTransaction(new Money(new BigDecimal(1.333)));
        Transaction transaction2 = new DepositTransaction(new Money(new BigDecimal(7.6666)));
        Transaction transaction3 = new WithdrawTransaction(new Money(new BigDecimal(5.6666)));
        transactions.record(transaction1);
        transactions.record(transaction2);
        transactions.record(transaction3);
        Account account = new Account(transactions);

        System.out.println(account.balance());
        System.out.println(account.transactions());

//        Scanner sc = new Scanner(System. in);
//        System.out.println("-----------choisir un chiffre qui correspond à l'opération volue---------");
//        System.out.println("1- Débiter");
//        System.out.println("2- Déposer");
//        System.out.println("3- Voir des transactions");
//        int choix = sc. nextInt();
//        switch(choix){
//            case 1:
//
//                break;
//            case 2:
//                System.out.println("Hello");
//                break;
//
//            case 3:
//                System.out.println("Buenos dias");
//                break;
//            default:
//                System.out.println("Choix incorrect");
//                break;
//        }

    }


}

