import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        String input=br.readLine();
    
        char []stack = new char[input.length()];
        int result=0,flag=0;
        // flag는 배열에 저장함으로 배열의 index를 지칭
        for(int i=0;i<input.length();i++){
            int tmp=0; 
            // 계산값을 result에 저장하기 전에 계산하는 변수
            if(input.charAt(i)=='('){
                stack[flag++]='(';
            } else if(input.charAt(i)=='['){
                stack[flag++]='[';
            }
            //여는 괄호들은 배열에 넣어 저장
            else if(input.charAt(i)==')'){
            //배열에 아무것도 없는데 아래값 들어오면 break    
                if(flag==0) {result=0; break;}
                //닫는 괄호가 나왔으면 바로옆 문자와 비교해서 괄호가 닫혔는지 확인
                if(input.charAt(i-1)=='('){
                    flag-=1; // 배열에 들어간 여는괄호 빼야함으로 flag-=1
                    tmp+=2; // 문제에 따라 tmp값 증가
                    for(int j=0;j<flag;j++){
                        if(stack[j]=='('){
                            tmp*=2;
                        } else {
                            tmp*=3;
                        }
                    }
                }
                // 바로옆에 괄호가 있는경우가 아닐때 처리
                else if(stack[flag-1]=='('){flag-=1;}
                else {result=0; break;}
            } else if(input.charAt(i)==']'){
                if(flag==0) {result=0; break;}
                if(i>0 && input.charAt(i-1)=='['){
                    flag-=1;
                    tmp+=3;
                    for(int j=0;j<flag;j++){
                        if(stack[j]=='('){
                            tmp*=2;
                        } else {
                            tmp*=3;
                        }
                    }
                }
                else if(stack[flag-1]=='['){flag-=1;}
                else {result=0; break;}
            }
                 
            result+=tmp;
        }
        // 빠지지 않은 처리가 있다면 성사가 안된 것이므로 결과 값은 0
        if(flag!=0){result=0;}
        System.out.println(result);
	}
}
