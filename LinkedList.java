public class LinkedList{
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public Node head;
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(this.head != null){
            newNode.next = head;
        }
        this.head = newNode;
    }
    public void addLast(int data){
        Node newNode = new Node(data);
        if(this.head!=null) {
            Node ptr = this.head;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = newNode;
        }
        else{
            this.head = newNode;
        }
    }
    public void printLinkedList(){
        if(this.head == null){
            System.out.println("The linked list is empty");
        }
        else{
            Node ptr = this.head;
            while(ptr!=null){
                System.out.print(ptr.data+" ");
                ptr = ptr.next;
            }
        }
        System.out.println();
    }
    public int length(){
        int count = 0;
        Node ptr = this.head;
        while(ptr!=null){
            ptr = ptr.next;
            count++;
        }
        return count;
    }
    public void addAtLocation(int index, int value){
        if(index==0){
            addFirst(value);
            return;
        }
        if(index==length()){
            addLast(value);
            return;
        }
        Node ptr = this.head;
//        int i=0;
        while(index-1!=0){
            ptr = ptr.next;
            index--;
        }
        Node newNode = new Node(value);
        newNode.next = ptr.next;
        ptr.next = newNode;
    }
    public void removeFirst(){
        if(this.head==null){
            System.out.println("The linked list is empty");
            return;
        }
        this.head = this.head.next;
    }
    public void removeLast(){
        if(this.head==null){
            System.out.println("The linked list does not exist");
            return;
        }
        else{
            Node ptr = this.head;
            if(ptr.next==null){
                this.head = null;
                return;
            }
            while(ptr.next.next!=null){
                ptr = ptr.next;
            }
            ptr.next = null;
        }
    }
    public void removeAtLocation(int index){
        if(index==0){
            removeFirst();
        }
        else if(index==length()-1){
            removeLast();
        }
        else{
            Node ptr = this.head;
            while(index-1!=0){
                ptr = ptr.next;
                index--;
            }
            ptr.next = ptr.next.next;
        }
    }
    public void iterativeSearch(int value){
        if(this.head==null){
            System.out.println("Linked list is empty");
        }
        else{
            Node ptr = this.head;
            while(ptr!=null){
                if(ptr.data == value){
                    System.out.println("Found");
                    return;
                }
                ptr = ptr.next;
            }
            System.out.println("Not found");
        }
    }
    public void recursiveSearch(int value, Node ptr){
        if(ptr==null){
            System.out.println("Not found");
            return;
        }
        else{
            if(ptr.data==value){
                System.out.println("Found");
            }
            recursiveSearch(value, ptr.next);
            return;
        }
    }
    public void reverse(){
        Node prev = null;
        Node curr = this.head;
        Node next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        this.head = prev;
    }
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public boolean isPalindrome(){
        if(head==null || head.next==null){
            return true;
        }
        Node midNode = findMid(head);
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;
        while(right!=null){
            if(right.data!=left.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
    public boolean isCyclic(){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    public void removeCycle(){
        Node slow = head;
        Node fast = head;
        Node prev = null;
        boolean cycle = false;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                cycle = true;
            }
        }
        if(cycle==false){
            return;
        }
        slow = head;
        while(slow!=fast){
            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }
        prev.next = null;
    }
    public static void main(String args[]){
        LinkedList l1 = new LinkedList();
        l1.addFirst(10);
        l1.addFirst(20);
        System.out.println(l1.head.next.data);
        l1.addLast(30);
        System.out.println(l1.head.next.next.data);
        l1.printLinkedList();
        l1.addAtLocation(3, 40);
        l1.printLinkedList();
        l1.removeFirst();
        l1.printLinkedList();
        l1.removeAtLocation(0);
        l1.printLinkedList();
        l1.iterativeSearch(40);
        l1.recursiveSearch(40, l1.head);
        System.out.println(l1.head.data);
        l1.reverse();
        l1.printLinkedList();
        l1.reverse();
        l1.printLinkedList();
        LinkedList l2 = new LinkedList();
        l2.addFirst(1);
        l2.addFirst(2);
        l2.addFirst(3);
        l2.addFirst(2);
        l2.addFirst(1);
        l2.printLinkedList();
        System.out.println(l1.head.data);
        System.out.println(l2.head.data);
        System.out.println(l1 + "   " + l2);
        System.out.println(l2.isPalindrome());
        System.out.println(l1.isPalindrome());
        l2.printLinkedList();
        System.out.println(l2.isCyclic());
        l2.removeCycle();
    }
}