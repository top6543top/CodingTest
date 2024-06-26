import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        int arr[]=new int[1000001];
        Arrays.fill(arr,1000001);
        arr[1]=0;
        for (int i=1;i<=n;i++) {
            if(i+1<=1000000) arr[i+1]=Math.min(arr[i]+1,arr[i+1]);
            if(i*2<=1000000) arr[i*2]=Math.min(arr[i]+1,arr[i*2]);
            if(i*3<=1000000) arr[i*3]=Math.min(arr[i]+1,arr[i*3]);
        }

        /*for (int i=1;i<=n;i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();*/
        
        int flag=n;
        StringBuilder sb=new StringBuilder();
        sb.append(flag+" ");
        while (flag!=1) {
            if(arr[flag]-1 == arr[flag-1]){
                sb.append(flag-1+" ");
                flag=flag-1;
            }
            if(flag%3==0 && arr[flag]-1 == arr[flag/3]){
                sb.append(flag/3+" ");
                flag=flag/3;
            }
            if(flag%2==0 && arr[flag]-1 == arr[flag/2]){
                sb.append(flag/2+" ");
                flag=flag/2;
            }
        }
        
        System.out.println(arr[n]);
        System.out.println(sb.toString());
    }
}
