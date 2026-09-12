package LinkedList;

import java.util.Scanner;

class RemoveNthEnd
{
    Node Head;
    Node Tail;
    int size = 0;

    public void InsertAttail(int val) {
        Node temp = new Node(val);

        if(Head == null){
            Head = Tail = temp;

        }
        else{
            Tail.next = temp;
            Tail = temp;
        }

        size++;
    }

    public void removeNthNode(int k) {
        if(k <= 0 || k > size){
            throw new IllegalArgumentException("Invalid Index!");
        }

        Node slow = Head;
        Node fast = Head;

        for(int i=0; i<k; i++){
            fast = fast.next;
        }

        if(fast == null){
            Head = Head.next;
            size--;

            if(Head == null){
                Tail = null;
            }
            return;

        }
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        if(slow.next == Tail){
            Tail = slow;
        }

        slow.next = slow.next.next;
        size--;
    }

    public void display() {

        Node temp = Head;

        while(temp != null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }
}
public class RemoveFromEnd {

    public static void main(String[] args){
        RemoveNthEnd list = new RemoveNthEnd();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter No. Of Nodes : ");
        int n = sc.nextInt();

        System.out.println("Enter Node Elements : ");
        for(int i=0; i<n; i++){
            list.InsertAttail(sc.nextInt());
        }

        System.out.print("Enter Last Kth Index : ");
        int k = sc.nextInt();

        try{
            list.removeNthNode(k);

            System.out.print("List after removing node: ");
            list.display();

        }

        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        sc.close();
    }

}
