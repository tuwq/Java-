package init;
class Price{
	//类成员是Price的实例
	//类变量按排列顺序执行初始化，初始化INSTANCE时需要创建Price，导致initPrice没有在创建Price时初始化
	final static Price INSTANCE=new Price(2.8);
	
	static double initPrice=20;

	double currentPrice;
	public Price(double discount){
		currentPrice=initPrice-discount;
	}
	
}

public class PriceTest {
	
	public static void main(String[] args) {
		//通过Price的INSTANCE访问currentPrice实例变量
		//currentPrice=-2.8
		System.out.println(Price.INSTANCE.currentPrice);
		//显式创建Price实例
		Price p = new Price(2.8);
		//通过显式创建的Price实例访问currentPrice实例变量
		//currentPrice=17.2
		System.out.println(p.currentPrice);
		
	}
}
