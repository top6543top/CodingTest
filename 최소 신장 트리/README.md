## 정의

- 신장 트리

  방향성이 없는 그래프의 부분 그래프에서 모든 정점을 포함하는 트리

- 최소 신장 트리

  신장 트리 중에서 간선의 합이 최소인 신장 트리

## 구하는 법

  - 크루스칼 알고리즘

    Union-Find 알고리즘을 알아야 해결가능

    ---
    * Union-find 알고리즘이란?

    Disjoint-Set(서로소)를 찾아가는 알고리즘

    union(x,y) -> x가 속한 집합과 y가 속한 집합을 합치는 함수

    find(parent,x) -> x가 속한 그룹 찾기(부모찾기) x가 속한 루트 노드를 반환

    ```java
      public static boolean union(int x, int y) {
          	x = find(x); //x의 부모노드 찾기
          	y = find(y); //y의 부모노드 찾기
              
          	// 이미 같은 그래프에 속해있을 때 false 반환
          	if(x == y) return false;
          	
          	if(x <= y) parent[y] = x;
          	else parent[x] = y;
          	return true;
      }
      public static int find(int x) {
        	if(parent[x] == x) return x;
        	return find(parent[x]);
      }
    ```
    ---
