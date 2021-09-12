import java.util.*;

public class Dequeue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();

        Set<Integer> integerSet = new HashSet<>();
        int countDistinct = 0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
            integerSet.add(num);
            if(deque.size() == m) {
                if (integerSet.size() > countDistinct) {
                    countDistinct = integerSet.size();
                }
                int valueOfPoll = (int) deque.remove();
                if(!deque.contains(valueOfPoll)) {
                    integerSet.remove(valueOfPoll);
                }
            }
        }

        System.out.println(countDistinct);

    }
}
