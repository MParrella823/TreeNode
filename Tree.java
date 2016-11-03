
/*
 * 
 * This is a Binary Tree object.
 * 
 */

public class Tree<T> {
	
	private TreeNode<T> root;
	private int count;
	
	public Tree(){
		root = null;
		count = 0;
	}
	
	
	/**
	 * @return the root
	 */
	public TreeNode<T> getRoot() {
		return root;
	}


	/**
	 * @param root the root to set
	 */
	public void setRoot(TreeNode<T> root) {
		this.root = root;
	}


	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}


	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	public void insert(T val){
		
		
		
		
		
	}
	
	public void delete(T val){
		
		
		
	}
	
	public TreeNode<T> find(T val){
		
	
		TreeNode<T> curr = null;
		
		curr = root;
		
		while (curr != null){
			if (curr.getData() == (Integer)val){
				break;		
			}
			else if ((Integer)val < (Integer)curr.getData()){
				curr = curr.getLeft();
			}
			else {
				curr = curr.getRight();
			}
		}
		return curr;
	}
	

}
