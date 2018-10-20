package QueueStory;

public class DynamicQueue extends Queue {
	public DynamicQueue(int cap) {
		super(cap);
	}

	public void enqueue(int val) {
		if (isFull()) {
			int[] oa = this.data;
			data = new int[2 * oa.length];

			for (int i = 0; i < oa.length; i++) {
				data[i] = oa[(this.front + i) % oa.length];
			}
			front = 0;
		}
		super.enqueue(val);
	}
}
