package tree;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> implements Tree<T>{
	
	@Override
	public void insert(T data) {
		this.root = insert(data, root);
	}
	
	/**
	 * Helper method for inserting recursively
	 * @param data
	 * @param curNode
	 * @return a reference to the new root of the subtree
	 */
	protected TreeNode<T> insert(T data, TreeNode<T> curNode) {
		//TODO: Implement this method
		if(curNode == null) return new TreeNode< T >(data);

		  else if (data.compareTo(curNode.data) < 0)
		    curNode.left = insert(data, curNode.left);

		  else if (data.compareTo(curNode.data) > 0)
		    curNode.right = insert(data, curNode.right);

		  else ; //duplicate, ignoring the insert
		  return curNode; //curNode still the root of this subtree;
	}

	@Override
	public boolean find(T data) {
		return find(data, root);
	}
	
	private boolean find(T data, TreeNode<T> curNode) {
		//TODO: Implement this method
		if(curNode == null) return false;
		  else if (data.compareTo(curNode.data) < 0)
		    return find(data, curNode.left);
		  else if (data.compareTo(curNode.data) > 0) 
		    return find(data, curNode.right);
		  return true; 
	}

	@Override
	public void remove(T data) {
		this.root = remove(data, root);
	}
	
	protected TreeNode<T> remove(T data, TreeNode<T> curNode) {
		//TODO: Implement this method
		if(data.compareTo(curNode.data) == 0) {
			if ((curNode.right == null)&&(curNode.left == null)){
				return null;
			}
			else if ((curNode.right == null)||(curNode.left == null)){
				if (curNode.right == null) return curNode.left;
					return curNode.right;
			}
			else {
				T max = findMax(curNode.left);
				curNode.data = max;
				curNode.left = remove(max, curNode.left);
				return curNode;
				
			}
		}

		  else if (data.compareTo(curNode.data) < 0)
		    curNode.left = remove(data, curNode.left);
	
		  else if (data.compareTo(curNode.data) > 0)
		    curNode.right = remove(data, curNode.right);
		
		  return curNode; //curNode still the root of this subtree;
	}
	
	/**
	 * Returns the max item in the given subtree
	 */
	public T findMax() {
		return findMax(this.root);
	}
	private T findMax(TreeNode<T> curNode) {
		//TODO: Implement this method
		if (curNode.right == null) return curNode.data;
		
		return findMax(curNode.right);
	}
}