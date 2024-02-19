import java.util.*;

public class Hashing {
    public static void main(String args[]){
        HashMap<String, Integer> hashmap = new HashMap<>();
        hashmap.put("India", 1);
        hashmap.put("China", 2);
        hashmap.put("USA", 3);
        hashmap.put("Nepal", 4);
        iterate(hashmap);
        LinkedHashMap<String, Integer> linkedhashmap= new LinkedHashMap<>();
        linkedhashmap.put("India", 1);
        linkedhashmap.put("China", 2);
        linkedhashmap.put("USA", 3);
        linkedhashmap.put("Nepal", 4);
        iterate(linkedhashmap);
        TreeMap<String, Integer> treemap = new TreeMap<>();
        treemap.put("India", 1);
        treemap.put("China", 2);
        treemap.put("USA", 3);
        treemap.put("Nepal", 4);
        iterate(treemap);
        HashSet<Integer> hashset = new HashSet<>();
        hashset.add(1);
        hashset.add(2);
        hashset.add(3);
        iterate(hashset);
        LinkedHashSet<Integer> linkedhashset = new LinkedHashSet<>();
        linkedhashset.add(1);
        linkedhashset.add(2);
        linkedhashset.add(3);
        iterate(linkedhashset);
        TreeSet<Integer> treeset = new TreeSet<>();
        treeset.add(3);
        treeset.add(2);
        treeset.add(4);
        iterate(treeset);
    }
    public static void iterate(HashMap hashmap){
        Set<String> keys = hashmap.keySet();
        for(String key: keys){
            System.out.println(key + " = " + hashmap.get(key));
        }
    }
    public static void iterate(LinkedHashMap hashmap){
        Set<String> keys = hashmap.keySet();
        for(String key: keys){
            System.out.println(key + " -> " + hashmap.get(key));
        }
    }
    public static void iterate(TreeMap hashmap){
        Set<String> keys = hashmap.keySet();
        for(String key: keys){
            System.out.println(key + " \t " + hashmap.get(key));
        }
    }
    public static void iterate(HashSet hashset){
        // there are two methods to iterate on hashsets
        // 1. Iterators
        // 2. Enhanced for loop
        Iterator it = hashset.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
        System.out.println();
        for(Object num: hashset){
            System.out.print(num+" ");
        }
        System.out.println();
    }
    public static void iterate(LinkedHashSet hashset){
        // there are two methods to iterate on hashsets
        // 1. Iterators
        // 2. Enhanced for loop
        Iterator it = hashset.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
        System.out.println();
        for(Object num: hashset){
            System.out.print(num+" ");
        }
        System.out.println();
    }
    public static void iterate(TreeSet hashset){
        // there are two methods to iterate on hashsets
        // 1. Iterators
        // 2. Enhanced for loop
        Iterator it = hashset.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
        System.out.println();
        for(Object num: hashset){
            System.out.print(num+" ");
        }
        System.out.println();
    }
}


/*
 - Hashing is basically changing the form of input.
 - Hashing consists of two data structures:
  1. map - HashMap, LinkedHashMap, TreeMap
  2. set - HashSet, LinkedHashSet, TreeSet

 - HashMap: It is used to store key-value pairs.
    HashMap<DataClass, DataClass> name = new HashMap<>();

 -Functions in HashMap:
  1. put(key, value)
  2. get(key)
  3. containsKey(key)
  4. removeKey(key)
  5. size()
  6. clear()
  7. isEmpty()

 - LinkedHashMap: It is used to store key-value pairs, but keys are retrieved in the order which they are inserted.

 - TreeMap: Keys are sorted and put, get and remove are O(logn) instead of O(1) as in other maps.

 - HashSet: No duplicates, Unordered, null is allowed.
    HashSet<DataClass> name = new HashSet<>();

 - Functions in HashSet:
  1. add(element)
  2. contains(target)
  3. remove(value)
  4. size()
  5. clear()
  6. isEmpty();

*/
