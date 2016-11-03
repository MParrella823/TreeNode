
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
		insert(this.root, val);
    }

	private void insert(TreeNode<T> tn, T val){

		if (tn == null){ //empty tree
			TreeNode<T> t = new TreeNode<T>(val);
			this.root = t;
			this.count++;
			return;
		}		
		if ((Integer)val == (Integer)tn.getData()){
			return;
		}				
		if ((Integer)val < (Integer)tn.getData()){
			if (tn.getLeft() == null){
				TreeNode<T> t = new TreeNode<T>(val);
				tn.setLeft(t);
				t.setParent(tn);
				this.count++;
			}			
			else{				
				insert(tn.getLeft(),val);
			}				
			return;
		}
		if ((Integer)val > (Integer)tn.getData()){
			if (tn.getRight() == null){
				TreeNode<T> t = new TreeNode<T>(val);
				tn.setRight(t);
				t.setParent(tn);
				this.count++;
			}
			else{
				insert(tn.getRight(), val);
			}				
			return;
		}		
		
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
