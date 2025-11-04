class Printer {

    synchronized void printDocument(String userName, String documentName, int copies) {
        System.out.println(userName + " started printing: " + documentName);
        for (int i = 1; i <= copies; i++) {
            System.out.println("Printing " + documentName + " (Copy " + i + ")");
            try {
                Thread.sleep(1000); // simulate time taken for each page/copy
            } catch (InterruptedException e) {
                System.out.println("Printing interrupted for " + userName);
            }
        }
        System.out.println(userName + " finished printing: " + documentName + "\n");
    }
}


class User extends Thread {
    private String userName;
    private String documentName;
    private int copies;
    private Printer printer;

    public User(String userName, String documentName, int copies, Printer printer) {
        this.userName = userName;
        this.documentName = documentName;
        this.copies = copies;
        this.printer = printer;
    }

    @Override
    public void run() {
        printer.printDocument(userName, documentName, copies);
    }
}


public class LabSession7 {
    public static void main(String[] args) {
        System.out.println("=== Multithreading and Synchronization Demo ===\n");

        Printer sharedPrinter = new Printer();

        User user1 = new User("User A", "Report_A.pdf", 3, sharedPrinter);
        User user2 = new User("User B", "Project_B.docx", 2, sharedPrinter);
        User user3 = new User("User C", "Invoice_C.xlsx", 4, sharedPrinter);

        user1.start();
        user2.start();
        user3.start();
    }
}