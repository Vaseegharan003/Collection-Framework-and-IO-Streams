import java.util.*;

public class HashSetExample {
    public static void main(String[] args) {
        HashSet<Integer> numbers = new HashSet<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);
        
        System.out.println("Iterating using Iterator:");
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        
        System.out.println("\nIterating using enhanced for loop:");
        for (Integer num : numbers) {
            System.out.println(num);
        }
        
        System.out.println("\nIterating using forEach and lambda expression:");
        numbers.forEach(num -> System.out.println(num));
        
        System.out.println("\nIterating using Stream API:");
        numbers.stream().forEach(System.out::println);
    }
}
