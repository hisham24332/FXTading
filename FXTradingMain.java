package com.assignment.fxtrading;

import java.util.Scanner;

public class FXTradingMain {
    private static Scanner scanner = new Scanner(System.in);
    private static FXTradingApplication mobilePhone = new FXTradingApplication();

    private static final double getRate = 66.00d;
    private static double rupees;
    private static String customerName ="";
    private static String currencyPair = "";
    private static int amountToTransfer;
    private static String rate="";

    public static void main(String[] args) {

        printActions();
    }

    public static void convertUSDtoINR(int amountToTransfer){
        rupees = amountToTransfer * getRate;
    }

    public static void getRatePrint(){
        System.out.println("\nYou are transferring INR " + rupees + " to " + customerName);
    }

    private static void addNewContact() {
        System.out.println("Enter Customer Name");
        customerName = scanner.next().toUpperCase();
        System.out.println("Enter Currency Pair");
        currencyPair = scanner.next().toUpperCase();

        if(currencyPair.equalsIgnoreCase("usdinr")){
            System.out.println("Enter amount to transfer");
            amountToTransfer = scanner.nextInt();
            convertUSDtoINR(amountToTransfer);
            System.out.println("Do you want to get Rate");
            rate  = scanner.next().toUpperCase();
            if (rate.equalsIgnoreCase("yes")){
                getRatePrint();
            }
        }

        FXTrading newContact = FXTrading.createRecord(customerName, currencyPair, amountToTransfer, rate);
        if (mobilePhone.addNewRecord(newContact)) {

            System.out.println("\nBook/Cancel this trade?");
            System.out.println("1 : Book");
            System.out.println("2 : Cancel");

            int book = scanner.nextInt();
            switch (book)
            {
                case 1 :
                    System.out.println("\nTrade for USDINR has been booked with rate " + getRate + ", The amount of Rs " + rupees + " will be transferred in 2 working days to " + customerName + ".");
                    break;
                case 2 :
                    System.out.println("Trade is Canceled.\n");
                    break;
                default :
                    System.out.println("Invalid Option!! Please Enter Correct Option...");
                    break;
            }
        }
    }

    private static void printActions() {
        char exit = '\0';
        int choice;

        do {
            System.out.println("\n_____________________");
            System.out.println("1 : Book Trade");
            System.out.println("2 : Print Trades");
            System.out.println("3 : Exit\n");

            System.out.println("Choose Your Action : ");
            choice = scanner.nextInt();
            System.out.println("\n");

            switch (choice) {
                case 1 :
                    System.out.println("Book Trade-1");
                    addNewContact();
                    break;

                case 2 :
                    System.out.println("Print Trades-2");
                    mobilePhone.printContacts();
                    break;

                case 3 :
                    System.out.println("Do you really want to exit (Y/N)");
                    exit = scanner.next().charAt(0);

                default :
                    break;
            }
        }
        while(choice != 3 || (exit == 'n'|| exit == 'N'));
        System.out.println("Bye - have a good day");
    }
}