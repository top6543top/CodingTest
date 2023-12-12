import java.io.*;
import java.util.*;
public class Main
{
    //lis알고리즘
	public static int down_arr[];
	public static int up_arr[];
	public static int num[];
    public static int n;
	public static void make_Up_Arr(int index){
	    for(int i=0;i<index;i++){
	        if(num[index]>num[i]&& up_arr[index]<up_arr[i]+1){
	            up_arr[index]=up_arr[i]+1;
	        }
	    }
	}
	public static void make_Down_Arr(int index){
	    for(int i=n;i>index;i--){
	        if(num[index]<num[i] && down_arr[index]<down_arr[i]+1){
	            down_arr[index]=down_arr[i]+1;
	        }
	    }
	}
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n=Integer.parseInt(br.readLine());
        down_arr=new int[n+1];
        up_arr=new int[n+1];
        num=new int[n+1];
        
        //up은 0부터 시작해서 상관 없지만 down은 n에서 바로 시작하므로 
        //1로 초기화
        for(int i=0;i<n+1;i++){
            down_arr[i]=1;
        }
        
        int max=0;
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<n+1;i++){
            num[i]=Integer.parseInt(st.nextToken());
        }
        //배열값 찾기
        for(int i=1;i<n+1;i++){
            make_Down_Arr(n+1-i);
            make_Up_Arr(i);
        }
        for(int i=1;i<n+1;i++){
            max=Math.max(max,up_arr[i]+down_arr[i]);
        }
        
        System.out.print(max-1);
	}
}
