import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Boot {
    public static void main(String[] args) throws Exception {


        List<AddressInfo> addressInfos = new ArrayList<>();
        for (int i = 5050; i < 5060; i++) {
            AddressInfo addressInfo = new AddressInfo(i-5050,"localhost", i);
            addressInfos.add(addressInfo);

        }


        Grid grid = new Grid();
        grid.make_Grid();
        grid.set_Grid();
        int[][] ggg= grid.getGridEnv();


        List<Pig> pigs = new ArrayList<>();
        Pig R1 = null;
        for (int i = 5050; i < 5060; i++) {
            //Pig R1 = new Pig(new AddressInfo(i,"localhost", i)); // TODO add nextHop
            if (i != 5059)
            {
                R1 = new Pig(i, addressInfos.get(i-5050),addressInfos.get(i-5050+1));
            }
            else{
                R1 = new Pig(addressInfos.get(i-5050));
            }


            pigs.add(R1);
            R1.start(i);
        }
        for (Pig pig : pigs) {
            if(pig.isClientNull() == false){
                pig.connect();
            }
        }

        Message message = new Message("Attention");

        for (Pig pig : pigs) {
            if (pig.getServer().pigServiceImpl == null) {
                System.out.println("Null hello servant for " + pig);
                continue;
            }
            message.setMessage("Danger");
            message.setHeader(pig.getPigID(),"I'm OK :)");
            pig.getAddressInfo().getUrl();
            TimeUnit.MILLISECONDS.sleep(pig.getPropagationDelay());
            System.out.println(pig.getServer().pigServiceImpl.echo(message));
        }

    }
}
