/**
 * Created by raiden on 3/4/17.
 */

import java.util.Comparator;

public class Contact {

    private String name;
    private int number;
    // private String email;

    public Contact(String name, int number){
        this.name = name;
        this.number = number;
        // this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    /*public void setEmail(String email) {
        this.email = email;
    }*/

    public String getName() {
        return this.name;
    }
    public int getNumber() {
        return this.number;
    }
    /*public String getEmail() {
        return this.email;
    }*/

    public static Comparator<Contact> contactComparator = new Comparator<Contact>() {
        @Override
        public int compare(Contact o1, Contact o2) {
            return  (int) (o1.getName().compareTo(o2.getName()));
        }
    };
}
