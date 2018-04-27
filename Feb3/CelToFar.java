package Feb3;

public class CelToFar {
	public static void main (String[] args) {
		int minf = 0;
		int maxf = 300;
		int stepf = 20;
		int cel = 0;
		
		while(minf != maxf) {
			System.out.print(minf + " ");
			cel = (int)((5f/9) * (minf - 32));
			System.out.println(cel);
			minf = minf + stepf;
		}
	}
}
