# 실버 2 스택 수열

- 문제 유형

  자료구조 스택

  ---

- 공부한 점

  ```java
      for(int i=0;i<n;i++){
	        int num=Integer.parseInt(br.readLine());
    	    while(true){
    	        //스택이 비었거나 수열의 숫자가 더 크면 값을 집어 넣는다.
                if(s.empty() || s.peek()<num){
                    s.push(cnt++);
                    sb.append("+\n");
                } else {
                    break;
                }
    	    }
            //다 들어왔는데 입력된 숫자가 아니면 뺄수 없는 것이다.
            if(s.peek()!=num){
                sb=new StringBuilder("NO");
                System.out.println(sb);
                return;
            }
            //같으면 빼준다.
            s.pop();
            sb.append("-\n");
    	    }
  ```

  먼저 기존의 코드에서 개선한 코드이다. 기존의 코드에서는 배열에 입력값을 저장해서 비교했지만 여기서는

  입력받는대로 스택에 값을 집어 넣고 조건을 조사한다. 배열로 풀면 더욱 빠르게 풀 수 있다.

  정해진 값이 들어가는 경우 배열로 푼다. 여기서는 1~n까지의 정해진 수가 들어간다.
