package Sequence;

//单链表
public class LinkList<T> {
	
	//定义一个内部类Node、Node实例代表链表的节点
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
	//保存该链表的头节点
	private Node header;
	//保存该链表的尾节点
	private Node tail;
	//保存该链表中已包含的节点数
	private int size;
	//创建空链表
	public LinkList(){
		//空链表，header和tail都是null
		header=null;
		tail=null;
	}
	//以指定数据元素来创建链表，该链表只有一个元素
	public LinkList(T element){
		header=new Node(element,null);
		//只有一个节点，header、tail都指向该节点
		tail=header;
		size++;
	}
	//返回链表的长度
	public int length(){
		return size;
	}
	//获取链式线性表中索引为index处的元素
	public T get(int index){
		return getNodeByIndex(index).data;
	}
	//根据索引index获取指定位置的节点
	private Node getNodeByIndex(int index) {
		if(index < 0 || index > size-1){
			throw new IndexOutOfBoundsException("线性表索引越界");
		}
		Node current=header;
		for (int i = 0; i < size && current != null; i++,current=current.next) {
			if(i==index){
				return current;
			}
		}
		return null;
	}
	//查找链式线性表中指定元素的索引
	public int locate(T element){
		//从头节点开始搜索
		Node current=header;
		for (int i = 0; i < size && current!=null; i++,current=current.next) {
			if(current.data.equals(element)){
				return i;
			}
		}
		return -1;
	}
	//向链式线性表的指定位置插入一个元素
	public void insert(T element,int index){
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException("线性表索引越界");
		}
		//如果还是空链表
		if(header==null){
			add(element);
		}else{
			//当index为0时，也就是在链表头处插入
			if(index==0){
				addAtHeader(element);
			}else{
				//获取插入点的前一个节点
				Node prev=getNodeByIndex(index-1);
				//让prev的next指向新节点
				//让新节点的next引用指向原来的prev的下一个节点
				prev.next=new Node(element,prev.next);
				size++;
			}
		}
	}
	//采用尾插法为链表添加新节点
	public void add(T element){
		if(header==null){
			header=new Node(element,null);
			//只有一个节点，header、tail都指向该节点
			tail=header;
		}else{
			//创建新节点
			Node newNode=new Node(element,null);
			//让尾节点的next指向新增的节点
			tail.next=newNode;
			//以新节点作为新的尾点
			tail=newNode;
		}
		size++;
	}
	//采用头插法为链表添加新节点
	public void addAtHeader(T element){
		//创建新节点，让新节点的next指向原来header
		//并以新节点作为新的header
		header=new Node(element,header);
		//如果插入之前是空链表
		if(tail==null){
			tail=header;
		}
		size++;
	}
	//删除链表线性表中指定索引处的元素
	public T delete(int index){
		if(index < 0 || index >size-1){
			throw new IndexOutOfBoundsException("线性表索引越界");
		}
		Node del=null;
		//如果被删除的是header节点
		if(index==0){
			del=header;
			header=header.next;
		}else{
			//获取删除点的前一个节点
			Node prev=getNodeByIndex(index-1);
			//获取将要删除的节点
			del=prev.next;
			//让被删除节点的next指向被删除节点的下一个节点(prev的next将指向被删除节点的next)
			prev.next=del.next;
			//将被删除的节点的next引用赋为null
			del.next=null;
		}
		size--;
		return del.data;
	}
	//删除链式线性表中最后一个元素
	public T remove(){
		return delete(size-1);
	}
	public boolean empty(){
		return size==0;
	}
	//清空线性表
	public void clear(){
		//header、tail赋为null
		header=null;
		tail=null;
		size=0;
	}
	//显示链表
	public String toString(){
		//链表为空链表时
		if(empty()){
			return "[]";
		}else{
			StringBuilder sb=new StringBuilder("[");
			for (Node current=header;current!=null;current=current.next) {
				sb.append(current.data.toString()+", ");
			}
			int len=sb.length();
			return sb.delete(len-2, len).append("]").toString();
		}
	}
}
