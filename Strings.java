import java.util.Scanner;

public class Strings {
    public static boolean palindromeChecker(String str){
        int lPtr = 0;
        int rPtr = str.length()-1;
        while (lPtr<rPtr){
            if (str.charAt(lPtr) != str.charAt(rPtr)){
                return false;
            }
            lPtr++;
            rPtr--;
        }
        return true;
    }

    public static void main(String args[]){
        char arr[] = {'a', 'b', 'c', 'd'};
        String str1 = "abcd";
        String str2 = new String("abcdefgh");
        Scanner sc = new Scanner(System.in);
        String str3 = sc.nextLine();
        String str4 = sc.next();
        System.out.println(str4.length());
        String str5 = str3+str4;
        System.out.println(str5.charAt(3));
        System.out.println(palindromeChecker("madam"));
        System.out.println(str1.equals(str2));
        System.out.println(str5.substring(1,5));
        /*
        For compareTo Function
        * 0 for equal
        * -1 for str2 greater
        * +1 for str1 greater
        */
        System.out.println(str1.compareTo(str2));

        StringBuilder string = new StringBuilder("HW");
        System.out.println(string.toString()); // converts an object to string format
        System.out.println(Character.toUpperCase(str5.charAt(5)));
    }
}
// .length() is used for Strings whereas .length is used for Arrays