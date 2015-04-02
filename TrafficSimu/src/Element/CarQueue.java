package Element;


import ielement.Car;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Queue in each light object to store all cars passing through the light.
 * 
 * @author pichan vasantakitkumjorn.
 *
 */
final class CarQueue {
	private final Queue<Car> queue = new LinkedList<Car>();
	/**
	 * Adding car
	 * @param car
	 */
	void addCar(Car car){
		queue.add(car);
	}
	/**
	 * Removing car.
	 */
	void removeCar(){
		queue.poll();
	}
	/**
	 * Get a list of car remaining in this queue.
	 * 
	 * @return Iterator<Car>
	 */
	Iterator<Car> getCar(){
		return queue.iterator();
	}
}
