
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
	 * 
	 * @return the root
	 */
	public TreeNode<T> getRoot() {
		return root;
	}


	/**
	 * @param the root to set
	 */
	public void setRoot(TreeNode<T> root) {
		this.root = root;
	}


	/**
	 * @return the current node count
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
	
	/**
	 * 
	 * This method will insert the passed value into the tree, adhering to the rules of a Binary Tree
	 * 
	 * @param val The value to be added to the tree
	 */

	public void insert(T val){
		insert(this.root, val);
	}
	
	/**
	 * 
	 * This is a private insert method that performs the same operation of the other insert method,
	 * but instead it takes 2 arguments.
	 * 
	 * @param tn The starting node to begin inserting
	 * @param val The value to be inserted into the tree
	 */

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
	
	/**
	 * 
	 * This method will delete the passed value from the Tree and return the deleted Node location.
	 * 
	 * 
	 * @param val The value to be removed from the tree.
	 * @return The deleted node's memory location.
	 */

	public TreeNode<T> deleteNode(T val){
		TreeNode<T> temp;
		temp = find(val);
		deleteNode(this.root, val);
		return temp;
	}
	
	/**
	 * 
	 * This method is the same as the other 'deleteNode' method, except this version takes two arguments.
	 * 
	 * @param tn The starting node to find the node marked for deletion
	 * @param val The value to be removed from the Tree
	 * 
	 */

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
					else if (tn.getLeft() == curr){ //If it is the first node beyond the root node
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
					/*
					 * 
					 * The following lines of code will handle deleting a root node that has a right child
					 * 
					 */
					curr = findRightMin(curr);
					tn.setData(curr.getData());
					if (tn.getRight() != curr){ //If it is not on second level
						curr = curr.getParent();
						curr.setLeft(null);
						count--;
					}
					else if (tn.getRight() == curr){ //If it is the first node after the root node
						if (curr.getRight() == null){//If there is no node after the current node
							curr = tn;
							tn.setRight(null);
							count--;
						}
						else if (curr.getRight() != null){//If there are more nodes past the current node
							temp = curr.getRight();
							tn.setRight(temp);
							count --;
						}
					}

				}
			}
			/*
			 * 
			 * This lines of code deal with deleting any node that is NOT the root node
			 * 
			 */
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
					temp = temp.getParent();
					if (temp.getLeft() != null && temp.getRight() == null){
						curr.setLeft(null);
						curr.setRight(null);
						count--;
					}
					else if (temp.getLeft() == null && temp.getRight() != null){
					temp.setLeft(null);
					temp.setRight(null);
					count--;
					}
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
	
	/**
	 * 
	 * This method will find the passed value in the tree and return that node's location in memory.
	 * 
	 * @param val The value to find
	 * @return The node's location in memory
	 */

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

	/**
	 * 
	 * This method will print out the Tree's contents in 'pre' format (will first print the value, then move left/right)
	 * 
	 * @param tn The starting node in the tree to begin printing
	 */
	
	public void preorderPrint(TreeNode<T> tn){

		if (tn != null){
			System.out.print(tn.getData() + " ");
			preorderPrint(tn.getLeft());
			preorderPrint(tn.getRight());	
		}
	}
	
	/**
	 * 
	 * This method will print out the Tree's contents in 'post' format (will first  go left, go right, then print
	 * 
	 * @param tn The starting node in the tree to begin printing
	 */

	public void postorderPrint(TreeNode<T> tn){

		if (tn != null){
			postorderPrint(tn.getLeft());
			postorderPrint(tn.getRight());	
			System.out.print(tn.getData() + " ");
		}
	}
	
	/**
	 * 
	 * This method will print out the Tree's contents in 'in order' format (will first go left, print, then go right)
	 * 
	 * 
	 * @param tn The starting node in the tree to begin printing
	 */

	public void inorderPrint(TreeNode<T> tn){

		if (tn != null){
			inorderPrint(tn.getLeft());
			System.out.print(tn.getData() + " ");
			inorderPrint(tn.getRight());	

		}
	}
	
	/**
	 * 
	 * This method will find the minimum value on the right side of the Tree.  This is mainly used for when the 
	 * root node is deleted, and the minimum value on the right side of the tree needs to take it's place.
	 * 
	 * @param tn Starting node from which to find the minimum value on the right side
	 * @return The location in memory of the minimum value node
	 */

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

	/**
	 *  
	 * This method will find the maximum value in the left branch of the starting node.
	 * 
	 * @param tn The starting node to begin the search 
	 * @return The location of the node with the maximum value
	 */
	
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
	
}//End of class
