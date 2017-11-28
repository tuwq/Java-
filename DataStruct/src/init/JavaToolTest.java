package init;

public class JavaToolTest {
	
	//定义count实例变量，并为之指定初始值
	int count=20;
	{
		count=12;
	}
	
	public JavaToolTest(){
		System.out.println(count);
	}
	
	public JavaToolTest(String name){
		System.out.println(name);
	}
	
	public static void main(String[] args) {
		//count=12	非静态代码块和初始化赋值按顺序执行
		new JavaToolTest();
	}
	
}
