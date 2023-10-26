import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n=Integer.parseInt(br.readLine());
        Stack<Integer> s=new Stack[n];
        for(int i=0=;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                s[j].push(Integer.parseInt(st.nextToken()));
            }
        }
        
        StringBuilder sb=new StringBuilder();
        int cnt=0,max=0,max_index=0;
        while(cnt<n){
            for(int i=0;i<n;i++){
              //stack이 비었다면 skip
                if(s[i].size()==0) continue;
                
                if(i==0){
                  //첫번째 값을 max값으로 설정
                    max=s[i].peek();
                    max_flag=i;
                } else {
                  //맨 위값끼리 비교해서 max값 설정
                    if(max<s[i].peek()){
                        max=s[i].peek();
                        max_flag=i;
                    }
                }
            }
            s[max_flag].pop();
            cnt++;
        }
        sb.append(max);
        System.out.print(sb);
	}
}
