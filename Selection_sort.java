import java.util.Scanner;

public class Selection_sort {
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
    public static int[] selection_sort(int[] array){
        for(int i=0; i<array.length; i++){
            int minimumIndex = i;
            for(int j=i+1; j<array.length; j++){
                if (array[j]<array[minimumIndex]){
                    minimumIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minimumIndex];
            array[minimumIndex] = temp;
        }
        return array;
    }
    public static void main(String args[]){
        int[] array = creator();
        array = selection_sort(array);
        printer(array);
    }
}
