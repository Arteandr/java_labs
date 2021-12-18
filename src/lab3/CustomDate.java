package lab3;
import lab6.CustomException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CustomDate {
    Scanner scanner;

    String fDate;
    String sDate;

    static SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");

    public CustomDate() {
        this.scanner = new Scanner(System.in);
    }

    public void Start() {
        try {
            this.Input();
        } catch (CustomException e) {
            System.out.println(e);
            this.Start();
        }
    }

    public boolean IsLeap(int year) {
        return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
    }


    public String DateInput() {
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
            while(!this.scanner.hasNextInt()) {
                System.out.println("Введите год(1-9999): ");
                this.scanner.next();
            }
            year = this.scanner.nextInt();
        } while(year <= 0 || year > 9999);
        if(this.IsLeap(year))
            months[1] = 29;

        do {
            System.out.println("Введите месяц(1-12): ");
            while(!this.scanner.hasNextInt()) {
                System.out.println("Введите месяц(1-12): ");
                this.scanner.next();
            }
            month = this.scanner.nextInt();
        } while(month < 1 || month > 12);

        do {
            System.out.println("Введите день(1-"+months[month - 1]+")");
            while(!this.scanner.hasNextInt()) {
                System.out.println("Введите день(1-"+months[month - 1]+")");
                this.scanner.next();
            }
            day = this.scanner.nextInt();
        } while(day < 1 || day > months[month - 1]);

        return (day+"."+month+"."+year);
    }

    public void Input() throws CustomException {
        System.out.println("Введите первую дату: ");
        this.fDate = this.DateInput();

        System.out.println("Введите вторую дату: ");
        this.sDate = this.DateInput();
        if(this.fDate.equals(this.sDate))
            throw new CustomException("Даты должны отличаться!");
        try {
            int result = this.Calculate();
            System.out.println("Разница между этими датами: " + result + " дней");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int Calculate() throws ParseException {
        int count;
        Date date1, date2;

        if(this.DateGreater(this.fDate, this.sDate)) {
            date1 = CustomDate.df.parse(this.sDate);
            date2 = CustomDate.df.parse(this.fDate);
        } else {
            date1 = CustomDate.df.parse(this.fDate);
            date2 = CustomDate.df.parse(this.sDate);
        }

        long ms = date2.getTime() - date1.getTime();
        count = (int) (ms / (24 * 60 * 60 * 1000));
        return count;
    }

    public boolean DateGreater(String dateOne, String dateTwo) {
        try {
            Date date1 = CustomDate.df.parse(dateOne);
            Date date2 = CustomDate.df.parse(dateTwo);
            return date1.after(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return false;
    }
}
