package sort;
class DataWrap{
	int data;
	String flag;
	public DataWrap(int data,String flag){
		this.data=data;
		this.flag=flag;
	}
	public String toString(){
		return data+flag;
	}
	public int compareTo(DataWrap dw){
		return this.data>dw.data?1:(this.data==dw.data?0:-1);
	}
}

//直接选择排序
public class SelectSort {
	
	public static void selectSort(DataWrap[] data){
		System.out.println("开始排序");
		int arrayLenth=data.length;
		//依次进行n-1趟比较，第i趟比较将第i大的值选出放在i位置上  
		for (int i = 0; i < arrayLenth-1; i++) {
			//minIndex永远保留本趟比较中最小值的索引
			int minIndex=i;
			//第i个数据只需和它后面的数据比较
			for (int j = i+1; j < arrayLenth; j++) {
				//如果第i位置的数据>j位置的数据，就交换它们
				if(data[minIndex].compareTo(data[j])>0){
					//将j的值赋给minIndex
					minIndex=j;
				}
			}
			//每趟比较最多交换一次
			if(minIndex!=i){
				DataWrap tmp=data[i];
				data[i]=data[minIndex];
				data[minIndex]=tmp;
			}
			System.out.println(java.util.Arrays.toString(data));
		}
	}
	public static void main(String[] args) {
		DataWrap[] data={
				new DataWrap(21,""),
				new DataWrap(30,""),
				new DataWrap(49,""),
				new DataWrap(30,""),
				new DataWrap(16,""),
				new DataWrap(9,""),
		};
		System.out.println("排序之前: \n"+java.util.Arrays.toString(data));
		selectSort(data);
		System.out.println("排序之后: \n"+java.util.Arrays.toString(data));
	}
	
}
