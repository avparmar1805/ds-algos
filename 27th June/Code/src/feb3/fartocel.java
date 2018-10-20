package feb3;

public class fartocel {

	public static void main(String[] args) {
		int minf = 0;
		int maxf = 300;
		int stepf = 20;
		
		for(int tempf = minf; tempf <= maxf; tempf += stepf){
			int cel = (int)(5.0 / 9 * (tempf - 32));
			System.out.println(tempf + " " + cel);
		}
	}

}
