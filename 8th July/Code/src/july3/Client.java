package july3;

public class Client {

	public static void main(String[] args) {
		MyHashMap<String, Integer> pmap = new MyHashMap<>();
		
		pmap.put("China", 200);
		pmap.put("India", 120);
		pmap.put("US", 20);
		pmap.put("UK", 15);
		pmap.put("Aus", 25);
		pmap.put("Nigeria", 50);
		pmap.put("Pak", 80);
		pmap.put("Utopia", 0);
		
		pmap.display();
		
		pmap.put("Finland", 5);
		pmap.display();
	}

}
