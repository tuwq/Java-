package Sequence;

public class LinkListTest {
	public static void main(String[] args) {
		LinkList<String> list=new LinkList<String>();
		list.insert("aaaa", 0);
		list.add("bbbb");
		list.add("cccc");
		//在索引为1处插入一个新元素
		list.insert("dddd", 1);
		//输出顺序线性表的元素
		System.out.println(list);
		//删除索引为2处的元素
		list.delete(2);
		System.out.println(list);
		//获取cccc字符串在链表中的位置
		System.out.println("cccc在顺序线性表中的位置:"+list.locate("cccc"));
		System.out.println("链表中索引2处的元素:"+list.get(2));
	}	
}
