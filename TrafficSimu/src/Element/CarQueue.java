package Element;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

final class CarQueue {
	private final Queue<Car> queue = new LinkedList<Car>();
	
	void addCar(Car car){
		queue.add(car);
	}
	
	void removeCar(){
		queue.poll();
	}
	
	Iterator<Car> getCar(){
		return queue.iterator();
	}
}
