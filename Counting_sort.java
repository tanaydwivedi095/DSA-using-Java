import java.util.Scanner;

public class Counting_sort {
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
    public static void printer(int[] array){
        for (int i=0; i<array.length; i++){
            System.out.print(array[i]);
            System.out.print(" ");
        }
    }
    public static int[] counting_sort(int[] array){
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<array.length; i++){
            largest = Math.max(array[i], largest);
        }
        int count[] = new int[largest+1];
        for(int i=0; i<array.length; i++){
            count[array[i]]++;
        }
        int j = 0;
        for(int i=0; i<count.length; i++){
            while (count[i]>0){
                array[j] = i;
                j++;
                count[i]--;
            }
        }
        return array;
    }
    public static void main(String args[]){
        int[] array = creator();
        array = counting_sort(array);
        printer(array);
    }
}
