package sort;

//直接插入排序
public class InsertSort {
	
	public static void insertSort(DataWrap[] data){
		System.out.println("开始排序");
		int arrayLenth=data.length;
		for (int i = 1; i < arrayLenth; i++) {
			//当整体后移时，保证data[i]的值将不会丢失
			DataWrap tmp=data[i];
			//i索引处的值已经比前面的所有值更大，表明已经有序，无须插入
			//(i-1索引之前的数据已经有序，i-1索引处元素的值就是最大值)
			if(data[i].compareTo(data[i-1])<0){
				int j=i-1;
				//整体后移一位
				for (; j>=0&&data[j].compareTo(tmp)>0;j--) {
					data[j+1]=data[j];
				}
				//最后将tmp的值插入合适的位置
				data[j+1]=tmp;
			}
			System.out.println(java.util.Arrays.toString(data));
		}
	}
	public static void main(String[] args) {
		DataWrap[] data={
				new DataWrap(9,""),
				new DataWrap(-16,""),
				new DataWrap(21,""),
				new DataWrap(23,""),
				new DataWrap(-30,""),
				new DataWrap(-49,""),
				new DataWrap(21,""),
				new DataWrap(30,""),
				new DataWrap(13,"")
				
		};
		System.out.println("排序之前: \n"+java.util.Arrays.toString(data));
		insertSort(data);
		System.out.println("排序之后: \n"+java.util.Arrays.toString(data));
	}
	
}
