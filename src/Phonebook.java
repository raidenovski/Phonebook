/**
 * Created by raiden on 3/4/17.
 */

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;

public class Phonebook {

    static Scanner userWordInput = new Scanner(System.in);
    static Scanner userNumInput = new Scanner (System.in);
    ArrayList<String> menuOptions = new ArrayList<>();
    private ArrayList<Contact> contactList;

    String option1 = " 1 - Add a contact";
    String option2 = " 2 - Remove a contact";
    String option3 = " 3 - Find a contact";
    String option4 = " 4 - List all contacts";
    String option5 = " 5 - Dial a contact";
    String option6 = " 6 - Exit the phonebook";

    public Phonebook() {

        contactList = new ArrayList<>();
        System.out.println("Welcome to your phonebook");
        menuOptions.add(option1);
        menuOptions.add(option2);
        menuOptions.add(option3);
        menuOptions.add(option4);
        menuOptions.add(option5);
        menuOptions.add(option6);
        mainMenu();
    }

    public void mainMenu() {
        System.out.println("Choose an option bellow:");
        System.out.println();
        for (String option : menuOptions) {
            System.out.println(option);
        }
        System.out.println();
        System.out.print("Select by number:");

        try {
            int option = userNumInput.nextInt();
            switch (option) {
                case 1: addContact(); break;
                case 2: removeContact(); break;
                case 3: findContact(); break;
                case 4: listAll(); break;
                case 5: dialContact(); break;
                case 6: System.exit(0); break;
                default: return;
            }
        } catch (InputMismatchException e) {
            System.out.println("Please use numbers to select an option");
            userNumInput.nextLine();
        }
        mainMenu();
    }

    public void addContact() {

        String contactName = addContactName();
        int contactNum = addContactNumber();

        contactList.add(new Contact(contactName, contactNum));
        System.out.println(contactNum + " is added to contact " + contactName);
    }

    private String addContactName() {
        String contactName;

        while(true) {
            System.out.print("Contact name: ");
            contactName = userWordInput.nextLine();

            if (!(contactName.matches("([A-Za-z]{2,30})"))) {
                System.out.println("Invalid name. Please try again");
                continue;
            }
            break;
        }
        return contactName;
    }

    private int addContactNumber() {
        int contactNum;

        while (true) {
            System.out.print("Phone number: ");
            try {
                contactNum = userNumInput.nextInt();
                int contactNumLength = String.valueOf(contactNum).length();
                if ((contactNumLength < 6) || (contactNumLength > 15)) {
                    System.out.println("Incorrect phone number length. Try again");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid phone number format. Please try again.");
                userNumInput.next();
            }
        }
        return contactNum;
    }

    public void removeContact() {
        System.out.println("Removing a contact from the phonebook...");
    }

    public void findContact() {
        System.out.print("Enter a name or a number to search: ");
        searchContacts();
    }

    private ArrayList<Contact> searchContacts() {
        String toSearch = userWordInput.nextLine().toLowerCase();
        ArrayList<Contact> searchResults = new ArrayList<>();

        for (Contact i : contactList) {

            if ((i.getName().toLowerCase().contains(toSearch)) || (String.valueOf(i.getNumber()).contains(toSearch))) {
                searchResults.add(i);
            }
        }
        if (searchResults.size() > 0) {
            for (Contact i : searchResults) {
                System.out.println(i.getName() + ": " + i.getNumber());
            }
            if (searchResults.size() > 1) {
                System.out.println(searchResults.size() + " contacts found");
            } else if (searchResults.size() == 1) {
                System.out.println("1 contact found");
            }
        } else {
            System.out.println("No contacts found");
        }
        return searchResults;
    }

    public void listAll() {
        System.out.println("Total contacts in phonebook: " + contactList.size());
        // Make a comparator method to sort contacts by name
        for (Contact i : contactList) {
            System.out.println(i.getName() + ": " + i.getNumber());
        }
    }

    public void dialContact() {
        System.out.print("Enter a name or number to dial: ");
        String numToDial = userWordInput.nextLine();
        for (Contact i : contactList) {
            if ((numToDial.equalsIgnoreCase(i.getName())) || (numToDial.equalsIgnoreCase(String.valueOf(i.getNumber())))) {
                System.out.println("Calling " + i.getName());
                System.out.println("Dialing " + i.getNumber());
                break;
            } else {
                System.out.println("No contacts found by that name/number");
            }
        }
    }
}
