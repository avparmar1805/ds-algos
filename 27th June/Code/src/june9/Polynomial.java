package june9;

public class Polynomial {
	private int[] data;
	private int cap;
	
	public Polynomial(){
		this.cap = 10;
		this.data = new int[this.cap];
	}
	
	public Polynomial(Polynomial p){
		this.cap = p.cap;
		this.data = new int[p.cap];
		for(int i = 0; i < this.cap; i++){
			this.data[i] = p.data[i];
		}
	}
	
	public void setCoefficient(int deg, int coeff){
		if(this.cap <= deg){
			int oldCap = this.cap;
			int[] oldData = this.data;
			
			while(this.cap <= deg){
				this.cap *= 2;
			}
			
			this.data = new int[this.cap];
			for(int i = 0; i < oldCap; i++){
				this.data[i] = oldData[i];
			}
		}
		
		this.data[deg] = coeff;
	}
	
	public Polynomial add(Polynomial other){
		Polynomial res = new Polynomial();
		
		if(this.cap > other.cap){
			res.cap = this.cap;
			res.data = new int[res.cap];
			
			for(int i = 0; i < other.cap; i++){
				res.setCoefficient(i, other.data[i]);
			}
			
			for(int i = 0; i < res.cap; i++){
				res.setCoefficient(i, res.data[i] + this.data[i]);
			}
		} else {
			res.cap = other.cap;
			res.data = new int[res.cap];
			
			for(int i = 0; i < this.cap; i++){
				res.setCoefficient(i, this.data[i]);
			}
			
			for(int i = 0; i < res.cap; i++){
				res.setCoefficient(i, res.data[i] + other.data[i]);
			}
		}
		
		return res;
	}
	
	public Polynomial sub(Polynomial other){
		Polynomial res = new Polynomial();
		
		if(this.cap > other.cap){
			res.cap = this.cap;
			res.data = new int[res.cap];
			
			for(int i = 0; i < other.cap; i++){
				res.setCoefficient(i, other.data[i]);
			}
			
			for(int i = 0; i < res.cap; i++){
				res.setCoefficient(i, res.data[i] - this.data[i]);
			}
		} else {
			res.cap = other.cap;
			res.data = new int[res.cap];
			
			for(int i = 0; i < this.cap; i++){
				res.setCoefficient(i, this.data[i]);
			}
			
			for(int i = 0; i < res.cap; i++){
				res.setCoefficient(i, res.data[i] - other.data[i]);
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
	}
}
