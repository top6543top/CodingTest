#골드 4 15683 감시

- 문제 유형

  백트래킹, 시뮬레이션, 브루트포스 알고리즘, 구현

- 공부한 점

  **삼성 코테 문제**

  백트래킹을 이용하여 각 cctv의 방항을 정한다.

  여기서 움직이는 것은 배열로 설정하고

  주석에 달려있는 것처럼 0:북 1:동 2:남 3:서 로 설정하여

  cctv가 한개면 4가지 두개면 16가지 3개면 64가지 이런식으로 모든 방향을 고려한 다음

  감시 구역이 가장 넓은 것을 선정하면 된다. 백트래킹을 사용해도 되지만

  바킹독의 풀이대로 4진법을 배열에 저장하여 진행하였다.

  ---

  10진법 수가 주어졌을때

  ex ) 9    (/4)  ->  2  

      %4=1           %4=2

      21 -> 9의 사진법의 개수이다. (다른 진법도 똑같이 하면 된다.)

  num=1부터 증가시키며 4진법을 배열에 저장하여 풀이한다.
