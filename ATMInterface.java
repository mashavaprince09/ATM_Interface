package Task_03;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

import javax.annotation.processing.FilerException;
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
                sc.nextLine();
                String username = sc.nextLine();
                System.out.println("Create a password: ");
                String password1 = sc.nextLine();
                System.out.println("Confirm your password: ");
                String password2 = sc.nextLine();
                if (password1.equals(password2)){
                    try {
                        String fileName = "Task_03\\"+username+".txt";
                        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                        writer.write("Password "+password1+"\n");
                        writer.write("Current Balance R"+0.0+"\n");    
                        writer.close();
                        String error = "Account created successfully.";
                        String dashes = String.join("", Collections.nCopies(error.length(), "-"));
                        System.out.println(error+"\n"+dashes);
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
                String username = sc.nextLine();
                System.out.println("Create a password: ");
                String password1 = sc.nextLine();                
                try {
                    String fileName = "Task_03\\"+username+".txt";
                    BufferedReader reader = new BufferedReader(new FileReader(fileName));
                    String line;
                    String password2;
                    while ((line=reader.readLine())!=null){
                        if (line.contains("Password")){
                            password2 = line.substring(line.indexOf(" ")+1);
                            if (password1.equals(password2)) { 
                            System.out.println("Password is correct.");
                            display("Welcome "+username);                           
                            }
                            else {
                                display("Password is incorrect. Please try again.");                             
                            }

                        }
                    }
                } catch (Exception e) {
                    System.out.println("Error! That user does not exist. Please try again");
                    display("Password is incorrect. Please try again.");                   
                }
            }
            else {
                display("Invalid option! Please enter an option between 1..6");
            }
            
            System.out.print("Enter an option: ");
            option = sc.next();
        }
   

    } //main

    public static void display(String error){
        String dashes = String.join("", Collections.nCopies(error.length(), "-"));
        System.out.println(error+"\n"+dashes);
    }
} //class
