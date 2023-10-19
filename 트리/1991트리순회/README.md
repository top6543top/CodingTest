# 실버 1 1991 트리순회

- 문제 유형

  트리, 재귀

- 공부한 점

  root기준으로 트리순회한다.

  전위순회 : root->left->right (preOrder)

  중위순회 : left->root->right (inOrder)

  후위순회 : left->right->root (postOrder)

  문제 유형이 재귀인 이유는 순회 방식으로 재귀를 이용한다.

  ex)
  root를 출력하고 재귀 함수를 통해 left노드를 탐색, 이후 right노드 탐색하는 방식으로 쭉 내려간다.

  ```java
    if(x의 left가 빈것이 이고 && x의 right가 빈 것이면) print(x)
    else
      print(x)
      if(x의 left가 빈것이 아니면) x.left로 함수를 재귀
      if(x의 right가 빈것이 아니면) x.right로 함수를 재귀
  ```
