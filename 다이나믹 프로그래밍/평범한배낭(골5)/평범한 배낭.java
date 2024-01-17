import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken()); // 물품의 수
        int k=Integer.parseInt(st.nextToken()); // 버틸수 있는 무게

        ArrayList<int[]> bp=new ArrayList<>();
        int[][] arr=new int[n][k+1];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int w=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            bp.add(new int[]{w,v});
        }

        for (int i=1;i<k+1;i++){
            for (int j=0;j<n;j++){
                int tmp=bp.get(j)[0];
                if(j==0){
                    //첫번째 가방을 뽑을 때
                    //가방에 담을 수 있는 용량보다 물건의 무게가 적다면
                    //그냥 담는다.
                    if(tmp<=i){
                        arr[j][i]=bp.get(j)[1];
                    }
                } else {
                    // 그 이후 가방을 뽑을때
                    // 담을 수 있으면 그 가방을 담는다.(그 무게가 k라고 하면 가방 전체무게에서 k를 뺀 값을 탐색한다.)
                    // 위의 계산 값이 그전 가방까지 뽑았던것보다 가치가 적다면 그 전 가방까지 뽑았던 것을 고른다.
                    if(tmp<=i){
                        arr[j][i]=Math.max(arr[j-1][i],arr[j-1][i-tmp]+bp.get(j)[1]);
                        //만약 담을 수 없다면 그 전의 값을 그냥 가져온다. 
                        // 만약 3번째 물건을 뽑을때 3번째 물건을 못뽑는다면 2번째의 가치가 최대의 가치기 때문에
                    } else {
                        arr[j][i]=arr[j-1][i];
                    }
                }
            }
        }
       /* for (int i=0;i<n;i++){
            for (int j=0;j<k+1;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }*/
        
        int max=-1;
        for(int i=0;i<n;i++){
            if(max<arr[i][k]) max=arr[i][k];
        }
        
        System.out.println(max);
        
    }
}
