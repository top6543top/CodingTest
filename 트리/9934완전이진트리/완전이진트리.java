import java.io.*;
import java.util.*;
public class Main
{
    public static int bst[];
    public static int result[];
    public static int size;
    public static void search(int start,int last,int index){
        if(index>size){
            return;
        } // index가 배열 사이즈를 넘어가면 안되므로 그때는 재귀를 멈춤
        
        //mid는 항상 parents 이므로 설정
        int mid=(start+last)/2;
        result[index-1]=bst[mid];
        //result에 차곡차곡 루트노드 저장
        
        search(start,mid-1,index*2); // 왼쪽 루트 재귀
        search(mid+1,last,index*2+1); // 오른쪽 루트 재귀
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int k=Integer.parseInt(br.readLine());
        size=(int)Math.pow(2,k)-1;
        bst=new int[size];
        result=new int[size];
        
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<size;i++){
            bst[i]=Integer.parseInt(st.nextToken());
        }
        search(0,size-1,1);
	    
	    StringBuilder sb=new StringBuilder();
	    int a=0,b=1;
	    while(true){
	        if(b>size) break;
	        //인덱스가 사이즈를 넘으면 안되므로 조건문 사용
	        
	        //level이 늘어날수록 1,2,4...씩 늘어남으로 a,b를 이용하여 문자열에 넣기 
	        for(int i=a;i<b;i++){
	            sb.append(result[i]).append(" ");
	        }
	        sb.append("\n");
	        a=b; b=2*b+1;
	    }
	    System.out.println(sb);
	}
}
