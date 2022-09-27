package chap13.example04;

public class UtilExample {

	public static void main(String[] args) {
		Pair<String, Integer> pair = new Pair<>("홍길동",35);
		Integer age=Util.getValue(pair,"홍길동");
		System.out.println(age);
		
		ChildPair<String, Integer> childPair = new ChildPair<>("홍삼원",20);
		Integer childAge = Util.getValue(childPair,"홍삼순");
		System.out.println(childAge);
		
		/*OtherPair<String, Integer> otherPair = new OtherPair<>("홍삼원",20);
		//OtherPair는 Pair를 상속하지 않으므로 예외가 발생해야 합니다.
		int otherAge = Util.getValue(otherPair, "홍삼원");
		System.out.println(otherAge);;*/

	}
}

class Pair<K,V>{
	
	private K key;
	private V value;
	
	public Pair(K key, V value) {
		this.key=key;
		this.value=value;
	}
	
	public K getKey(){return this.key;}
	public V getValue(){return this.value;}
}

class ChildPair<K,A> extends Pair<K, A>{
	
	public ChildPair(K k, A a) {
		super(k, a);
	}
}

class OtherPair<K,V>{
	
	private K key;
	private V value;
	
	public OtherPair(K k, V v) {
		this.key=k;
		this.value=v;
	}
	
	public K getKey(){return this.key;}
	public V getValue(){return this.value;}
}

class Util{
	
	public static <P extends Pair<K,V>, K, V> V getValue(P p, K k) {
		if(k==p.getKey()) {
			return p.getValue();
		}
	return null;	
	}
}	