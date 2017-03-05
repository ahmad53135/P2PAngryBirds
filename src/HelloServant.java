import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Ahmad on 3/3/2017.
 */
public class HelloServant extends UnicastRemoteObject implements HelloService{

    HelloService helloService;

    public HelloServant() throws RemoteException{
        super();
    }

    @Override
    public String echo(String inputstr) throws RemoteException {
        helloService.echo(inputstr);

        System.out.println(inputstr);

        return "from Server " + inputstr;
    }

    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }
}
