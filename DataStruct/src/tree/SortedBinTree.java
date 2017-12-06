package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import tree.ThreeLinkBinTree.TreeNode;

//排序二叉树
public class SortedBinTree<T extends Comparable> {
	
	static class Node{
		Object data;
		Node parent;
		Node left;
		Node right;
		public Node(Object data, Node parent, Node left, Node right) {
			super();
			this.data = data;
			this.parent = parent;
			this.left = left;
			this.right = right;
		}
		public String toString() {
			return "Node [data=" + data + "]";
		}
		public boolean equals(Object obj){
			if(this==obj){
				return true;
			}
			if(obj.getClass()==Node.class){
				Node target=(Node) obj;
				return data.equals(target.data)
						&&left==target.left
						&&right==target.right
						&&parent==target.parent;
			}
			return false;
		}
	}
	
	private Node root;
	//两个构造器用于创建二叉树
	public SortedBinTree(){
		root=null;
	}
	public SortedBinTree(T o){
		root=new Node(o,null,null,null);
	}
	//添加节点
	public void add(T ele){
		//如果根节点为null
		if(root==null){
			root=new Node(ele,null,null,null);
		}else{
			Node current=root;
			Node parent=null;
			int cmp=0;
			//搜索合适的叶子节点，已该叶子节点作为父节点添加新节点
			do{
				parent=current;
				cmp=ele.compareTo(current.data);
				//如果新节点的值大于当前节点的值
				if(cmp>0){
					//以右子节点作为当前
					current=current.right;
				}//如果新节点的值小于当前节点的值
				else{
					//以左子节点作为当前节点
					current=current.left;
				}
			}while(current!=null);
			//创建新节点
			Node newNode=new Node(ele,parent,null,null);
			//如果新节点的值大于父节点的值
			if(cmp>0){
				parent.right=newNode;
			}else{
				parent.left=newNode;
			}
		}
	}
	//删除节点
	public void remove(T ele){
		//获取要删除的节点
		Node target=getNode(ele);
		if(target==null){
			return;
		}
		//如果要删除的节点的左、右子树为空
		if(target.left==null
			&&target.right==null){
			if(target==root){
				root=null;
			}else{
				//如果要删除节点是父节点的左子节点
				if(target==target.parent.left){
					//将target的父节点的left设为null
					target.parent.left=null;
				}else{
					//将target的父节点的right设为null
					target.parent.right=null;
				}
				//将target的父节点引用删除
				target.parent=null;
			}
		//如果要删除节点只有右子树
		}else if(target.left==null
			&&target.right!=null){
			if(target==root){
				root=target.right;
			}else{
				if(target==target.parent.left){
					target.parent.left=target.right;
				}else{
					target.parent.right=target.right;
				}
				target.right.parent=target.parent;
			}
		//如果要删除节点只有左子树
		}else if(target.left!=null
				&&target.right==null){
				if(target==root){
					root=target.right;
				}else{
					if(target==target.parent.left){
						target.parent.left=target.left;
					}else{
						target.parent.right=target.left;
					}
					target.left.parent=target.parent;
				}
		//如果要删除节点既有左子树，又有右子树
		}else{
			Node leftMaxNode=target.left;
			while(leftMaxNode.right!=null){
				leftMaxNode=leftMaxNode.right;
			}
			leftMaxNode.parent.right=null;
			leftMaxNode.parent=target.parent;
			if(target==target.parent.left){
				target.parent.left=leftMaxNode;
			}else{
				target.parent.right=leftMaxNode;
			}
			leftMaxNode.left=target.left;
			leftMaxNode.right=target.right;
			target.parent=target.left=target.right=null;
		}
	}
	//根据给定的值搜索节点
	public Node getNode(T ele){
		Node p=root;
		while(p!=null){
			int cmp=ele.compareTo(p.data);
			if(cmp<0){
				p=p.left;
			}else if(cmp>0){
				p=p.right;
			}else{
				return p;
			}
		}
		return null;
	}
	//广度优先遍历
	public List<Node> breadthFirst(){
		Queue<Node> queue = new ArrayDeque<Node>();
		List list=new ArrayList<String>();
		if(root!=null){
			queue.offer(root);
		}
		while(!queue.isEmpty()){
			list.add(queue.peek());
			Node p = queue.poll();
			if(p.left!=null){
				queue.offer(p.left);
			}
			if(p.right!=null){
				queue.offer(p.right);
			}
		}
		return list;
	}
	//实现中序序遍历
	public List<Node> centerIterator(){
		return centerIterator(root);
	}
	private List<Node> centerIterator(Node node) {
		List<Node> list = new ArrayList<Node>();
		//递归处理左子树
		if(node.left!=null){
			list.addAll(centerIterator(node.left));
		}
		//处理根节点
		list.add(node);
		//递归处理右子树
		if(node.right!=null){
			list.addAll(centerIterator(node.right));
		}
		return list;
	}
}
