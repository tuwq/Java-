package collection;

import java.util.HashMap;
import java.util.Map.Entry;

public class MyHashMap<K,V>{
	
	//HashMap的put方法源代码
	/*public V put(K key,V value){
		//如果key为Null，则调用putForNullKey方法来进行处理
		if(key==null){
			return putForNullKey(value);
		}
		//根据Key的keyCode计算Hash值
		int hash=hash(key.hashCode());
		//搜索指定的hash值在对应table中的索引
		int i=indexFor(hash,table.length);
		//如果i索引处的Entry不为null，则通过循环不断遍历e元素的下一个元素
		for (Entry<K,V> e=table[i];e!=null;e=e.next()) {
			Object k;
			//找到指定的key与需要放入的key相等(hash值相同，通过equals比较返回true)
			if(e.hash==hash&&((k==e.key)==key || key.equals(k))){
				V oldValue =e.value;
				e.value=value;
				e.recordAccess(this);
				return oldValue;
			}
		}
		//如果i索引处的Entry为null，则表明此处还没有Entry
		modCount++;
		//将key、vlaue添加到i索引处
		addEntry(hash,key,value,i);
		return null;
	}*/
	
	/*void addEntry(int hash,K Key,V value,int bucketIndex){
		//获取指定bucketIndex索引处的Entry
		Entry<K,V> e=table[bucketIndex];
		//将新创建的Entry放入bucketIndex索引处，并让新的Entry指向原来的Entry
		table[bucketIndex]=new Entry<K,V>(hash,key,value,e);
		//如果Map中的key-value对的数量超过了极限
		if(size++>=threshold){
			//把table对象的长度扩充到两倍
			resize(2*table.length);
		}
		
	}*/
	
}
