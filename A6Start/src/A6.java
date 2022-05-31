
import battleship.BattleShip;

/**
 * I, Ridham Patel, 000831171 and I Yash Khanduja, 000826385 certify that we have worked on this assessment together and that we have not copied it from anyone.
 * No other person’s work has been used without due acknowledgment.
 */

public class A6
{
   static final int NUMBEROFGAMES = 10000;        // number of games to play
   public static void startingSolution()
  {
    int totalShots = 0;
    System.out.println(BattleShip.version());
     long start = System.nanoTime();
    for (int game = 0; game < NUMBEROFGAMES; game++) {

      BattleShip battleShip = new BattleShip();
      SampleBot sampleBot = new SampleBot(battleShip);
      
      // Call SampleBot Fire randomly - You need to make this better!
     while (!battleShip.allSunk()) {
        sampleBot.fireShot();
     }
      int gameShots = battleShip.totalShotsTaken();
      totalShots += gameShots;
    }

    long stop = System.nanoTime();
    System.out.printf("SampleBot - The Average # of Shots required in %d games to sink all Ships = %.2f\n", NUMBEROFGAMES, (double)totalShots / NUMBEROFGAMES);
    System.out.println("To play " + NUMBEROFGAMES + " games program takes " + (stop-start) + " nano Seconds");
  }
  public static void main(String[] args)
  {
    startingSolution();
  }
}
