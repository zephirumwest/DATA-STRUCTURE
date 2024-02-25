import java.io.*;

public class testcaseMaker {
  public static final int n = 20000;
  public static void main(String[] args) throws IOException {
    BufferedWriter wr = new BufferedWriter(new FileWriter("input.txt"));
    wr.write(Integer.toString(n) + " " + Integer.toString(n));
    wr.newLine();
		for (int i = 0; i < n - 1 ; i++) {
      wr.write(Integer.toString(i) + " " + Integer.toString(i + 1));
      wr.newLine();
    }
    wr.write(Integer.toString(n - 1) + " " + Integer.toString(0));
    wr.newLine();
		wr.close();
  }
  
}
