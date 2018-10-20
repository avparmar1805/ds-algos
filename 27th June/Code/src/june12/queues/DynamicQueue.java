package june12.queues;

public class DynamicQueue extends Queue {
	public DynamicQueue(int cap){
		super(cap);
	}
	
	@Override
	public void enqueue(int val) {
		if(this.size == data.length){
			int[] newdata = new int[2 * data.length];
			for(int i = 0; i < size; i++){
				newdata[i] = data[(front + i) % data.length];
			}
			data = newdata;
			front = 0;
		}
		
		super.enqueue(val);
	}
}
