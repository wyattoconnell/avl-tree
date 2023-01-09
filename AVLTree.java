package tree;

/**
 * Self-balancing AVL Tree
 * @author Mark Floryan
 *
 * @param <T>
 */
public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T>{
	
	@Override
	public void insert(T data) {
		this.root = insert(data, this.root);
	}
	protected TreeNode<T> insert(T data, TreeNode<T> curNode) {
		//TODO: Implement this method
		curNode = super.insert(data, curNode);
		newHeights(curNode);
		return balance(curNode);
	}

	@Override
	public void remove(T data) {
		this.root = remove(data, this.root);
	}
	protected TreeNode<T> remove(T data, TreeNode<T> curNode) {
		//TODO: Implement this method
		curNode = super.remove(data, curNode);
		newHeights(curNode);
		return balance(curNode);
	}
	
	/**
	 * Balances the given node. Assumes it is the lowest unbalanced node if unbalanced
	 * @param node
	 * @return
	 */
	private TreeNode<T> balance(TreeNode<T> curNode) {
		//TODO: Implement this method
		int balFact = balanceFactor(curNode);
		if (balFact < -1) {
			if (balanceFactor(curNode.left) <= 0) {
				curNode = rotateRight(curNode);
			}
			else {
				curNode.left = rotateLeft(curNode.left);
				curNode = rotateRight(curNode);
			}
		}
		if (balFact > 1) {
			if (balanceFactor(curNode.right) >= 0) {
				curNode = rotateLeft(curNode);
			}
			else {
				curNode.right = rotateRight(curNode.right);
				curNode = rotateLeft(curNode);
			}
		}
		return curNode;
	}
	
	public TreeNode<T> rotateRight(TreeNode<T> curNode) {
		//TODO: Implement this method
		TreeNode<T> newRoot = curNode.left;
		curNode.left = newRoot.right;
		newRoot.right = curNode;
		newHeights(curNode);
		newHeights(newRoot);
		return newRoot;
	}
	
	private TreeNode<T> rotateLeft(TreeNode<T> curNode){
		//TODO: Implement this method
		TreeNode<T> newRoot = curNode.right;
		curNode.right = newRoot.left;
		newRoot.left = curNode;
		newHeights(curNode);
		newHeights(newRoot);
		return newRoot;
	}
	
	private int balanceFactor(TreeNode<T> node) {
		//TODO: Implement this method
		if (node == null) return -1;
		return height(node.right) - height(node.left);
	}
	
	private void newHeights(TreeNode<T> curNode) {
		if (curNode == null) return;
		curNode.height = Math.max(height(curNode.right), height(curNode.left)) + 1;
		
	}
	protected int height(TreeNode<T> curNode) {
		if (curNode == null) return 0;
		return curNode.height;
		
	}
	
	
}
