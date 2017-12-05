package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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
	public SortedBinTree(){
		root=null;
	}
	public SortedBinTree(T o){
		root=new Node(o,null,null,null);
	}
	public void add(T ele){
		if(root==null){
			root=new Node(ele,null,null,null);
		}else{
			Node current=root;
			Node parent=null;
			int cmp=0;
			do{
				parent=current;
				cmp=ele.compareTo(current.data);
				if(cmp>0){
					current=current.right;
				}else{
					current=current.left;
				}
			}while(current!=null);
			Node newNode=new Node(ele,parent,null,null);
			if(cmp>0){
				parent.right=newNode;
			}else{
				parent.left=newNode;
			}
		}
	}
	public void remove(T ele){
		Node target=getNode(ele);
		if(target==null){
			return;
		}
		if(target.left==null
			&&target.right==null){
			if(target==root){
				root=null;
			}else{
				if(target==target.parent.left){
					target.parent.left=null;
				}else{
					target.parent.right=null;
				}
				target.parent=null;
			}
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
}
