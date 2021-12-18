package lab10;

import lab10.interfaces.IDateServer;
import lab6.CustomException;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateServer implements IDateServer {
    static SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");

    @Override
    public int date_calculate(String date1_str, String date2_str) throws RemoteException {
        int count;
        Date date1 = null, date2 = null;

        if(this.DateGreater(date1_str, date2_str)) {
            try {
                date1 = df.parse(date2_str);
                date2 = df.parse(date1_str);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            try {
                date1 = df.parse(date1_str);
                date2 = df.parse(date2_str);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        long ms = date2.getTime() - date1.getTime();
        count = (int) (ms / (24 * 60 * 60 * 1000));
        return count;
    }

    public boolean DateGreater(String dateOne, String dateTwo) {
        try {
            Date date1 = df.parse(dateOne);
            Date date2 = df.parse(dateTwo);
            return date1.after(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return false;
    }
}
