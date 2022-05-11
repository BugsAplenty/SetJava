import java.util.Date;

public class Person implements Comparable{
    private int id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    public Person(int id, String firstName, String lastName, Date dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public int compareTo(Object o) {
        Person other = (Person) o;
        String idString = Integer.toString(getId());
        String idStringOther = Integer.toString(other.getId());
        return idString.compareTo(idStringOther);
    }
}
