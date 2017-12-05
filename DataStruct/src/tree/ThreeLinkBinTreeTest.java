package tree;

import tree.ThreeLinkBinTree.TreeNode;

public class ThreeLinkBinTreeTest {
	
	public static void main(String[] args) {
		ThreeLinkBinTree<String> binTree=new ThreeLinkBinTree<String>("root");
		TreeNode tn1 = binTree.addNode(binTree.root(), "第二层节点的左子节点", true);
		TreeNode tn2 = binTree.addNode(binTree.root(), "第二层节点的	左子节点", false);
		TreeNode tn3 = binTree.addNode(tn2, "第二层右节点的右子节点", false);
		System.out.println(tn3);
	}
}	
