package other;

public class StaticInitTest {
	
	static int count=2;
	
	static{
		System.out.println("StaticInitTest的静态代码块");
		name="Java编程";
	}
	static String name="疯狂Java讲义";
	
	public static void main(String[] args) {
		//访问该类的两个类变量 静态代码块和类变量赋值按排列顺序执行
		//count=2
		System.out.println("count类变量的值:"+StaticInitTest.count);
		//name="疯狂Java讲义"
		System.out.println("name类变量的值:"+StaticInitTest.name);
	}
	
}	
