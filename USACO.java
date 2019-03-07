import java.util.*;
import java.io.*;
public class USACO{
  public static void main(String[] args){
    try{
      bronze("makelake.1.in");
    }
    catch (FileNotFoundException e){
      System.out.println("file not found");
    }
  }
    public static int bronze(String filename) throws FileNotFoundException{
      File file = new File(filename);
      Scanner input = new Scanner(file);
      int line = 0;
      int R = 0;
      int C = 0;
      int E = 0;
      int N = 0;
      int[][] pasture;
      String readLine = "";
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
        }else if (line < R){
          pasture = new int[R][C];
          int r = line - 1;
          for (int i = 0; i < pasture[0].length; i++){
            pasture[r][i] = Integer.parseInt(numbers[i]);
            System.out.print(pasture[r][i]+" ");
          }
        }
        line++;

      }
	return 0;
    }
    public static int silver(String filename){
	return 0;
    }


}
