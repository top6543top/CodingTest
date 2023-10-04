## 실버 4 10828 스택

- 문제 유형

  스택

- 공부한 점

  스택은 구현된 라이브러리 이용도 가능하지만 배열을 이용할 수 있다.

  배열 풀이법
  1) 문제에서는 n번만 입력을 받으므로 최대 push의 개수는 n개이다.
     따라서 배열의 크기는 n으로 지정해주면 된다.
  2) 스택은 FILO의 형태이므로 넣을때는 index를 더해주면서 넣으면 되고 뺄때는 인덱스를 마이너스 해줘서 접근하게 하면 된다.

     ```java
      static void push() throws Exception {
		    stack[++index] = read();
	    }


       static void pop() {
	      	if (index == -1)
			        sb.append("-1\n");
		      else
			        sb.append(stack[index--]).append("\n");
	        }
     ```

     와 같이 구현하면 된다.
