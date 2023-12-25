https://www.acmicpc.net/problem/1005

- 문제 풀이 방법

  구하는 점에서 역으로 찾아가면 더 빠른 풀이를 할 수 있다.

  각 점을 -1로 초기화 해놓고 뒤의 값을 재귀 함수를 찾아가면 편하다.

  ```java
    import java.io.*;
import java.util.*;

public class Main {
	
	static InputReader in = new InputReader(System.in);
	static PrintWriter out = new PrintWriter(System.out);
	
	static ArrayList<Integer>[] need;
	static int[] d;
	static int[] memo;
	
	public static void main(String[] args) {
		
		int T = in.nextInt();
		while(T --> 0) {
			int n = in.nextInt();
			int k = in.nextInt();
			d = new int[n];
			need = new ArrayList[n];
			memo = new int[n];
			Arrays.fill(memo, -1);
			for(int i=0; i<n; ++i)
				need[i] = new ArrayList<>();
			for(int i=0; i<n; ++i)
				d[i] = in.nextInt();
			for(int i=0; i<k; ++i) {
				int u = in.nextInt() - 1;
				int v = in.nextInt() - 1;
				need[v].add(u);
			}
			int w = in.nextInt() - 1;
			out.println( time(w) );
		}
		
		out.close();
	}
	
	static int time(int x) {
		if(memo[x] != -1)
			return memo[x];
		int ret = 0;
		for(int u : need[x]) {
			ret = Math.max(ret, time(u));
		}
		ret += d[x];
		return memo[x] = ret;
	}
}

  ```
