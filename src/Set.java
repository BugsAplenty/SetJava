import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Set<T> {
    private final ArrayList<T> values;
    public Set() {
        values = new ArrayList<>();
    }
    public Set(ArrayList<T> valueArray) {
        values = new ArrayList<>();
        for (T val: valueArray) {
            insert(val);
        }
    }
    public Set<T> union(Set<T> other) {
        for (T val: other.values) {
            insert(val);
        }
        return this;
    }
    public Set<T> intersect(Set<T> other) {
        Set<T> intersection = new Set<>();
        for (T val: values) {
            if(other.values.contains(val)) {
                intersection.insert(val);
            }
        }
        for (T val: other.values) {
            if(values.contains(val)) {
                intersection.insert(val);
            }
        }
        return intersection;
    }
    public void insert(T val) {
        if (!values.contains(val)) {
            values.add(val);
        }
    }
    public void delete(T val) {
        values.remove(val);
    }
    public int size() {
        return values.size();
    }
    public boolean isSuperset(Set<T> other) {
        if (other.size() <= size()) {
            for(T val: other.values) {
                if (!values.contains(val)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
    public boolean contains(T val) {
        return values.contains(val);
    }
    public Iterator<T> iterator() {
        return values.iterator();
    }
    public String toString() {
        StringBuilder setStringBuilder = new StringBuilder("{");
        for (T val: values) {
            setStringBuilder.append(val.toString()).append(", ");
        }
        setStringBuilder.append("}");
        return setStringBuilder.toString();
    }
    public T getRandom() {
        Random random = new Random();
        return values.get(random.nextInt(values.size()));
    }
}
