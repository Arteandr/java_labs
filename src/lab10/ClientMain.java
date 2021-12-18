package lab10;

import lab10.interfaces.IDateServer;
import lab10.interfaces.IStringServer;
import lab6.CustomException;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClientMain {
    public static IDateServer date_server;
    public static IStringServer string_server;

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws RemoteException, NotBoundException {
        final Registry registry = LocateRegistry.getRegistry(2732);

        date_server = (IDateServer) registry.lookup("server.date");
        string_server = (IStringServer) registry.lookup("server.string");

        Menu();
    }

     public static void Menu() {
        System.out.println("\nВыберите желаемую лабораторную работу");
        System.out.println("1. Лабораторная номер 3 (количество дней между двумя датами)");
        System.out.println("2 - Лабораторная номер 5 (работа со строками)");

         int key = 0;
         do {
             System.out.print("Ваш выбор: ");
             while(!scanner.hasNextInt()) {
                 scanner.next();
             }
             key = scanner.nextInt();
         } while (key != 1 && key != 2);

         switch (key) {
             case 1:
                 try {
                     ThirdLab();
                 } catch (Exception e) {
                     System.out.println("[ОШИБКА]: " + e);
                 }
                 break;
             case 2:
                 try {
                     FifthLab();
                 } catch (Exception e) {
                     System.out.println("[ОШИБКА]: " + e);
                 }
                 break;
         }
     }

     public static void FifthLab() {
        try {
            String src_str = Input();
            String out_str = string_server.sort(src_str);
            System.out.println("Выходная строка: ");
            System.out.println(out_str);

            Menu();
        } catch (Exception e) {
            System.out.println(e);
            FifthLab();
        }
     }

     private static String Input() throws CustomException {
        Scanner local_scanner = new Scanner(System.in);

        String str;
        System.out.println("Введите исходную строку");
        str = local_scanner.nextLine();
        if (str.split(" ").length < 2)
            throw new CustomException("Количество слов должно быть больше двух!");

        return str;
     }

     public static void ThirdLab() {
        try {
            String[] dates = FullDateInput();
            int res = date_server.date_calculate(dates[0],dates[1]);
            System.out.println("Количество дней между датами: " + res);
            Menu();
        } catch (Exception e) {
            System.out.println(e);
            ThirdLab();
        }
     }

     private static String[] FullDateInput() throws CustomException {
        String[] result = new String[2];
        System.out.println("Введите первую дату: ");
        result[0] = DateInput();

        System.out.println("Введите вторую дату: ");
        result[1] = DateInput();
        if(result[0].equals(result[1]))
            throw new CustomException("Даты должны отличаться!");

        return result;
     }

     private static String DateInput() {
         int[] months = new int[] {
                 31,
                 28,
                 31,
                 30,
                 31,
                 30,
                 31,
                 31,
                 30,
                 31,
                 30,
                 31
         };

         int year;
         int month;
         int day;

         do {
             System.out.println("Введите год(1-9999): ");
             while(!scanner.hasNextInt()) {
                 System.out.println("Введите год(1-9999): ");
                 scanner.next();
             }
             year = scanner.nextInt();
         } while(year <= 0 || year > 9999);
         if((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)))
             months[1] = 29;

         do {
             System.out.println("Введите месяц(1-12): ");
             while(!scanner.hasNextInt()) {
                 System.out.println("Введите месяц(1-12): ");
                 scanner.next();
             }
             month = scanner.nextInt();
         } while(month < 1 || month > 12);

         do {
             System.out.println("Введите день(1-"+months[month - 1]+")");
             while(!scanner.hasNextInt()) {
                 System.out.println("Введите день(1-"+months[month - 1]+")");
                 scanner.next();
             }
             day = scanner.nextInt();
         } while(day < 1 || day > months[month - 1]);

         return (day+"."+month+"."+year);
     }
}
