package Sequence;

public class SequenceListTest {
	public static void main(String[] args) {
		SequenceList<String> list=new SequenceList<String>();
		list.add("aaaa");
		list.add("bbbb");
		list.add("cccc");
		//在索引为1处插入一个新元素
		list.insert("dddd", 1);
		//输出顺序线性表的元素
		System.out.println(list);
		//删除索引为2处的元素
		list.delete(2);
		System.out.println(list);
		//获取cccc字符串在顺序线性表中的位置
		System.out.println("cccc在顺序线性表中的位置"+list.locate("cccc"));
	}
}
