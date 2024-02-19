import java.util.ArrayList;

public class Tries {
    class Node{
        Node[] children = new Node[26];
        boolean endOfWord = false;
        Node(){
            for(int i=0; i<26; i++){
                children[i] = null;
            }
        }
    }
    public Node root = new Node();
    public void insert(String word){
        Node curr = root;
        for(int level=0; level<word.length(); level++){
            int idx = word.charAt(level)-'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.endOfWord = true;
    }
    public boolean search(String word){
        Node curr = root;
        for(int level=0; level<word.length(); level++){
            int idx = word.charAt(level)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr = curr.children[idx];
        }
        if(curr.endOfWord==true){
            return true;
        }
        return false;
    }
    public boolean startsWith(String target){
        Node curr= root;
        for(int i=0; i<target.length(); i++){
            int index = target.charAt(i)-'a';
            if(curr.children[index]==null){
                return false;
            }
            curr = curr.children[index];
        }
        return true;
    }
    public static void main(String args[]){
        Tries trie1 = new Tries();
        String words[] =  {"the","a","there","their","any","thee"};
        for(String word: words){
            trie1.insert(word);
        }
        System.out.println(trie1.search("thee"));
        System.out.println(trie1.search("thor"));
        System.out.println(trie1.startsWith("thei"));
    }
}
