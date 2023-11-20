import java.io.*;
import java.util.*;
public class Main
{
	public static ArrayList<int[]>[] tree;
    public static int n,r,giga;
	public static boolean visited[];
	public static int root; // 루트의 길이
	public static ArrayList<Integer> l;
	public static void root_dfs(int start){
        visited[start]=true;
        if(start==r && tree[start].size()>=2){
            giga=start;
            return;
        } // 루트노드가 기가노드이면 처리
        if(tree[start].size()>2){
	        giga=start;
            return;
	    } // 다른 노드가 기가 노드이면 처리
	    
	    //dfs로 root부분 탐색
       for(int i=0;i<tree[start].size();i++){
	        if(!visited[tree[start].get(i)[0]]){
	            root+=tree[start].get(i)[1];
                root_dfs(tree[start].get(i)[0]);
	        }
	    }
	}
	public static void branch_dfs(int start,int b){
	    visited[start]=true;
	    //리프노드이면 가지의 길이를 list에 넣는다.
	    if(tree[start].size()==1){
	        l.add(b);
	        return;
	    }
	    //dfs로 가지 탐색 
	    for(int i=0;i<tree[start].size();i++){
	        if(!visited[tree[start].get(i)[0]]){
	            branch_dfs(tree[start].get(i)[0],b+tree[start].get(i)[1]);
	        }
	    }
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());//노드의 개수
		r=Integer.parseInt(st.nextToken());//루트노드의 번호
		
		tree=new ArrayList[n+1];
		for(int i=0;i<n+1;i++){
		    tree[i]=new ArrayList<>();
		}
		l=new ArrayList<>();
		visited=new boolean[n+1];

		for(int i=1;i<n;i++){
		    st=new StringTokenizer(br.readLine());
		    int a=Integer.parseInt(st.nextToken());
		    int b=Integer.parseInt(st.nextToken());
		    int d=Integer.parseInt(st.nextToken()); // 거리
		    
		    tree[a].add(new int[]{b,d});
            tree[b].add(new int[]{a,d});
		}
        
		root_dfs(r);
		if(giga!=0){
		    branch_dfs(giga,0);
		}
		// giga값을 받아서 오름차순 정렬 후  출력
        if(l.size()==0){l.add(0);}
        else {Collections.sort(l);}
		System.out.print(root+" "+l.get(l.size()-1));
	}
}
