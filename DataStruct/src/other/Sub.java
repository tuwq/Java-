package other;
class Base{
	int count=2;
}
class Mid extends Base{
	int count=20;
}

//系统内存中并不存在Mid和Base两个对象，程序内存中只有
//一个Sub对象，只是这个Sub对象中不仅保存了在Sub类中定义的
//所有实例变量，还保存了它的
//所有父类所定义的全部实例变量
public class Sub extends Mid{
	int count=200;
	public static void main(String[] args) {
		Sub s=new Sub();
		Mid s2m=s;
		Base s2b=s;
		System.out.println(s.count);
		System.out.println(s2m.count);
		System.out.println(s2b.count);
	}
}
