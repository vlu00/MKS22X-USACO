public class USACO{
  public static int bronze(String filename){
    File text = new File(filename);
    Scanner inf = new Scanner(text);
    int[][] lake;
    int i = 0;
    int r = 0;
    int c = 0;
    int row, col, elevation, n;

    while (inf.hasNext()) {
      if (i == 0) {
        row = Integer.parseInt(inf.next());
      }
      else if  (i == 1) {
        col = Integer.parseInt(inf.next());
        lake = new int[row][col];
      }
      else if (i == 2) {
        elevation = Integer.parseInt(inf.next());
      }
      else if (i == 3) {
        n = Integer.parseInt(inf.next());
      }
      else if (i < row * col) {
        
      }
      i++;
    }
    int[][] lake = new int[][];

  }

}
