import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String a=br.readLine();
        Stack<Character> s=new Stack<>();
        
        int result=0;
        for(int i=0;i<a.length();i++){
          //열린괄호면 스택에 넣는다
            if(a.charAt(i)=='(') s.push('(');
            else {
                s.pop();
              //만나면 쇠막대기 끝나는 것 or 레이저 임으로 ()가 세트로 나가야함으로 pop()
                if(a.charAt(i-1)=='(') result+=s.size(); // 전 문자가 (이면 레이저 임으로 그전의 스택에 있는 ( 건 다잘린다.
                else result+=1; // 원래 기본적으로 1개임으로 +1 해준다
            }
        }
        System.out.print(result+"\n");
	}
}
//속도 212ms
