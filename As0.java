import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
class As0 {
    public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("input.txt"));
    PrintWriter output = new PrintWriter(new File("output.txt"));

    int n = input.nextInt();
    String least_expensive_souvenir = "";
    long souvenir_Price = Long.MAX_VALUE;

    for (int i = 0; i < n; i++) {
        long price = input.nextLong();
        String name = input.nextLine().trim();

        if (price < souvenir_Price) {
             least_expensive_souvenir = name;
            souvenir_Price = price;
        }
    }

    output.println(least_expensive_souvenir);

    input.close();
    output.close();
}
}