import java.util.*;
import java.io.*;
public class Main
{
	public static int n,m;
	public static int result[];
	public static int input[];
	public static StringBuilder sb;
    // 정석 풀이 -> 배열은 정렬되어 있으므로 i번째까지 입력되어 있으면
    // i+1부터 검사를 하면 된다.
    */static void perm(int depth, int cur) {
		if (depth == M) {
			for (int i = 0; i < depth; i++) {
				sb.append(temp[i]).append(' ');
			}
			//'', "" 차이?
			sb.append('\n');
			return;
		}

		for (int i = cur; i < N; i++) {

			temp[depth] = arr[i];
			perm(depth + 1, i);
		}

	}*/

	public static void backTracking(int start){
	    if(start==m){
            for(int i=0;i<m;i++){
    	     if(i!=0){
                     if(result[i]<result[i-1]){
                         return;
                     }
                 }
            }
	        
	        for(int i=0;i<m;i++){
	            sb.append(result[i]+" ");
	        }
	        sb.append("\n");
            return;
	    }
	    
	    for(int i=0;i<n;i++){
            result[start]=input[i];
	        backTracking(start+1);
	    }
	}
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        
        input=new int[n];
        result=new int[m];
        sb=new StringBuilder();
        
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            input[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        backTracking(0);
        
        System.out.print(sb);
	}
}
