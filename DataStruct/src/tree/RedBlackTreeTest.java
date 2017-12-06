package tree;

public class RedBlackTreeTest {
	public static void main(String[] args) {
		RedBlackTree<Integer> tree = new RedBlackTree<Integer>();
		tree.add(11);
		tree.add(2143);
		tree.add(3213);
		tree.add(455);
		tree.add(5);
		tree.remove(3213);
		System.out.println(tree.inIterator());
		
	}
	
}
