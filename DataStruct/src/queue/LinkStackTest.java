package queue;


public class LinkStackTest {
	
	public static void main(String[] args) {
		LinkStack stack = new LinkStack();
		//不断地入栈
		stack.push("aaaa");
		stack.push("bbbb");
		stack.push("cccc");
		stack.push("dddd");
		//访问栈顶元素
		System.out.println("访问栈顶元素"+stack.peek());
		//弹出一个元素
		System.out.println("第一次弹出栈顶元素"+stack.pop());
		//再次弹出一个元素
		System.out.println("第二次弹出栈顶元素"+stack.pop());
		System.out.println("两次pop之后的栈"+stack);
	}
	
}
