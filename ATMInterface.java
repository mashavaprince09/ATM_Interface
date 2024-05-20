package Task_03;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;
public class ATMInterface {
    public static void main(String[] args) {
        System.out.println("Welcome to the ATM.");
        System.out.println("Enter (1) to sign up");
        System.out.println("Enter (2) to sign in");
        System.out.println("Enter (3) for a withdrawal");
        System.out.println("Enter (4) for a deposit");
        System.out.println("Enter (5) to check the balanace");
        System.out.println("Enter (6) for bank statement");
        System.out.println("Enter 'done' to exit");
        /* textfile's name is username
         * last line is latest balance, current balance: amount
         * date /t transaction \t amount
         */
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an option: ");
        String option = sc.next();
        while (!option.equalsIgnoreCase("done")){
            if (option.equalsIgnoreCase("1")){
                System.out.println("Enter your username: ");
                String username = sc.nextLine();
                sc.nextLine();
                System.out.println("Create a password: ");
                String password1 = sc.nextLine();
                System.out.println("Confirm your password: ");
                String password2 = sc.nextLine();
                if (password1.equals(password2)){
                    try {
                        BufferedWriter writer = new BufferedWriter(new FileWriter(username+".txt"));
                        writer.write("password: "+password1);
                        writer.write("current balance: "+0);    
                        writer.close();
                        System.out.println("Account created successfully.");
                    } catch (Exception e) {
                        System.out.println("Account creation unsuccessful. Please try again.");
                    }
                        
                }                   
            }
            else {
                System.out.println("Invalid option! Please enter an option between 1..6");
            }
            System.out.print("Enter an option: ");
            option = sc.next();
        }
   

    } //main
} //class
