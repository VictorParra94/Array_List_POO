package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Employee> list = new ArrayList<>();

        System.out.print("How many employees will be registered? ");
        int registers = sc.nextInt();
        System.out.println();

        for (int i = 0; i < registers; i++) {
            System.out.println("Employee #" + (i + 1));
            System.out.print("Id: ");
            Integer id = sc.nextInt();
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            System.out.println();

            Employee employee = new Employee(id, name, salary);
            list.add(employee);
        }

        System.out.print("Enter the employee id that will have salary increase : ");
        int idSalary = sc.nextInt();
        Integer pos = IdPosition(list, idSalary);
        if (pos == null) {
            System.out.println("This id does not exist!");
        } else {
            System.out.print("Enter the percentage: ");
            double percentage = sc.nextDouble();
            list.get(pos).increaseSalary(percentage);
        }
        System.out.println();
        System.out.println("List of employees:");
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    public static Integer IdPosition(List<Employee> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return null;
    }
}
