import java.util.*;
import java.io.*;
public class Main
{
    public static int heap[];
    public static int n,index;
    public static void add(int input){
        heap[++index]=input;
        
        int flag=index<<1;
        while((flag>>=1)>1){
            if(!swap(flag)) break;
        }
    }
    public static int poll(){
        if(index==0) return 0;
        
        int max=heap[1];
        heap[1]=heap[index--];
        int i=1;
        while((i<<=1)<=index){
            if(i<index && heap[i]<heap[i+1]) i++;
            
            if(!swap(i)) break;
        }
        
        return max;
    }
    public static boolean swap(int i){
        int parent=heap[i>>1];
        int child=heap[i];
        if(parent>child) return false;
        
        heap[i>>1]=child;
        heap[i]=parent;
        return true;
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb=new StringBuilder();
	    
	    n=Integer.parseInt(br.readLine());
	    heap=new int[n+1];
	    for(int i=0;i<n;i++){
	        int input=Integer.parseInt(br.readLine());
	        if(input==0){
	            sb.append(poll()).append("\n");
	        } else {
	            add(input);
	        }
	    }
	    
	    System.out.println(sb.toString());
	}
}
