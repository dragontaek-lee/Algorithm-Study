package Stack;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9935 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String bombString = br.readLine();

        Stack<Character> stack = new Stack<>();

        int arrLength = s.length();
        int bombLength = bombString.length();

        for(int i = 0; i < arrLength; i++) {
            stack.push(s.charAt(i));
            if(stack.size() >= bombLength){
                boolean isEven = true;
                for(int j = 0; j < bombLength ; j++) {
                    if(stack.get(stack.size() - bombLength + j) != bombString.charAt(j)){
                        isEven = false;
                        break;
                    }
                }
                if(isEven) {
                    for(int j = 0; j < bombLength; j++) {
                        stack.pop();
                    }
                }
            }
        }

        if(stack.empty()){
            System.out.print("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            for(char c : stack) {
                sb.append(c);
            }
            System.out.println(sb.toString());
        }

    }
}
