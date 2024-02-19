import java.util.Scanner;

public class KadanesAlgorithm {
    public static int algorithm(int array[]){
        int currSum = 0;
        int maxSum = 0;
        for(int idx=0; idx<array.length; idx++){
            int temp = currSum+array[idx];
            if (temp<=0){currSum=0;}
            else{
                currSum = temp;
                maxSum = Math.max(currSum, maxSum);
            }
        }
        return maxSum;
    }

    public static int[] creator(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();
        int array[] = new int[size];
        for (int i=0; i<array.length; i++){
            array[i] = sc.nextInt();
        }
        return array;
    }

    public static void main(String args[]){
        int array[] = creator();
        int temp = algorithm(array);
        System.out.println(temp);
    } 
}

// If all elements in the array are negative the algorithm will always return 0

/*
Algorithm
 1. Initialize two variables maxSum and currSum as 0
 2. Run a loop
    2.1. If currSum+currElement <= 0 make currSum=0
    2.2. Else currSum = currSum+currElement and maxSum = max(maxSum, currSum)
 3. Return maxSum
 */