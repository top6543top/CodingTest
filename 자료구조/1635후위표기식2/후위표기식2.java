import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String input=br.readLine();
        
        double a[]=new double[n];
        for(int i=0;i<n;i++){
            a[i]=Double.parseDouble(br.readLine());
        }
        
        double x,z;
        Stack<Double> s=new Stack<>();
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)>=65 && input.charAt(i)<=90){
                //값저장은 A부터 순차적으로 이루어지므로 a배열의 
                //배열값을 스택에 다음과 같이 저장.
                s.push(a[input.charAt(i)-'A']);
            } else if(input.charAt(i)=='-'){
               if(s.size()>=2){
                    z=s.pop();
                    x=s.pop();
                    s.push(x-z);
                } else {
                    z=s.pop();
                    s.push(-z);
                }
            } else if(input.charAt(i)=='*'){
                z=s.pop();
                x=s.pop();
                s.push(x*z);
            } else if(input.charAt(i)=='+'){
                if(s.size()>=2){
                    z=s.pop();
                    x=s.pop();
                    s.push(x+z);
                }
            } else if(input.charAt(i)=='/'){
                z=s.pop();
                x=s.pop();
                s.push(x/z);
            }
        }
        System.out.printf("%.2f", s.pop());
	}
}
