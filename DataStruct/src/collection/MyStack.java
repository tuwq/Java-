package collection;

import java.util.EmptyStackException;
import java.util.Vector;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class MyStack<E> extends Vector<E>{
	//无参构造器
	public MyStack(){
		
	}
	//实现向栈顶添加元素的方法
	public E push(E item){
		addElement(item);
		return item;
	}
	//实现出栈的方法
	public synchronized E pop(){
		E obj;
		int len=size();
		obj=peek();
		removeElementAt(len-1);
		return obj;
	}
	//取出最后一个元素，但并不弹出栈
	public synchronized E peek(){
		int len=size();
		if(len==0){
			//如果不包含任何元素，则直接抛出异常
			throw new EmptyStackException();
		}
		return elementAt(len-1);
	}
	public boolean empty(){
		//集合不包含任何元素就是空栈
		return size()==0;
	}
	public synchronized int search(Object o){
		//获取o在集合中的位置
		int i=lastIndexOf(o);
		if(i>=0){
			//用集合长度减去o在集合中的位置，就得到该元素到栈顶的距离
			return size()-1;
		}
		return -1;
	}
	
}
