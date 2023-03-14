import java.util.*;

class Queue {

	protected int size;

	protected int front;
	protected int[] data;

	public Queue() {
		this.size = 0;
		this.front = 0;
		this.data = new int[5];
	}

	public Queue(int cap) {
		this.size = 0;
		this.front = 0;
		this.data = new int[cap];
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public void enqueue(int item) throws Exception {
		if (this.size() == this.data.length) {
			int[] oa = this.data;
			int[] na = new int[oa.length * 2];
			for (int i = 0; i < this.size(); i++) {
				int idx = (i + front) % oa.length;
				na[i] = oa[idx];
			}

			this.data = na;
			this.front = 0;
		}

		// if (this.size == this.data.length) {
		// throw new Exception("queue is full");
		// }

		this.data[(front + size) % this.data.length] = item;
		size++;

	}

	public int dequeue() throws Exception {
		if (this.size == 0) {
			throw new Exception("queue is empty");

		}

		int rv = this.data[front];
		front = (front + 1) % this.data.length;
		size--;

		return rv;

	}

	public int getFront() throws Exception {
		if (this.size == 0) {
			throw new Exception("queue is empty");
		}

		int rv = this.data[front];

		return rv;
	}

	public void display() {
		System.out.println();
		for (int i = 0; i < size; i++) {
			int idx = (i + front) % this.data.length;
			System.out.print(this.data[idx] + " ");
		}
        System.out.print("END");
	}

	
    

}

public class Q9_Hoodies_at_CB{
	public static void hoodies() throws Exception{ 
			Scanner sc = new Scanner(System.in);
		// Write your Code here
			Queue q1=new Queue();
			Queue q2=new Queue();
			Queue q3=new Queue();
			Queue q4=new Queue();
	
			Queue order=new Queue();
			int n=sc.nextInt();
			while(n--!=0){
				String str=sc.next();
	
				if(str.equals("E")){
					int cn=sc.nextInt();
					int rn=sc.nextInt();
	
					if(cn==1){
						if(q1.size==0){
							order.enqueue(cn);
						}
						q1.enqueue(rn);
					}
					else if(cn==2){
						if(q2.size==0){
							order.enqueue(cn);
						}
						q2.enqueue(rn);
					}
					else if(cn==3){
						if(q3.size==0){
							order.enqueue(cn);
						}
						q3.enqueue(rn);
					}
					else{
						if(q4.size==0){
							order.enqueue(cn);
						}
						q4.enqueue(rn);
					}
				}
	
				else{
					if(order.getFront()==1){
						System.out.println(1+" "+q1.dequeue());
						if(q1.size==0) order.dequeue();
					}
	
					else if(order.getFront()==2){
						System.out.println(2+" "+q2.dequeue());
						if(q2.size==0) order.dequeue();
					}
	
					else if(order.getFront()==3){
						System.out.println(3+" "+q3.dequeue());
						if(q3.size==0) order.dequeue();
					}
					else{
						System.out.println(4+" "+q4.dequeue());
						if(q4.size==0) order.dequeue();
					}
				}
			}
			sc.close();
		} 

	

	public static void main(String[] args) throws Exception {
		hoodies();
	}
}