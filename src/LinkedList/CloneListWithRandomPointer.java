package LinkedList;

public class CloneListWithRandomPointer {
    static class Node {
        int val;
        Node next;
        Node random;
        Node(int val) {
            this.val = val;
        }
    }

    static Node cloneList(Node head) {
        if (head == null) {
            return null;
        }
        Node current = head;
        while (current != null) {
            Node copyNode = new Node(current.val);
            copyNode.next = current.next;
            current.next = copyNode;
            current = copyNode.next;
        }
        current = head;
        while (current != null) {
            Node copyNode = current.next;
            if (current.random != null) {
                copyNode.random = current.random.next;
            }
            current = copyNode.next;
        }
        current = head;
        Node cloneHead = head.next;
        while (current != null) {
            Node copyNode = current.next;
            current.next = copyNode.next;
            if (copyNode.next != null) {
                copyNode.next = copyNode.next.next;
            }
            current = current.next;
        }

        return cloneHead;
    }

    static void display(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print("Node: " + current.val);
            if (current.random != null) {
                System.out.print(", Random: " + current.random.val);
            }
            else {
                System.out.print(", Random: null");
            }
            System.out.println();
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);
        first.next = second;
        second.next = third;
        third.next = fourth;
        first.random = third;
        second.random = first;
        third.random = fourth;
        fourth.random = second;
        System.out.println("Original List:");
        display(first);
        Node clonedHead = cloneList(first);
        System.out.println("\nCloned List:");
        display(clonedHead);
    }
}