import java.util.Date;
import java.util.Iterator;

public class SetDemo2 {
    public static <T extends Comparable<T>> T getMin(Set<T> set) {
        T min = set.getRandom();
        for (Iterator<T> it = set.iterator(); it.hasNext(); ) {
            T member = it.next();
            if (member.compareTo(min) < 0)  {
                min = member;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        Person person1 = new Person(123456789, "Isaac", "Newton", new Date());
        Person person2 = new Person(987654321, "Bob", "Jones", new Date());
        Person person3 = new Person(192837465, "Barack", "Obama", new Date());
        Person person4 = new Person(564738291, "Dua", "Lipa", new Date());
        Person person5 = new Person(543219876, "Santa", "Claus", new Date());
        Set<Person> set = new Set<>();
        set.insert(person1);
        set.insert(person2);
        set.insert(person3);
        set.insert(person4);
        set.insert(person5);
        Person min = getMin(set);
        System.out.println(min.getFirstName() + " " + min.getLastName());
    }
}
