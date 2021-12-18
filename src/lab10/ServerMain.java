package lab10;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerMain {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException, InterruptedException {
        final DateServer dateServer = new DateServer();
        final StringServer stringServer = new StringServer();

        final Registry registry = LocateRegistry.createRegistry(2732);

        Remote date_stub = UnicastRemoteObject.exportObject(dateServer, 0);
        Remote string_stub = UnicastRemoteObject.exportObject(stringServer, 0);

        registry.bind("server.date", date_stub);
        registry.bind("server.string", string_stub);

        System.out.println("Сервер успешно запущен на порту 2732");
        Thread.sleep(Integer.MAX_VALUE);
    }
}
