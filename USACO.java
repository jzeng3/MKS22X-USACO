import java.util.*;
import java.io.*;
public class USACO{

  public static void main(String[] args){
    try{
      System.out.println(bronze("testCases/makelake.2.in"));
    //  bronze("testCases/makelake.2.in");
    //  bronze("testCases/makelake.3.in");
    }
    catch (FileNotFoundException e){
      System.out.println("file not found");
    }
  }

  public static int bronze(String filename) throws FileNotFoundException{
    Lake test = new Lake(filename);
    System.out.println(test);
    return test.volume();
  }
  public static int silver(String filename){
    return 0;
  }
}
class Lake{

  private int R;
  private int C;
  private int E;
  private int N;
  private int[][] pasture;
  private int[] cowHerd;

  public Lake(String filename) throws FileNotFoundException{
    File file = new File(filename);
    Scanner input = new Scanner(file);
    String readLine = "";
    int line = 0;
    while (input.hasNextLine()){
      readLine = input.nextLine();
      String[] numbers = readLine.split(" ");
      /* read the first line of information for
      number of rows, columns, final elevation, and
      number of instructions*/
      if (line == 0){
        R = Integer.parseInt(numbers[0]);
        C = Integer.parseInt(numbers[1]);
        E = Integer.parseInt(numbers[2]);
        N = Integer.parseInt(numbers[3]);
        pasture = new int[R][C];
        System.out.println(R + " " + C+" "+E+ " "+N);
      }else if (line <= R){

        int r = line - 1;
        for (int i = 0; i < pasture[0].length; i++){

          pasture[r][i] = Integer.parseInt(numbers[i]);

        }


      }else if (line > R){
        int R_s = Integer.parseInt(numbers[0]);
        int C_s = Integer.parseInt(numbers[1]);
        int D_s = Integer.parseInt(numbers[2]);
        stomp(R_s, C_s, D_s);
      }
      line++;

    }

  }

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

  public void stomp(int R_s, int C_s, int D_s){
    cowHerd = new int[9];
    int index = 0;
    if (1 <= R_s && R_s <= R-2 && 1 <= C_s && C_s <= C-2){
      // add the 9 elevations to an array
      for (int i = R_s-1; i < R_s+2; i++){
        cowHerd[index] = pasture[i][C_s-1];
        cowHerd[index+1] = pasture[i][C_s];
        cowHerd[index+2] = pasture[i][C_s+1];
        index += 3;
      }

      Arrays.sort(cowHerd);
      int highestElev = cowHerd[8];
      int diff = 0;

      // update the pasture levels
      for (int i = R_s -1; i < R_s+2; i++){
        diff = highestElev - pasture[i][C_s-1];
        if (diff <= D_s){
          int start = D_s - diff;

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

  public int volume(){
    int totalDepth = 0;
    for (int r = 0; r < R; r++){
      for (int c = 0; c < C; c++){
        if ( (E - pasture[r][c]) > 0){
          totalDepth += (E - pasture[r][c]);
        }
      }
    }
    System.out.println("total Depth: "+ totalDepth);
    int length = R * 6 * 12;
    System.out.println("L: "+ length);
    int width = C * 6* 12;
    System.out.println("W: "+ width);
    int volume = totalDepth * 72 * 72;
    return volume;
  }
}
