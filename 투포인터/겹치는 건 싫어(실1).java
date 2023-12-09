import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str=new StringTokenizer(br.readLine());
        
        int n=Integer.parseInt(str.nextToken());
        int k=Integer.parseInt(str.nextToken());
        
       
        int input[]=new int[n];
        
        str=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            input[i]=Integer.parseInt(str.nextToken());
        }
        
        int num[]=new int[100001];
        int st=0,en=0,max=-1;
        while(en<n){
            while(en<n){
                if(num[input[en]]+1<=k){
                    num[input[en]]++;
                    en++;
                } else {
                    break;
                }
            }
            num[input[st]]--;
            max=Math.max(max,en-st);
            st++;
        }
        
        System.out.print(max);
	}
}
