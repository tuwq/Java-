package queue;

import java.util.LinkedList;

public class LoopQueueTest {
	public static void main(String[] args) {
		 LoopQueue<String> queue=new LoopQueue<String>("aaaa",3);
		 //向队列添加元素
		 queue.add("bbbb");
		 queue.add("cccc");
		 //此时队列已满
		 System.out.println(queue);
		 //删除一个元素后，队列可以再多加一个元素
		 queue.remove();
		 System.out.println("删除一个元素之后额队列:"+queue);
		 //再次添加一个元素，此时队列已满
		 queue.add("dddd");
		 System.out.println("队列满时的长度:"+queue.length());
		//删除一个元素后，队列又可以再多加一个元素
		 queue.remove();
		 //再次加入一个元素，此时队列又满
		 queue.add("eeee");
		 System.out.println(queue);
		 LinkedList list = new LinkedList();
	}
	//上面程序创建了一个底层数组长度为3的队列，因此向队列中添加3个元素之后队列就处于"满的状态"，
	//此时再向队列中添加元素将引发异常，当调用队列的remove()方法将front端的一个元素从队列移除后，多出来的空间将可以循环使用
	//可以再次添加新的数据元素
}
