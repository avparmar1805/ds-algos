package jan21;

import java.util.ArrayList;

public class cbp {

	public static void main(String[] args) {
		ArrayList<String>[] strg = new ArrayList[11];
		for (int i = 0; i < strg.length; i++) {
			strg[i] = new ArrayList<>();
		}
		cbpIV(0, 10, strg);

		System.out.println(strg[0]);

	}

	public static void cbpIV(int curr, int end, ArrayList<String>[] strg) {
		if (curr == end) {
			strg[curr].add("");
			return;
		}

		for (int dice = 1; dice <= 6; dice++) {
			int inter = curr + dice;
			if (inter <= end) {
				if (strg[inter].size() == 0) {
					cbpIV(inter, end, strg);
				}
				
				for (String path : strg[inter]) {
					strg[curr].add(dice + path);
				}
			}
		}

	}

}
