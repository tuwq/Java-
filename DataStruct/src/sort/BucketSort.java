package sort;

//桶式排序
public class BucketSort {
	
	public static void bucketSort(DataWrap[] data
				,int min,int max){
		System.out.println("开始排序");
		//arrayLength记录待排序数组的长度
		int arrayLength=data.length;
		DataWrap[] tmp=new DataWrap[arrayLength];
		//buckets数组相当于定义了max-min个桶
		//buckets数组用于记录待排序元素的信息
		int[] buckets=new int[max-min];
		//计算每个元素在序列中出现的次数
		for (int i = 0; i < arrayLength; i++) {
			//buckets数组记录DataWrap出现的次数
			buckets[data[i].data-min]++;
		}
		System.out.println(java.util.Arrays.toString(buckets));
		//计算"落入"各桶内的元素在有序序列中的位置
		for (int i = 1; i < max-min; i++) {
			//前一个bucket的值+当前bucket的值->当前bucket新的值
			buckets[i]=buckets[i]+buckets[i-1];
		}
		//循环结束后，buckets数组元素记录了"落入"前面所有桶和
		//"落入"当前buckets中元素的值
		//也就是说,buckets数组元素的值代表了"落入"当前桶中的元素在有序序列中的位置
		System.out.println(java.util.Arrays.toString(buckets));
		//将data数组中数据完全复制到tmp数组中缓存起来
		System.arraycopy(data, 0, tmp, 0, arrayLength);
		//根据buckets数组中的信息将待排序的各元素放入相应的位置
		for (int k = arrayLength-1; k >=0; k--) {
			data[--buckets[tmp[k].data-min]]=tmp[k];
		}
	}
	
	public static void main(String[] args) {
		DataWrap[] data={
				new DataWrap(9,""),
				new DataWrap(5,""),
				new DataWrap(-1,""),
				new DataWrap(8,""),
				new DataWrap(5,""),
				new DataWrap(7,""),
				new DataWrap(3,""),
				new DataWrap(-3,""),
				new DataWrap(1,"")
		};
		System.out.println("排序之前: \n"+java.util.Arrays.toString(data));
		bucketSort(data,-3,10);
		System.out.println("排序之后: \n"+java.util.Arrays.toString(data));
	}
}
