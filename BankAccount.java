import java.util.Scanner;
public class BankAccount {
    private double balance;
    public BankAccount(double initialBalance)
    {
       this.balance=initialBalance;
    }
    public double getBalance()
    {
    return balance;
    
}

public void deposit(double amount)
{
    if(amount>0)
    {
        balance+=amount;
        System.out.println("Deposit successful.New balnce:$"+balance);
    }
    else{
        System.out.println("Invalid deposit amount.Please enter a positive value.");
    }
}



public boolean withdraw(double amount)
{
    if(amount>0&&amount<=balance)
    {
        balance-=amount;
        System.out.println("Withdrawal successfull. New balance:$"+balance);
        return true;

    }
    else
    {
        System.out.println("Insufficient funds or invalid amount for withdrawal");
        return false;
   }
}
}
 class ATM{
    private BankAccount userAccount;

     public  ATM(BankAccount userAccount)
    {
        this.userAccount=userAccount;
    }
    public void displayMenu()
    {
        System.out.println("\nATM Menu");
        System.out.println("1.Check Balance");
        System.out.println("2.Deposit");
        System.out.println("3.Withdraw");
        System.out.println("Exit");
    }
    public void processOption(int option,Scanner scanner)
    {
        switch(option)
        {
            case 1:
            System.out.println("Your balance:$"+userAccount.getBalance());
            break;
            case 2:
            System.out.println("Enter deposit amount:$");
            double depositAmount=scanner.nextDouble();
            userAccount.deposit(depositAmount);
            break;
            case 3:
            System.out.println("Enter withdrawalAmount:$");
            double withdrawalAmount=scanner.nextDouble();
            userAccount.withdraw(withdrawalAmount);
            break;
            case 4:
            System.out.println("Thank you for using ATM.Goodbye");
            System.exit(0);
            break;
            default:
            System.out.println("Invalid option.Please choose a valid option");
        }
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter initial balance:$");
        double initialBalance=scanner.nextDouble();
        BankAccount userAccount=new BankAccount(initialBalance);
        ATM atm=new ATM(userAccount);
        
        while(true)
        {
            atm.displayMenu();
            System.out.println("Choose an option(1-4):");
            int option=scanner.nextInt();
            atm.processOption(option,scanner);
        }
        }


       
}
