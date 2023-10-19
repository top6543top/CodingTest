# 트리

1) 트리의 구현

  트리의 구현은 이진 트리일경우 직접 구현하는 경우가 많은거 같다.

  이진 이상 연결된 트리는 그래프 형식으로 연결 시켜 탐색하고 값을 저장하는게 더욱 좋을 것 같다. 

  트리의 직접 구현은

  ```java
    class Node{
      Object data;
      Node left;
      Node right;
    }
  ```

  그 외의 add remove와 같은 함수는 객체 안에 구현해 주면된다. 

  TreeSet, TreeMap을 사용하는 방법도 있는데 함수는 찾아보고 풀이하도록 하자
