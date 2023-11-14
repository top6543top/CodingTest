import java.io.*;
import java.util.*;
public class Main
{
    public static int c[][];
    public static StringBuilder sb;
	public static void combination(int a,int b){
	    c=new int[b+1][];
    // 조합론의 삼각형을 이용
	    for(int i=0;i<=b;i++){
	        for(int j=1;j<=b+1;j++){
	            c[i]=new int[j];
	        }
	    }
	    c[0][0]=1;
	    c[1][0]=1;
	    c[1][1]=1;
    // 초기값 설정
	    if(b>=2){
    	    for(int i=2;i<=b;i++){
    	        for(int j=0;j<c[i].length;j++){
    	            if(j==0){
                    // 만약 nC1이면 1로 설정
    	                c[i][j]=1;
    	            } else {
                      //그 뒤의 값이면 조합의 공식 이용 n-1Cr + n-1Cr-1  = nCr
    	                c[i][j]=c[i-1][j]+c[i-1][j-1];
    	            }
    	            if(i==b && j==a){
                    // 원하는 값이 나오면 sb에 붙이고 함수 종료
    	                sb.append(c[i][j]+"\n");
    	                return;
    	            }
    	        }
    	    }
	    } else {
        // 초기값 이내의 것은 바로 출력할 수 있도록 함
	        sb.append(c[b][a]+"\n");
    	   return;
	    }
	}
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb=new StringBuilder();
        
        int n=Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            combination(a,b);
        }
        System.out.print(sb);
	}
}
