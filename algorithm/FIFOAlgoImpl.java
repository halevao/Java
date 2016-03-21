package hit.algorithm;

import java.util.LinkedHashMap;

public class FIFOAlgoImpl<V, K> extends LinkedHashMap<K, V> implements IAlgoCache<K,V>{

	FIFOAlgoImpl(){
		
	};
	
	@Override
	public V getElements(K key){
		return null;
		
	};
	@Override
	public V putElement(K key, V value) {
		return value;
		
	};
	@Override
	public void removeElement(K key) {
		
	}

}
