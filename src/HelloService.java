import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloService extends Remote {

    String echo (String inputstr) throws RemoteException;
}
