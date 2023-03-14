package Java_Concepts;
import java.util.*;

// package Java_Concepts;

class Car implements Comparable<Car>{
    int price,speed;
    String color;

    Car(int p,int s,String col){
        price=p;
        speed=s;
        color=col;
    }

    //Every object has a default toString method which prints the address 
    //if we try to print the object straight away
    //We can overload that func to create our own function
    @Override
    public  String toString() {
        return "P: "+this.price+", S: "+this.speed+", Col: "+this.color;
    }

    //Overriding compareTo func from Interface Comparables (which is generic <T> ,where T is any data type),
    //to Non primitive data type Car
    @Override
    public int compareTo(Car a){
        // we need to compare obj[j] and obj[j+1]
        // now obj[j+1] is the object "a" which we passed in sort method
        // obj[j] is used as "this"
        return this.price-a.price;
    }

}

// if we don't want to create/edit a sort func as well as change in the class we create a whole new class 
// CarComparator and create new sort function there
class CarComparatorColor implements Comparator<Car>{
    @Override
    public int compare(Car a, Car b) {
        return a.color.compareTo(b.color);
    }
}
class CarComparatorPrice implements Comparator<Car>{
    @Override
    public int compare(Car a, Car b) {
        return a.price-b.price;
    }
}
class CarComparatorSpeed implements Comparator<Car>{
    @Override
    public int compare(Car a, Car b) {
        return a.speed-b.speed;
    }
}

public class Sorting_Overloading {

    //Bubble sort
    // private static void sort(Car[] obj) {
    //     for(int i=0;i<obj.length;i++){
    //         for(int j=0;j<obj.length-i-1;j++){
    //             if(obj[j].compareTo(obj[j+1])>0){
    //                 Car temp=obj[j];
    //                 obj[j]=obj[j+1];
    //                 obj[j+1]=temp;
    //             }
    //         }
    //     }
    // }

    //Comparator:
    // 2 ways to implent the compare func from the three classes above:
    
    // 1.Individually : We can implement 3 such functions 1 for col, 1for price and 1 for speed
    // private static void sort(Car[] obj, CarComparatorColor comp) {
    //     for(int i=0;i<obj.length;i++){
    //         for(int j=0;j<obj.length-i-1;j++){
    //             if(comp.compare( obj[j], obj[j+1] ) > 0){
    //                 Car temp=obj[j];
    //                 obj[j]=obj[j+1];
    //                 obj[j+1]=temp;
    //             }
    //         }
    //     }
    // }
    
    // 2.Parent class Comparator : Parent can contain a child's object so Comparator which is implemented above is the parent
    // private static <T> void sort(T[] obj,Comparator<T> comp) {
    //     for(int i=0;i<obj.length;i++){
    //         for(int j=0;j<obj.length-i-1;j++){

    //             if(comp.compare( obj[j], obj[j+1] ) > 0){
    //                 T temp=obj[j];
    //                 obj[j]=obj[j+1];
    //                 obj[j+1]=temp;
    //             }
    //         }
    //     }
    // }
    
    private static void display(Car[] obj) {
        for(int i=0;i<obj.length;i++){
            System.out.println(obj[i]);
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        //Creates an obj array of non-primitive data types (Car);
        //no object created till now
        Car[] obj =new Car[5];

        obj[0]=new Car(1000, 25, "Yellow");
        obj[1]=new Car(3500, 10, "Red");
        obj[2]=new Car(8600, 15, "Green");
        obj[3]=new Car(2000, 30, "White");
        obj[4]=new Car(1500, 18, "Black");

        display(obj);

        //Passing an object
        //the above sort function is not needed as the Arrays.sort() has a very similar func like this
        //we just pass our own Comparator here
        // Arrays.sort(obj, new CarComparatorColor());

        // Meth 1

        //Alternative to creating 3 diff classes :
        //Creating an anonymous class and iplementing a compare func acc to our need
        // Arrays.sort(obj, new Comparator<Car>(){
        //     @Override
        //     public int compare(Car a,Car b) {
        //         return a.price-b.price;
        //     }
        // });
        
        // Meth 2
        Arrays.sort(obj, (Car a,Car b)->(a.price-b.price));
        

        //Collections.sort eg
        
        // Collections.sort(marvelHeroes, new Comparator<String>() {
        //     @Override
        //     public int compare(String hero1, String hero2) {
        //         return hero1.compareTo(hero2);
        //     }
        // });

        // Collections.sort(marvelHeroes, (m1, m2) -> m1.compareTo(m2));

        display(obj);
    }
}

//4 ways to sort objs:
//1. implementing Comparable to class and overriding compareTo acc to our need
//2. crating a sort function and using getter setter if given access to variables
//3. if we don't want to create/edit a sort func as well as change in the class we create a whole new class 
//   CarComparator and create new sort function there by implementing Comparator and passing that Comparator to Arrays.sort()
//4. 
