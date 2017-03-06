
public class AddressInfo {
    public AddressInfo(Integer pigId, String address, Integer port) {
        this.pigId = pigId;
        this.address = address;
        this.port = port;
    }

    private Integer pigId;
    private String address;
    private Integer port;

    public String getUrl(){
        return "rmi://"+address+":"+port+"/"+pigId;
    }
    public String getAddress() {return address;}
    public Integer getPort() { return  port;}
    public Integer getPigId() { return  pigId;}
}
