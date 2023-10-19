import java.util.*;
import java.io.*;

public class Main
{
    public static int [][] tree;
    public static String result="";
    //전위순회 root->left->right
    public static void preOrder(int x){
        //마지막 녿드이면 result에 작성
	    if(tree[x][0]==-19&&tree[x][1]==-19){
	        result+=(char)(x+65);
	    } else {
	        //먼저 방문한 루트노드를 result에 작성
	        result+=(char)(x+65);
	        //왼쪽노드 순회
            if(tree[x][0]!=-19){
                preOrder(tree[x][0]);
            }
            //오른쪽노드 순회
            if(tree[x][1]!=-19){
                preOrder(tree[x][1]);
            }
	    }
	}
	
	//중위순회 left->root->right
	public static void inOrder(int x) {
		if(tree[x][0] == -19 && tree[x][1] == -19) { 
			result+=(char)(x+65);
		} else {
		    //순회 순서에 따라 왼쪽먼저 순회하고
			if(tree[x][0] != -19) {
				inOrder(tree[x][0]);
			}
			//root를 적어주고
			result+=(char)(x+65);
			//오른쪽 순회
			if(tree[x][1] != -19) {
				inOrder(tree[x][1]);
			}
		}
	}
	//후위순회 left->right->root
	public static void postOrder(int x) {
		if(tree[x][0] == -19 && tree[x][1] == -19) {
			result+=(char)(x+65);
		} else {
			if(tree[x][0] != -19) {
				postOrder(tree[x][0]);
			}
			if(tree[x][1] != -19) {
				postOrder(tree[x][1]);
			}
			result+=(char)(x+65);
		}
	}
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        StringBuilder sb=new StringBuilder();
        
        int n=Integer.parseInt(br.readLine());
        tree=new int[n][2];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int p=(int)st.nextToken().charAt(0)-'A';
            int l=(int)st.nextToken().charAt(0)-'A';
            int r=(int)st.nextToken().charAt(0)-'A';
            //. 은 -19
            tree[p][0]=l;
            tree[p][1]=r;
        }
        preOrder(0);
        sb.append(result).append("\n");
        result="";
        inOrder(0);
        sb.append(result).append("\n");
        result="";
        postOrder(0);
        sb.append(result).append("\n");
        
        System.out.print(sb);
	}
}
