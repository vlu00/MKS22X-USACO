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

  public static int findGreatest(int[][] map, int row, int col, int[][] surroundings) {
    int greatest = map[row+surroundings[0][0]][col+surroundings[0][1]];
    for (int r = 0; r < surroundings.length; r++) {
      if (map[row+surroundings[r][0]][col+surroundings[r][1]] > greatest) {
        greatest = map[row+surroundings[r][0]][col+surroundings[r][1]];
      }
    }
    return greatest;
  }

  public static int[][] cowStomping(int[][] map, int row, int col, int stomps) {
    int [][] surrounding = new int [][] { {-1, -1}, {-1, 0}, {-1, 1},
                                          {0, -1}, {0, 0}, {0, 1},
                                          {1, -1}, {1, 0}, {1, 1}};
    int greatest = findGreatest(map, row, col, surrounding);
    while (stomps > 0) {
      for (int r = 0; r < surrounding.length; r++) {
        int plot = map[row+surrounding[r][0]][col+surrounding[r][1]];
        if (plot == greatest) {
          map[row+surrounding[r][0]][col+surrounding[r][1]] = plot - 1;
        }
      }
      stomps--;
      greatest--;
    }
    return map;
  }


  public static int bronze(String filename) throws FileNotFoundException{
    File text = new File(filename);
    Scanner inf = new Scanner(text);

    int rows = 0;
    int cols = 0;
    int elevation = 0;
    int n = 0;

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
    //sets up 2D array with lake depth values
    int[][] lake = new int [rows][cols];
    int counter = 0;
    for (int r = 0; r < rows; r++) {
      String lakeInfo = inf.nextLine();
      for (int c = 0; c < cols; c++) {
        lake[r][c] = getNumber(lakeInfo, c);
      }
    }
    //sets up 2D array with farmer's directions
    int[][] directions = new int[n][3];
    for (int j = 0; j < n; j++) {
      String directionInfo = inf.nextLine();
      for (int k = 0; k < 3; k++) {
        directions[j][k] = getNumber(directionInfo, k);
      }
    }

    //cowStomping
    for (int p = 0; p < n; p++) {
      lake = cowStomping(lake, directions[p][0], directions[p][1], directions[p][2]);
    }

    //pasture depths
    for (int r = 0; r < rows; r++) {
      for (int c = 0; r < cols; c++) {
        if (elevation - lake[r][c] < 0) {
          lake[r][c] = 0;
        }
        else {
          lake[r][c] = elevation - lake[r][c];
        }
      }
    }


    //to show lake map
    String display = "";
    for (int ro = 0; ro < rows; ro++) {
      for (int c = 0; c < cols; c++) {
        display += lake[ro][c] + " ";
      }
      display += "\n";
    }

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
