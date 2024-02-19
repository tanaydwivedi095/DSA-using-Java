public class OOPS {
    public static void main(String args[]){
        Student s1 = new Student("Tanay",20016);
        Student s2 = new Student(s1);
        Fish shark = new Fish();
        shark.eat();
        Chicken c1 = new Chicken();
        c1.walk();
        System.out.println(c1.color);
        c1.changeColor("White");
        System.out.println(c1.color);
        Queen q = new Queen();
        q.moves();
        Kingdom k1 = new Kingdom();
        k1.walk();
    }
}

class Student{
    public String name;
    public int rollNumber;
    Student(String name, int rollNumber){
        this.name = name;
        this.rollNumber = rollNumber;
    }
    Student(String name){
        this.name = name;
    }
    Student(int rollNumber){
        this.rollNumber = rollNumber;
    }
    Student(){
        System.out.println("Constructer called");
    }
//  Shallow Copy Constructor
    Student(Student s1){
        this.name = s1.name;
        this.rollNumber = s1.rollNumber;
    }
}

class Animal{
    String color;
    void eat(){
        System.out.println("Eats");
    }
    void breathe(){
        System.out.println("Breathes");
    }
}

class Fish extends Animal{
    int fins;
    void swims(){
        System.out.println("Swims");
    }
}

abstract class Animals{
    String color;
    Animals(){
        this.color = "Brown";
    }
    void eat(){
        System.out.println("Animals eat");
    }
    abstract void walk();
}

class Chicken extends Animals{
    public void walk(){
        System.out.println("It walks on 2 legs");
    }
    public void changeColor(String color){
        this.color = color;
    }
}

interface ChessPlayer{
    void moves();
}

class Queen implements ChessPlayer{
    public void moves(){
        System.out.println("up, down, left, right, diagonal (in all directions)");
    }
}

class Rook implements ChessPlayer{
    public void moves(){
        System.out.println("up, down, left, right");
    }
}

class King implements ChessPlayer{
    public void moves(){
        System.out.println("up, down, left, right");
    }
}

// Multiple inheritances
interface Herbivore{
    void walk();
}
interface Carnivore{
    void walk();
}
class Kingdom implements Herbivore, Carnivore{
    public void walk(){
        System.out.println("They walk");
    }
}
/*
Access Modifiers:
 1. Private - Within Class
 2. Default - Within Class, Within Package
 3. Protected - Within Class, Within Package, Outside package by subclass only
 4. Public - Within Class, Within Package, Outside package by subclass only, outside package

Encapsulation:
 - It is defined as the wrapping up of the data and methods under a single unit.
 - It also implements data hiding.

Constructors:
 It is a special method which is invoked automatically at the time of object creation.
  - Constructors have the same name as class or structure
  - Constructors don't have a return type (Not even void)
  - Constructors are only called once, at object creation
  - Memory allocation happens when constructor is called

Types of Constructors:
 1. Non parametrized Constructors - Arguments are not passed
 2. Parametrized Constructors - Arguments are passed
 3. Copy Constructors - Shallow and deep

Constructor Overloading:
 - Multiple constructors are developed as per need i.e. same function with different functionality.

Copy Constructors:
 - It is used to copy all the properties of one object to another object.

Destructors:
 - It is not explicitly written in java because it uses garbage collector.

Inheritance:
 - It is when properties and methods of base/parent class are passed on to a derived/child class.

Types of Inheritance:
 1. Single level inheritance: It has only one base class.
 2. Multi level inheritance: It has a hierarchical classes.
 3. Hierarchical inheritance: It has one base class and multiple derived classes.
 4. Hybrid inheritance: It is a combination of different types of inheritances.
 5. Multiple inheritance: It has multiple base classes and one derived classes. It cannot be implemented in Java directly, although we can implement it using Interfaces.

Polymorphism:
 - When a class or a method exist in multiple forms it can be referred as Polymorphism.

Types of Polymorphism:
 1. Compile Time Polymorphism: Method Overloading
 2. Run Time Polymorphism: Method Overriding

Method Overloading:
 - Multiple function with the same name but different parameters.

Method Overriding:
 - Parent and child class both contain the same function with a different definition.

Package:
 - It is a group of similar types of classes, interfaces and sub-packages.
 - It can be classified as In-built packages and User-defined packages.

Abstraction:
 - Hiding all the unnecessary details and showing only the important parts to the user.
 - It can be achieved by abstract classes or interfaces.

Abstract Classes:
 - To create an abstract class use the keyword abstract.
    abstract class <classname>{}
 - Cannot create an instance of abstract class
 - Can have abstract or non-abstract method
 - Can have constructors

Interfaces:
 - It is a blueprint of a class.
 - It is used to implement multiple inheritance.
 - It is used to achieve total abstraction.
 - It is implemented using Interface keyword and using implements keyword.
 - All methods are public, abstract and without implementation.
 - Used to achieve total abstraction.
 - Variables in the interface are final, public and static.

Static Keyword:
 - static Keyword in Java is used to share the same variable or method of a given class
 - It can be used for:
   1. Properties
   2. Functions
   3. Blocks
   4. Nested Classes
 - These are not re-initialized again and again.

super Keyword:
 - super keyword is used to refer immediate parent class object.
 - It is used to access parent's properties
 - It is used to access parent's functions
 - It is used to access parent's functions
*/