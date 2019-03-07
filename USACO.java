import java.util.*;
import java.io.*;
public class USACO{
  private int R;
  private int C;
  private int E;
  private int N;
  private int[][] pasture;
  private int[] cowHerd;

  public static void main(String[] args){
    try{
      Lake test = new Lake("makelake.1.in");
      test.stomp(1,1,4);
      bronze("makelake.1.in");
    }
    catch (FileNotFoundException e){
      System.out.println("file not found");
    }
  }

    public static int bronze(String filename) throws FileNotFoundException{

	return 0;
}

    public class Lake{

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
          System.out.println(R + " " + C+" "+E+ " "+N);
        }else if (line <= R){
          pasture = new int[R][C];
          int r = line - 1;
          for (int i = 0; i < pasture[0].length; i++){
            pasture[r][i] = Integer.parseInt(numbers[i]);
            System.out.print(pasture[r][i]+" ");
          }
        }else if (line > R){

        }
        line++;

      }

    }

    public void stomp(int R_s, int C_s, int D_s){
      cowHerd = new int[9];
      int index = 0;
      if (1 <= R_s && R_s <= R-2 && 1 <= C_s && C_s <= C-2){
        // add the 9 elevations to an array
        for (int i = R_s; i < R_s+2; i++){
          cowHerd[index] = pasture[i][C_s];
          cowHerd[index+1] = pasture[i][C_s +1];
          cowHerd[index+2] = pasture[i][C_s +2];
          index += 3;
        /*  cowHerd.add(new Cow(i, C_s, pasture[i][C_s]));
          cowHerd.add(new Cow(i, C_s+1, pasture[i][C_s+1]));
          cowHerd.add(new Cow(i, C_s+2, pasture[i][C_s+2]));*/

        }
        Arrays.sort(cowHerd);
        int highestElev = cowHerd[8];
        int diff = 0;
        // update the pasture levels
        for (int i = R_s; i < R_s+2; i++){
          diff = highestElev - pasture[i][C_s];
          if (diff <= D_s){
            pasture[i][C_s] -= (D_s - diff);
          }
          diff = highestElev - pasture[i][C_s+1];
          if (diff <= D_s){
            pasture[i][C_s+1] -= (D_s - diff);
          }
          diff = highestElev - pasture[i][C_s+2];
          if (diff <= D_s){
            pasture[i][C_s+2] -= (D_s - diff);
          }

        /*  cowHerd.add(new Cow(i, C_s, pasture[i][C_s]));
          cowHerd.add(new Cow(i, C_s+1, pasture[i][C_s+1]));
          cowHerd.add(new Cow(i, C_s+2, pasture[i][C_s+2]));*/

        }
      }

    }
  }



    public static int silver(String filename){
	return 0;
    }


}
