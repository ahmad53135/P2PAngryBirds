import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahmad on 3/5/17.
 */
public class Grid {

    private int numberOfRows=10;
    private int numberOfColumns=5;
    private int gridEnv [][];


    public void make_Grid()
    {
        gridEnv = new int[numberOfRows][numberOfColumns];
    }

    public void set_Grid()
    {

        int numberOfPigs = 6;
        int numberOfStones = 3;



        for(int i = 0; i < numberOfRows; i++){
            for (int j = 0; j< numberOfColumns; j++){
                gridEnv[i][j] = 1;
            }
        }
    }

    public int[][] getGridEnv()
    {
        return gridEnv;
    }

    public List<Integer> find_neighbor(int row, int column){
        List<Integer> list = new ArrayList<>();
        for (int i = row -1; i <= row+1; i++){
            for(int j=column-1; j<= column+1; j++) {
                if (i >= 0 && j >= 0) {
                    if (gridEnv[i][j] == 0) {

                        list.add(i);
                        list.add(j);

                        gridEnv[i][j] = 1;
                        gridEnv[row][column] = 0;

                        return list;
                    }
                }
            }

        }
        return list;
    }



}
