import java.io.*;
import java.util.*;
interface PerformOperation {
    boolean check(int a);
}
class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    public static PerformOperation isOdd() {
        return isOdd -> (isOdd % 2 == 0) ? false:true;
    }

    public static PerformOperation isPalindrome() {
        return checkPalindrome;
    }

    public static PerformOperation checkPalindrome = (int num) -> {
        String s = Integer.toString(num);

        StringBuilder stringBuilder = new StringBuilder(s);
        String reverse = stringBuilder.reverse().toString();

        if(s.equals(reverse)) {
            return true;
        }

        return false;
    };

    public static PerformOperation isPrime() {
        return number -> {
                if(number < 2){
                    return false;
                }
                for(int i = 2; i <= number/2; i++) {
                        if(number % i == 0) {return false;
                            }
                }
                return true;
            };
    }


    // Write your code here
}
public class LambdaExpression {

    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret = false;
        String ans = null;
        while (T--> 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.isOdd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }
    }
}
