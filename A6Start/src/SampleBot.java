
import battleship.BattleShip;

import java.awt.Point;
import java.util.Random;
/**
 * I, Ridham Patel, 000831171 and I Yash Khanduja, 000826385 certify that we have worked on this assessment together and that we have not copied it from anyone.
 * No other person’s work has been used without due acknowledgment.
 */

public class SampleBot {
    private int gameSize;
    private BattleShip battleShip;
    private Random random;

    /**
     * Constructor keeps a copy of the BattleShip instance
     *
     * @param b previously created battleship instance - should be a new game
     */
    public SampleBot(BattleShip b) {
        battleShip = b;
        gameSize = b.boardSize;
        random = new Random();   // Needed for random shooter - not required for more systematic approaches
    }

    /**
     * Create a random shot and calls the battleship shoot method
     *
     * @return true if a Ship is hit, false otherwise
     */

    /**
     * craete @-D array to store shot
     */
     int[][] number =new int[10][10];

     int num =2;

    /**
     * this method search for ship in small square
     * this method call itself (recursion mwthod)
     * @param i x line of grid
     * @param j y line of grid
     */
    public void ShipHit(int i,int j){
        //search horizontally for ship
        for (int a = i - num; a < i + num; a++) {
            if (a >= 0 && a < 10) {
                if (!battleShip.allSunk() && number[a][j] != 1 && number[a][j] != -1) {
                    Point shot1 = new Point(a, j);
                    boolean hit = battleShip.shoot(shot1);

                    if(hit ==true){
                        number[a][j] = 1;       // store shot in array
                        ShipHit(a,j);           // method call itself
                    }else{
                        number[a][j] = -1;       // store shot in array
                    }

                }
            }
        }

        // search vertically fro ship
        for (int a = j - num; a < j + num; a++) {
            if (a >= 0 && a < 10) {
                if (!battleShip.allSunk() && number[i][a] != 1 && number[i][a] != -1) {
                    Point shot1 = new Point(i, a);
                    boolean hit = battleShip.shoot(shot1);

                    if(hit ==true){
                        number[i][a] = 1;     // store shot in array
                        ShipHit(i,a);         // method call itself
                    }else{
                        number[i][a] = -1;      // store shot in array
                    }
                }
            }
        }
    }

    /**
     * this method shot on particular spot to find boat
     * @return
     */
    public boolean fireShot() {
        boolean hit = true;
        int i =random.nextInt(gameSize);
        int j=random.nextInt(gameSize);

        // checking condition before shot on sot
        if (!battleShip.allSunk() && number[i][j] != 1 && number[i][j] != -1) {
            Point shot = new Point(i, j);
            hit = battleShip.shoot(shot);
            if (hit == true) {
                number[i][j] = 1;
                ShipHit(i,j);     // call method to find around that spot
            }else{
                number[i][j] = -1;
            }
        }        return hit;
    }
}

