## 골드 3 앱

- 문제 유형

  다이나믹프로그래밍, 배낭문제

- 문제 해결 방법

  배낭문제 알고리즘을 이용하여 문제를 해결하였다.

  배낭문제란? k의 무게를 담을 수 있는 배낭과 n개의 물건의 무게와 가치가 주어졌을때 가치가 최대가 되도록 담을 수 있는 알고리즘

  알고리즘 해결 방식은 두 가지가 존재한다.

  1. 재귀를 이용한 방식

  - 위 방식은 구현이 간단하나 시간 복잡도가 2^n이기 때문에 사용 못하는 경우가 많다

  2. dp를 이용한 방식
 
  - dp를 이용하여 시간 복잡도가 비교적 낮다. 각 물건을 배열로 즉, 2중배열로 만든후
    
       각 물건이 안 담길 때(dp[i-1][j]) , 담길 때 (dp[i-1][j-무게]+가치) 를 비교하여 최대 값을 가져온다.

  설명 : https://chb2005.tistory.com/158


  - 문제 해결 시 개선 방안
 
    첫 문제 풀이 시에 재귀를 이용하여 풀어 시간 초과가 났다
    
    ```java
      public static void backTracking(int start,int m,int cost){
        if(m>=M){
            result=Math.min(cost,result);
            return;
        }
        if(start==N) return;
        
        backTracking(start+1,m+An[start],cost+Cn[start]);
        backTracking(start+1,m,cost);
    }
    ```
    
    두번째 문제 풀이시에는 기준을 무게로 잡아 배열을 크게 만들어 메모리 초과가 났다.

    ```java

      N=Integer.parseInt(st.nextToken());
      M=Integer.parseInt(st.nextToken());
      An=new int[N+1];
      Cn=new int[N+1];
      dp=new int[N+1][M+1];
    ```

    dp배열을 2중 배열로 하지 않고 cost에 따라 정렬을 하면 1중 배열로 더욱 빠르게 풀 수 있다.
