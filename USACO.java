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
      int line = 1;
      int R = 0;
      int C = 0;
      int E = 0;
      int N = 0;
      String readLine = "";
      while (input.hasNextLine()){
          if (line == 0){
          readLine = input.nextLine();
          //System.out.println(readLine.toCharArray());
          String[] numbers = readLine.split(" ");
          R = numbers[0];
          C = numbers[1];
          E = numbers[2];
          N = numbers[3];
          for (int i = 0; i < numbers.length; i++){
          System.out.println(numbers[i] + ", ");
          line++;
          }



        }

      }
	return 0;
    }
    public static int silver(String filename){
	return 0;
    }


}
