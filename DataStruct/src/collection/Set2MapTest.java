package collection;

public class Set2MapTest {
	public static void main(String[] args) {
		Set2Map<String,Integer> scores = new Set2Map<>();
		//将key-value对放入集合中
		scores.put("语文", 89);
		scores.put("数学", 83);
		scores.put("英文", 80);
		System.out.println(scores);
		//访问Map集合里包含的key-vlaue对
		System.out.println(scores.size());
		scores.removeEntry("数学");
		System.out.println("删除key为\"数学\"的Entry之后:"+scores);
		//根据key取出value
		System.out.println("语文成绩:"+scores.get("语文"));
		//判断是否包含指定的key
		System.out.println("是否包含\"英文\"key:"+scores.containsKey("英文"));
		//判断是否包含指定的value
		System.out.println("是否包含 82 value:"+scores.containsValue(82));
		//清空集合
		scores.clear();
		System.out.println("执行clear()方法之后的集合:"+scores);
		//上面的程序完全将Set2Map当成一个Map集合使用，包括把key-value对放入集合中，
		//根据Key取出value，等等
		//只要对传统的Set稍做改造，就可以将Set改造成Map集合，而且这个Map集合在功能上
		//几乎可以与系统提供的Map类媲美
	}
}
