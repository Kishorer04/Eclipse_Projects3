package datastructures;

public class LinkedListImplement {
	Node head;
	
	LinkedListImplement(){
		head=null;
	}
	
	class Node{
		int data;
		Node next;
		
		Node(int val){
		data=val;
		next=null;
		}
	}

	public void insertAtBeginning(int val) {
		
		Node newNode = new Node(val);
		
		if(head==null)//list is empty
			head=newNode;
		
		else //list is not empty
		{
		   newNode.next=head;	
			head=newNode;
		}
		
		
	}

	public void display() {
		Node temp=head;
		
		while(temp!=null)
		{
			System.out.print(temp.data);
			temp=temp.next;
		}
			
		
	}

	public void insertAtPosition(int pos, int val) {
		Node newNode = new Node(val);
		
		if(pos==0)
		{
			insertAtBeginning(val);
		     return;
		}
		Node temp=head;
		for(int i=0;i<pos-1;i++)
		{
			temp=temp.next;
			if(temp==null)
				throw new IllegalArgumentException("Invalid position "+ pos);
		}
		newNode.next=temp.next;
		temp.next=newNode;
		
	}
			
		
	}


