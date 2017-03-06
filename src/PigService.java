import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PigService extends Remote {

    String echo (Message message) throws RemoteException;
    void bird_approaching(int position,int hopcount)throws RemoteException;
    void take_shelter(int pigID)throws RemoteException;
    boolean status(int pigID) throws RemoteException;
    void status_all() throws RemoteException;
    void was_hit(int pigID ,boolean trueFlag) throws RemoteException;
}
