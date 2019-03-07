import java.util.*;
import java.io.*;
public class USACO{

  public static void main(String[] args){
    try{


      bronze("testCases/makelake.1.in");
    }
    catch (FileNotFoundException e){
      System.out.println("file not found");
    }
  }

    public static int bronze(String filename) throws FileNotFoundException{
      Lake test = new Lake(filename);
      test.stomp(1,4,4);
	return 0;
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
          if (line == 0){

          //System.out.println(readLine.toCharArray());
        //  String[] numbers = readLine.split(" ");
          R = Integer.parseInt(numbers[0]);
          C = Integer.parseInt(numbers[1]);
          E = Integer.parseInt(numbers[2]);
          N = Integer.parseInt(numbers[3]);
          pasture = new int[R][C];
          System.out.println(R + " " + C+" "+E+ " "+N);
        }else if (line <= R){

          int r = line - 1;
          for (int i = 0; i < pasture[0].length; i++){
            System.out.println("r: "+r);
            pasture[r][i] = Integer.parseInt(numbers[i]);

          }
          System.out.println(Arrays.toString(pasture[r]));

        }else if (line > R){

        }
        line++;

      }
      for (int r = 0; r < R; r++){
        for (int c = 0; c < C; c++){
          System.out.print(pasture[r][c]+" ");
          if (c == C -1){
            System.out.println("");
          }
        }
      }

    }

    public void stomp(int R_s, int C_s, int D_s){
      cowHerd = new int[9];
      int index = 0;
      if (1 <= R_s && R_s <= R-2 && 1 <= C_s && C_s <= C-2){

        // add the 9 elevations to an array
        for (int i = R_s-1; i < R_s+2; i++){
            System.out.println("index: "+index);
          System.out.println("current row: "+i);
          System.out.println("current place: "+i+", "+C_s+": "+pasture[i][C_s-1]);
          cowHerd[index] = pasture[i][C_s-1];
          System.out.println(cowHerd[index]);
          cowHerd[index+1] = pasture[i][C_s];
          cowHerd[index+2] = pasture[i][C_s+1];
          index += 3;
        /*  cowHerd.add(new Cow(i, C_s, pasture[i][C_s]));
          cowHerd.add(new Cow(i, C_s+1, pasture[i][C_s+1]));
          cowHerd.add(new Cow(i, C_s+2, pasture[i][C_s+2]));*/

        }
        System.out.println(Arrays.toString(cowHerd));
        Arrays.sort(cowHerd);
        int highestElev = cowHerd[8];
        System.out.println(highestElev);
        int diff = 0;
        // update the pasture levels
        for (int i = R_s -1; i < R_s+1; i++){
          diff = highestElev - pasture[i][C_s-1];
          if (diff <= D_s){
            int start = D_s - diff;
            System.out.println("subtract by "+ start);
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

        /*  cowHerd.add(new Cow(i, C_s, pasture[i][C_s]));
          cowHerd.add(new Cow(i, C_s+1, pasture[i][C_s+1]));
          cowHerd.add(new Cow(i, C_s+2, pasture[i][C_s+2]));*/

        }
      }
      for (int r = 0; r < 4; r++){
      System.out.println(Arrays.toString(pasture[r]));
    }


    }
  }
