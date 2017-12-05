package queue;

//链表队列
public class LinkQueue<T> {
	
	//定义一个内部类节点
	private class Node{
		//存储的数据
		private T data;
		//指向下一个节点
		private Node next;
		private Node(){
			
		}
		public Node(T data,Node next){
			this.data=data;
			this.next=next;
		}
	}
	//指向头节点
	private Node front;
	//指向尾节点
	private Node rear;
	private int size;
	//创建空链队列
	public LinkQueue(){
		front=null;
		rear=null;
	}
	//初始化添加链队列
	public LinkQueue(T element){
		front=new Node(element,null);
		rear=front;
		size++;
	}
	//返回长度
	public int length(){
		return size;
	}
	//添加数据元素进入队列
	public void add(T element){
		if(front==null){
			front=new Node(element,null);
			rear=front;
		}else{
			Node newNode=new Node(element,null);
			rear.next=newNode;
			rear=newNode;
		}
		size++;
	}
	//从队列中删除数据元素
	public T remove(){
		Node oldFront=front;
		front=front.next;
		oldFront.next=null;
		size--;
		return oldFront.data;
	}
	//获取最后一个元素
	public T element(){
		return (T) rear.data;
	}
	//判断是否为空链队列
	public boolean empty(){
		return size==0;	
	}
	//清空链队列
	public void clear(){
		front=null;
		rear=null;
		size=0;
	}
	//显示链队列   
	public String toString(){   
		if(empty()){
			return "[]";
		}else{
			StringBuilder sb=new StringBuilder();
			for (Node current=front;current!= null;current=current.next) {
				sb.append(current.data.toString()+", ");
			}
			int len=sb.length();
			return sb.delete(len-2, len).append("]").toString();
		}
	}
}
