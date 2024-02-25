import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        if(a.equals("+")){
            System.out.println(a);
            System.out.println("됨");
        }
        else{
            System.out.println(a);
            System.out.println("안됨");
        }

    }
}
