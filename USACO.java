import java.util.*;
import java.io.*;
public class USACO{

  public static void main(String[] args){
    // try every test case, catch if file is invalid
    try{
      System.out.println(bronze("testCases/makelake.1.in"));
    /*  System.out.println(bronze("testCases/makelake.2.in"));
      System.out.println(bronze("testCases/makelake.3.in"));
      System.out.println(bronze("testCases/makelake.4.in"));
      System.out.println(bronze("testCases/makelake.5.in"));*/
      System.out.println(silver("testCases/ctravel.1.in"));
    }
    catch (FileNotFoundException e){
      System.out.println("File not found");
    }
  }

  public static int bronze(String filename) throws FileNotFoundException{
    // make new lake and return volume
    Lake test = new Lake(filename);
    return test.volume();
  }

  public static int silver(String filename) throws FileNotFoundException{
    Path test = new Path(filename);
    System.out.println(test);
    return 0;
  }
}
class Path{
  private int N;
  private int M;
  private int T;
  private int R1;
  private int C1;
  private int R2;
  private int C2;
  private char[][] pasture;

  public Path(String filename) throws FileNotFoundException{
    // read input file
    File file = new File(filename);
    Scanner input = new Scanner(file);
    String readLine = "";
    int line = 0;
    while (input.hasNextLine()){
      readLine = input.nextLine();
      /* Read the first line of information for
      number of rows, columns, final elevation, and number of instructions*/
      if (line == 0){
        // separate the line into String array of the "numberStr" to be used
        String[] numberStr = readLine.split(" ");
        N = Integer.parseInt(numberStr[0]);
        M = Integer.parseInt(numberStr[1]);
        T = Integer.parseInt(numberStr[2]);
        pasture = new char[N][M];
      }
      // When reading the lines with the pasture
      else if (line <= N){
        // update current  pasture row
        int r = line - 1;
        for (int i = 0; i < pasture[0].length; i++){
          pasture[r][i] = readLine.charAt(i);
        }
      }
      // When reading the instructions
      else if (line > N){
        String[] numberStr = readLine.split(" ");
        // call herd to stomp where specified
        int R1 = Integer.parseInt(numberStr[0]);
        int C1 = Integer.parseInt(numberStr[1]);
        int R2 = Integer.parseInt(numberStr[2]);
        int C2 = Integer.parseInt(numberStr[3]);
      }
      line++;
  }
}
  public String toString(){
    String pastureStr = "";
    for (int r = 0; r < N; r++){
      for (int c = 0; c < M; c++){
        pastureStr += pasture[r][c]+" ";
        if (c == M -1){
          pastureStr += "\n";
        }
      }
    }
    return pastureStr;
  }

}

class Lake{

  private int R;
  private int C;
  private int E;
  private int N;
  private int[][] pasture; // 2D array with pasture depths
  private int[] cowHerd; // 9-squares to be stomped on

  public Lake(String filename) throws FileNotFoundException{
    // read input file
    File file = new File(filename);
    Scanner input = new Scanner(file);
    String readLine = "";
    int line = 0;
    while (input.hasNextLine()){
      readLine = input.nextLine();
      // separate the line into String array of the "numberStr" to be used
      String[] numberStr = readLine.split(" ");
      /* Read the first line of information for
      number of rows, columns, final elevation, and number of instructions*/
      if (line == 0){
        R = Integer.parseInt(numberStr[0]);
        C = Integer.parseInt(numberStr[1]);
        E = Integer.parseInt(numberStr[2]);
        N = Integer.parseInt(numberStr[3]);
        pasture = new int[R][C];

      }
      // When reading the lines with the pasture
      else if (line <= R){
        // update current  pasture row
        int r = line - 1;
        for (int i = 0; i < pasture[0].length; i++){
          pasture[r][i] = Integer.parseInt(numberStr[i]);
        }


      }
      // When reading the instructions
      else if (line > R && (line - R) <= N){
        // call herd to stomp where specified
        int R_s = Integer.parseInt(numberStr[0]);
        int C_s = Integer.parseInt(numberStr[1]);
        int D_s = Integer.parseInt(numberStr[2]);
        stomp(R_s, C_s, D_s);
      }
      line++;

    }

  }

  // for printing pasture
  public String toString(){
    String pastureStr = "";
    for (int r = 0; r < R; r++){
      for (int c = 0; c < C; c++){
        pastureStr += pasture[r][c]+" ";
        if (c == C -1){
          pastureStr += "\n";
        }
      }
    }
    return pastureStr;
  }

  // stomp on a 9-square space on the pasture given specified row, column, and depth to stomp down
  public void stomp(int R_s, int C_s, int D_s){
    cowHerd = new int[9];
    int index = 0;
    // Check if cow herd can fit on the given area
    if (1 <= R_s && R_s <= R-2 && 1 <= C_s && C_s <= C-2){
      // add the 9 elevations to an array
      for (int i = R_s-1; i < R_s+2; i++){
        cowHerd[index] = pasture[i][C_s-1];
        cowHerd[index+1] = pasture[i][C_s];
        cowHerd[index+2] = pasture[i][C_s+1];
        index += 3;
      }
      // sort the array of elevations and store the highest elevation
      Arrays.sort(cowHerd);
      int highestElev = cowHerd[8];

      int diff = 0;
      // update the pasture levels
      for (int i = R_s -1; i < R_s+2; i++){
        /* If the difference between elevations of current spot and highest spot
          is less than or equal to the number of inches to push down,
          subtract the elevation of the current spot by the difference between
          the number of inches to push down and the difference between elevations.
        */
        diff = highestElev - pasture[i][C_s-1];
        if (diff <= D_s){
          pasture[i][C_s-1] -= (D_s - diff);
        }
        diff = highestElev - pasture[i][C_s];
        if (diff <= D_s){
          pasture[i][C_s] -= (D_s - diff);
        }
        diff = highestElev - pasture[i][C_s+1];
        if (diff <= D_s){
          pasture[i][C_s+1] -= (D_s - diff);
        }

      }
    }
  }
// Find the volume of the lake
  public int volume(){
    int totalDepth = 0;
    for (int r = 0; r < R; r++){
      for (int c = 0; c < C; c++){
        // If the pasture is under the water, add the depth to total depth
        if ( (E - pasture[r][c]) > 0){
          totalDepth += (E - pasture[r][c]);
        }
      }
    }
    // Multiply depth by 6 feet by 6 feet to get volume
    int volume = totalDepth * 72 * 72;
    return volume;
  }
}
