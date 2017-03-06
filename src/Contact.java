/**
 * Created by raiden on 3/4/17.
 */
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        //if (number != contact.number) return false;
        //return name.equals(contact.name);
        return number == contact.number;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + number;
        return result;
    }
}
