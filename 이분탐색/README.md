- 이분탐색이란?

  정렬되어 있는 배열에서 특정 데이터를 찾기위해 모든 데이터를 순차적으로 확인하는 대신 탐색 범위를 절반으로 줄여가며 찾는 탐색 방법

  주의할점 : 무한루프 빠지는 것을 조심해라 mid값을 잘 설정해야 한다. 배열은 정렬 되어 있어야 한다.

  st 값과 end 값이 한자리 차이가 나면 ex) st=2 end=3일때 st+end / 2 = 2로 st,end,mid가 합쳐지지 않는다.

  mid가 계속 2가 나온다 이와 같은 상황은 mid=st+end+1 / 2와 같이 mid를 설정 해서 해결해야 한다.

-이분탐색의 정의
https://www.acmicpc.net/blog/view/109

-이분탐색을 어떻게 범주를 정해야 하는가?
https://blossoming-man.tistory.com/entry/%EC%9D%B4%EC%A7%84-%ED%83%90%EC%83%89-Binary-Search-%EA%B2%BD%EA%B3%84-%EC%84%A4%EC%A0%95%EC%9D%84-%EC%96%B4%EB%96%BB%EA%B2%8C-%ED%95%B4%EC%95%BC-%ED%95%98%EB%8A%94%EA%B0%80
