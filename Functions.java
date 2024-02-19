import java.util.*;

public class Functions {
    public static void printer(){
        System.out.println("HELLO WORLD");
    }

    public static boolean primeChecker(int num){
        for(int factor=2; factor<=(int)(Math.sqrt(num)); factor++){
            if (num%factor==0){
                return (false);
            }
        }
        return (true);
    }

    public static int adder(int a, int b){
        return (a+b);
    }

    public static void main(String args[]){
//        printer();
        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(primeChecker(b));
    }
}

/*
 Java always calls by value

 Function Overloading:
  Multiple functions with the same name but with different parameters
    1. Function Overloading with parameters
    2. Function Overloading using datatypes
*/