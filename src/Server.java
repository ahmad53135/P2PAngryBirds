import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by Ahmad on 3/3/2017.
 */
public class Server {

    private AddressInfo addressInfo;
    PigServiceImpl pigServiceImpl;

    Server(AddressInfo addressInfo) {
        this.addressInfo = addressInfo;

    }

    public void start(int port) {
        Registry registry = null;
        try {
            int i = port - 5050 ;
            registry = LocateRegistry.createRegistry(port);
            pigServiceImpl = new PigServiceImpl();
            //registry.rebind(addressInfo.getUrl(), helloServant);//TODO
            registry.rebind(Integer.toString(i), pigServiceImpl);
            System.out.println("Server started: "+addressInfo.getUrl());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void setPigService(PigService pigService) {
        pigServiceImpl.setPigService(pigService);

    }

}

