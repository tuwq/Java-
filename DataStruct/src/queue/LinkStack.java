package queue;

//链表栈
public class LinkStack<T> {
	
	//定义一个内部类Node,Node实例代表链栈的节点
	private class Node{
		//保存节点的数据
		private T data;
		//指向下一个节点的引用
		private Node next;
		//无参数的构造器
		public Node(){
			
		}
		//初始化全部属性的构造器
		public Node(T data,Node next){
			this.data=data;
			this.next=next;
		}
	}
	//保存该链栈的栈顶元素
	private Node top;
	//保存该链栈中已包含的节点树
	private int size;
	//创建空链栈
	public LinkStack(){
		//空链栈，top的值为null
		top=null;
	}
	//以指定数据元素来创建链栈，该链栈只有一个元素
	public LinkStack(T element){
		top=new Node(element,null);
		size++;
	}
	//返回栈顶的元素
	public int length(){
		return size;
	}
	//进栈
	public void push(T element){
		top=new Node(element,top);
		size++;
	}
	//出栈
	public T pop(){
		Node oldTop=top;
		oldTop.next=null;
		size--;
		return oldTop.data;
	}
	public T peek(){
		return top.data;
	}
	public boolean empty(){
		return size==0;
	}
	public void clear(){
		top=null;
		size=0;
	}
	public String toString(){
		if(empty()){
			return "[]";
		}else{
			StringBuilder sb=new StringBuilder("[");
			for (Node current=top;current != null;current=current.next) {
				sb.append(current.data.toString()+",");
			}
			int len=sb.length();
			return sb.delete(len-2, len).append("]").toString();
		}
	}
	
	
}
