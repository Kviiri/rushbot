
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * The grand strategy of the AI for the CTF game.
 * @author kviiri
 */
public class Donkey {
    private HashMap<String, Lion> expendables;
    private ArrayList<Things.Enemy> charlies;
    Scanner lue;
    
    private float[][][][] dist;       //fromX fromY toX toY
    private ArrayList<ArrayList<Boolean>> wallMap;       //true = passable, false = not passable
    private boolean team;           //true = A, false = B
    private int ourScore;
    private int theirScore;
    public Donkey() {
        this.expendables = new HashMap<String, Lion>();
        this.charlies = new ArrayList<Things.Enemy>();
        dist = floydWarshall(2, 2);
        lue = new Scanner(System.in);
        
    }
    private void parseInitialEngineOutput() {
        if(lue.nextLine().equals("A")) team = true;
        else team = false;
        int rowNum = 0;
        while(lue.hasNextLine()) {
            String line = lue.nextLine();
            if(line.length() < 2) break;
            for(int i = 0; i < line.length(); i++) {
                if(line.charAt(i) == '#') wallMap.get(rowNum).add(false);
            }
            rowNum++;
        }
        
    }
    private void parseTurnEngineOutPut() {
        
    }
    private float[][][][] floydWarshall(int xSize, int ySize) {
        float[][][][] ret = new float[xSize][ySize][xSize][ySize];
        for(int x1 = 0; x1 < xSize; x1++) {
            for(int x2 = 0; x2 < xSize; x2++) {
                for(int y1 = 0; y1 < ySize; y1++) {
                    for(int y2 = 0; y2 < ySize; y2++) {
                        if(x1 == x2 && y1 == y2) ret[x1][y1][x2][y2] = 0;
                        else ret[x1][y1][x2][y2] = Float.POSITIVE_INFINITY;
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
                                //if blocked
                                if(!map[xDest][yDest]) {
                                    dist[xAt][yAt][xDest][yDest] = Float.POSITIVE_INFINITY;
                                    continue;
                                }
                                //if neighbor, distance is 1
                                else if(Math.abs(yAt - yDest) + Math.abs(xAt - xDest) == 1) {
                                    dist[xAt][yAt][xDest][yDest] = 1;
                                    continue;
                                }
                                else {
                                    dist[xAt][yAt][xDest][yDest] = Math.min(dist[xAt][yAt][xDest][yDest],
                                            dist[xAt][yAt][xBetween][yBetween] + dist[xBetween][yBetween][xDest][yDest]);
                                }
                            }
                        }
                    }
                }
            }
        }
        return ret;
    }
}
