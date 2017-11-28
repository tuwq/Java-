package other;
class Fruit{
	String color="未确定颜色";
	public Fruit getThis(){
		return this;
	}
	public void info(){
		System.out.println("Fruit方法");
	}
}
public class Apple extends Fruit{
	@Override
	public void info(){
		System.out.println("Apple方法");
	}
	public void AccessSuperInfo(){
		super.info();
	}
	public Fruit getSuper(){
		return super.getThis();
	}
	String color="红色";
	public static void main(String[] args) {
		Apple a=new Apple();
		Fruit f = a.getSuper();
		System.out.println("a和f所引用的对象是否相同:"+(a==f));//true
		System.out.println("访问a所引用对象的color实例变量:"+a.color);
		System.out.println("访问f所引用对象的color实例变量:"+f.color);
		a.info();
		f.info();
		a.AccessSuperInfo();
		//从中可以看出，通过Apple对象的getSupper方法所返回的依然是Apple对象本身
		//只是它的声明类型是Fruit，因此通过f变量访问color实例变量时
		//该实例变量的值由Fruit类决定，但通过f变量调用info方法时，该方法的行为由f变量实际所引用
		//Java对象决定，因此程序输出Apple方法
	}
}

