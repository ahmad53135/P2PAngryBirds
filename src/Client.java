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

    public PigService connect(){
        PigService pigService = null;
        try {
            //String url = "rmi://localhost:5050/0";
            pigService = (PigService) Naming.lookup(addressInfo.getUrl());
            //pigService = (PigService) Naming.lookup(url);

        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return pigService;
    }
}
