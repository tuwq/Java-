package tree;

import java.util.ArrayList;
import java.util.List;

//父节点表示法树
public class TreeParent<E> {
	
	public static class Node<T>{
		
		T data;
		// 用于记录其父节点的位置
		int parent;
		public Node(){
			
		}
		public Node(T data){
			this.data=data;
		}
		public Node(T data,int parent){
			this.data=data;
			this.parent=parent;
		}
		@Override
		public String toString() {
			return "TreeParent$Node [data=" + data + ", parent=" + parent + "]";
		}
	}
	private final int DEFAULT_TREE_SIZE=100;
	private int treeSize=0;
	//使用一个Node[]数组来记录该树里的所有节点
	private Node[] nodes;
	//记录节点数
	private int nodeNums;
	//以指定根节点创建树
	@SuppressWarnings("unchecked")
	public TreeParent(E data){
		treeSize=DEFAULT_TREE_SIZE;
		nodes=new Node[treeSize];
		nodes[0]=new Node(data,-1);
		nodeNums++;
	}
	//已指定根节点、指定treeSize创建树
	@SuppressWarnings("unchecked")
	public TreeParent(E data,int treeSize){
		this.treeSize=treeSize;
		nodes=new Node[treeSize];
		nodes[0]=new Node(data,-1);
		nodeNums++;
	}
	//为指定节点添加子节点
	public void addNode(E data,Node parent){
		for (int i = 0; i < treeSize; i++) {
			//找到数组中第一个为null的元素，该元素保存新节点
			if(nodes[i]==null){
				nodes[i]=new Node(data,pos(parent));
				nodeNums++;
				return;
			}
		}
		throw new RuntimeException("该树已满，无法添加新节点");
	}//判断树是否为空
	public boolean empty(){
		return nodes[0]==null;
	}
	//返回根节点
	public Node<E> root(){
		return nodes[0];
	}
	//返回指定节点的(非根节点)的父节点
	public Node<E> parent(Node node){
		return nodes[node.parent];
	}
	//返回指定节点(非叶子节点)的所有子节点
	public List<Node<E>> children(Node parent){
		List<Node<E>> list=new ArrayList<Node<E>>();
		for (int i = 0; i < treeSize; i++) {
			//如果当前节点的父节点的位置等于parent节点的位置
			if(nodes[i]!= null&&nodes[i].parent==pos(parent)){
				list.add(nodes[i]);
			}
		}
		return list;
	}
	//返回该树的深度
	public int deep(){
		int max=0;
		for (int i = 0; i < treeSize&& nodes[i]!=null; i++) {
			//初始化本节点的深度
			int def=1;
			//m记录当前节点的父节点的位置
			int m=nodes[i].parent;
			//如果其父节点存在
			while(m!=-1&&nodes[m]!=null){
				//向上继续搜索节点
				m=nodes[m].parent;
				def++;
			}
			if(max<def){
				max=def;
			}
		}
		return max;
	}
	//返回包含指定值的节点
	public int pos(Node node){
		for (int i = 0; i < treeSize; i++) {
			//找到指定节点
			if(nodes[i]==node){
				return i;
			}
		}
		return -1;
	}
}
