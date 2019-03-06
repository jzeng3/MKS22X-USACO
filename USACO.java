import java.util.*;
import java.io.*;
public class USACO{
  public static void main(String[] args){
    bronze(makelake.1.in);
  }
    public static int bronze(String filename){
      File file = new File(filename);
      Scanner input = new Scanner(file);
      int line = 1;
      int R = 0;
      int C = 0;
      int E = 0;
      int N = 0;
      while (file.hasNextLine){
        str readLine = "";
        if (line == 1){
          readLine += file.nextLine();
          int spaces = 0;
          String rowString = "";
          String colString = "";
          for (int i = 0; i < readLine.length(); i++){
            if (readLine.charAt(i) == ' '){
              spaces++;
            }
            else if (spaces == 0){
              rowString += readLine.substring(i,i+1);
            }
            else if (spaces == 1){
              colString += readLine.substring(i,i+1);
            }
          }
        }
      }
	return 0;
    }
    public static int silver(String filename){
	return 0;
    }


}
