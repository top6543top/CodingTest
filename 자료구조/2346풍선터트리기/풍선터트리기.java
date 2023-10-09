import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    int n=Integer.parseInt(br.readLine());
	    
	    Deque<int[]> dq=new ArrayDeque<>();
	    StringBuilder sb=new StringBuilder();
	    
	    st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            //deque에 순서와 움직이는 위치를 저장
            dq.add(new int[]{i+1,Integer.parseInt(st.nextToken())});
        }
        
        int move[]=dq.poll();
        sb.append("1").append(" "); 
        // 무조건 첫번째가 빠짐으로 다음과 같이 저장
        while(!dq.isEmpty()){
            if(move[1]>0){
                move[1]--; 
                // move가 양수이면 앞에가 poll되어 있으므로 한번 움직인 것과 같으므로 한번 빼준다
                for(int i=0;i<move[1];i++){
                    dq.addLast(dq.pollFirst());
                }
            } else {
                for(int i=move[1];i<0;i++){
                    dq.addFirst(dq.pollLast());
                }
            }
            move=dq.poll();
            sb.append(move[0]).append(" ");
        }
        System.out.println(sb);
	}
}
