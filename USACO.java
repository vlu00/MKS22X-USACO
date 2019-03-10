import java.util.*;
import java.io.*;

public class USACO{

  private static int getNumber(String s, int index) { //returns the numbers that make up a string
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

  public static int findGreatest(int[][] map, int row, int col, int[][] surroundings) { //finds greatest elevation in 3 by 3 plot
    int greatest = map[row+surroundings[0][0]][col+surroundings[0][1]];
    for (int r = 0; r < surroundings.length; r++) {
      if (map[row+surroundings[r][0]][col+surroundings[r][1]] > greatest) {
        greatest = map[row+surroundings[r][0]][col+surroundings[r][1]];
      }
    }
    return greatest;
  }

  public static int[][] cowStomping(int[][] map, int row, int col, int stomps) {
    int [][] surrounding = new int [][] { {-1, -1}, {-1, 0}, {-1, 1}, //possible spots the cows can stomp
                                          {0, -1}, {0, 0}, {0, 1},
                                          {1, -1}, {1, 0}, {1, 1}};
    int greatest = findGreatest(map, row, col, surrounding); //find the greatest
    while (stomps > 0) { //while the cows sstill need to stomp
      for (int r = 0; r < surrounding.length; r++) { //check each possible spot
        int plot = map[row+surrounding[r][0]][col+surrounding[r][1]];
        if (plot == greatest) { //if the spot is the greatest or one of the greatest elevations
          map[row+surrounding[r][0]][col+surrounding[r][1]] = plot - 1; //cows stomp
        }
      }
      stomps--; //cows have one less stomp
      greatest--; //max elevation has decreased by 1
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

    //setups up number of rows, columns, elevation and number of directions
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

    //adds postive, non-zero aggregatedDepths
    int aggregatedDepth = 0;
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (elevation - lake[r][c] > 0) {
          aggregatedDepth += elevation - lake[r][c];
        }
      }
    }

    return aggregatedDepth * 72 * 72;
  }

  public static int silver(String filename) throws FileNotFoundException{
    File text = new File(filename);
    Scanner inf = new Scanner(text);

    int rows = 0;
    int cols = 0;
    int moves = 0;

    //setups up number of rows, columns, moves(time)
    String setupInfo = inf.nextLine();
    int index = 0;
    while (index < 3) {
      int num = getNumber(setupInfo, index);
      if (index == 0) {
        rows = num;
      }
      if (index == 1) {
        cols = num;
      }
      else {
        moves = num;
      }
      index++;
    }

    //sets up 2D array with map
    int[][] map = new int [rows][cols];
    for (int r = 0; r < rows; r++) {
      String mapInfo = inf.nextLine();
      for (int c = 0; c < cols; c++) {
        char word = mapInfo.charAt(c);
        if (word == '.') {
          map[r][c] = 0;
        }
        else {
          map[r][c] = 9;
        }
      }
    }

    String display = "";
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        display += map[r][c];
      }
      display += "\n";
    }
    System.out.println(display);

    //setups up number of rows, columns, moves(time)
    String startingInfo = inf.nextLine();
    int startingRow = 0;
    int startingCol = 0;
    int endRow = 0;
    int endCol = 0;

    index = 0;
    while (index < 4) {
      int num = getNumber(startingInfo, index);
      if (index == 0) {
        startingRow = num - 1;
      }
      if (index == 1) {
        startingCol = num - 1;
      }
      if (index == 2) {
        endRow = num - 1;
      }
      else {
        endCol = num - 1;
      }
      index++;
    }

    System.out.println(startingRow);
    System.out.println(startingCol);
    System.out.println(endRow);
    System.out.println(endCol);

    return -10;

  }

  public static void main(String[] args) {
    try {
      System.out.println(silver("ctravel.in"));
    }
    catch (FileNotFoundException e) {
      System.out.println("File Not Found");
    }
  }

}
