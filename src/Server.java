import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by Ahmad on 3/3/2017.
 */
public class Server {

    private static int port;
    Server(int myport) throws RemoteException {
       port = myport;
       main();
    }

    public static void main() throws RemoteException {
        Registry registry = LocateRegistry.createRegistry(port);

        System.out.println("Server started");
        registry.rebind("hello", new HelloServant());
        System.out.println("Server started");

    }

}
