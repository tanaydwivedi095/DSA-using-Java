import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Queues {
    public static void main(String args[]){
        QueueUsingArrayList q1 = new QueueUsingArrayList();
        System.out.println(q1.dequeue());
        q1.enqueue(1);
        System.out.println(q1.dequeue());
        System.out.println(q1.dequeue());
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        interleave(q);
        System.out.println(q);
    }
    public static void interleave(Queue<Integer> q){
        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q.size();
        for(int i=0; i<size/2; i++){
            firstHalf.add(q.remove());
        }
        while(!firstHalf.isEmpty()){
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
    }
}

class QueueUsingArrayList{
    public ArrayList<Integer> queue = new ArrayList<>();
    public int front = 0;
    public int rear = 0;
    public void enqueue(int data){
        this.queue.add(data);
        front++;
    }
    public int dequeue(){
        if(front==rear){
            return -1;
        }
        else{
            int temp = queue.get(rear);
            rear++;
            return temp;
        }
    }
}

class DoublyEndedQueue{
    Deque<Integer> deque = new LinkedList<>();
    void function(){
        deque.addFirst(1);
        deque.addLast(2);
        deque.removeFirst();
        deque.removeLast();
    }
}
