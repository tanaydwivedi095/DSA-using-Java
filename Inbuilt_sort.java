import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.Collections;

public class Inbuilt_sort {
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

    public static void main(String args[]){
        int[] array = creator();
        Arrays.sort(array);
        printer(array);
        array = creator();
        Arrays.sort(array, 2,5);
        printer(array);
    }
}
