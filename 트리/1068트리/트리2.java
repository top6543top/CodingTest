import java.io.*;
import java.util.*;
public class Main
{
    public static ArrayList<ArrayList<Integer>> t;
    public static boolean visited[];
    public static int remove,result=0;
	public static void dfs(int start){
	    visited[start]=true;

        int flag=0;
        // 더 방문할 노드가 없으면 result를 증가시켜준다.
	    for(int i=0;i<t.get(start).size();i++){
	        if(visited[t.get(start).get(i)]==false) flag=1;
	    }
        if(flag==0){
            result++;
        }
        
	    for(int i=0;i<t.get(start).size();i++){
	        int tmp=t.get(start).get(i);
	        if(visited[tmp]==false) dfs(tmp);
	    }
	}
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n=Integer.parseInt(br.readLine()); // 노드의 개수
        t=new ArrayList<>();
        for(int i=0;i<n;i++) t.add(new ArrayList<>());
        visited=new boolean[n];
        
        int flag=-1,start=0;
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int a=Integer.parseInt(st.nextToken());
            flag++;
            if(a==-1){
                start=flag;
                continue;
            } else {
                t.get(flag).add(a);
                t.get(a).add(flag);
            }
        }
        
        remove=Integer.parseInt(br.readLine());
        if(remove==start) {System.out.println("0"); return;}
        //제거해야할 숫자를 가지고 있으면 배열에서 제거한다.
        for(int i=0;i<n;i++){
            if(t.get(i).contains(remove)){
                t.get(i).remove(t.get(i).indexOf(remove));
            }
        }
        
        dfs(start);
        
        System.out.println(result);
	}
}
