package eg.edu.alexu.csd.datastructure.stack.cs29;
import java.util.Scanner;
public class TestMyStack {
	public static void main(String[] args) {
    IStack stack = new MyStack();
    Scanner scan = new Scanner(System.in);
    int x;
    do {
    	System.out.println("Enter the number of operation:");
        System.out.println("1 -(push())// Push items to the stack.");
        System.out.println("2 -(pop())// Pop items from the stack.");
        System.out.println("3 -(peek())// Show the item on top of the stack.");
        System.out.println("4 -(isEmpty())// Check if the stack is empty.");
        System.out.println("5 -(size())// Get the size of the stack");
        System.out.println("0 -to Exit");
        System.out.println("==================================================================================");
        x = scan.nextInt();
    switch (x) {
    case 1:{
    	System.out.println("Enter the element to add");
    	Object o;
    	 Scanner scan1 = new Scanner(System.in);
    	 o = scan1.next();
    	 stack.push(o);
    }
    break;
    case 2:{
    	if (stack.isEmpty()) {
    		System.out.println("Empty Stack,Invalid operation.");
    	}
    	else {
    	Object o = stack.pop();
    	System.out.println(o);
    }
    }
    break;
    case 3:{
    	if (stack.isEmpty()) {
    		System.out.println("Empty Stack,Invalid operation.");
    	}else {
    	Object  i = stack.peek();
    	System.out.println(i);
    }
    }
    break;
    case 4:{
    	boolean i = stack.isEmpty();
    	System.out.println(i);
    }
    break;
    case 5:{
    	int i = (int)stack.peek();
    	System.out.println(i);
    }
    break;
    default :
    	System.out.println("Invalid Input");
    
    }
    
    System.out.println("==================================================================================");
    }while(x!= 0);
	}
}
 

