import java.util.*;
import java.io.*;

public class USACO{
  public static int bronze(String filename) throws FileNotFoundException{
    File text = new File(filename);
    Scanner inf = new Scanner(text);

    //int[][] lake;
    int i = 1;
    int rows = 0;
    int cols = 0;
    int elevation = 0;
    int n = 0;

    //while (inf.hasNextLine()) {
      if (i == 1) {
        String setupInfo = inf.nextLine();
        int index = 0;
        while (setup.hasNext()) {
          int num = Integer.parseInt(setupInfo.charAt(index));
          if (index == 0) {
            rows = num;
          }
          if (index == 1) {
            cols = num;
          }
          if (index == 2) {
            elevation = num;
          }
          else {
            n = num;
          }
          index++;
        }
      }
    //}

    System.out.println(rows);
    System.out.println(cols);
    System.out.println(elevation);
    System.out.println(n);

    return -10;

  }

  public static void main(String[] args) {
    try {
      System.out.println(bronze("makelake.in"));
    }
    catch (FileNotFoundException e) {
      System.out.println("File Not Found");
    }
  }

}
