import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Ahmad on 3/3/2017.
 */
public class PigServiceImpl extends UnicastRemoteObject implements PigService {

    PigService pigService;

    public PigServiceImpl() throws RemoteException{
        super();
    }


    public void setPigService(PigService pigService) {
        this.pigService = pigService;
    }

    @Override
    public String echo(Message message) throws RemoteException {
        //pigService.echo(inputstr);

        System.out.println(message);

        return "from Server " + message;
    }

    public void bird_approaching(int position,int hopcount) throws RemoteException  //hopcount equals number of pigs
    {

    }

    public void take_shelter(int pigID) throws RemoteException{

    }

    public boolean status(int pigID) throws RemoteException{
        return false;
    }

    public void status_all() throws RemoteException{

    }

    public void was_hit(int pigID ,boolean trueFlag) throws RemoteException{

    }
}



