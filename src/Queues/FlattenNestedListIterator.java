package Queues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Arrays;

public class FlattenNestedListIterator {
    private Queue<Integer> queue;
    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        queue = new LinkedList<>();
        flatten(nestedList);
    }
    private void flatten(List<NestedInteger> nestedList) {
        for (NestedInteger element : nestedList) {
            if (element.isInteger()) {
                queue.offer(element.getInteger());
            }
            else {
                flatten(element.getList());
            }
        }
    }
    public int next() {
        return queue.poll();
    }
    public boolean hasNext() {
        return !queue.isEmpty();
    }
    public static void main(String[] args) {
        List<NestedInteger> nestedList = new ArrayList<>();
        nestedList.add(new MyNestedInteger(Arrays.asList(new MyNestedInteger(1),new MyNestedInteger(1))));
        nestedList.add(new MyNestedInteger(2));
        nestedList.add(new MyNestedInteger(Arrays.asList(new MyNestedInteger(1),new MyNestedInteger(1))));
        FlattenNestedListIterator iterator = new FlattenNestedListIterator(nestedList);
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
class MyNestedInteger implements NestedInteger {
    private Integer value;
    private List<NestedInteger> list;
    public MyNestedInteger(int value) {
        this.value = value;
        this.list = null;
    }
    public MyNestedInteger(List<NestedInteger> list) {
        this.list = list;
        this.value = null;
    }

    @Override
    public boolean isInteger() {
        return value != null;
    }
    @Override
    public Integer getInteger() {
        return value;
    }
    @Override
    public List<NestedInteger> getList() {
        return list;
    }
}
interface NestedInteger {
    boolean isInteger();
    Integer getInteger();
    List<NestedInteger> getList();
}
