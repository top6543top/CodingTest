import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    int n=Integer.parseInt(br.readLine());
	    
	    Stack<Integer> s=new Stack<>();
	    StringBuilder sb=new StringBuilder();
	    int cnt=1,flag=0;
	    //cnt는 1~n중에 어디까지 넣었는지
	    //flag는 수열을 어디까지 만들었는지
	    int num[]=new int[n];
	    for(int i=0;i<n;i++){
	        num[i]=Integer.parseInt(br.readLine());
	    }
	    while(flag<n){
	        //스택이 비었거나 수열의 숫자가 더 크면 값을 집어 넣는다.
            if(s.empty() || s.peek()<num[flag]){
                s.push(cnt++);
                sb.append("+\n");
            } 
            //값을 빼려고 하는데 위의 값이 수열의 값보다 큰경우
            //원하는 값이 스택의 밑부분에 있기때문에 뺄 수 없다.
            if(s.peek()>num[flag]){
                sb=new StringBuilder("NO");
                break;
            }
            //같으면 빼준다.
            if(s.peek()==num[flag]){
                s.pop();
                flag++;
                sb.append("-\n");
            }
	    }
	    
        System.out.println(sb);
	}
}
