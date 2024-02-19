import java.util.*;
import java.lang.*;

public class Find_subsets {
    public static void main(String args[]){
        String str = "abc";
        find_subsets(str, 0, new StringBuilder());
    }
    public static void find_subsets(String str, int index, StringBuilder currString){
        if(index==str.length()){
            System.out.println(currString);
            return;
        }
        else{
            currString.append(str.charAt(index));
            find_subsets(str, index+1, currString);
            currString.deleteCharAt(currString.length()-1);
            find_subsets(str, index+1, currString);
        }
    }
}
