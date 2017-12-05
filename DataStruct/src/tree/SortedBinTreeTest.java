package tree;

public class SortedBinTreeTest {
	public static void main(String[] args) {
		SortedBinTree<Integer> tree = new SortedBinTree<Integer>();
		tree.add(5);
		tree.add(20);
		tree.add(66);
		tree.add(13);
		tree.add(71);
		tree.add(20);
		tree.add(23);
		System.out.println(tree.breadthFirst());
		tree.remove(5);
		System.out.println(tree.breadthFirst());
	}
}
