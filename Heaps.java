import java.util.Collections;
import java.util.*;
import java.lang.*;

public class Heaps {
    static class NearbyCars implements Comparable<NearbyCars>{
        int x;
        int y;
        public NearbyCars(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(NearbyCars c2){
            double temp1 = Math.sqrt(this.x*this.x + this.y*this.y);
            double temp2 = Math.sqrt(c2.x*c2.x + c2.y*c2.y);
            return (int)(temp1-temp2);
        }
    }
    public static void main(String args[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(3);
        pq.add(4);
        pq.add(1);
        pq.add(7);
        while(!pq.isEmpty()){
            System.out.println(pq.remove());
        }
        Heap heap = new Heap();
        heap.add(3);
        heap.add(4);
        heap.add(1);
        heap.add(7);
        while(!heap.isEmpty()){
            System.out.print(heap.delete()+" ");
        }
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(3);
        temp.add(3);
        arr.add(temp);
        temp = new ArrayList<>();
        temp.add(-2);
        temp.add(4);
        arr.add(temp);
        temp = new ArrayList<>();
        temp.add(5);
        temp.add(-1);
        arr.add(temp);
        arr = nearbyCars(arr,2);
        Scanner sc = new Scanner(System.in);
        PriorityQueue<NearbyCars> pq2 = new PriorityQueue<>();
        for(int i=0; i<3; i++){
            pq2.add(new NearbyCars(sc.nextInt(), sc.nextInt()));
        }
        for(int i=0; i<2; i++){
            NearbyCars temptemp = pq2.remove();
            System.out.println(temptemp.x + " " + temptemp.y);
        }
        System.out.println();
        System.out.println(arr);
        int army[][] = {{1,0,0,0}, {1,1,1,1}, {1,0,0,0}, {1,0,0,0}};
        int k=2;
        PriorityQueue<Row> queue = new PriorityQueue<>();
        for(int i=0; i<army.length; i++){
            int count = 0;
            for(int j=0; j<army[i].length;j++){
                count += army[i][j]==1?1:0;
            }
            queue.add(new Row(count, i));
        }
        for(int i=0; i<k; i++){
            System.out.println("Row"+queue.remove().idx);
        }
    }

    public static ArrayList<ArrayList<Integer>> nearbyCars(ArrayList<ArrayList<Integer>> arr, int k){
        PriorityQueue<Double> pq= new PriorityQueue<>(Comparator.reverseOrder());
        HashMap<Double, ArrayList> hashmap= new HashMap<>();
        for(int i=0; i<arr.size(); i++){
            int x = arr.get(i).get(0);
            int y = arr.get(i).get(1);
            double distance = Math.sqrt(x*x + y*y);
            if(pq.size()<k){
                pq.add(distance);
                hashmap.put(distance, arr.get(i));
            }
            else{
                double minDist = pq.remove();
                if(distance<minDist){
                    pq.add(distance);
                    hashmap.remove(minDist);
                    hashmap.put(distance, arr.get(i));
                }
                else{
                    pq.add(minDist);
                }
            }
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(Map.Entry<Double, ArrayList> i: hashmap.entrySet()){
            result.add(i.getValue());
        }
        return result;
    }
    //For storing custom classes in priority queues with self made comparators
    static class Row implements Comparable<Row>{
        int soldiers;
        int idx;
        public Row(int soldiers, int idx){
            this.soldiers = soldiers;
            this.idx = idx;
        }
        @Override
        public int compareTo(Row r2){
            if(this.soldiers == r2.soldiers){
                return this.idx - r2.idx;
            }
            else{
                return this.soldiers - r2.soldiers;
            }
        }
    }


}

class Heap{
    public ArrayList<Integer> arr = new ArrayList<>();
    public boolean isEmpty(){
        if(arr.size()>0){
            return false;
        }
        return true;
    }
    public void add(int data){
        // add at last of array
        arr.add(data);
        int childIdx = arr.size()-1;
        int parentIdx = (childIdx-1)/2;
        // while value of child is less than parent, swap
        while(arr.get(childIdx)<arr.get(parentIdx)){
            int temp = arr.get(childIdx);
            arr.set(childIdx, arr.get(parentIdx));
            arr.set(parentIdx, temp);
        }
    }
    public int peek(){
        return arr.get(0);
    }
    private void heapify(int idx){
        int left = 2*idx + 1;
        int right = 2*idx + 2;
        int minIdx = idx;
        //for checking whether left and right exist
        if(left<arr.size() && arr.get(minIdx)>arr.get(left)){
            minIdx = left;
        }
        if(right<arr.size() && arr.get(minIdx)>arr.get(right)){
            minIdx = right;
        }
        if(minIdx!=idx){
            int temp = arr.get(idx);
            arr.set(idx, arr.get(minIdx));
            arr.set(minIdx, temp);
            heapify(minIdx);
        }
    }
    public int delete(){
        int top = arr.get(0);
        //Step 1: Swap first and last index
        int temp = arr.get(0);
        arr.set(0, arr.getLast());
        arr.set(arr.size()-1, temp);
        //Step 2: Delete the last index
        arr.removeLast();
        //Step 3: heapify
        heapify(0);
        return top;
    }
}