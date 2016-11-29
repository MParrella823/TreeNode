
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

		tn = bt.deleteNode(7);
		System.out.println("Postorder (After 7 removal): ");
		bt.postorderPrint(bt.getRoot());
		System.out.println("\nPreorder (After 7 removal): ");
		bt.preorderPrint(bt.getRoot());
		System.out.println("\nInorder (After 7 removal): ");
		bt.inorderPrint(bt.getRoot());
		System.out.println("\nCount: " + bt.getCount());
		
		tn = bt.deleteNode(10);
		
		System.out.println("Postorder (After 10 removal): ");
		bt.postorderPrint(bt.getRoot());
		System.out.println("\nPreorder (After 10 removal): ");
		bt.preorderPrint(bt.getRoot());
		System.out.println("\nInorder (After 10 removal): ");
		bt.inorderPrint(bt.getRoot());
		System.out.println("\nCount: " + bt.getCount());
	
		
		tn = bt.deleteNode(12);
		System.out.println("Postorder (After 12 removal): ");
		bt.postorderPrint(bt.getRoot());
		System.out.println("\nPreorder (After 12 removal): ");
		bt.preorderPrint(bt.getRoot());
		System.out.println("\nInorder (After 12 removal): ");
		bt.inorderPrint(bt.getRoot());
		System.out.println("\nCount: " + bt.getCount());
		
		tn = bt.deleteNode(15);
		System.out.println("Postorder (After 15 removal): ");
		bt.postorderPrint(bt.getRoot());
		System.out.println("\nPreorder (After 15 removal): ");
		bt.preorderPrint(bt.getRoot());
		System.out.println("\nInorder (After 15 removal): ");
		bt.inorderPrint(bt.getRoot());
		System.out.println("\nCount: " + bt.getCount());
		
	
		
		tn = bt.deleteNode(5);
		System.out.println("Postorder (After 5 removal): ");
		bt.postorderPrint(bt.getRoot());
		System.out.println("\nPreorder (After 5 removal): ");
		bt.preorderPrint(bt.getRoot());
		System.out.println("\nInorder (After 5 removal): ");
		bt.inorderPrint(bt.getRoot());
		System.out.println("\nCount: " + bt.getCount());
		
		tn = bt.deleteNode(3);
		System.out.println("Postorder (After 3 removal): ");
		bt.postorderPrint(bt.getRoot());
		System.out.println("\nPreorder (After 3 removal): ");
		bt.preorderPrint(bt.getRoot());
		System.out.println("\nInorder (After 3 removal): ");
		bt.inorderPrint(bt.getRoot());
		System.out.println("\nCount: " + bt.getCount());
		
		tn = bt.deleteNode(2);
		System.out.println("Postorder (After 2 removal): ");
		bt.postorderPrint(bt.getRoot());
		System.out.println("\nPreorder (After 2 removal): ");
		bt.preorderPrint(bt.getRoot());
		System.out.println("\nInorder (After 2 removal): ");
		bt.inorderPrint(bt.getRoot());
		System.out.println("\nCount: " + bt.getCount());
		
		tn = bt.deleteNode(34);
		
		
	}

}
