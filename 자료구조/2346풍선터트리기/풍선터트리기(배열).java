import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    int n=Integer.parseInt(br.readLine());
	    
	    List<int[]> list=new ArrayList<>();
	    StringBuilder sb=new StringBuilder();
	    
	    st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            //list에 순서와 움직이는 위치를 저장
            list.add(new int[]{i+1,Integer.parseInt(st.nextToken())});
        }
        
        int move[]=list.remove(0);
        int cur=0;
        sb.append("1 ");
        while(!list.isEmpty()){
            if(move[1]>0) move[1]--;
            //move가 양수이면 제거 했을때 한칸 움직인 것과 같으므로 move-1
            
            cur=(cur+move[1])%list.size(); // 현재 위치 계산
            
            if(cur<0) cur+=list.size(); // 음수면 뒤쪽으로 이동
            
            move=list.remove(cur);
            sb.append(move[0]).append(" ");
        }
        
        
        System.out.println(sb);
	}
}
