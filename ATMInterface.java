package Task_03;
import java.io.*;
import java.util.*;
import java.time.*;

public class ATMInterface {
    public static void main(String[] args) {
        System.out.println("Welcome to the ATM.");
        System.out.println("Enter (1) to sign up");
        System.out.println("Enter (2) to sign in");
        System.out.println("Enter 'done' to exit");
        /* textfile's name is username
         * last line is latest balance, current balance amount
         * date transaction amount
         */
        String username="";
        String password1="";
        String previousInfo = "";
        boolean signedIn = false;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an option: ");
        String option = sc.next();
        while (!option.equalsIgnoreCase("done")){
            if (option.equalsIgnoreCase("1")){
                System.out.println("Enter your username: ");
                sc.nextLine();
                username = sc.nextLine();
                System.out.println("Create a password: ");
                password1 = sc.nextLine();
                System.out.println("Confirm your password: ");
                String password2 = sc.nextLine();
                if (password1.equals(password2)){
                    try {
                        String fileName = "Task_03\\"+username+".txt";
                        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                        writer.write("Password "+password1+"\n");
                        writer.write("Current Balance: "+0.0+"\n");    
                        writer.close();
                        String error = "Account created successfully.";
                        String dashes = String.join("", Collections.nCopies(error.length(), "-"));
                        System.out.println(error+"\n"+dashes);
                        signedIn = true;
                    } catch (Exception e) {
                        String error = "Account creation unsuccessful. Please try again.";
                        String dashes = String.join("", Collections.nCopies(error.length(), "-"));
                        System.out.println(error+"\n"+dashes);                        
                    }                        
                }  

            }
            else if (option.equalsIgnoreCase("2")){
                System.out.println("Enter your username: ");
                sc.nextLine();
                username = sc.nextLine();
                System.out.println("Enter your password: ");
                password1 = sc.nextLine();                
                try {
                    String fileName = "Task_03\\"+username+".txt";
                    BufferedReader reader = new BufferedReader(new FileReader(fileName));
                    String line;
                    String password2;
                    while ((line=reader.readLine())!=null){
                        if (line.contains("Password")){
                            password2 = line.substring(line.indexOf(" ")+1);
                            if (password1.equals(password2)) { 
                            signedIn = true;
                            System.out.println("Password is correct.");
                            display("Welcome "+username);                           
                            }
                            else {
                                display("Password is incorrect. Please try again.");                             
                            }
                        }
                    }
                    reader.close();
                } catch (Exception e) {
                    System.out.println("Error! That user does not exist. Please try again");
                    display("Password is incorrect. Please try again.");                   
                }
            }
            else if (option.equalsIgnoreCase("3")){
                if (signedIn==true){
                    System.out.print("Enter amount to withdraw: R");
                    double withdrawal = sc.nextDouble();

                    try {
                        String fileName = "Task_03\\"+username+".txt";
                        BufferedReader reader = new BufferedReader(new FileReader(fileName));
                        String line;
                        double balance = 0;
                        while ((line=reader.readLine())!=null){
                            previousInfo += line+"\n";
                            if (line.contains("Current Balance")){
                                balance = Double.parseDouble(line.substring(line.indexOf(":")+2));                            
                            }
                            if (balance>=withdrawal) { 
                                balance=balance-withdrawal;
                                System.out.println("R"+withdrawal+" has been succesfully been withdrawn.");  
                                display("Your new balance is R"+balance);
                                reader.close();

                                try {
                                    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));                                    
                                    LocalDate currentDate = LocalDate.now(); 
                                    writer.write(previousInfo);
                                    writer.write(currentDate+" Withdrawal "+withdrawal+"\n");
                                    writer.write("Current Balance: "+balance+"\n");
                                    writer.close();
                                } catch (Exception e) {
                                    display("Transaction was not recorded successfully."); 
                                }
                            }
                            else display("Transaction unsuccessful due too insufficient funds.");                            
                        }                                
                    } catch (Exception e) {
                        display("Transaction was not recorded successfully."); 

                    }
                }
                else {
                    display("Error! You are not signed. So you cannot access these features. Please sign in first");
                }
            }
            else {
                display("Invalid option! Please enter an option between 1..6");
            }
            
            if (signedIn == true){
                System.out.println("Enter (3) for a withdrawal");
                System.out.println("Enter (4) for a deposit");
                System.out.println("Enter (5) to check the balanace");
                System.out.println("Enter (6) for bank statement");
                System.out.println("Enter 'done' to exit");
            } else {
                System.out.println("Enter (1) to sign up");
                System.out.println("Enter (2) to sign in");
                System.out.println("Enter 'done' to exit");                
            }

            System.out.print("Enter an option: ");
            option = sc.next();
        }
        sc.close();
   

    } //main
    public static void display(String error){
        String dashes = String.join("", Collections.nCopies(error.length(), "-"));
        System.out.println(error+"\n"+dashes);
    } //display method
} //class
