# 실버 3 2407 조합

- 문제 유형

  다이나믹 프로그래밍, 조합론, 큰 수 계산

- 공부한 점

  왜 다이나믹 프로그래밍이 카테고리인지 모르겠음

  큰 수 계산이 메인인 카테고리

  -> 무한대인 수 연산 시에

  BigInteger을 사용한다. BigInteger은 객체로써 선언하여 사용하는데 이것의 원리는 스트링으로 숫자를 저장하여 연산하는 것이다.

  BigInteger num=new BigInteger("10000"); 와 같이 사용하거나

  BigInteger bigNum1 = BigInteger.ZERO;  // 0

  BigInteger bigNum2 = BigInteger.ONE;   // 1

  BigInteger bigNum3 = BigInteger.TEN;   // 10

  다음과 같이 사용할 수 있다.

  또한 연산도 가능한데

      // 사칙연산  

   afterBigNum = bigNum1.add(bigNum3);        // 더하기

   afterBigNum = bigNum3.subtract(bigNum2);    // 빼기   

   afterBigNum = bigNum2.multiply(bigNum3);    // 곱하기

   afterBigNum = bigNum3.divide(bigNum2);        // 나누기

    // 변수와 사칙연산

    afterBigNum = bigNum1.add(BigInteger.valueOf(i));        // 더하기

   afterBigNum = bigNum1.subtract(BigInteger.valueOf(i));    // 빼기

   afterBigNum = bigNum1.multiply(BigInteger.valueOf(i));    // 곱하기

   afterBigNum = bigNum1.divide(BigInteger.valueOf(i));    // 나누기

  이와 같이 연산을 할때는 안에 다른 BigIntger객체가 들어가야 한다.
