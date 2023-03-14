// package Java_Concepts;

//Interface:

//all methods are abstract (by deafult)
interface RBI{
    public void getBalance();    // no need to add "abstract" (it is by default)
    public void reciept();
}

//class - extends Class , implements Interface(just inherit methods and other vals)
class HDFC implements RBI
{
    public void getBalance(){
        System.out.println("ok");
    }
    //declare all abstract meth.
    public void reciept(){
        System.out.println("hmm");
    }
}


//interface - extends Interface (inherits and implements)
interface Axis_Bank extends RBI{
    public void FD();
    public void RD();

    //to give body to function (can be overridden)
    default public void homeLoan(){
        System.out.println("Method with body");
        abc();
    }

    //above can also be done with private
    private void abc(){
        System.out.println("to be used within the interface only");
    }
}


//Diff between instance and abstract class:
// Instance has all methods abstract (by default) (upto 100% abstraction (due to default,private))
// Abstract class can have methods with body as well as abstract ones (Upto 100% abstraction)

