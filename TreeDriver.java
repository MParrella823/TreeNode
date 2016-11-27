
public class TreeDriver {


	public static void main(String[] args) {

		Tree<Integer> t1 = new Tree<Integer>();
		TreeNode<Integer> tn;

		t1.insert(6);
		t1.insert(12);
		t1.insert(9);
		t1.insert(3);
		t1.insert(5);
		t1.insert(2);
		t1.insert(15);
		t1.insert(10);
		t1.insert(7);
		t1.insert(1);

		System.out.println("Count: " + t1.getCount());

		System.out.println("\nPre Order: ");

		t1.preorder(t1.getRoot());
		System.out.println("");
		System.out.println("\nIn Order:");

		t1.inorder(t1.getRoot());
		System.out.println("");
		System.out.println("\nPost Order:");

		t1.postorder(t1.getRoot());
		
		tn = t1.deleteNode(6);
		
		System.out.println("");
		System.out.println("After remove");
		
		t1.preorder(t1.getRoot());

	}

}
