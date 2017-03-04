import java.rmi.RemoteException;
import java.rmi.server.ExportException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Ahmad on 3/3/2017.
 */
public class HelloServant extends UnicastRemoteObject implements HelloService{

    public HelloServant() throws RemoteException{
        super();
    }

    @Override
    public String echo(String inputstr) throws RemoteException {
        return "from Server" + inputstr;
    }
}
