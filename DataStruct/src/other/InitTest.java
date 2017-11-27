package other;

class Cat {
	
	//定义name,age两个实例变量
	String name;
	int age;
	//使用构造器初始化name、age两个实例变量
	public Cat(String name,int age){
		System.out.println("执行构造器");
		this.name=name;
		this.age=age;
		//构造器中赋值在非静态代码块和初始化赋值之后
		//weight=3.0;
	}
	{
		System.out.println("执行非静态初始化块");
		weight=2.0;
	}
	double weight=2.3;
	public String toString() {
		return "Cat [name=" + name + ", age=" + age + ", weight=" + weight + "]";
	}
}
public class InitTest{
	
	public static void main(String[] args){
		//wetght=2.3 非静态代码块和初始化赋值按顺序执行
		Cat cat = new Cat("kitty",2);
		System.out.println(cat);
		Cat c2 = new Cat("Garfield", 3);
		System.out.println(c2);
	}
}
