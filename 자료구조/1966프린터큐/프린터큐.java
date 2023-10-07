import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();
        
        int n=Integer.parseInt(br.readLine());//case개수
        
        for(int i=0;i<n;i++){
            Queue<Integer> q=new LinkedList<>();
            st=new StringTokenizer(br.readLine());
            int doc=Integer.parseInt(st.nextToken());//문서의 개수
            int loc=Integer.parseInt(st.nextToken());//찾는 문서의 위치
            
            //중요도를 내림차순으로 정렬
            Integer input[]=new Integer[doc];
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<doc;j++){
                input[j]=Integer.parseInt(st.nextToken());
                q.offer(input[j]);
            }
            Arrays.sort(input,Collections.reverseOrder());

            int flag=0,cnt=0;//뽑는 숫자 가르킴,몇번째로 뽑히는 지 확인
            while(true){
                if(loc==0){ //뽑혀야 하는 숫자가 맨 앞에 있는 경우
                    if(q.peek()==input[flag]){ 
                        // 앞에 있는 숫자가 가장 중요도 높은 숫자일 경우
                        sb.append(++cnt).append("\n");
                        break;
                    } else {
                        q.offer(q.poll());
                        loc=q.size()-1;
                    }
                } else { // 아닌 경우
                    if(q.peek()==input[flag]){ 
                        q.poll();
                        flag++; cnt++;
                        loc-=1;
                    } else {
                        q.offer(q.poll()); 
                        loc-=1;
                    }
                }
            }
        }
        System.out.println(sb);    
	}
}
