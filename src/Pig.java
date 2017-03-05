import java.rmi.RemoteException;


class Pig  {
    private AddressInfo addressInfo;

    private Server server;
    private Client client;

    public Pig(AddressInfo addressInfo, AddressInfo nextHop) {
        this.addressInfo = addressInfo;
        server = new Server(addressInfo);
        client = new Client(nextHop);
    }

    public Pig(AddressInfo addressInfo){
        this.addressInfo = addressInfo;
        server = new Server(addressInfo);
    }

    public void start(int port) throws RemoteException {

        server.start(port);
    }

    public boolean isClientNull () throws  Exception{
        if(this.client == null)
            return true;
        return false;
    }

    public void connect() {
        HelloService helloService = client.connect();
        server.setHelloService(helloService);
    }
}

