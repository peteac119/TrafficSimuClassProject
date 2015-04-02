package Element;

import ielement.Car;

import java.util.Iterator;

import Utility.Queue;

public final class Road {
	
	private final Queue<Car> car_queue = new Queue<Car>();
	private final int length;
	private final int width;
	private final int type;
	
	Road(int width, int length, int type){
		this.length = length;
		this.width = width;
		this.type = type;
	}
	
	void add_Car(Car car){
		car_queue.enqueue(car);
	}
	
	void remove_Car(){
		car_queue.dequeue();
	}

	int get_Length(){
		return length;
	}
	
	int get_Width(){
		return width;
	}
	
	Car get_FirstCar(){
		return car_queue.get_Head();
	}
	
	Car get_LastCar(){
		return car_queue.get_Tail();
	}
	
	boolean hasCar(){
		return car_queue.size() != 0;
	}
	
	public Iterator<Car> get_Car(){
		return car_queue.iterator();
	}
	
	public int get_Type(){
		return type;
	}
	
}
