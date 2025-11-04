import java.util.ArrayList;

class Box<T> {
    private ArrayList<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public void printItems() {
        for (T item : items) {
            System.out.println(item);
        }
    }
}

public class LabSession8 {
    public static void main(String[] args) {
      
        Box<Integer> intBox = new Box<>();
        intBox.add(10);   
        intBox.add(20);
        intBox.add(30);

        System.out.println("Integer Box contents:");
        intBox.printItems();

        Box<Double> doubleBox = new Box<>();
        doubleBox.add(3.14);
        doubleBox.add(2.71);

        System.out.println("\nDouble Box contents:");
        doubleBox.printItems();

        Box<String> stringBox = new Box<>();
        stringBox.add("Hello");
        stringBox.add("World");

        System.out.println("\nString Box contents:");
        stringBox.printItems();
    }
}
