# 실버 1 9934 완전이진트리

- 문제 유형

  트리, 재귀

- 공부한 점

  문제가 완전이진트리가 아닌 포화이진트리를 말하고 있다. 이 점을 파악하지 못하여 시간을 오래썼던것 같다.

  완전 이진트리란? -> 레벨 n인 이진트리가 있다면 n-1까진 모든 노드가 꽉 차있고 n부터는 왼쪽부터 차있는 이진트리를 말한다.(굳이 다 안차도 됌)

  포화 이진트리란? -> 레벨 n 까지 모든 노드가 다 차있는 것을 의미한다.

  이 문제에서는 중위 순회로 탐색한다 왼쪽-> 중앙 -> 오른쪽이므로 무조건 중앙 값이 root노드이다.  이 점을 이용해 재귀를 이용하면 문제를 해결 할 수 있다.

  ** 좀 더 나은 풀이 **

  마지막 출력은 레벨 별로 숫자를 출력하는 것인데 나는 반복문을 써서 변수를 더 사용했다. 여기서 StringBuilder 배열 이나 ArrayList<ArrayList<>>를 이용하여

  레벨을 표현했으면 더 좋았을 것 같다.
