import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int dp[][];
    static StringBuilder sb;
    public static void hanoi_top(int start,int mid,int goal, int k){
        if(k==0) return;
        hanoi_top(start,goal,mid,k-1);
        sb.append(start+" "+goal).append("\n");
        hanoi_top(mid,start,goal,k-1);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
    
        int k=sc.nextInt();
        sb=new StringBuilder();
        sb.append((int)Math.pow(2,k)-1).append("\n");
        hanoi_top(1,2,3,k);
        
        System.out.println(sb);
    }
}
