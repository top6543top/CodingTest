import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static int heap[];
    public static int index;
    public static void add(int input){
        heap[++index]=input; 

        int i=index<<1; 
        while((i>>=1)>1){
            if(!swap(i)) break;
        }
    }
    public static boolean swap(int i){
        int parent=heap[i>>1];
        int child=heap[i];
        
        if(Math.abs(parent)<Math.abs(child)){
            return false;
        }
        //swap시에 부모노드와 자식노드의 절댓값이 같은데 실제값이 부모노드가 작으면 바꾸지 않는다.
        if(Math.abs(parent)==Math.abs(child)&&parent<child) {return false;}
        heap[i>>1]=child;
        heap[i]=parent;
        return true;
    }
    public static int remove(){
        if(index==0) return 0;
        int num=heap[1];
        heap[1]=heap[index--]; 
        int i=1;
        while((i<<=1)<=index){
            if(i<index && Math.abs(heap[i])>Math.abs(heap[i+1]) 
                   || (i<index &&Math.abs(heap[i])==Math.abs(heap[i+1]) &&heap[i]>heap[i+1])) i++;
            //여기도 같은 레벨의 노드를 비교하는데 절댓값이 작으면 오른쪽 것으로 넘어간다.
            if(!swap(i)) break;
        }
        return num;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        
        int n=Integer.parseInt(br.readLine());
        heap=new int[n+1];
        for(int i=0;i<n;i++){
            int input=Integer.parseInt(br.readLine());
            if(input==0){
                sb.append(remove()+"\n");
            } else {
                add(input);
            }
        }
        System.out.println(sb); 
    }
}
