package hit.algorithm;

public class Test {

	public static void main(String[] args) {
		LFUAlgoCacheImpl<Integer, Integer> x = new LFUAlgoCacheImpl<>(2);
		
		x.putElement(new Integer(0), new Integer(16));
		x.putElement(new Integer(1), new Integer(14));
		x.getElements(0);
		x.getElements(0);
		x.putElement(new Integer(2), new Integer(15));
		x.getElements(2);
		System.out.println(x.getElements(2));

	}

}



