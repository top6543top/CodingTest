import java.util.*;
import java.io.*;
public class Main
{
    public static class Node{
        Node right;
        Node left;
        int data;
    }
    public static class Tree{
        Node root=null;
        public StringBuilder sb=new StringBuilder();
        
        public void add(int input){
            //노드를 넣는 작업
            Node newnode = new Node();
            newnode.data=input;
            
            if(root==null){
                root=newnode; 
                //루트노드가 비었다면 넣어준다   
            }else{
                // 넣는 작업이 완료된 루트를 넣어준다.
                root=addTree(root,newnode);   
            }
        }
        public Node addTree(Node root,Node newnode){
            if(root==null){
                return newnode;
            } else {
                if(root.data>newnode.data){
                    root.left=addTree(root.left,newnode);
                } else {
                    root.right=addTree(root.right,newnode);
                }
            }
            return root;
        }
        public void doinOrder(){
            inOrder(root);
        }
        public void inOrder(Node node){
            if(node==null) return;
            inOrder(node.left);
            inOrder(node.right);
            sb.append(node.data).append("\n");
        }
        
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        Tree t=new Tree();
        
        String a;
        while((a=br.readLine())!=null){
            t.add(Integer.parseInt(a));
        }
        t.doinOrder();
        System.out.print(t.sb);
	}
}
