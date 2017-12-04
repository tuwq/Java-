package queue;


public class LinkQueueTest {
	
	public static void main(String[] args) {
		LinkQueue<String> queue=new LinkQueue<String>();
		//向队列中添加元素
		queue.add("aaaa");
		queue.add("bbbb");
		queue.add("cccc");
		System.out.println(queue);
		//删除一个元素后
		queue.remove();
		System.out.println("删除一个元素后的队列:"+queue);
		//再次添加元素后
		queue.add("dddd");
		System.out.println("再次添加元素后的队列:"+queue);
		//删除一个元素后，继续添加元素
		queue.remove();
		queue.add("eeee");
		System.out.println(queue);
	} 
	//上面的程序创建了一个链队列，链队列不会出现队列"满"的情形，因此程序可以不受任何限制地向链队列中添加元素
	
}
