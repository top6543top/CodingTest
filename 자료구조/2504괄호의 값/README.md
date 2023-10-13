# 실버 1 2504 괄호의 값

- 문제유형

  자료구조 , 스택

- 공부한 점

  문제 접근 방식 자체는 맞음. 스택문제 풀때 굳이 배열로 풀려고 하지 말자.

  물론 내 풀이할때는 배열이 빠르겠지만 굳이? 시간 차이는 많이 안나는듯

  예외를 오답나는거 보면서 처리해서 조금더 생각할 필요가 있을 듯

  배열로 접근하니 인덱스 관련 오류가 많이 남. 스택으로 풀것

  잘 푼 예시

  ```java
  //bng4535님의 코드
    if(c=='(') {
                mul*=2;
        // 애초에 더하기가 아닌 곱하기로 처음 부터 처리해서 나처럼 계속 반복문 처리하는 일이 없도록 만들었다.
                s.push(c);
            }else if (c=='['){
                mul*=3;
                s.push(c);
            }else if (c==')') {
                if (i>0&& line.charAt(i - 1) == '(') {
                    answer += mul;
                }
                mul/=2;
                if(!s.isEmpty()&&s.peek()=='(') s.pop();
                else {
                    System.out.println(0);
                    return;
                }

            }else if (c==']'){
                if(i>0&& line.charAt(i-1)=='[') {
                    answer+= mul;
                }
                mul/=3;
                if(!s.isEmpty()&& s.peek()=='[') s.pop();
                else {
                    System.out.println(0);
                    return;
                }
            }
        }
  ```
