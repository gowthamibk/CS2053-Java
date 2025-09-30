class Book {
 
    private String title;
    private String author;
    private double price;

    public Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
    }

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println(" Title  : " + this.title);
        System.out.println(" Author : " + this.author);
        System.out.println(" Price  : " + this.price);
        System.out.println("-----------------------------------");
    }

    public static void main(String[] args) {
        Book book1 = new Book("Twisted Love", "Ana Huang", 399.00);
        Book book2 = new Book("Twisted Games", "Ana Huang", 420.50);
        Book book3 = new Book("Twisted Lies", "Ana Huang", 450.75);
        Book book4 = new Book("Twisted Hate", "Ana Huang", 430.25);
      
	System.out.println("Twisted Series Collection:");
        book1.displayDetails();
        book2.displayDetails();
        book3.displayDetails();
        book4.displayDetails();
    }
}
