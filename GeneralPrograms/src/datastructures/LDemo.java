package datastructures;

import java.util.LinkedList;
import java.util.List;

public class LDemo {
	public static void main(String[] args) {
		LinkedListImplement list=new LinkedListImplement();
		
		list.insertAtBeginning(7);
		list.insertAtBeginning(9);
		//list.display();
		list.insertAtPosition(3,6);
		list.display();
		
		List<String> ll = new LinkedList<String>();
		ll.add("abd");
		ll.add("abc");
		
	
		
		
	}

}
