package main;

public class MainApp {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		LinkedList linkedList = new LinkedList();
		
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(4);
		linkedList.add(5);
		linkedList.add(6);
		linkedList.add(7);
		linkedList.add(8);
		
		linkedList.showList();
		
		linkedList.rotateSubList(2, 5, 2);
		
		linkedList.showList();
		
		System.out.println(linkedList.haveLoop());
		System.out.println(linkedList.getLinkedListHavingLoop().haveLoop());
		
	}

}