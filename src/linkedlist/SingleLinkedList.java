package linkedlist;

import java.util.Stack;

public class SingleLinkedList {

	private Node head;
	private Node tail;
	public void add(int data) {
		if(head==null && tail==null) {
			head=new Node(data);
			tail=head;
		}else {
			tail.next=new Node(data);
			tail=tail.next;
		}
	}
	public void reverseRecursive(Node p){
		if(p.next==null){
			head=p;
			return;
		}
		reverseRecursive(p.next);
		Node q=p.next;
		q.next=p;
		p.next=null;
		
	}
	public void reverseIterative(){

		Node pre=null;
		Node nxt=null;
		Node current=head;
		while(current!=null){
			nxt=current.next;
			current.next=pre;
			pre=current;
			current=nxt;
		}	
		head=pre;
	}
	public int getNthNodeFromEnd(int pos){
		
		Node slow=head;
		Node fast=head;
		while(pos-->0){
			fast=fast.next;
		}
		while(fast!=null){
			slow=slow.next;
			fast=fast.next;
		}
		return slow.data;
	}
	public Node getMiddleNode(Node a){
		Node slow=head;
		Node fast=head.next;
		while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next;
		}
		return slow;
	}
	public Node mergeSort(Node n){
		if(n.next==null)
			return n;
		Node middle= getMiddleNode(n);
		Node nxt=middle.next;
		middle.next=null;
		Node a=mergeSort(n);
		Node b=mergeSort(nxt);	
		Node tmp=merge(a,b);
		return tmp;
	}
	public Node mergeSort(){
		return mergeSort(head);
	}
	public Node merge(Node a, Node b){
		if(a==null)
			return b;
		if(b==null)
			return a;
		Node tmp=null;
		if(a.data<b.data){
			tmp=a;
			tmp.next=merge(a.next,b);
		}else{
			tmp=b;
			tmp.next=merge(a,b.next);
		}
		return tmp;

	}
	public void removeDuplicateNode(){
	
		Node current=head;
		Node tmp=head;
		while(current!=null && current.next!=null){
			if(current.data!=current.next.data){
				tmp.next=current.next;
				tmp=current.next;
			}
			current=current.next;
		}
	}
	public boolean isPallindrome(){

		Stack<Integer> stack=new Stack();
		Node tmp=head;
		Node current=head;
		while(current!=null){
			stack.push(current.data);
			current=current.next;
		}
		while(!stack.isEmpty()){
			int data=stack.pop();
			if(tmp.data!=data)
				return false;
			tmp=tmp.next;
		}
		return true;
	}
	public void print() {
		Node current=head;
		while(current!=null) {
			System.out.print(current.data+",");
			current=current.next;
		}
		System.out.println();
	}
	public void print(Node n) {
		Node current=n;
		while(current!=null) {
			System.out.print(current.data+",");
			current=current.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		SingleLinkedList ll=new SingleLinkedList();
		ll.add(2);ll.add(4);ll.add(2);ll.add(2);ll.add(4);ll.add(7);ll.add(9);ll.add(8);
		ll.print();

		System.out.println("Get Nth Node from end");
		System.out.println("Nth Node From End:"+ ll.getNthNodeFromEnd(3));
		System.out.println("Reverse LinkedList using Recursive");

		ll.reverseRecursive(ll.head);
		ll.print();
		System.out.println("Reverse LinkedList using Iterative");
		ll.reverseIterative();
		ll.print();
		System.out.println("Sort LinkedList");
		Node n=ll.mergeSort();
		ll.print(n);
		System.out.println("Remove Duplicate Data");
		ll.removeDuplicateNode();
		ll.print();
		System.out.println("Add 1 to LinkedList");
		
		System.out.println("Check Pallindrome");
		System.out.println("IsPallindrome:"+ ll.isPallindrome());
		System.out.println("Partition the Given Node");
		
	}
}
