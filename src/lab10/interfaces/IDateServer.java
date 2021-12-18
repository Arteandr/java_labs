package lab10.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IDateServer extends Remote {
    int date_calculate(String date1, String date2) throws RemoteException;
}
