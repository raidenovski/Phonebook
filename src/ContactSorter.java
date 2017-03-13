import java.util.ArrayList;

/**
 * Created by raiden on 3/10/17.
 */
import java.util.ArrayList;
import java.util.Collections;

public class ContactSorter {

    public static ArrayList<Contact> getSortedList(ArrayList<Contact> contactArrayList) {
        Collections.sort(contactArrayList, Contact.contactComparator);
        return contactArrayList;
    }

}
