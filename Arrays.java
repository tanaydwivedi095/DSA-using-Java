import java.util.*;
public class Arrays {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int array[] = creator();
//        int target = sc.nextInt();
//        int temp = linearSearch(array, target);
//        int temp = largetNumberInArray(array);
//        int temp = binarySearch(array, 0, array.length, target);
        int temp[] = reverse(array);
//        System.out.println(temp);
        printer(temp);
    }

    public static void printer(int array[]){
        for (int i=0; i<array.length; i++){
            System.out.print(array[i]);
            System.out.print(" ");
        }
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

    public static int linearSearch(int array[], int target){
        for(int idx=0; idx<array.length; idx++){
            if (array[idx] == target){
                return (idx);
            }
        }
        return (-1);
    }

    public static int largetNumberInArray(int array[]){
        int max = Integer.MIN_VALUE;
        for(int i=1; i<array.length; i++){
            max = Math.max(array[i], max);
        }
        return max;
    }

    public static int binarySearch(int array[], int low, int high, int target){
        if (low<high) {
            int mid = (low + high) / 2;
            if (array[mid] == target) {
                return mid;
            } else {
                if (target < array[mid]) {
                    return binarySearch(array, low, mid-1, target);
                } else {
                    return binarySearch(array, mid+1, high, target);
                }
            }
        }
        else{return -1;}
    }

    public static int[] reverse(int array[]){
        int lPtr = 0;
        int rPtr = array.length-1;
        while (lPtr<rPtr){
            int temp = array[lPtr];
            array[lPtr] = array[rPtr];
            array[rPtr] = temp;
            lPtr++;
            rPtr--;
        }
        return array;
    }
}

/*
 Arrays:
  List of elements of the same type placed in a contigous memory location.

 Creating an Array:
  dataType arrayName[] = new dataType[size];
*/