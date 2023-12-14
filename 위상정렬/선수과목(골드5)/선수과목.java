import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(st.nextToken());// 과목의 개수
	    int m=Integer.parseInt(st.nextToken());// 선수 조건의 선수
	    
	    int cnt[]=new int[n+1];
	    int result[]=new int[n+1];
	    ArrayList<Integer>[] arr=new ArrayList[n+1];
	    for(int i=0;i<n+1;i++){
	        arr[i]=new ArrayList<>();
	    }
	    
	    for(int i=0;i<m;i++){
	        st=new StringTokenizer(br.readLine());
	        int a=Integer.parseInt(st.nextToken());
	        int b=Integer.parseInt(st.nextToken());
	        
	        arr[a].add(b);
	        cnt[b]++;
	    }
	    
	    Queue<Integer> q=new LinkedList<>();
	    for(int i=1;i<n+1;i++){
	        if(cnt[i]==0){
	            q.offer(i);
	            result[i]=1;
	        }
	    }
	    
	    while(!q.isEmpty()){
	        int tmp=q.poll();
	        for(int i=0;i<arr[tmp].size();i++){
	            int prev=result[tmp];
	            int next=arr[tmp].get(i);
	            if(--cnt[next]==0){
                    q.offer(next);
	                result[next]=prev+1;
	            }
	        }
	    }
	    
	    StringBuilder sb=new StringBuilder();
	    for(int i=1;i<n+1;i++){
	        sb.append(result[i]+" ");
	    }

        System.out.print(sb);
	}
}
