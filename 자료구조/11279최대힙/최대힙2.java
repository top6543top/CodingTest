import java.util.*;
import java.io.*;
public class Main
{
    public static int heap[];
    public static int n,index;
    public static void add(int input){
	//index를 늘리며 배열의 마지막에 들어온 값 저장
        heap[++index]=input;
        
        int flag=index<<1; // 반복문을 돌리기 위해 미리 비트연산
        while((flag>>=1)>1){
	    //child node -> parents node:beat calculation 
            if(!swap(flag)) break;
        }
    }
    public static int poll(){
         // 배열에 아무것도 들어있지 않다면 return 0
        if(index==0) return 0;
        
        int max=heap[1]; // 최대힙의 가장 큰값은 루트노드임으로 저장
        heap[1]=heap[index--]; // 루트노드를 없애고 그 자리를 매꿔야 함으로 
	// 가장 작은 노드를 루트노드로 변경
        int i=1;
        while((i<<=1)<=index){
	    // 만약 같은 레벨에 더 큰값이 있으면 i값을 옮겨 비교
            if(i<index && heap[i]<heap[i+1]) i++;
            // 부모노드와 자식노드 swap
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
