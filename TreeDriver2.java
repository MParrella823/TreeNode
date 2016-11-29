
public class TreeDriver2{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		BinaryTree<Integer> bt = new BinaryTree<Integer>();
		TreeNode<Integer> tn = new TreeNode<Integer>();
		
		
		bt.insert(8);
		bt.insert(4);
		bt.insert(5);
		bt.insert(6);
		bt.insert(2);
		bt.insert(3);
		bt.insert(1);
		bt.insert(12);
		bt.insert(9);
		bt.insert(10);
		
		System.out.println("Postorder: ");
		bt.postorderPrint(bt.getRoot());
		System.out.println("\nPreorder: ");
		bt.preorderPrint(bt.getRoot());
		System.out.println("\nInorder: ");
		bt.inorderPrint(bt.getRoot());
		System.out.println("\nCount: " + bt.getCount());
		System.out.println("");
		tn = bt.deleteNode(5);
		
		System.out.println("Postorder: ");
		bt.postorderPrint(bt.getRoot());
		System.out.println("\nPreorder: ");
		bt.preorderPrint(bt.getRoot());
		System.out.println("\nInorder: ");
		bt.inorderPrint(bt.getRoot());
		System.out.println("\nCount: " + bt.getCount());
		System.out.println("");
		

	}

}
