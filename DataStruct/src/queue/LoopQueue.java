package queue;

import java.util.Arrays;

//循环顺序队列
public class LoopQueue<T> {
	private int DEFAULT_SIZE=10;
	//保存数组长度
	private int capacity;
	//保存循环列表数据元素的底层数组
	private Object[] elementData;
	//保存循环队列中元素的个数
	private int front=0;
	private int rear=0;
	//以默认长度创建底层数组
	public LoopQueue(){
		capacity=DEFAULT_SIZE;
		elementData=new Object[capacity];
	}
	//初始化插入元素至循环队列
	public LoopQueue(T element){
		this();
		elementData[0]=element;
		rear++;
	}
	//初始化插入元素至循环队列，并指定底层数组的起始大小
	public LoopQueue(T element,int initSize){
		capacity=initSize;
		elementData=new Object[capacity];
		elementData[0]=element;
		rear++;
	}
	//返回循环队列当前的数据元素数量
	public int length(){
		if(empty()){
			return 0;
		}
		return rear>front?rear-front:capacity-(front-rear);
	}
	//添加数据元素至循环队列
	public void add(T element){
		if(rear==front && elementData[front]!=null){
			throw new IndexOutOfBoundsException("队列已满的异常");
		}
		elementData[rear++]=element;
		//如果rear已经到头，那就转头
		rear=rear==capacity?0:rear;
	}
	//从循环队列中删除数据元素
	public T remove(){
		if(empty()){
			throw new IndexOutOfBoundsException("空队列异常");
		}
		T oldValue=(T) elementData[front];
		elementData[front++]=null;
		//如果front已经到头，那就转头
		front=front==capacity?0:front;
		return oldValue;
	}
	//从循环队列中取出数据元素，但不删除元素
	public T element(){
		if(empty()){
			throw new IndexOutOfBoundsException("空队列异常");
		}
		return (T) elementData[front];
	}
	//判断循环队列是否为空
	private boolean empty() {
		return rear==front&&elementData[rear]==null;
	}
	//清空循环队列
	public void clear(){
		Arrays.fill(elementData, null);
		front=0;
		rear=0;
	}
	//显示循环队列
	public String toString(){
		if(empty()){
			return "[]";
		}else{
			//如果front<rear，那么有效元素就是front到rear之间的元素
			if(front<rear){
				StringBuilder sb=new StringBuilder("[");
				for (int i = front; i < rear; i++) {
					sb.append(elementData[i].toString()+", ");
				}
				int len=sb.length();
				return sb.delete(len-2, len).append("]").toString();
			}
			//如果front>=rear,那么有效元素为front->capacity之间和0->front之间的元素
			else{
				StringBuilder sb=new StringBuilder();
				for (int i = front; i < capacity; i++) {
					sb.append(elementData[i].toString()+", ");
				}
				for (int i = 0; i < rear; i++) {
					sb.append(elementData[0].toString()+", ");
				}
				int len=sb.length(); 
				return sb.delete(len-2,len).append("]").toString();
			}
		}
		
	}
	
}
