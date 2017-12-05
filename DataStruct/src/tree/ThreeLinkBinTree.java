package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import javax.xml.soap.Node;

//三叉链表存储
public class ThreeLinkBinTree<E> {
	public static class TreeNode{
		Object data;
		//内部分别指向左、右和父节点的引用
		TreeNode left;
		TreeNode right;
		TreeNode parent;
		public TreeNode(){
			
		}
		public TreeNode(Object data){
			this.data=data;
		}
		public TreeNode(Object data, TreeNode left, TreeNode right, TreeNode parent) {
			this.data = data;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}
	}
	private TreeNode root;
	//已默认的构造器来创建二叉树
	public ThreeLinkBinTree(){
		this.root=new TreeNode();
	}
	//已指定的根元素来创建二叉树
	public ThreeLinkBinTree(E data){
		this.root=new TreeNode(data);
	}
	/**
	 * 为指定节点添加子节点
	 * @param parent	需要添加子节点的父节点的索引
	 * @param data		新子节点的数据
	 * @param isLeft	是否为左节点
	 * @return			返回新增的节点
	 */
	public TreeNode addNode(TreeNode parent,E data,boolean isLeft){
		if(parent==null){
			throw new RuntimeException("节点为null，无法添加子节点");
		}
		if(isLeft&&parent.left!=null){
			throw new RuntimeException("节点已有左子节点，无法添加左子节点");
		}
		if(!isLeft&&parent.right!=null){
			throw new RuntimeException("节点已有右子节点，无法添加右子节点");
		}
		TreeNode newNode=new TreeNode(data);
		if(isLeft){
			//让父节点的left引用指向新节点
			parent.left=newNode;
		}else{
			//让父节点的right引用指向新节点
			parent.right=newNode;
		}
		newNode.parent=parent;
		return newNode;
	} 
	
	//判断二叉树是否为空
	public boolean empty(){
		return root.data==null;
	}
	//返回根节点
	public TreeNode root(){
		if(empty()){
			throw new RuntimeException("树为空，无法访问根节点");
		}
		return root;
	}
	//返回指定节点(非根节点)的父节点
	public E parent(TreeNode node){
		if(node==null){
			throw new RuntimeException("");
		}
		return (E) node.parent.data;
	}
	//返回指定节点(非叶子)的左子节点，当左子节点不存在时返回null
	public E leftChild(TreeNode parent){
		if(parent==null){
			throw new RuntimeException("");
		}
		return parent.left==null?null:(E)parent.left.data;
	}
	//返回指定节点(非叶子)的右子节点，当右子节点不存在时返回null
	public E rightChild(TreeNode parent){
		if(parent==null){
			throw new RuntimeException("");
		}
		return parent.right==null?null:(E)parent.right.data;
	}
	//返回树的深度
	public int deep(){
		return deep(root);
	}
	//返回指定节点的深度
	private int deep(TreeNode node) {
		if(node==null){
			return 0;
		}
		if(node.left==null
			&&node.right==null){
			return 1;
		}else{
			int leftDeep = deep(node.left);
			int rightDeep = deep(node.right);
			int max=leftDeep>rightDeep?leftDeep:rightDeep;
			return max+1;
		}
	}
	//实现先序遍历
	public List<TreeNode> preIterator(){
		return preIterator(root);
	}
	private List<TreeNode> preIterator(TreeNode node) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		//处理根节点
		list.add(node);
		//递归处理左子树
		if(node.left!=null){
			list.addAll(preIterator(node.left));
		}
		//递归处理右子树
		if(node.right!=null){
			list.addAll(preIterator(node.right));
		}
		return list;
	}
	//广度优先遍历
	public List<TreeNode> breadthFirst(){
		Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		if(root!=null){
			//将根元素加入队列
			queue.offer(root);
		}
		while(!queue.isEmpty()){
			//将该队列的头部元素添加到List中
			list.add(queue.peek());
			//将该队列的头部元素移出队列
			TreeNode p = queue.poll();
			//如果左子节点不为null，将它加入队列
			if(p.left!=null){
				queue.offer(p.left);
			}
			//如果右子节点不为null，将它加入队列
			if(p.right!=null){
				queue.offer(p.right);
			}
		}
		return list;
	}
}
