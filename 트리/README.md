# 트리

  n개의 노드를 가진 트리는 n-1개의 간선을 가진다.

1) 트리의 구현

  1. 이진 트리가 아닌 트리는 그래프를 이용하여 구현한다.

  2. 이진 트리의 구현

     - 일차원 배열을 이용한 구현
    
       완전 이진트리나 포화 이진트리 구현 시 사용 because 다른 트리는 공간의 낭비가 심해짐

       부모가 i일 때 자식은 2*i , 2*i+1

     - 이중 배열을 이용한 구현
    
        ** 내 생각으로는 이중 배열을 이용한 구현 시에는 값을 전부 아는 경우에만 사용해야 할 것 같다.
    
       그래야 값 서로 연결 가능 ** 
  
        node[0]이 root노드일 때 node[0][1]가 left, node[0][2]가 right이다.

        순회방식은 1991 트리순회 문제에 설명 되어 있음.

     - 구조체를 이용한 구현

        ```java
          class Node { //트리의 노드 정보를 저장할 클래스 구조체 
            	int data; //노드 값 
            	Node left; //왼쪽 자식 노드 참조 값 
            	Node right; //오른쪽 자식 노드 참조 값 
            	
            	Node(int data){ 
            		this.data = data;
            	}
            }
        ```

       이와 같은 Node 구조체 생성하고

       ```java
          public class TreeOrderClass {
              	public Node root; //초기 root는 null
              
              	public void createNode(int data, int leftData, int rightData) {
              	}
              
              	public void searchNode(Node node, int data, int leftData, int rightData) { 
              	}
              
              	public void preOrder(Node node) {
              	}
              
              	public void preOrder(Node node) {
              	}
              
              	public void preOrder(Node node) {
              	}
        }
       ```

       트리 클래스를 만들어 노드를 이용하는 형식으로 사용한다.

       3. 이진 검색 트리의 구현
      
          기본적으로 구조체를 이용한 구현이 맞다. 전위 순위나 후위 순위가 주어졌을때는 배열에 저장하고 풀이하는 것을 생각해 보자

          이진 검색 트리에서 중위순회는 자연스럽게 크기순으로 정렬이 된다.
