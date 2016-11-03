
public class TreeDriver {

	
	public static void main(String[] args) {

		Tree<Integer> t1 = new Tree<Integer>();
		
		t1.insert(6);
		t1.insert(9);
		t1.insert(7);
		t1.insert(3);
		t1.insert(5);
		t1.insert(2);
		t1.insert(15);
		
	 System.out.println("Count: " + t1.getCount());
	 
	 Tree<Integer> t = new Tree<Integer>();
	
	 t1.display(t1.getRoot());

	}

}
