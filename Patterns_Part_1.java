import java.util.*;

public class Patterns_Part_1 {
    public static void main(String args[]){
        pattern1();
        pattern2();
    }

    public static void pattern1(){
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=i; j++){
                System.out.print('*');
            }
            System.out.println();
        }
    }

    public static void pattern2(){
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        for(int i=0; i<rows; i++){
            for(int j=0; j<rows-i; j++){
                System.out.print('*');
            }
            System.out.println();
        }
    }
}
