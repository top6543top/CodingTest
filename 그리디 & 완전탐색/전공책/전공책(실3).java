import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static String make;
    public static int bcnt,min_cost=1000000;
    public static int[] cost;
    public static String[] name;
    public static int[] alpha;
    public static int[] select;
    public static void backTracking(int start,int tmp_cost){
        if(start==bcnt){
            int flag=0;
            // 문장의 구성보다 더 적게 알파벳이 구성되어 있다면 성립 x
            for(int i=0;i<26;i++){
                if(alpha[i]>select[i]) flag=1;
            }

            if(flag==0){
                min_cost=Math.min(min_cost,tmp_cost);
            }
            return;
        }
        // 경우의 수는 이 책을 선택하느냐 안하느냐이다.
        for(int i=0;i<name[start].length();i++){
            //이 반복문은 선택한 경우이므로 고른 책의 알파벳 구성을 나타내는 배열에 넣어준다
            select[name[start].charAt(i)-'A']++;
        }
        //고른경우 가격을 더해서 재귀를 돌려준다.
        backTracking(start+1,tmp_cost+cost[start]);
        for(int i=0;i<name[start].length();i++){
            //이 경우는 선택 안한 경우이므로 앞에서 더해준것을 빼서 없던 것으로 만들어준다.
            select[name[start].charAt(i)-'A']--;
        }
        // 선택안한 경우는 값을 그냥 보내준다.
        backTracking(start+1,tmp_cost);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        make=br.readLine();
        bcnt=Integer.parseInt(br.readLine());
        cost=new int[bcnt];
        name=new String[bcnt];
        
        alpha=new int[26];
        select=new int[26];
        //문장에 들어있는 알파벳의 구성을 배열에 저장한다.
        for(int i=0;i<make.length();i++){
            alpha[make.charAt(i)-'A']++;
        }
            
        for(int i=0;i<bcnt;i++){
            st=new StringTokenizer(br.readLine());
            cost[i]=Integer.parseInt(st.nextToken());
            name[i]=st.nextToken();
        }
        
        backTracking(0,0);

        if(min_cost==1000000){
            System.out.println(-1);
            return;
        }
        System.out.println(min_cost);
        
    }
}
