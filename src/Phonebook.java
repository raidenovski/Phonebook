/**
 * Created by raiden on 3/4/17.
 */

import java.beans.IndexedPropertyChangeEvent;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;

public class Phonebook {

    private ArrayList<Contact> contactList;
    // ArrayList<String> menuOptions = new ArrayList<>();
    static Scanner nameInput = new Scanner(System.in);
    static Scanner numInput = new Scanner(System.in);

    // why this doesn't work?
    /*String option1 = " 1 - Add a contact"; menuOptions.add(option1);
    String option2 = " 2 - Remove a contact";
    String option3 = " 3 - Find a contact";
    String option4 = " 4 - List all contacts";
    String option5 = " 5 Dial a contact";*/

    public Phonebook() {

        contactList = new ArrayList<>();
        System.out.println("Welcome to your phonebook");
        mainMenu();
    }

    public void mainMenu() {
        System.out.println("Choose an option bellow:");
        System.out.println();
        System.out.println(" 1 - Add a contact");
        System.out.println(" 2 - Remove a contact");
        System.out.println(" 3 - Find a contact");
        System.out.println(" 4 - List all contacts");
        System.out.println(" 5 - Dial a contact");
        System.out.println();
        System.out.print("Select by number:");

        int option = numInput.nextInt();

        switch (option) {
            case 1: addContact(); break;
            case 2: removeContact(); break;
            case 3: findContact(); break;
            case 4: listAll(); break;
            case 5: dialContact(); break;
            default: return;
        }
        mainMenu();
    }

    public void addContact() {

        String contactName = addContactName();

        int contactNum = addContactNumber();

        contactList.add(new Contact(contactName, contactNum));
        System.out.println(contactNum + " is added to " + contactName);
    }

    private String addContactName() {
        String contactName;

        while(true) {
            System.out.print("Contact name: ");
            contactName = nameInput.nextLine();

            if (!(contactName.matches("([A-Za-z]{2,30})"))) {
                System.out.println("Invalid name. Please try again");
                continue;
            }
            break;
        }
        return contactName;
    }

    private int addContactNumber() {
        int contactNum = 0;

        while (true) {
            System.out.print("Phone number: ");
            try {
                contactNum = numInput.nextInt();
                int contactNumLength = String.valueOf(contactNum).length();
                if ((contactNumLength < 5) || (contactNumLength > 15)) {
                    System.out.println("Incorrect phone number length. Try again");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid phone number format. Please try again.");
            }
        }
        return contactNum;
    }

    public void removeContact() {
        System.out.println("Removing a contact from the phonebook...");
    }

    public void findContact() {
        System.out.println("Enter to search...");
        String toSearch = nameInput.nextLine().toLowerCase();
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
        } else {
            System.out.println("No results found");
        }

    }

    public void listAll() {
        for (Contact i : contactList) {
            System.out.println(i.getName() + ": " + i.getNumber());
        }
    }

    public void dialContact() {
        System.out.println("Calling a contact...");
    }
}
