import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class Boot {
    public static void main(String[] args) throws RemoteException {


        List<AddressInfo> addressInfos = new ArrayList<>();
        for (int i = 5050; i < 5055; i++) {
            AddressInfo addressInfo = new AddressInfo(i-5050,"localhost", i);
            addressInfos.add(addressInfo);

        }


        List<Pig> pigs = new ArrayList<>();
        Pig R1 = null;
        for (int i = 5050; i < 5055; i++) {
            //Pig R1 = new Pig(new AddressInfo(i,"localhost", i)); // TODO add nextHop
            if (i != 5054)
            {
                 R1 = new Pig(addressInfos.get(i-5050),addressInfos.get(i-5050+1));
            }
            else{
                 R1 = new Pig(addressInfos.get(i-5050));
            }


            pigs.add(R1);
            R1.start(i);
        }
        for (Pig pig : pigs) {
            pig.connect();
        }

    }
}
