package other;
class Parent{
	public String tag="疯狂Java讲义";
}
class Derived extends Parent{
	//这个私有化将会隐藏基类中定义的tag实例变量
	private String tag="轻量级Java EE企业应用实战";
}
public class HideTest {
	public static void main(String[] args) {
		Derived d = new Derived();
		//下面这条语句将会报错
		//System.out.println(d.tag);
		System.out.println(((Parent)d).tag);
	}
}
