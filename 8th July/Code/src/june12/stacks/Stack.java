package june12.stacks;

public class Stack {
	protected int[] data;
	protected int tos;
	
	public Stack(int cap){
		this.data = new int[cap];
		this.tos = -1;
	}
	
	public void push(int val){
		if(tos == data.length - 1){
			System.out.println("Stack overflow");
			return;
		}
		tos++;
		data[tos] = val;
	}
	
	public int top(){
		if(this.isEmpty()){
			System.out.println("Stack underflow");
			return -1;
		}
		
		int rv = data[tos];
		return rv;
	}
	
	public int pop(){
		if(this.isEmpty()){
			System.out.println("Stack underflow");
			return -1;
		}
		
		int rv = data[tos];
		
		data[tos] = 0;
		tos--;
		
		return rv;
	}
	
	public int size(){
		return tos + 1;
	}
	
	public boolean isEmpty(){
		return tos == -1;
	}
	
	public void display(){
		for(int i = tos; i >= 0; i--){
			System.out.print(data[i] + " -> ");
		}
		System.out.println(".");
	}
}
