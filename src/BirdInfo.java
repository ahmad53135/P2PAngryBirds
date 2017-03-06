/**
 * Created by ahmad on 3/5/17.
 */
public class BirdInfo {

    private int landingCoordinateX;
    private int landingCoordinateY;

    private int birdSpeed;        //in milisecond: for example 4500 means that bird will land at
                                    // X,Y after 4.5 seconds

    public BirdInfo(int x, int y, int speed){
        landingCoordinateX = x;
        landingCoordinateY = y;
        birdSpeed = speed;

    }



}
