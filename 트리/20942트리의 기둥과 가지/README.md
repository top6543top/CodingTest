#골드 4 트리의 기둥과 가지

```java
  public static void root_dfs(int start,int dis){
        visited[start]=true;
        int cnt=0;
        int[] next=new int[2];
        for(int[] n:tree[start]){
            //tree[start]에 저장되어 있는 배열을 n이 다 가져온다.
            if(!visited[n[0]]){
                cnt++;
                next=n;
            }
        }
        if(cnt==1){
            root_dfs(next[0],dis+next[1]);
        } else {
            giga=start;
            root=dis;
            return;
        }
	}
```

root_dfs를 다음과 같은 방식으로 수정했더니 1540-> 1200으로 속도 증가
