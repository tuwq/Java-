package queue;

public class SequenceQueueTest {
	public static void main(String[] args) {
		SequenceQueue<String> queue=new SequenceQueue<String>();
		queue.add("aaaa");
		queue.add("bbbb");
		queue.add("cccc");
		queue.add("dddd");
		System.out.println(queue);
		System.out.println("访问队列的front端元素:"+queue.element());
		System.out.println("移除队列的front端元素:"+queue.remove());
		System.out.println("移除队列的front端元素:"+queue.remove());
		System.out.println("两次调用remove方法后的队列:"+queue);
	}
}
