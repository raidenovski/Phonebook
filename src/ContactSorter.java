import java.util.ArrayList;

/**
 * Created by raiden on 3/10/17.
 */
import java.util.ArrayList;
import java.util.Collections;

public class ContactSorter {
    ArrayList<Contact> contactArrayList = new ArrayList<>();

    public ContactSorter(ArrayList<Contact> contactArrayList) {
        this.contactArrayList = contactArrayList;
    }

    public ArrayList<Contact> getSortedList() {
        Collections.sort(contactArrayList, Contact.contactComparator);
        return contactArrayList;
    }

}
