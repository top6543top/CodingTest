import java.util.*;
import java.io.*;
public class Main
{
    static int queue[];
    static int back=0,front=0;
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb=new StringBuilder();
        
        int n=Integer.parseInt(br.readLine());
        queue=new int[n];
        for(int i=0;i<n;i++){
            String input=br.readLine();
            String[] a=input.split(" ");
            switch(a[0]){
                case "push":
                    queue[back++]=Integer.parseInt(a[1]);
                    break;
                case "pop":
                    if(front==back){
                        sb.append("-1\n");   
                    }else{
                        sb.append(queue[front++]).append("\n");
                    }
                    break;
                case "size":
                    
                        sb.append(back-front).append("\n");
                
                    break;
                case "empty":
                    if(front==back){
                        sb.append("1\n");   
                    }else{
                        sb.append("0\n");   
                    }
                    break;
                case "front":
                    if(front==back){
                        sb.append("-1\n");   
                    }else{
                        sb.append(queue[front]).append("\n");
                    }
                    break;
                case "back":
                    if(front==back){
                        sb.append("-1\n");   
                    }else{
                        sb.append(queue[back]).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
	}
}
