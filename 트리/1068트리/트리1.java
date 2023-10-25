import java.io.*;
import java.util.*;
public class Main
{
    public static ArrayList<ArrayList<Integer>> t; // 자식노드만 저장
    public static int parents[]; // 해당 노드의 부모노드 저장
    public static int result=0; // 제거해야하는 리프노드의 개수
    public static void remove_node(int remove){
        int size=t.get(remove).size();
        if(size==0){ 
            // 배열의 사이즈가 0이면 자식이 없는 것이므로 리프노드
            result++;
            return;
        } else {
            for(int i=0;i<size;i++){      
                remove_node(t.get(remove).get(i)); 
            }
        }
        return;
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n=Integer.parseInt(br.readLine()); // 노드의 개수
        t=new ArrayList<>();
        for(int i=0;i<n;i++) t.add(new ArrayList<>());
        parents=new int[n];
        
        int flag=-1,tmp=n;
        st=new StringTokenizer(br.readLine());
        while(tmp-->0){
            int a=Integer.parseInt(st.nextToken());
            flag++;
            if(a==-1) {continue;}
            else {
                t.get(a).add(flag);
                parents[flag]=a;
            }
        }
        //5  ,-1 0 0 1 1 , 1 입력시 
        //[1,2][3,4][][][]
        
        // 접근 방법 -> ArrayList를 다 뒤져서 빈곳이 있으면 그게 리프노드
        // 거기서 제거하는 노드의 리프토드 개수를 뺀다.
        int cnt=0;
        int remove=Integer.parseInt(br.readLine());
        
        remove_node(remove);
        
        if(t.get(parents[remove]).size()==1){
            cnt++++;
        } // 제거하는 노드의 부모노도가 자신만 가지고 있있으면
        // 제거하고 부모노드가 리프노드가 되므로 1을 더해준다.
        
        for(int i=0;i<n;i++){
            if(t.get(i).size()==0) cnt++;
        }
        
        System.out.println(cnt-result);
	}
}
