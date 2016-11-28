
public class TreeDriver {


	public static void main(String[] args) {

		
		Tree<Integer> t1 = new Tree<Integer>();
		TreeNode<Integer> tn;
		
		BinaryTree<Integer> bt = new BinaryTree<Integer>();
		
		bt.insert(6);
		bt.insert(12);
		bt.insert(9);
		bt.insert(3);
		bt.insert(5);
		bt.insert(2);
		bt.insert(15);
		bt.insert(10);
		bt.insert(7);
		
		System.out.println("Postorder: ");
		bt.postorderPrint(bt.getRoot());
		System.out.println("\nPreorder: ");
		bt.preorderPrint(bt.getRoot());
		System.out.println("\nInorder: ");
		bt.inorderPrint(bt.getRoot());
		System.out.println("\nCount: " + bt.getCount());
		System.out.println("");
		tn = bt.deleteNode(9);
	
		System.out.println("Postorder (After 9 removal): ");
		bt.postorderPrint(bt.getRoot());
		System.out.println("\nPreorder (After 9 removal): ");
		bt.preorderPrint(bt.getRoot());
		System.out.println("\nInorder: (After 9 removal): ");
		bt.inorderPrint(bt.getRoot());
		System.out.println("\nCount: " + bt.getCount());
		System.out.println("");
		tn = bt.deleteNode(6);
		
		System.out.println("Postorder (After 6 removal): ");
		bt.postorderPrint(bt.getRoot());
		System.out.println("\nPreorder (After 6 removal): ");
		bt.preorderPrint(bt.getRoot());
		System.out.println("\nInorder (After 6 removal): ");
		bt.inorderPrint(bt.getRoot());
		System.out.println("\nCount: " + bt.getCount());

		

		/*t1.insert(6);
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
		
		t1.preorder(t1.getRoot());*/

	}

}
