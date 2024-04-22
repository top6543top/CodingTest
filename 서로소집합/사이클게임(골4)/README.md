## 골 4 사이클 게임

https://www.acmicpc.net/problem/20040

### 1. 문제 유형

  자료구조 , 분리집합

### 2. 접근법

  union&find 알고리즘을 이용하여 연결하려는 노드가 다시 같은 사이클에 연결하는지를 확인 했다.

  기존의 union & find 방식으로는 시간오류가 발생하였다. 
  ```java
     public static int find(int x){
        if(parents[x]==x) return x;
        return find(parents[x]);
    }
  ```

### 3. 개선 방안

  시간 오류가 발생하는 이유는 find함수가 최악의 시간복잡도의 경우 모든 노드를 탐색하기 때문인데,

  연결하는 노드를 다른노드를 검사하지 않고 바로 루트 노드를 지칭하도록 코드를 변경하면서 시간 초과 문제를 해결할 수 있었다.
  ```java
    public static int find(int x){
        if(parents[x]==x) return x;
        return parents[x] = find(parents[x]);
    }
  ```

  경로를 찾을게 아니라면 해당 방법으로 풀이하는 게 더 빠르다
