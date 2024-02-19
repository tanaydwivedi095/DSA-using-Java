import java.util.*;

public class Recursion {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
//        printInDecreasing(n);
//        System.out.println("\n"+fibonacci(n));
//        System.out.println("\nEnter the elements of the array: ");
//        int[] array = new int[n];
//        for(int i=0; i<n; i++){
//            array[i] = sc.nextInt();
//        }
//        System.out.println(isSorted(0, array));
//        System.out.println(exponentCalc(n,4));
        String str = sc.next();
        int[] occur = new int[26];
        for(int i=0; i<26; i++){occur[i]=0;}
        System.out.println(removeDuplicates(str, occur, 0));
    }
    public static void printInDecreasing(int n){
        if(n==0){
            return;
        }
        else{
            System.out.print(n+"-->");
            printInDecreasing(n-1);
        }
    }
    public static int fibonacci(int n){
        if(n<=0){return 0;}
        else if(n==1){return 1;}
        else{return fibonacci(n-1)+fibonacci(n-2);}
    }
    public static boolean isSorted(int index, int[] array){
        if(index==array.length-2){
            return (array[index]<=array[index+1]);
        }
        else{
            return (array[index]<=array[index+1] && isSorted(index+1, array));
        }
    }
    public static long exponentCalc(int base, int power){
        if(power==1){
            return base;
        }
        else if(power%2==0){
            return (exponentCalc(base, power/2)*exponentCalc(base, power/2));
        }
        else{
            return (base*exponentCalc(base, power/2)*exponentCalc(base, power/2));
        }
    }
    public static String removeDuplicates(String str, int[] occur, int index){
        if (index==str.length()){
            return "";
        }
        else{
            if (occur[(int)(str.charAt(index))-97]==1){
                return removeDuplicates(str, occur, index+1);
            }
            else{
                occur[(int)(str.charAt(index))-97] = 1;
                return str.charAt(index)+removeDuplicates(str, occur, index+1);
            }
        }
    }
}

/*
Recursion:
 - It is a method of solving a computational problem where the solution depends on the solution to smaller instances of the same problem.

*/