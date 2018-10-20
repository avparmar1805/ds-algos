package june29;

public class Client {

	public static void main(String[] args) {
//		HuffmanEncoder enc = new HuffmanEncoder(
//				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbccd");
//		System.out.println(enc.encode("aaabcdaaad"));
//		System.out.println(enc.decode("11101001000111000"));
		
		MedianPQ mpq = new MedianPQ();
		mpq.add(10);
		mpq.add(20);
		mpq.add(30);
		mpq.add(40);
		System.out.println(mpq.peek());
		mpq.add(50);
		mpq.add(60);
		System.out.println(mpq.peek());
		mpq.add(70);
		System.out.println(mpq.peek());
		System.out.println(mpq.remove());
		System.out.println(mpq.remove());
		System.out.println(mpq.remove());
		System.out.println(mpq.remove());
		System.out.println(mpq.remove());
		System.out.println(mpq.remove());
		System.out.println(mpq.remove());
		System.out.println(mpq.remove());
	}

}
