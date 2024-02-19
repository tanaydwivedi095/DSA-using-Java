import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Arraylist {
    public static void main(String args[]){
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        System.out.println(list1);
        System.out.println(list1.get(0));
        list1.remove(1);
        System.out.println(list1);
        list1.set(0,10);
        System.out.println(list1);
        System.out.println(list1.contains(10));
        System.out.println(list1.size());
        ArrayList<Integer> list2 = creator();
        reversePrinter(list2, 0);
        swap(list2, 5, 8);
        System.out.println("\n"+list2);
        Collections.sort(list2, Collections.reverseOrder());
        System.out.println(list2);
        ArrayList<ArrayList<Integer>> list3 = multiCreator();
        System.out.println(list3);
    }
    public static void reversePrinter(ArrayList<Integer> list, int index){
        if(index==list.size()){
            return;
        }
        reversePrinter(list, index+1);
        System.out.print(list.get(index)+" ");
    }
    public static ArrayList<Integer> creator(){
        ArrayList<Integer> lst = new ArrayList<>();
        for(int i=0; i<10; i++){
            lst.add(i);
        }
        return lst;
    }
    public static void swap(ArrayList<Integer> lst, int idx1, int idx2){
        int temp = lst.get(idx2);
        lst.set(idx2, lst.get(idx1));
        lst.set(idx1, temp);
    }
    public static ArrayList<ArrayList<Integer>> multiCreator(){
        ArrayList<ArrayList<Integer>> lst = new ArrayList<>();
        for(int i=0;i<4;i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j=0; j<5; j++){
                temp.add(j);
            }
            lst.add(temp);
        }
        return lst;
    }
}

/*
Operations in ArrayList
 1. .add(value) - O(1)  or .add(index, value) - O(n)
 2. .get(index) - O(1)
 3. .remove(index) - O(n)
 4. .set(index, value) - O(n)
 5. .contain(value) - O(n)
 6. .size() - O(1)
*/
