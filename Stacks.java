import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.Scanner;

public class Stacks {
    public static void pushAtBottom(Stack<Integer> s, int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }
    public static StringBuilder reverse(StringBuilder str){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<str.length(); i++){
            stack.push(str.charAt(i));
        }
        int i=0;
        while(!stack.isEmpty()){
            str.setCharAt(i, stack.pop());
            i++;
        }
        return str;
    }
    public static void reverseStack(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int top = stack.pop();
        reverseStack(stack);
        pushAtBottom(stack, top);
    }
    public static ArrayList<Integer> stockSpanProblem(ArrayList<Integer> stocks) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> span = new ArrayList<>();
        span.add(1);
        stack.push(0);
        for (int i = 1; i < stocks.size(); i++) {
            int currPrice = stocks.get(i);
            while (!stack.isEmpty() && currPrice > stocks.get(stack.peek())) {
                stack.pop();
            }
            if(stack.isEmpty()){
                span.add(i+1);
            }
            else{
                int prevHigh = stack.peek();
                span.add(i-prevHigh);
            }
            stack.push(i);
        }
        return span;
    }
    public static ArrayList<Integer> nextGreaterElement(ArrayList<Integer> arr){
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<arr.size(); i++){
            result.add(-1);
        }
        for(int i=arr.size()-1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek()<=arr.get(i)){
                stack.pop();
            }
            if(stack.isEmpty()){
                result.set(i, -1);
            }
            else{
                result.set(i, stack.peek());
            }
            stack.push(arr.get(i));
        }
        return result;
    }
    public static boolean duplicateParenthesis(StringBuilder str){
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)!=')'){
                s.push(str.charAt(i));
            }
            else{
                int count = 0;
                while(s.pop()!='('){
                    count++;
                }
                if(count<1){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String args[]){
        StackUsingArrayList s1 = new StackUsingArrayList();
        s1.push(1);
        s1.push(2);
        StackUsingLinkedList s2 = new StackUsingLinkedList();
        s2.push(1);
        s2.push(2);
        Stack<Integer> s3 = new Stack<>();
        s3.push(1);
        StringBuilder str = new StringBuilder("HELLO");
        System.out.println(reverse(str));
//        ArrayList<Integer> stocks = new ArrayList<>();
//        System.out.print("Enter the number of stocks: ");
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        System.out.println("Enter the stock prices");
//        for(int i=0; i<n; i++){
//            stocks.add(sc.nextInt());
//        }
//        System.out.println(stockSpanProblem(stocks));
//        System.out.println(nextGreaterElement(stocks));
        System.out.println(duplicateParenthesis(new StringBuilder("(((a+b)+(c+d)))")));
    }
}

class StackUsingArrayList{
    ArrayList<Integer> stack = new ArrayList<>();
    public boolean isEmpty(){
        return this.stack.size()==0;
    }
    public void push(int value){
        this.stack.add(value);
    }
    public int pop(){
        int top = stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        return top;
    }
    public int peek(){
        return stack.get(stack.size()-1);
    }
}

class StackUsingLinkedList{
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    Node head = null;
    public boolean isEmpty(){
        return head==null;
    }
    public void push(int value){
        Node newNode = new Node(value);
        if(isEmpty()){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    public int pop(){
        if(isEmpty()){
            return -1;
        }
        int top = head.data;
        head = head.next;
        return top;

    }
}
