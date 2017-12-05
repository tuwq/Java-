package tree;

import java.util.ArrayList;
import java.util.List;

import tree.HuffmanTree.Node;

public class HuffmanTreeTest {
	public static void main(String[] args) {
		List<Node<String>> nodes=new ArrayList<>();
		nodes.add(new Node<String>("A",40.0));
		nodes.add(new Node<String>("B",57.0));
		nodes.add(new Node<String>("C",102.0));
		nodes.add(new Node<String>("D",32.0));
		nodes.add(new Node<String>("E",11.0));
		Node<String> root = HuffmanTree.createTree(nodes);
		System.out.println(HuffmanTree.breadthFirst(root));
	}
}
