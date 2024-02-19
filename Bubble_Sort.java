import java.util.*;
public class Bubble_Sort {
    public static void main(String args[]){
        int[] array = creator();
        array = bubble_sort(array);
        printer(array);
    }
    public static int[] bubble_sort(int[] array){
        for(int pass=0; pass<array.length-1; pass++){
            for(int i=0; i<array.length-1-pass; i++){
                if (array[i]>array[i+1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
        return array;
    }
    public static int[] creator(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();
        int array[] = new int[size];
        System.out.println("Enter the elements in the array: ");
        for(int i=0; i<size; i++){array[i] = sc.nextInt();}
        System.out.println("DONE");
        return (array);
    }
    public static void printer(int array[]){
        for (int i=0; i<array.length; i++){
            System.out.print(array[i]);
            System.out.print(" ");
        }
    }
}
