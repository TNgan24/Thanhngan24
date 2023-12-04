package lab10_Tree;

import java.util.Collection;
import java.util.List;

public class BST<E extends Comparable<E>> {
	private BNode<E> root;

	public BST() {
		this.root = null;

	}

	// Add element e into BST
	public void add(E e) {
		if (this.root == null) {
			root = new BNode<E>(e);
		} else {
			this.root.add(e);
		}
	}

	// Add a collection of elements col into BST
	public void add(Collection<E> col) {
		for (E e : col) {
			add(e);
		}
	}

	// compute the depth of a node in BST
	public int depth(E node) {
		if (this.root != null) {
			return this.root.depth(node);
		}

		return -1;
	}

	// compute the height of BST
	public int height() {
		if (this.root != null) {
			return this.root.height();
		}

		return -1;
	}

	// Compute total nodes in BST
	public int size() {
		if (this.root == null)
			return 0;
		else {
			return this.root.size();
		}
	}

	// Check whether element e is in BST
	public boolean contains(E e) {
		if (this.root == null)
			return false;
		else {
			return this.root.contains(e);
		}
	}

	// Find the minimum element in BST
	public E findMin() {
		if (this.root == null) {
			return null;
		}
		return this.root.findMin();
	}

	// Find the maximum element in BST
	public E findMax() {
		if (this.root == null) {
			return null;
		}
		return this.root.findMax();
	}

	// Remove element e from BST
	public boolean remove(E e) {
		if (this.root == null)
			return false;
		else {
			return this.root.remove(e);
		}
	}

	// get the descendants of a node
	public List<E> descendants(E data) {
		if (this.root == null) {
			return null;
		} else {
			return this.root.descendants(data);
		}
	}

	// get the ancestors of a node
	public List<E> ancestors(E data) {
		if (this.root == null) {
			return null;
		} else {
			return this.root.ancestors(data);
		}
	}

	// display BST using inorder approach
	public void inorder() {
		if (this.root != null) {
			this.root.inorder();
		}
	}

	// display BST using preorder approach
	public void preorder() {
		if (this.root != null) {
			this.root.preorder();
		}
	}

	// display BST using postorder approach
	public void postorder() {
		if (this.root != null) {
			this.root.postorder();
		}
	}

	public static void main(String[] args) {
		BST<Integer> numberTree = new BST<>();
		numberTree.add(70);
		numberTree.add(20);
		numberTree.add(5);
		numberTree.add(19);
		numberTree.add(90);
		numberTree.add(10);
		numberTree.add(22);
		numberTree.add(18);
		
		

		System.out.println(numberTree.depth(44));
		System.out.println(numberTree.depth(56));

		System.out.println(numberTree.height());
		System.out.println(numberTree.size());
		System.out.println(numberTree.contains(30));
		System.out.println(numberTree.contains(41));
		System.out.println(numberTree.findMax());
		System.out.println(numberTree.findMin());

		System.out.println(numberTree.descendants(15));
		System.out.println(numberTree.descendants(50));

		System.out.println(numberTree.ancestors(12));
		System.out.println(numberTree.ancestors(30));
		System.out.println(numberTree.ancestors(70));

		System.out.println(numberTree.remove(20));
		System.out.println(numberTree.remove(42));

		numberTree.inorder();
		System.out.println();
		numberTree.preorder();
		System.out.println();
		numberTree.postorder();

	}

}
