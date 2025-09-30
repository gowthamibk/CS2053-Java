import java.util.Scanner;

class Employee {
    String name;
    int id;
    double salary;

    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Salary: " + salary);
    }
}

public class EmployeeManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter name: ");
            String name = sc.nextLine();
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            System.out.print("Enter salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();

            employees[i] = new Employee(name, id, salary);
        }

        for (String arg : args) {
            String[] parts = arg.split(":");
            if (parts.length == 2) {
                int empId = Integer.parseInt(parts[0]);
                double newSalary = Double.parseDouble(parts[1]);

                for (Employee emp : employees) {
                    if (emp.id == empId) {
                        emp.salary = newSalary;
                        System.out.println("Updated salary for ID " + empId);
                    }
                }
            }
        }

        System.out.println("\nEmployee Details:");
        for (Employee emp : employees) {
            emp.display();
        }

        sc.close();
    }
}
