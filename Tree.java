
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
		
		else if (count == 1){ // Tree only contains 1 node
			root = null;
			count--;
			System.out.println("Tree is now empty!");
		}
		else{
			if ((Integer)val == (Integer)tn.getData()){  //Deleting Root Node
				/*
				 * 
				 * The following code is for removing the root node of a tree that has no right child (only left side populated)
				 * 
				 */
				if (tn.getRight() == null){ //If no right child of root node exists
					curr = findLeftMax(curr);
					tn.setData(curr.getData());
					
					/*
					 * The following lines of code will dictate removal behavior based upon location of node with the highest value
					 * 
					 */
					if (tn.getLeft() != curr){ // If it is not the first node
						curr = curr.getParent();
						curr.setRight(null);
						count--;
					}
					else if (tn.getLeft() == curr){ //If it is the first node
						if (curr.getLeft() == null){ 
							curr = tn;
							tn.setLeft(null);
							count--;
						}
						else if (curr.getLeft() != null){ // If it is beyond the first node
							temp = curr.getLeft();
							tn.setLeft(temp);
							count --;
						}
					}
				}
				else{
					System.out.println("tn data = " + tn.getData());
					curr = findRightMin(curr);
					tn.setData(curr.getData());
					if (tn.getRight() != curr){ //If it is not on second level
						curr = curr.getParent();
						curr.setLeft(null);
						count--;
					}
					else if (tn.getRight() == curr){
						if (curr.getRight() == null){
							curr = tn;
							tn.setRight(null);
							count--;
						}
						else if (curr.getRight() != null){
							temp = curr.getRight();
							tn.setRight(temp);
							count --;
						}
					}

				}
			}
			else{ 
				curr = find(val);
				if (curr.getLeft() == null && curr.getRight() == null){ //Deleting Leaf node
					curr = curr.getParent();
					if ((Integer)val < (Integer)curr.getData()){
						curr.setLeft(null);
						count--;
					}
					else {
						
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
				else if (curr.getRight() == null && curr.getLeft() !=null){ //Deleting node which has 1 child node
					temp = findLeftMax(curr);
					curr.setData(temp.getData());
					curr.setLeft(temp.getParent());
					curr = curr.getLeft();
					curr.setRight(null);
					count--;
				}
				
				else if (curr.getRight() != null && curr.getLeft() == null){
					temp = curr.getRight();
					curr.setData(temp.getData());
					curr.setRight(null);
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

	public void preorderPrint(TreeNode<T> tn){

		if (tn != null){
			System.out.print(tn.getData() + " ");
			preorderPrint(tn.getLeft());
			preorderPrint(tn.getRight());	
		}
	}

	public void postorderPrint(TreeNode<T> tn){

		if (tn != null){
			postorderPrint(tn.getLeft());
			postorderPrint(tn.getRight());	
			System.out.print(tn.getData() + " ");
		}
	}

	public void inorderPrint(TreeNode<T> tn){

		if (tn != null){
			inorderPrint(tn.getLeft());
			System.out.print(tn.getData() + " ");
			inorderPrint(tn.getRight());	

		}
	}

	private TreeNode<T> findRightMin(TreeNode<T> tn){
		TreeNode<T> curr = null;
		curr = tn;

		if (curr.getRight() == null){
			return tn;
		}
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

	private TreeNode<T> findLeftMax(TreeNode<T> tn){
		TreeNode<T> curr = null;
		curr = tn;

		curr = curr.getLeft();

		if (curr.getRight() == null){
			return curr;
		}

		else{
			while (curr.getRight() != null){
				curr = curr.getRight();
			}
		}
		return curr;

	}
}
