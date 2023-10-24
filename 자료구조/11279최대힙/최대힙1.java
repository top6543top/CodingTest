import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        // 높은숫자를 기준으로 하는  max_heap 문제 해결의 속도는 340ms
        PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());
	    
	    StringBuilder sb=new StringBuilder();
	    
	    int n=Integer.parseInt(br.readLine());
	    for(int i=0;i<n;i++){
	        int input=Integer.parseInt(br.readLine());
	        if(input==0){
	            if(max_heap.size()==0){
	                sb.append("0\n");
	            } else {
	                sb.append(max_heap.poll()).append("\n");
	            }
	        } else {
	            max_heap.offer(input);
	        }
	    }
	    
	    System.out.println(sb.toString());
	}
}
