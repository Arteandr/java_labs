import lab2.CustomArray;
import lab3.CustomDate;
import lab5.CustomString;

import java.awt.*;
import java.util.Scanner;

public class Program {
    static Scanner sc;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Menu();
    }

    private static void Menu() {
        int key = 0;
        System.out.println("\n\nДоступные лабороторные работы: 2, 3, 5");

        do {
            System.out.println("Выберите номер лабороторной работы: ");
            while (!sc.hasNextInt()) {
                System.out.println("Выберите корректный номер: ");
                sc.next();
            }
            key = sc.nextInt();
        } while(key != 2 && key != 3 && key != 5);

        switch (key) {
            case 2:
                CustomArray cs = new CustomArray();
                cs.Start();
                Menu();
                break;
            case 3:
                CustomDate cd = new CustomDate();
                cd.Start();
                Menu();
                break;
            case 5:
                CustomString c_str = new CustomString();
                c_str.Start();
                Menu();
                break;
        }
    }
}
