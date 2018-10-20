package StackStory;

public class DynamicStack extends Stack {
	public DynamicStack(int cap) {
		super(cap);
	}

	public void push(int val) {
		if (isFull()) {
			int[] oa = this.data;
			data = new int[2 * oa.length];

			for (int i = 0; i < oa.length; i++) {
				data[i] = oa[i];
			}
		}
		super.push(val);
	}
}
