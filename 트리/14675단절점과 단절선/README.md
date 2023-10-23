# 실버 1 14675 단절점과 단절선

- 문제 유형

  그래프, 트리, 단절점과 단절선 이론

- 공부한 점

  위 문제는 이진트리가 아니므로 여러 노드가 연결될 수 있으므로 그래프처럼 트리를 구현한다. 

  단절점과 단절선 : 점 또는 선을 제거 했을때 두 개의 그래프 혹은 트리로 나뉘는 것, 간선은 모두 단절선이 될수 있다.

  단절점이 되는 조건은 루트노드의 자식노드가 한개이거나 마지막 리프노드인 것이다.

  
  내 해결방법 -> 첫번째 풀이에서 첫 노드와 마지막 노드로 착각해서 문제 해결을 잘못했다.

  첫노드에서 자식노드가 하나만 있어야 된다는 조건을 생각을 하지 못했다.

  dp형식으로 문제를 해결할 수 있다, 입력한 값이 한번만 등장한 것이면 연결된 곳이 한개 즉, 마지막노드여서 부모노드에 연결된 것이거나, 루트노드가 한개만 연결된 것이므로 이에 해당한다.

  굳이 그래프를 만들 필요는 없었다. 


  ```java
    //ultmhoon21님의 코드
    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.StringTokenizer;
    
    public class Main {
    	
    	public static void main(String[] args) throws IOException {
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		StringBuilder sb = new StringBuilder();
    		StringTokenizer st;
    		int N = Integer.parseInt(br.readLine());
    		int[] visit = new int[N+1]; //정점 등장횟수가 1이면 나눌수 없음
    		while(N-->1) {
    			st = new StringTokenizer(br.readLine());
    			++visit[Integer.parseInt(st.nextToken())];
    			++visit[Integer.parseInt(st.nextToken())];
    		}
    		int Q = Integer.parseInt(br.readLine());
    		while(Q-->0) {
    			String s = br.readLine();
    			int t = s.charAt(0);
    			if(t=='2') sb.append("yes\n"); //트리구조는 모든 간선이 단절선이 됨
    			else {
    				int k = Integer.parseInt(s.substring(2));
    				sb.append(visit[k]>=2?"yes\n":"no\n");
    			}
    		}
    		System.out.print(sb);
    	}
    }
  ```
  이와 같이 다이나믹 프로그래밍으로 해결할 수 있다.
