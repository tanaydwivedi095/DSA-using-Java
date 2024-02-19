import java.util.Scanner;

public class Insertion_sort {
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
    public static int[] insetion_sort(int[] array){
        for(int i=0; i<array.length; i++){
            int curr = array[i];
            int prev = i-1;
            while(prev>=0 && array[prev]>curr){
                array[prev+1] = array[prev];
                prev--;
            }
            array[prev+1] = curr;
        }
        return array;
    }

    public static void main(String args[]){
        int[] array = creator();
        array = insetion_sort(array);
        printer(array);
    }
}
