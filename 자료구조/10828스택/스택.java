import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Stack<Integer> s=new Stack<>();
        
        int n=Integer.parseInt(br.readLine());
        
        StringBuilder result=new StringBuilder();
        for(int i=0;i<n;i++){
            String cmd=br.readLine();
            String[] input=cmd.split(" ");
            switch(input[0]){
                case "push":
                    s.push(Integer.parseInt(input[1]));
                    break;
                case "pop":
                    if(s.isEmpty()){
                        result.append("-1").append("\n");
                    } else {
                         result.append(s.pop()).append("\n");
                    }
                    break;
                case "size":
                    result.append(s.size()).append("\n");
                    break;
                case "empty":
                    if(s.isEmpty()){
                        result.append("1").append("\n");
                    } else {
                        result.append("0").append("\n");
                    }
                    break;
                case "top":
                    if(s.isEmpty()){
                        result.append("-1").append("\n");
                    } else {
                        result.append(s.peek()).append("\n");
                    }
                    
                    break;
            }
        }
        System.out.println(result);
	}
}
