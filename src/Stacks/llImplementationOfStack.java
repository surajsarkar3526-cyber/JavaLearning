package Stacks;
import java.util.Scanner;

class Node{
    int val;
    Node next;

    Node(int val){
        this.val = val;
    }
}
class MyStack{
    Node head;
    int len;
    int peek(){
        if(head==null){
            System.out.print("Stack Empty!");
            return -1;
        }
        return head.val;
    }
    int pop(){
        if(head==null){
            System.out.print("Stack Empty!");
            return -1;
        }
        int x = head.val;
        head = head.next;
        len--;
        return x;

    }
    void push(int ele){
        Node temp = new Node(ele);
        if(len == 0){
            head = temp;
        }
        else{
            temp.next = head;
            head = temp;
        }
        len++;
    }
    int size(){
        return len;
    }
    void display(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
        System.out.println();
    }
}
public class llImplementationOfStack {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        MyStack st = new MyStack();
        st.push(64); st.push(47); st.push(23); st.push(98);
        st.display();
        st.pop();
        st.display();

        sc.close();
    }
}
