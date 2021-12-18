package lab10.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IStringServer extends Remote {
    String sort(String str) throws RemoteException;
}
