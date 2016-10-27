
public class TreeNode<T> {	
	
	private TreeNode<T>left;
	private TreeNode<T> right;
	private TreeNode<T> parent;
	private T data;
	
	public TreeNode(){
		data = null;
		left = null;
		right = null;
		parent = null;
	}
	
	public TreeNode(T data){
		this.data = data;
		left = null;
		right = null;
		parent = null;
	}
	
	/**
	 * @return the left
	 */
	public TreeNode<T> getLeft() {
		return left;
	}
	/**
	 * @param left the left to set
	 */
	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}
	/**
	 * @return the right
	 */
	public TreeNode<T> getRight() {
		return right;
	}
	/**
	 * @param right the right to set
	 */
	public void setRight(TreeNode<T> right) {
		this.right = right;
	}
	/**
	 * @return the parent
	 */
	public TreeNode<T> getParent() {
		return parent;
	}
	/**
	 * @param parent the parent to set
	 */
	public void setParent(TreeNode<T> parent) {
		this.parent = parent;
	}
	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}
	

	
}
