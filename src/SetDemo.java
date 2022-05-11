import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SetDemo {
    private static final int MAX_VALUE = 100;
    private static final int MIN_VALUE = 0;
    private static final int NUM_VALUES = 10;
    public static void main(String[] args) {
        Set<Integer> set1 = new Set<>(generateRandomInts(NUM_VALUES, MIN_VALUE, MAX_VALUE));
        Set<Integer> set2 = new Set<>(generateRandomInts(NUM_VALUES, MIN_VALUE, MAX_VALUE));
        Set<Integer> set3 = new Set<>(generateRandomInts(NUM_VALUES, MIN_VALUE, MAX_VALUE));

        // Step 1 - Display all sets:
        System.out.println("--- Display all sets: ---");
        System.out.println(set1.toString());
        System.out.println(set2.toString());
        System.out.println(set3.toString());

        // Step 2 - Display union of set 1 with set 2:
        System.out.println("--- Display union of set 1 with set 2: ---");
        Set<Integer> union = set1.union(set2);
        System.out.println(union.toString());

        // Step 3 - Display intersection of the union above with set 3:
        System.out.println("--- Display intersection of previous union with set 3: ---");
        Set<Integer> intersection = union.intersect(set3);
        System.out.println(intersection.toString());

        // Step 4 - Create set 4 from 2 user inputs and check if it is a subset of one of the sets 1-3:
        System.out.println("--- Create set 4 from 2 user inputs and check if it's a subset of sets 1-3: ---");
        Set<Integer> set4 = new Set<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        int num1 = Integer.parseInt(sc.nextLine());
        set4.insert(num1);
        System.out.println("Enter the second number: ");
        int num2 = Integer.parseInt(sc.nextLine());
        set4.insert(num2);

        System.out.println("Set 1 - " + set1.isSuperset(set4));
        System.out.println("Set 1 - " + set2.isSuperset(set4));
        System.out.println("Set 1 - " + set3.isSuperset(set4));

        // Step 5 - Get integer from user, check whether it is a member of set1, add it to set2 and remove it from set 3:
        System.out.println("--- Get integer from user, check whether it is a member of set 1, add it to set 2 and remove it from set 3: ---");
        System.out.println("Enter number: ");
        int num3 = Integer.parseInt(sc.nextLine());
        System.out.println("Is the number a member of set 1? - " + set1.contains(num3));
        set2.insert(num3);
        System.out.println("Set 2 after adding the number: " + set2);
        set3.delete(num3);
        System.out.println("Set 3 after removing the number: " + set3);
    }
    public static ArrayList<Integer> generateRandomInts(int n, int min, int max) {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        while (list.size() < n) {
            int newInt = random.nextInt(max-min) + min;
            if(!list.contains(newInt)) {
                list.add(newInt);
            }
        }
        return list;
    }
}
