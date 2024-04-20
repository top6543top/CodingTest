import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int n,m;
    static int parents[];
    public static void union(int x,int y){
        x=find(x);
        y=find(y);

        if(x==y) return;
        
        if(x<=y) parents[x]=y;
        else parents[y]=x;
    }
    public static int find(int x){
        if(parents[x]==x) return x;
        return find(parents[x]);
    }
    public static void main(String[] args) throws IOException {
        // 집합의 합집합 및 같은 집합인지 찾는 문제이므로 union & find를 이용한다
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        parents=new int[n+1];
        for (int i=1;i<n+1;i++) {
            parents[i]=i;
        }

        StringBuilder sb=new StringBuilder();
        for (int i=0;i<m;i++) {
            st=new StringTokenizer(br.readLine());
            int method=Integer.parseInt(st.nextToken());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());

            if(method==0){
                union(a,b);
            } else {
                a=find(a);
                b=find(b);
                if(a==b){
                    sb.append("YES"+"\n");
                } else {
                    sb.append("NO"+"\n");
                }
            }
        }
        System.out.println(sb);
    }
}
