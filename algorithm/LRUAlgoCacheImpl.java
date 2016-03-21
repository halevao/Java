package hit.algorithm;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LRUAlgoCacheImpl<V, K> extends LinkedHashMap<K, V> implements IAlgoCache<K,V>{


	private LinkedHashMap<K, V> cache;
	private int capacity;
	

	public LRUAlgoCacheImpl(int capacity){
		cache = new LinkedHashMap<>(capacity);
		this.capacity = capacity;
	}
	

	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		
		return super.removeEldestEntry(eldest);
	}

	
	@Override
	public V getElements(K key){
		if(cache.containsKey(key)){
			return cache.get(key);
		}
		return null;
	}

	@Override
	public V putElement(K key, V value) {
		
		V curValue = null;
		boolean isRemoved = false;
		if (capacity == cache.size()){
			java.util.Map.Entry<K, V> eldest = null;
			isRemoved = removeEldestEntry(eldest);
			if (isRemoved){
			cache.put(key, value);
			return curValue;
			} 
		}
		else {
			cache.put(key, value);
		}
		
		return curValue;
		
	}

	@Override
	public void removeElement(K key) {
		if(cache.containsKey(key)){
			cache.remove(key);
		}
	}
	
}
