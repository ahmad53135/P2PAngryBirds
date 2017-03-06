import java.rmi.RemoteException;


class Pig  {
    private AddressInfo addressInfo;

    private Server server;
    private Client client;
    private Integer pigID;
    private Integer propagationDelay;
    private boolean status;


    public Pig(Integer pigID, AddressInfo addressInfo, AddressInfo nextHop) {
        this.addressInfo = addressInfo;
        server = new Server(addressInfo);
        client = new Client(nextHop);
        this.status = true;
        this.pigID = pigID;
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
        PigService pigService = client.connect();
        server.setPigService(pigService);
    }

    public Server getServer() {
        return server;
    }

    public AddressInfo getAddressInfo() {return addressInfo; }

    public Integer getPigID() { return  pigID;}

    public Integer getPropagationDelay() {return propagationDelay;}

}

