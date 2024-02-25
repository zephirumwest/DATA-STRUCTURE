import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class As21 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            String postfixExpression = br.readLine();
            br.close();
            
            String infixExpression = postfixToInfix(postfixExpression);
            
            FileWriter fw = new FileWriter("output.txt");
            fw.write(infixExpression);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static String postfixToInfix(String postfixExpression) {
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < postfixExpression.length(); i++) {
            char c = postfixExpression.charAt(i);
            if (Character.isLetter(c)) {
                stack.push(Character.toString(c));
            } else {
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                String result = "(" + operand1 + c + operand2 + ")";
                stack.push(result);
            }
        }
        return stack.pop();
    }
}
