package june12.stacks;

public class DynamicStack extends Stack {
	public DynamicStack(int cap){
		super(cap);
	}

	@Override
	public void push(int val) {
		if(tos == data.length - 1){
			int[] newdata = new int[2 * data.length];
			for(int i = 0; i < data.length; i++){
				newdata[i] = data[i];
			}
			
			this.data = newdata;
		}
		super.push(val);
	}
}
