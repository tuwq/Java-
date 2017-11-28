package other;
class StaticBase{
	static int count=20;
}
public class StaticSub {
	static int count=200;
	public void info(){
		System.out.println("访问本类的count类变量:"+count);
		System.out.println("访问父类的count类变量:"+StaticBase.count);
		//下面这种方法已作废
		//System.out.println("访问父类的count类变量:"+super.count);
	}
	public static void main(String[] args) {
		StaticSub sb=new StaticSub();
		sb.info();
	}
}
