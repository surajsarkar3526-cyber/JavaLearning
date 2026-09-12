package LinkedList;

public class FlattenMultilevelDoublyLinkedList {

    static class Node {

        int val;
        Node next;
        Node prev;
        Node child;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;

        head.next.next = new Node(3);
        head.next.next.prev = head.next;

        head.next.next.next = new Node(4);
        head.next.next.next.prev = head.next.next;

        Node node3 = head.next.next;

        node3.child = new Node(7);
        node3.child.next = new Node(8);
        node3.child.next.prev = node3.child;

        node3.child.next.next = new Node(9);
        node3.child.next.next.prev = node3.child.next;

        Node node8 = node3.child.next;

        node8.child = new Node(11);
        node8.child.next = new Node(12);
        node8.child.next.prev = node8.child;

        System.out.print("Original Main List: ");
        display(head);

        head = flatten(head);

        System.out.print("Flattened List: ");
        display(head);

        System.out.print("Backward List: ");
        displayBackward(head);
    }

    private static Node flatten(Node head) {

        if (head == null) {
            return null;
        }

        Node current = head;

        while (current != null) {

            if (current.child != null) {

                Node childHead = current.child;

                Node childTail = childHead;

                while (childTail.next != null) {
                    childTail = childTail.next;
                }

                Node nextNode = current.next;

                current.next = childHead;
                childHead.prev = current;

                flatten(childHead);

                childTail = childHead;

                while (childTail.next != null) {
                    childTail = childTail.next;
                }

                childTail.next = nextNode;

                if (nextNode != null) {
                    nextNode.prev = childTail;
                }

                current.child = null;
            }

            current = current.next;
        }

        return head;
    }

    private static void display(Node head) {

        Node current = head;

        while (current != null) {

            System.out.print(current.val);

            if (current.next != null) {
                System.out.print(" <-> ");
            }

            current = current.next;
        }

        System.out.println();
    }

    private static void displayBackward(Node head) {

        if (head == null) {
            return;
        }

        Node tail = head;

        while (tail.next != null) {
            tail = tail.next;
        }

        while (tail != null) {

            System.out.print(tail.val);

            if (tail.prev != null) {
                System.out.print(" <-> ");
            }

            tail = tail.prev;
        }

        System.out.println();
    }
}