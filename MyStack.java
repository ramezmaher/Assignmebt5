package eg.edu.alexu.csd.datastructure.stack.cs29;

public class MyStack implements IStack {
 int count =0;
 Node top;
 public void push(Object element) {
	 Node n = new Node(element);
	 if (top == null) 
		 top = n;
	 else {
		 n.prev = top ; 
		 top = n;
	 }
	 count++;
 }
 public Object pop() {
	 if (top == null) {
		 return null;
	 }
	 Object o ;
	 o = top.value;
	 top = top.prev ;
	 count--;
	 return o;
 }
 public Object peek() {
	 if (top == null) {
		 return null;
	 }
	 Object o ; 
	 o = top.value;
	 return o;
 }
 public boolean isEmpty() {
	 if (top == null) 
		 return true;
	 else return false;
 }
 public int size() {
	 return count;
 }
}
