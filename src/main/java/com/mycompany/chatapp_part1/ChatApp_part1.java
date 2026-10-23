package com.mycompany.chatapp_part1;

import java.util.Scanner;

public class ChatApp_part1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();

        System.out.println("--- User Registration ---");
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        // Register user
        String regStatus = login.registerUser(username, password, firstName, lastName);
        System.out.println(regStatus);

        if (!regStatus.equals("The two above conditions have been met, and the user has been registered successfully.")) {
            System.out.println("Registration failed. Exiting application.");
            return;
        }

        // Login user
        System.out.println("\n--- User Login ---");
        System.out.print("Enter Username: ");
        String loginUsername = scanner.nextLine();

        System.out.print("Enter Password: ");
        String loginPassword = scanner.nextLine();

        boolean isLoggedIn = login.loginUser(loginUsername, loginPassword);
        System.out.println(login.returnLoginStatus(isLoggedIn));

        if (isLoggedIn) {
            // Launch Part 2 QuickChat Menu Loop
            showPart2Menu(scanner);
        } else {
            System.out.println("Login failed. Exiting application.");
        }
    }

    public static void showPart2Menu(Scanner scanner) {
        Message messageHandler = new Message();
        boolean running = true;
        int messageCounter = 1;

        while (running) {
            System.out.println("\n==================================");
            System.out.println("WELCOME TO CHATAPP PART 2");
            System.out.println("==================================");
            System.out.println("1. Send Messages");
            System.out.println("2. Show Disregard Message");
            System.out.println("3. Quit");
            System.out.print("Choose an option: ");

            if (!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter Recipient Cell Number (e.g., +27821234567 or 0821234567): ");
                    String recipient = scanner.nextLine();

                    if (!messageHandler.checkRecipientCell(recipient)) {
                        System.out.println("Invalid recipient number format!");
                        break;
                    }

                    System.out.print("Enter Message Text (Max 250 characters): ");
                    String text = scanner.nextLine();

                    if (!messageHandler.checkMessageLength(text)) {
                        System.out.println("Message exceeds character limit of 250!");
                        break;
                    }

                    String id = messageHandler.generateMessageID();
                    String hash = messageHandler.createMessageHash(messageCounter, id, text);

                    System.out.println("\n--- MESSAGE CREATED SUCCESSFULLY ---");
                    System.out.println("Message ID: " + id);
                    System.out.println("Message Hash: " + hash);
                    System.out.println("Recipient: " + recipient);
                    System.out.println("Message: " + text);
                    
                    messageCounter++;
                    break;

                case 2:
                    System.out.println("Press 0 to disregard message.");
                    break;

                case 3:
                    System.out.println("Exiting application. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please enter 1, 2, or 3.");
            }
        }
    }
}