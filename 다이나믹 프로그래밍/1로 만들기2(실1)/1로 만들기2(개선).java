import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        ArrayDeque<Integer> aq=new ArrayDeque<>();
        ArrayList<Integer> list=new ArrayList<>();
        int []arr=new int[n+1];

        aq.offerLast(n);

        StringBuilder sb=new StringBuilder();
        while (!aq.isEmpty()) {
            int now=aq.pollFirst();
            if(now==1){
                while(now!=n){
                    list.add(now);
                    now=arr[now];
                }
                //여기서 break를ㄹ 해주면 아래의 next-1>0을 조건문에 넣을 필요가 없다
                break;
            }

            int next=now;
            //next-1>0 비교연산이 들어가면 시간이 많이 잡아 먹힌다.
            if(arr[next=now-1]==0){
                arr[next]=now;
                aq.offerLast(next);
            }
            if(now%3==0 && arr[next=now/3]==0){
                arr[next]=now;
                aq.offerLast(next);
            }
            if(now%2==0 && arr[next=now/2]==0){
                arr[next]=now;
                aq.offerLast(next);
            }
            
            
        }
        
        
        sb.append(list.size()+"\n");
        sb.append(n+" ");
        for (int i=list.size()-1;i>=0;i--) {
            sb.append(list.get(i)+" ");    
        }
        
        System.out.println(sb.toString());
    }
}
