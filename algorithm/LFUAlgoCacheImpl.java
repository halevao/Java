package hit.algorithm;

import java.util.LinkedHashMap;


public class LFUAlgoCacheImpl<K, V>  implements IAlgoCache<K,V>{
	
	private class PageCount {
		private V page;
		
		private int count;

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		public V getPage() {
			return page;
		}

		public void setPage(V page) {
			this.page = page;
		}	
	}
	
	private LinkedHashMap<K, PageCount> cache;
	
	private int capacity;
	
	
	public LFUAlgoCacheImpl(int capacity){
		cache = new LinkedHashMap<>(capacity);
		this.capacity = capacity;
	}
	
	@Override
	public V getElements(K key){
			if(cache.containsKey(key)){
				cache.get(key).count = cache.get(key).count +1;
				return cache.get(key).page;
			}
			
			return cache.get(key).page;
	}
	
	@Override
	public V putElement(K key, V value) {
		V curValue = null;
		PageCount P = new PageCount();
		if (cache.size() == capacity) {
			K keyToRemove = getLeastFreqUsedPage();
			curValue = cache.get(keyToRemove).page;
			removeElement(keyToRemove);
			}	
		P.page = value;
		cache.put(key,P);
		curValue = cache.get(key).page;


		return curValue;
	}
	
	@Override
	public void removeElement(K key) {
		if(cache.containsKey(key)){
			cache.remove(key);
		}
	}
	
	 private K getLeastFreqUsedPage() {
		 int count = 100;
		 K keyToReturn = null;
		 
		 for (K key : cache.keySet()) {
			 if (cache.get(key).count < count){
				 count = cache.get(key).count;
				 keyToReturn = key;
			 }
		 }
		 return keyToReturn;
	 }
	
}
