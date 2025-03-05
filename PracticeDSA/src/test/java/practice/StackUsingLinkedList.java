package practice;

public class StackUsingLinkedList {
	
	Node top;
	
	class Node{
		int data;
		Node next;
		
		Node(int val){
			data=val;
			next=null;
		}
	}
	
	StackUsingLinkedList(){
		top=null;
	}
	
	public void push(int val) {
	
		Node newNode = new Node(val);
		newNode.next=top;
		top=newNode;

	}
	
	public int pop(){
		
		if(top==null)
			throw new IndexOutOfBoundsException("Stack is empty");
		
		int temp = top.data;
		top=top.next;
		return temp;
				
	}
	
	public boolean isEmpty() {
		return top==null;
	}

	public int peek() {
		return top.data;
	}
	
	
}
