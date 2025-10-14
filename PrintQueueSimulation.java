class Printer {

    public synchronized void printDocument(String user, int copies) {
        System.out.println(user + " started printing " + copies + " copies...");

        for (int i = 1; i <= copies; i++) {
            System.out.println("  → " + user + " is printing copy #" + i);
            try {
                Thread.sleep(500); 
            } catch (InterruptedException e) {
                System.out.println("Printing interrupted for " + user);
            }
        }

        System.out.println(user + " finished printing.\n");
    }
}

class UserThread extends Thread {
    private String userName;
    private Printer printer;
    private int copies;

    public UserThread(String userName, Printer printer, int copies) {
        this.userName = userName;
        this.printer = printer;
        this.copies = copies;
    }

    @Override
    public void run() {
        printer.printDocument(userName, copies);
    }
}

public class PrintQueueSimulation {
    public static void main(String[] args) {
        Printer sharedPrinter = new Printer(); // one shared printer

        UserThread user1 = new UserThread("Alice", sharedPrinter, 3);
        UserThread user2 = new UserThread("Bob", sharedPrinter, 2);
        UserThread user3 = new UserThread("Charlie", sharedPrinter, 4);

        user1.start();
        user2.start();
        user3.start();
    }
}
