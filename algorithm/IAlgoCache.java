package hit.algorithm;

public interface IAlgoCache<K,V> {
	
	public abstract V getElements(K key);
	public abstract V putElement(K key, V value);
	public abstract void  removeElement(K key);
	
}
