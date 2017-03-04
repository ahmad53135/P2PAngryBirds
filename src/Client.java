import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Time;

/**
 * Created by Ahmad on 3/3/2017.
 */

class RunnableDemo implements Runnable {
    private Thread t;

    private String threadName;

    RunnableDemo( String name) {

        threadName = name;
        System.out.println("Creating " +  threadName );

    }

    public void run() {
        System.out.println("Running " +  threadName );
        HelloService helloService = null;
        try {
            helloService = (HelloService) Naming.lookup("rmi://localhost:5353/hello");
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(helloService.echo(threadName));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // Let the thread sleep for a while.
                Thread.sleep(5000);
            }
        }catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}


public class Client {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {


        for (int i = 0; i < 5; i++) {
            RunnableDemo R1 = new RunnableDemo("Thread-"+i);
            R1.start();
        }

        //HelloService helloService = (HelloService) Naming.lookup("rmi://localhost:5099/hello");
        //System.out.println(helloService.echo("Helloooooo"));

        //RunnableDemo R1 = new RunnableDemo( "Thread-1");


    }
}
