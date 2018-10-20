package jan28;

public class BitManipulation {

	public static void main(String[] args) {
		byte b = (byte)600;
		byte onidx = 6;
		byte offidx = 4;
		byte toggleidx = 2;
		
		// turn the bit on
		byte onbitmask = (byte)(1 << onidx);
		byte bitturnedon = (byte)(b | onbitmask);
		System.out.println(bitturnedon);
		
		// turn the bit off
		int offbitmask = ~(1 << offidx);
		byte bitturnedoff = (byte)(b & offbitmask);
		System.out.println(bitturnedoff);
		
		// toggle the bit
		byte togglebitmask = (byte)(1 << toggleidx);
		byte bittoggled = (byte)(b ^ togglebitmask);
		System.out.println(bittoggled);
		
		// last set bit
		System.out.println(b & -b);
		
	}

}
