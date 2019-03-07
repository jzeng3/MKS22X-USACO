import java.util.*;
import java.io.*;
public class USACO{
  private int R;
  private int C;
  private int E;
  private int N;
  private int[][] pasture;
  private ArrayList<Cow> cowHerd;

  public static void main(String[] args){
    try{
      bronze("makelake.1.in");
    }
    catch (FileNotFoundException e){
      System.out.println("file not found");
    }
  }

    public static int bronze(String filename) throws FileNotFoundException{
      public makelake(filename);
      stomp(1,1,4);
	return 0;
    }

    public int makelake(String filename) throws FileNotFoundException{
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
      return 0;
    }

    public void stomp(int R_s, int C_s, int D_s){
      cowHerd = new ArrayList<Cow>();

      if (1 <= R_s && R_s <= R-2 && 1 <= C_s && C_s <= C-2){
        for (int i = R_s; i < R_s+2; i++){
          cowHerd.add(new Cow(i, C_s, pasture[i][C_s]));
          cowHerd.add(new Cow(i, C_s+1, pasture[i][C_s+1]));
          cowHerd.add(new Cow(i, C_s+2, pasture[i][C_s+2]));
        }
      }
      Collections.sort(cowHerd);
    }

    private class Cow implements Comparable<Cow>{
      public int row, col, elev;
      public Cow(int r, int c, int e){
        row = r;
        col = c;
        elev = e;
      }
      public int compareTo(Cow other){
        return elev - other.elev;
      }
    }

    public static int silver(String filename){
	return 0;
    }


}
