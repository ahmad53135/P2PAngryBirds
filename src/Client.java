import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by Ahmad on 3/3/2017.
 */
public class Client {
    AddressInfo addressInfo;

    public Client(AddressInfo addressInfo) {
        this.addressInfo = addressInfo;
    }

    public HelloService connect(){
        HelloService helloService = null;
        try {
            //String url = "rmi://localhost:5050/0";
            helloService = (HelloService) Naming.lookup(addressInfo.getUrl());
            //helloService = (HelloService) Naming.lookup(url);

        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
       return helloService;
    }
}
