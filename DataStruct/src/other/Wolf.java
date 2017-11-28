package other;
class Animal{
	private String desc;
	public Animal(){
		this.desc=getDesc();
	}
	public String getDesc() {
		return "Animal";
	}
	public String toString(){
		return desc;
	}
}


public class Wolf extends Animal{
	private String name;
	private double weight;
	public Wolf(String name,double weight){
		this.name=name;
		this.weight=weight;
	}
	@Override
	public String getDesc() {
		return "Wolf [name=" + name + ", weight=" + weight + "]";
	}
	public static void main(String[] args) {
		//将会输出Wolf [name=null, weight=0.0]
		System.out.println(new Wolf("灰太狼",32.3));
	}
}
