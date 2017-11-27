package other;


public class TwoDimensionTest {
	
	public static void main(String[] args) {
		//定义一个二维数组
		int[][] a;
		//把a当成一维数组进行初始化，初始化a是一个长度为3的数组
		//a数组的数组元素又是引用类型
		a=new int[4][];
		//把a数组当成一维数组，遍历a数组的每个数组元素
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		//初始化a数组的第一个元素
		a[0]=new int[2];
		//访问a数组的第一个元素所指数组的第二元素
		a[0][1]=6;
		//a数组的第一个元素是一个一维数组，遍历这个一维数组
		for (int i = 0; i < a[0].length; i++) {
			System.out.println(a[0][i]);
		}
		
	}
}
