import java.util.*;
import java.io.*;

public class USACO{

  private static int getNumber(String s, int index) {
    while (index > 0) {
      s = s.substring(s.indexOf(" ")+1);
      index--;
    }
    int i = s.indexOf(" ");
    String num;
    if (i == -1) {
      num = s;
    }
    else {
      num = s.substring(0, i);
    }
    return Integer.parseInt(num);
  }


  public static int bronze(String filename) throws FileNotFoundException{
    File text = new File(filename);
    Scanner inf = new Scanner(text);

    int rows = 0;
    int cols = 0;
    int elevation = 0;
    int n = 0;

    //while (inf.hasNextLine()) {
      //if (i == 0) {
        String setupInfo = inf.nextLine();
        int index = 0;
        while (index < 4) {
          int num = getNumber(setupInfo, index);
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
        //i++
      //}

      int[][] lake = new int [rows][cols];
      int counter = 0;

      //System.out.println(lakeInfo);
      for (int r = 0; r < rows; r++) {
        String lakeInfo = inf.nextLine();
        counter = 0;
        //System.out.println
        for (int c = 0; c < cols; c++) {
          lake[r][c] = getNumber(lakeInfo, counter);
          counter++;
        }
      }

      String display = "";
      for (int ro = 0; ro < rows; ro++) {
        for (int c = 0; c < cols; c++) {
          display += lake[ro][c] + " ";
        }
        display += "\n";
      }
      System.out.println(display);
      System.out.println();
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
