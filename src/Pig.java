import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

  class  Global{
     public static int id = 0;
}

class Pig implements Runnable {
    private Thread t;
    private int PigID;
    private String threadName;

    Pig( String name) {
        PigID = ++Global.id;
        threadName = name;
        System.out.println("Creating " +  threadName );

    }



    public void run() {
        System.out.println("Running " +  threadName );
        HelloService helloService = null;
        try {
            String url = "rmi://localhost:"+threadName+"/hello";
            helloService = (HelloService) Naming.lookup(url);
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

    public void start () throws RemoteException {
        System.out.println("Starting " +  threadName );

        Server Pigserver = new Server(Integer.parseInt(threadName));


        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
    public static void main(String[] args) throws RemoteException {
        for (int i = 5050; i < 5055; i++) {
            Pig R1 = new Pig(Integer.toString(i));
            R1.start();
        }
    }
}

