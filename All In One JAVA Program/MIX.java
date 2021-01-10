// MIX - All in One JAVA Program.
/*
 * @Author: Aditya Ambre 
 * @Date: 2020-11-25 20:45:25 
 * @Last Modified by: Aditya Ambre
 * @Last Modified time: 2020-11-30 21:06:51
 */

// Default Packages.
import java.io.File;
import java.io.FileInputStream;
import java.time.*;

// User-Defined Packages.
import dir.*;

class A{
    static void met3(){
        System.out.println("4. Static Method - A Class.");  // 4
    }
    void met4(){
        System.out.println("5. Normal Method - A Class.");  // 5
    }
}

class B extends A{
    @Override
    void met4(){
        System.out.println("6. Method Overriding - B Class.");  // 6
    }
    void met5(int m5){
        System.out.println("7. Method Overloading [1] - B Class." + " --> " + m5);  // 7 [1]
    }
    void met5(int m5, int m6){
        System.out.println("   Method Overloading [2] - B Class." + " --> " + m5 + ", "+ m6);  // 7 [2]
    }
}

abstract class C{  // Abstract class
    abstract void met6();  // 8
}

class D extends C{
    void met6(){
        System.out.println("8. Abstract Class - C Class.");  // 8
    }
}

class E{
    E(){
        System.out.println("9. Default Constructor - E Class.");  // 9
    }
    E(String s){
        System.out.println("10. Parameterized Constructor - E Class.  with a 'string' parameter --> " + s);  // 10
    }
}

interface F{  // Interface
    String s = "String";
    void met7();  // 11
}

class G implements F{
    @Override
    public void met7(){
        System.out.println("11. Interface - F Interface.  with a 'string' parameter --> " + s);  // 11
    }
}

class H{
    private int a;  // Access Modifier - Private
    public void set(int a){  // Setters
        this.a = a;  // this
    }
    public int get(){  // Getters
        return a;  // 12
    }
    protected int x=1;  // Access Modifier - Protected
}

class I extends H{
    int x=2;
    void met8(){
        System.out.println("13. Super Keyword - I Class.  with, 'Value of X in I Class' x:" + x + " & 'Value of X in H Class' x:" + super.x);  // 13
    }
    final double y=3.14;
    void met9(){
        System.out.println("14. Final Keyword - I Class.  with 'final' keyword the variable value remains constant.  i.e. Y = " + y);  // 14
    }
    void met10(){
        float z=5.4f;
        int zz = (int)z;  // Typecasting
        System.out.println("15. Typecasting - I Class. 'Value of Z before Typecasting'  Z = "+ z + " & 'Value if Z after Typecasting'  Z = "+ zz);  // 15
    }
}

class J extends I{
    @Override
    void met9(){
        System.out.println("16. Run-Time Polymorphism - J Class. Here, 'Object of I Class' calls 'Method of J Class'.");  // 16
    }
    void met10(){
        try{  // Try block
            System.out.println("17. Try Block - Tries to Read 2 files from current the directory.");  // 17
            // File exists, throws 'No Exception'.
            File objFile1 = new File("MIX.java");
            FileInputStream fis1 = new FileInputStream(objFile1);
            fis1.close();
            // File doesn't exists, throws an 'Exception' but it's handled by 'Try-Catch' block! to prevent the program from being terminated.
            File objFile2 = new File("X.java");
            FileInputStream fis2 = new FileInputStream(objFile2);
            fis2.close();
        }
        catch(Exception e){  // Catch block
            System.out.println("    Catch Block - Exception: File not found! - " + e);  // 17
        }
        finally{  // Finally block
            System.out.println("    Finally Block - This block will automatically execute after Try-Catch blocks irrespective of the results!");  // 17
        }
    }
    static void met11() throws ArrayIndexOutOfBoundsException{  // throws
        try{
            String array[] = {"array[0]", "array[1]"};  // Array
            for(int i=0; i<=2; i++){  // For Loop
                System.out.println("Printing array[2] which is out of bound!" + array[2]);  // 18
                throw new ArrayIndexOutOfBoundsException("This will throw Exception in Catch Block defined in Main Method of MIX Class.");  // throw
            }
        }
        catch(ArrayIndexOutOfBoundsException e){  // Catch block
            System.out.println("18. Arrays, Throw & Throws Keyword with Exception Handling!");  // Exception Handling
        }
    }
    static int i=0;  // Counter
    static void met12(){
        i++;
        if(i<=10){
            System.out.print(i);  // 19
            met12();  // Recursion - met12() calls itself until the condition fails!
        }
    }
    static void met13(){
        int i=20;
        Integer objInt = new Integer(i);  // Autoboxing
        System.out.print("\n20. Wrapper Class -->  Autoboxing: " + objInt);  // 20
        int j=objInt.intValue();  // Unboxing
        System.out.print("  &  Unboxing:" + j);  // 20
    }
}

class K{
    static int x=5, y=10;  // Static Variables
    static void met14(int x, int y){  // Call by Value
        int temp = x;
        x=y;
        y=temp;
        System.out.print("  [After Swap]: " + x + ", " + y);  // 21
    }
    static void met15(K objK){  // Call by Reference
        int temp = objK.x;
        objK.x = objK.y;
        objK.y = temp;
        System.out.print("  [After Swap]: " + objK.x + ", " + objK.y);  // 21
    }
}

class L extends Thread{
    public void run(){
        int i=1;
        do{
            // Try-Catch block to catch Exceptions!
            try{  // Try block
                System.out.print(i);  // 22
                i++;
                //Thread.sleep(10);
            }
            catch(Exception e){  // Catch block
                System.out.print("Thread Terminated!");  // Exception
            }
        }while(i<=10);  // Do-While Loop
    }
}

class MIX{
    static void met1(){
        System.out.println("2. Static Method - MIX Class.");  // 2
    }
    void met2(){
        System.out.println("3. Normal Method - MIX Class.");  // 3
    }
    protected void finalize(){
        System.out.println("24. Garbage Collected: " + this + ".");  // 24
    }
    public static void main(String args[]){  // Main Method
        System.out.println("<---------- MIX - All in One JAVA Program. ---------->");
        // 1. Main Method - MIX Class.
        System.out.println("1. Main Method - MIX Class.");  // 1
        // 2. Static Method - MIX Class.
        met1();
        // 3. Normal Method - MIX Class.
        MIX objMIX = new MIX();
        objMIX.met2();
        // 4. Static Method - A Class.
        A.met3();
        // 5. Normal Method - A Class.
        A objA = new A();
        objA.met4();
        // 6. Method Overriding.
        B objB = new B();
        objB.met4();
        // 7. Method Overloading.
        objB.met5(1);  // [1]
        objB.met5(1, 2);  // [2]
        // 8. Abstract Class.
        D objD = new D();
        objD.met6();
        // 9. Default Constructor.
        E objE1 = new E();
        // 10. Parameterized Constructor.
        E objE2 = new E("String");
        // 11. Interface.
        G objG = new G();
        objG.met7();
        // 12. Encapsulation.
        H objH = new H();
        objH.set(3);
        System.out.println("12. Encapsulation, Access Modfiers & This Keyword - H Class.  with 'integer' parameter --> " + objH.get());  // 12
        // 13. Super Keyword.
        I objI = new I();
        objI.met8();
        // 14. Final Keyword.
        objI.met9();
        // 15. Typecasting.
        objI.met10();
        // 16. Run-Time Polymorphism.
        I objIN = new J();
        objIN.met9();
        // 17. Try-Catch-Finally.
        J objJ = new J();
        objJ.met10();
        // 18. Throw & Throws Keywords.
        J.met11();
        // 19. Recursion.
        System.out.print("19. Recursion Counter: ");
        J.met12();
        // 20. Wrapper Class.
        J.met13();
        // 21. Call by Value & Call by Reference.
        System.out.print("\n21. Call by Value --> [Before Swap]: " + K.x + ", " + K.y);
        K.met14(K.x, K.y);  // Call by Value
        System.out.print("    &    Call by Reference --> [Before Swap]: " + K.x + ", " + K.y);
        K objK = new K();
        K.met15(objK);  // Call by Reference
        // 22. Threads.
        L objL = new L();
        Thread t = new Thread();
        System.out.print("\n22. Threads -->  Default Thread: " + t);
        Thread ct = new Thread(objL);
        ct.start();
        System.out.print("    &    Custom Thread: " + ct);
        // 23. User-Defined Packages.
        X objX = new X();  // X Class located in X.java
        objX.met16();  // 23
        // 24. Garbage Collection.
        MIX objgc = new MIX();
        objgc = null;  // Null reference
        System.gc();  // Reclaims Memory that are no longer occupied by objects and dispose the garbage
        // 25. Local Date & Time.
        LocalDate objDate = LocalDate.now();  // Local Date
        LocalTime objTime = LocalTime.now();  // Local Time
        System.out.println("25. Prints Local Date: " + objDate + " & " + "Local Time: " + objTime + ".");  // 25
        // Credits.
        System.out.println("<---------- Credits: Developed By, Aditya Ambre. ---------->");
    }
}


// File --> X.java
/*
// MIX --> X.Java

package dir; // User-Defined Package
public class X{
    public void met20(){
        System.out.println("\n23. User-Defined Package 'dir' with 'X Class' in 'X.java' File.");  // 23
    }
}
// Classes & Methods are public.
// File Location: C:/Java/dir/X.java 
*/
// Topics Covered:
/* [1] Normal & Static Classes, [2] Normal & Static Methods,
   [3] Normal & Static Variables,[4] Method Overriding & Overloading,
   [5] Abstract Class, [6] Default & Parameterized Constructors, [7] Interface, [8] Encapsulation,
   [9] Access Modifiers - 'default' 'public', 'private', 'protected', [10] References like 'this', 'super' & 'final' Keywords,
   [11] Run-Time Polymorphism, [12] Try-Catch-Finally Block, [13] Exceptions Handling - 'throw' & 'throws' Keywords, [14] Recursion,
   [15] Wrapper Class, [16] Call by Value & Call by Reference, [17] Threads - Default & Custom Threads, [18] Packages, [19] User-Defined Packages,
   [20] Garbage Collection, [21] Local Date & Time.
*/
// Access Modifiers - 'default', 'public', 'private', 'protected'
/*
 Access    same    same   outside package  outside
Modifiers  class  package   by subclass    package

Private	     Y	     N	         N            N
Default	     Y	     Y	         N            N
Protected    Y	     Y	         Y            N
Public	     Y	     Y	         Y            Y
*/

// Copyrights © - 2020 Aditya Ambre. │ All Rights Reserved.