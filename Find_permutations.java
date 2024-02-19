public class Find_permutations {
    public static void main(String args[]){
        String str = "abc";
        find_permutations(str, "");
    }
    public static void find_permutations(String str, String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        for(int i=0; i<str.length(); i++){
            char curr = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i+1);
            find_permutations(newStr, ans+curr);
        }
    }
}
