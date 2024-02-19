import java.util.LinkedList;

public class LinkedListInJCF {
    public static void main(String args[]){
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addFirst(10);
        ll.addLast(20);
        ll.add(1,30);
        System.out.println(ll);
        ll.removeFirst();
        ll.removeLast();
        ll.remove(0);
        System.out.println(ll);

    }
}
