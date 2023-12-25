import java.io.*;
import java.util.*;
public class Main
{   
    public static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static int t,n,k;// test case 의 수, 건물의 수, 건설 순서 규칙의 총 개수
	public static int time[]; // 기존 건설 시간 저장
	public static int copy_time[]; // 뒤의 시간까지 더한 건설 시간 저장
	public static int cnt[]; // 자신에게 오는 노드의 수 저장
	public static ArrayList<Integer>[] graph;
	public static int last_build; // 결과
	public static StringBuilder sb=new StringBuilder();
	public static void play_Game(){
	    // 시작지점을 구해준다.
	    Queue<Integer> q=new LinkedList<>();
	    for(int i=1;i<n+1;i++){
	        if(cnt[i]==0) q.offer(i);
            copy_time[i]=time[i];
	    }
	    
	    // 자신의 노드가 한개라면 그냥 더해주면되고.
	    // 여러개라면 그중에서 최대값을 가져온다. -> 이때 자신의 이전노드를 전부 계산해 놓아야 함.
	    while(true){
	        ArrayList<Integer> zero=new ArrayList<>();
	        // n번째로 돌아가는 것은 한번에 처리해야함으로 배열에 저장
	        while(!q.isEmpty()){
	            int tmp_child=q.poll();
	            for(int i=0;i<graph[tmp_child].size();i++){
    	            int tmp_parent=graph[tmp_child].get(i);
    	            if(--cnt[tmp_parent]==0){
    	                zero.add(tmp_parent);
    	            }
    	            // 선행 노드 제거
    	            copy_time[tmp_parent]=Math.max(copy_time[tmp_parent],
    	                                               time[tmp_parent]+copy_time[tmp_child]);
    	           // n번째 노드까지 걸리는 시간 구하기(여러갈래에서 올 수도 있으므로  max사용)
	            }
	        }
	        if(cnt[last_build]==0) break; // 원하는 값이 나오면 break
	        for(int i=0;i<zero.size();i++){
	            q.offer(zero.get(i));
	        }
	    }
	    
	    sb.append(copy_time[last_build]).append("\n");
	}
	//입력부
	public static void test_Case() throws IOException {
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        
        time=new int[n+1];
        copy_time=new int[n+1];
        cnt=new int[n+1];
        graph=new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            graph[i]=new ArrayList<>();
        }
        
        
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<n+1;i++){
            time[i]=Integer.parseInt(st.nextToken());
        }
        
        for(int i=0;i<k;i++){
            st=new StringTokenizer(br.readLine());
            int child=Integer.parseInt(st.nextToken());
            int parent=Integer.parseInt(st.nextToken());
            cnt[parent]++;
            graph[child].add(parent);
        }
        
        last_build=Integer.parseInt(br.readLine());
        
        play_Game();
	}
	public static void main(String[] args) throws IOException {
        t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){ 
            test_Case();
        }
        
        System.out.print(sb);
        br.close();
	}
}
