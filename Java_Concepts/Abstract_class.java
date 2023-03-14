package Java_Concepts;
// import java.util.*;        ///imports all definitions


//"Abstract class":

//this class "can" contain an abstract method (ho bhi skta/ nhi nhi ho skta)
//We cannot "instantialize"(create an instance/object) of such classes
//If a normal class extends abstract class then u "have" to declare "all" the abstract methods with body
abstract class Abstract{            //Class
    
    int x,y;
    
    //"Abstract method" : 

    //A method without a body
    //this method is not defined but rather left for user to define himself
    //such method "needs" an abstract class
    abstract int sum(int x,int y);  // requires a body or make it abstract

    //Use Of abstract class and methods;

    //when we want a lay a predefined structure so that the other developer cannot modify it
    //helps in controling the general structure of the code(i.e so the other devlopers do no just make any funcs. acc. to their pref and stick to the predefined structure)
}

/////Imp points :

//To inherit a class use "Class a extends b"

//We cannot achieve multiple inheritances though (because if classes on same level are used with same method names , then the compiler gets confused) , 
//BUT we can achieve Multi-level inheritance
