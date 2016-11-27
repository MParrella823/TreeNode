
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

	public TreeNode<T> deleteNode(T val){
		TreeNode<T> temp;
		temp = find(val);
		
		deleteNode(this.root, val);
		
		
		
		return temp;
		
		
	}
	
	private void deleteNode(TreeNode<T> tn, T val){
		TreeNode<T> curr;
		TreeNode<T> temp;
		curr = tn;
		if (tn == null){ //empty tree
			System.out.println("Tree is empty!");
		}
		
		else if (count == 1){
			root = null;
			count--;
			System.out.println("Tree is now empty!");
		}
		else{
			if ((Integer)val == (Integer)tn.getData()){  //Deleting Root Node
				curr = findRightMin(curr);
				tn.setData(curr.getData());
				curr = curr.getParent();
				curr.setLeft(null);
				count --;
			}
			
			else{ 
				curr = find(val);
				if (curr.getLeft() == null && curr.getRight() == null){ //Deleting Leaf node
					curr = curr.getParent();
					if (curr.getLeft() == find(val)){
						curr.setLeft(null);
						count--;
					}
					else if (curr.getRight() == find(val)){
						curr.setRight(null);
						count--;
					}
				}
				else if (curr.getRight() != null && curr.getLeft() != null){ //Deleting node with 2 children
					temp = findRightMin(curr);
					curr.setData(temp.getData());
					curr.setRight(null);
					count--;
				}
				else if (curr.getRight() == null && curr.getLeft() !=null){ //Deleting node with only left child
					temp = curr.getLeft();
					curr.setData(temp.getData());
					curr.setLeft(null);
					count--;
				}
			}
		}
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
	
	public void preorder(TreeNode<T> tn){
		
		if (tn != null){
			System.out.print(tn.getData() + " ");
			preorder(tn.getLeft());
			preorder(tn.getRight());	
		}
	}
	
	public void postorder(TreeNode<T> tn){
		
		if (tn != null){
			postorder(tn.getLeft());
			postorder(tn.getRight());	
			System.out.print(tn.getData() + " ");
		}
	}
	
	public void inorder(TreeNode<T> tn){
		
		if (tn != null){
			inorder(tn.getLeft());
			System.out.print(tn.getData() + " ");
			inorder(tn.getRight());	
			
		}
	}
	
	private TreeNode<T> findRightMin(TreeNode<T> tn){
		TreeNode<T> curr = null;
		curr = tn;
		curr = curr.getRight();
		if (curr.getLeft() == null){
			return curr;
		}
		else{
			while (curr.getLeft() != null){
				curr = curr.getLeft();
			}
		}
		return curr;
	}
}
