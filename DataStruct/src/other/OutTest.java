package other;
class Out{
	class In{
		public void test(){
			System.out.println("In的Test方法");
		}
	}
	class A extends In{
		//这个out形参就可以解决调用In类的构造器问题，也就是说，对于类A而言，编译器会为之增加如下构造器
//		A(Out this){
//			this.super();
//		}
		//上面增加的this参数是编译器自动增加的，当程序通过Out对象创建A实例时，该Out对象就会被传给这个this引用
	}
}
public class OutTest extends Out.In{
	public OutTest(){
		////因为Out.In没有无参数的构造器
		//显示调用基类指定的构造器
		new Out().super();
	}
	public static void main(String[] args) {
		System.out.println("HelloWorld");
	}
}
//从上面的程序可以看出，程序为OutTest定义的构造器通过显式的方式调用了基类的构造器
//再调用基类构造器时，使用new out()作为主调，即以一个Out对象作为主调
//其实这个主调会作为参数传入super()，也就是传给In类带一个Out参数的构造器
//但对于In的另一个派生类A而言，由于它本身就是Out的内部类，因此系统在编译它时也会为它的构造器增加一个Out形参

