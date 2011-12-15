
import java.util.ArrayList;

/**
 * The grand strategy of the AI for the CTF game.
 * @author kviiri
 */
public class Donkey {
    private ArrayList<Lion> expendables;
    
    
    private int[][][][] dist;       //fromX fromY toX toY
    public Donkey() {
        this.expendables = new ArrayList<Lion>();
        
    }
    private int[][][][] floydWarshall(int xSize, int ySize) {
        int[][][][] ret = new int[xSize][ySize][xSize][ySize];
        for(int x1 = 0; x1 < xSize; x1++) {
            for(int x2 = 0; x2 < xSize; x2++) {
                for(int y1 = 0; y1 < ySize; y1++) {
                    for(int y2 = 0; y2 < ySize; y2++) {
                        if(x1 == x2 && y1 == y2) ret[x1][y1][x2][y2] = 0;
                        else ret[x1][y1][x2][y2] = Integer.MAX_VALUE;
                    }
                }
            }
        }
        for(int xBetween = 0; xBetween < xSize; xBetween++) {
            for(int yBetween = 0; yBetween < ySize; yBetween++) {
                for(int xAt = 0; xAt < xSize; xAt++) {
                    for(int yAt = 0; yAt < ySize; yAt++) {
                        for(int xDest = 0; xDest < xSize; xDest++) {
                            for(int yDest = 0; yDest < ySize; yDest++) {
                                //NOTE: Seinä- ja naapuri tarkistus tähän!
                                
                            }
                        }
                    }
                }
            }
        }
    }
}
