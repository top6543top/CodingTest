import java.io.*;
import java.util.*;
public class Main
{
    public static ArrayList<ArrayList<Integer>> t;
    public static int parent[];
    public static int n;
    public static boolean node(int a){
        // 루트노드의 자식노드가 한개이거나 마지막 노드일 경우에 안됨으로
        // 연결이 한개씩만 된 노드는 안된다.
        if(t.get(a).size()<2) return false;
        else return true;
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n=Integer.parseInt(br.readLine());
        
        t=new ArrayList<>();
        for(int i=0;i<n+1;i++) t.add(new ArrayList<>());
        
        parent=new int[n+1];
        
        for(int i=1;i<n;i++){
            //연결된 걸 이중배열에 저장
            st=new StringTokenizer(br.readLine());
            int first=Integer.parseInt(st.nextToken());
            int second=Integer.parseInt(st.nextToken());
            t.get(first).add(second);
            t.get(second).add(first);
        }
        
        int q=Integer.parseInt(br.readLine());
        
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<q;i++){
            st=new StringTokenizer(br.readLine());
            int choose=Integer.parseInt(st.nextToken());
            int flag=Integer.parseInt(st.nextToken());
            if(choose==1){
                if(node(flag)){
                    sb.append("yes").append("\n");
                } else {
                    sb.append("no").append("\n");
                }
            } else {
                // 단절선은 무조건 yes
                sb.append("yes").append("\n");
            }
        }
        System.out.println(sb);
	}
}
