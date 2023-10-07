# 실버 3 1966 프린터 큐

- 문제 유형

  자료구조, 큐

- 공부한 점

  문제 풀이 방식은 배열에 중요도 저장하여 큐와 비교해가면서 문제를 해결하였다.

  비교하는 다른 방법

  ```java
    for (int i = 9; i > 0; i--) {
           while (counter[i] > 0) {
                 // 중요도는 1부터 9까지이다.
                 // counter은 그 중요도에 몇개가 있는지 새는 배열이다.
                 // 이렇게하면 나처럼 정렬할 필요 x <시간 단축>
                item = q.poll();
                  // 여기서 q는 int 배열이 들어있다.
                  // 0에는 큐에 몇번째 있는지 1에는 중요도가 저장
                if (item[1] == i) {
                    counter[i]--;
                    count++;
                    if (item[0] == m) {
                        return count;
                    }
                } else {
                    q.offer(item);
                }
            }
        }
  ```
