import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String calculationSymbol = br.readLine();
            int arrSize = Integer.parseInt(br.readLine());
            String inputArr = br.readLine();
            ACCalculation(sb, calculationSymbol, arrSize, inputArr);
        }
        System.out.print(sb.toString());
    }

    public static void ACCalculation(StringBuilder sb, String cs, int as, String ia) {
        Deque<Integer> deque = new LinkedList<>();
        String temp = ia.substring(1, ia.length() - 1);

        if (!temp.isEmpty()) {
            for (String s : temp.split(",")) {
                deque.add(Integer.parseInt(s));
            }
        }

        boolean isRight = true;

        for (int i = 0; i < cs.length(); i++) {
            char nxt = cs.charAt(i);
            if (nxt == 'R') {
                isRight = !isRight;
            } else {
                if (deque.isEmpty()) {
                    sb.append("error\n");
                    return;
                }

                if (isRight) {
                    deque.pollFirst();
                } else {
                    deque.pollLast();
                }
            }
        }

        sb.append("[");
        while (!deque.isEmpty()) {
            sb.append(isRight ? deque.pollFirst() : deque.pollLast());
            if (!deque.isEmpty()) {
                sb.append(",");
            }
        }
        sb.append("]\n");
    }
}