package other;

public class ObjectArrayTest {
	
	
	public static void main(String[] args) {
		Object[] objArr=new Object[3];
		objArr[1]=new Object[2];
		Object[] objArr2=(Object[])objArr[1];
		objArr2[1]=new Object[3];
		Object[] objArr3=(Object[])objArr2[1];
		objArr3[1]=new int[5];
		int[] iArr=(int[])objArr3[1];
		for (int i = 0; i < iArr.length; i++) {
			iArr[i]=i*3+1;
		}
		System.out.println(((int[])((Object[])((Object[])objArr[1])[1])[1])[2]); 
	
	}
	
}
