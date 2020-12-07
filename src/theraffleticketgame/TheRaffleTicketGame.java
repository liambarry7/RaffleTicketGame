
package theraffleticketgame;
import java.util.*;
import java.io.*;

public class TheRaffleTicketGame {  
    
    private static ArrayList<String> names = new ArrayList<>();

    private static ArrayList<String> numbers = new ArrayList<>();
    
    private static ArrayList<String> nameNumber = new ArrayList<>();
    
    private static String userName = "";
    
    private static String primeNumbers = "2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97";
    
    
    public static void getNameNumber(){
        Random rand = new Random();
        

        int userNumber = rand.nextInt(100);
        String change = Integer.toString(userNumber);
        numbers.add(change);
        System.out.println("Your number is: " + change);


        nameNumber.add(userName + " " + userNumber);


    }
    
    public static void checkTicket(){
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Please enter your name");
            String nameCheck = input.readLine();

            if (names.contains(nameCheck)) {
                System.out.println("Please enter your ticket number");
                String numberCheck = input.readLine();

                if (primeNumbers.contains(numberCheck)) { //checls if user input is in arraylist
                    System.out.println("You won");
                } else {
                    System.out.println("You did not win");
                }

            } else if (!names.contains(nameCheck)) { //if arraylist doesnt contain user input, then loss
                System.out.println("please try again");
            }
            
        } catch (Exception e) {
            System.out.println("EXCEPTION: ERROR OCCURED");
        }

    }
    
    public static void main(String[] args) {

        boolean valid = true;
        while (valid) {
            try {

                BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

                System.out.println("\nWelcome to my raffle.");
                System.out.println("\n1- Would you like to buy some tickets? \n2- Would you like to check a ticket? \n3- Quit");
                int menuSelection = Integer.parseInt(input.readLine());

                switch (menuSelection) {
                    case (1)://buy ticket

                        System.out.println("Enter name");
                        userName = input.readLine();
                        names.add(userName); //adds input to arraylist names

                        System.out.println("How many tickets do you want?");
                        String times = input.readLine();
                        int time = Integer.parseInt(times);//turn string into integer to be used
                        for (int i = 0; i < time; i++) {
                            getNameNumber();
                        }
                        
                        System.out.print(nameNumber); //prints the array nameNumber
                        break;

                    case (2)://check ticket
                        
                        checkTicket();
                        break;

                    case (3)://quit
                        
                        System.out.println("Thanks for playing.");
                        valid = false;
                        break;

                    default:
                        System.out.println("not a valid choice");
                        break;

                }

            } catch (Exception e) {
                System.out.println("EXCEPTION: ERROR OCCURED");
            }
        }

    }
}

