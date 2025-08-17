package STACK_2;
import java.util.Stack;

class Node {
    char data;
    Node next;
     Node(char d){
        data = d;
        next =null;
     }
}

public class palindromeLL {
    public static void main(String[] args) {
        Node one = new Node('A');
        Node two = new Node('B');
        Node three = new Node('C');
        Node four = new Node('B');
        Node five = new Node('E');

        one.next = two;
        two.next = three;
        three.next= four;
        four.next = five;

        boolean result = isPalindrome(one);
        if(result){
            System.out.println("yes , It is palindrome");

        }else{
            System.out.println("no");
        }


    }

    public static boolean isPalindrome(Node head){
        
        Stack<Character> s = new Stack<>();

        Node temp =head;

        // push the elements to the stack

        while(temp != null){
            s.push(temp.data);
            temp = temp.next ;
        }

        //compare  the head with the top of the stack(pop)
        while(head != null){
            if(head.data != s.pop()){
                return false;
            }
            else{
                head = head.next;
            }
        } 

        return true;
    }
    
}
