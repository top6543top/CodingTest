import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String a=br.readLine();
        int tail=a.length();
        
        int pipe[]=new int[tail];
        for(int i=0;i<tail;i++){
            pipe[i]=0;
        }
        tail-=1; 
        
        // 뒤에서부터 찾기 진행
        int laser=1; 
        // laser은 막대기가 몇개인지 알려주는 변수
        int result=0;
        while(tail>-1){
            //전에 것과 비교해서 레이저인지 판결
            if(a.charAt(tail)=='(' && a.charAt(tail+1)==')' ){
                laser--; // 아래부분에서 열린괄호로 판단하고 하나 더했음으로 빼줌
                for(int i=0;i<=laser;i++){
                    pipe[i]++; 
                    // 한 막대기에 레이저가 몇개있는지 판단하기 위해 레이져 만나면 변수 증가
                }
                tail--;
                //tail은 어딜 검사하고 있는지
                continue;
            }
            if(a.charAt(tail)==')'){
                laser++;
            } // 쇠막대기의 시작
            else if(a.charAt(tail)=='(') {
                result+= (pipe[laser]+1);
                pipe[laser]=0;
                laser--;
            } // 레이저가 아닌 열린괄호를 만나면 안에있는 레이저로 나눈 개수 더해줌 변수 초기화
             tail--;
        }
        
        System.out.println(result);
        
	}
}
// 속도 632ms
