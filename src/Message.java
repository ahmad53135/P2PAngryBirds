import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by ahmad on 3/5/17.
 */
public class Message implements Serializable{

    private LinkedHashMap <Integer, Object> header;
    private String message;
    private String messageTitle;

    public Message(){
        this.header = new LinkedHashMap<>();
    }

    public Message (String title){
        this.header = new LinkedHashMap<>();
        this.messageTitle = title;
    }

    public Message(Integer id, String msg){
        this.message = msg;
        //this.header = new HashMap<>();
        this.header.put(id,message);
    }

    public void setMessage(String Message) {message = Message;}
    public String getMessage(){ return message;}
    public HashMap getHeader() { return header;}
    public void setHeader(Integer pigID, String message) { header.put(pigID,message);}
}
