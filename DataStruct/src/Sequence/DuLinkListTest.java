package Sequence;

public class DuLinkListTest {
	public static void main(String[] args) {
		DuLinkList list = new DuLinkList();
		list.insert("aaaa", 0);
		list.add("bbbb");
		list.insert("cccc", 0);
		list.insert("dddd", 1);
		System.out.println(list);
		list.delete(2);
		System.out.println(list);
		System.out.println(list.reverseToString());
		System.out.println("cccc在顺序线性表中的位置:"+list.locate("cccc"));
		System.out.println("链表中索引1处的元素:"+list.get(1));
		list.remove();
		System.out.println("调用remove方法后的链表"+list);
		list.delete(0);
		System.out.println("调用delete(0)后的链表"+list);
	}
}
