package tree;

import java.util.List;

import tree.TreeParent.Node;

public class TreeParentTest {
	public static void main(String[] args) {
		TreeParent<String> tp = new TreeParent<String>("root");
		TreeParent.Node root=tp.root();
		System.out.println(root);
		tp.addNode("节点1", root);
		System.out.println("此时树的深度"+tp.deep());
		tp.addNode("节点2", root);
		List<Node<String>> nodes = tp.children(root);
		System.out.println("根节点的第一个子节点:"+nodes.get(0));
		//为根节点的第一个子节点新增一个子节点
		tp.addNode("节点3", nodes.get(0));
		System.out.println("此时树的深度"+tp.deep());
	}
}
//通过上面的介绍可以发现，父节点表示法的特点是:每个节点都可以快速找到它的父节点
//但如果要找到某个节点的所有子节点比较麻烦，程序要遍历整个节点数组
