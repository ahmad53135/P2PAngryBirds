import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by Ahmad on 3/3/2017.
 */
public class Server {

    private AddressInfo addressInfo;
    HelloServant helloServant;

    Server(AddressInfo addressInfo) {
        this.addressInfo = addressInfo;

    }

    public void start(int port) {
        Registry registry = null;
        try {
            registry = LocateRegistry.createRegistry(port);
            helloServant = new HelloServant();
            //egistry.rebind(addressInfo.getUrl(), helloServant);//TODO
            System.out.println("Server started: "+addressInfo.getUrl());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void setHelloService(HelloService helloService){
        helloServant.setHelloService(helloService);
    }

}
