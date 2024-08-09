import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int n;
    static Set<Integer> set;
    static int result[];
    static boolean prime[];
    public static void is_Prime(int num){
      //에라토스테네스의 채를 이용하여 문제 해결
      // 수의 범위 안에서 배수를 탐색
        for (int j=num+num;j<1_000_001;j+=num) {
          // set안에 들어와 있는 것이면 result배열의 값 변화
            if(set.contains(j)){
                result[num]++;
                result[j]--;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n=Integer.parseInt(br.readLine());
        set = new LinkedHashSet<Integer>();
        result=new int[1_000_001];
        
        st=new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++) {
          //입력 값을 set에 저장
            int input=Integer.parseInt(st.nextToken());
            set.add(input);
        }
          // set에 저장된 수의 배수가 set에 저장되어 있는지 확인위한 반복문
        for (Integer e : set) {
            is_Prime(e);
        }
        StringBuilder sb=new StringBuilder();
        for (Integer e : set) {
            sb.append(result[e]+" ");
        }
        
        System.out.println(sb.toString());
    }
}
