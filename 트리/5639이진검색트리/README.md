# 골드 5 5639 이진검색트리

- 문제 유형

  그래프 탐색,이론 , 트리, 재귀

- 공부한 점

  먼저 위 문제와 같이 끝나는 조건이 없는 경우는 while((a = br.readLine()) != null) 을 이용하여 입력을 받으면 된다.

  이진 검색 트리-> 왼쪽의 노드는 부모노드보다 작은 노드, 오른쪽의 노드는 부모노드보다 큰 노드로 이루어져 있다.
  
  내가 풀이한 방법은 트리를 구현하고 전위 순환을 하는 방법이다. 이 방법은 최악의 경우일때 효율적이지 않다.

  재귀를 많이 하기 때문이다. 그래서 다른 방법을 찾아보았다.


  1. 풀이방식
  
  ```java
    //girawhale님의 코드
    import java.util.Scanner;
    
    public class Main {
        static int[] tree = new int[10001];
      
          public static void main(String[] args) {
              Scanner sc = new Scanner(System.in);
      
              int idx = 0;
              while (sc.hasNext())
                  tree[idx++] = sc.nextInt();
      
              postOrder(0, idx - 1);
      
          }
      
          static void postOrder(int n, int end) {
              if (n > end)
                  return;
      
              int mid = n + 1;
              // 어느쪽부터 오른쪽인지 판명하는 반복문
              while (mid <= end && tree[mid] < tree[n])
                  mid++;
      
              postOrder(n + 1, mid - 1);
              postOrder(mid, end);
              System.out.println(tree[n]);
          }
      }

  ```

  위 코드는 이진트리의 특성을 이용한 것이다.

  문제에서 전위 순회한 트리의 출력이 주어지는데 전위 순위의 특징은

  맨 앞은 루트노드, 그 다음 나오는 것은 왼쪽노드, 루트노드보다 커지는 지점은 오른쪽노드이다. 이 방식을 이용하여 구현한 코드이다.

  
