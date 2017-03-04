/**
 * Created by raiden on 3/4/17.
 */

import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;

public class Phonebook {

    private ArrayList<Contact> contactList;
    static Scanner userInput = new Scanner(System.in);

    public Phonebook() {

        contactList = new ArrayList();
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

        int option = userInput.nextInt();

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
        String contactName;
        int contactNum;

        System.out.print("Name: ");
        contactName = userInput.nextLine();
        // userInput.next
        System.out.print("Phone number: ");
        contactNum = userInput.nextInt();
        System.out.println("Adding " + contactName + " to the phonebook. Phone number is " + contactNum);
    }

    public void removeContact() {
        System.out.println("Removing a contact from the phonebook...");
    }

    public void findContact() {
        System.out.println("Looking up for a contact...");
    }

    public void listAll() {
        System.out.println("Listing all contacts...");
    }

    public void dialContact() {
        System.out.println("Calling a contact...");
    }
}
