package Element;

import ielement.Car;

import java.util.Iterator;

import Utility.Queue;

/**
 * 
 * 
 * 
 * @author pichan vasantakitkumjorn
 *
 */
public final class Road {
	
	private final Queue<Car> car_queue = new Queue<Car>();
	private final int length;
	private final int width;
	private final int type;
	//Constructor
	Road(int width, int length, int type){
		this.length = length;
		this.width = width;
		this.type = type;
	}
	/**
	 * Adding car to this road.
	 * 
	 * @param car
	 */
	void add_Car(Car car){
		car_queue.enqueue(car);
	}
	/**
	 * Remove car in this road.
	 */
	void remove_Car(){
		car_queue.dequeue();
	}
	/**
	 * Get the length of this road
	 * 
	 * @return int
	 */
	int get_Length(){
		return length;
	}
	/**
	 * Get the width of this road.
	 * 
	 * @return int
	 */
	int get_Width(){
		return width;
	}
	/**
	 * Get the first car in this road.
	 * 
	 * @return Car
	 */
	Car get_FirstCar(){
		return car_queue.get_Head();
	}
	/**
	 * Get the last car in the road.
	 * 
	 * @return Car
	 */
	Car get_LastCar(){
		return car_queue.get_Tail();
	}
	/**
	 * Does the road have a car?
	 * 
	 * @return boolean
	 */
	boolean hasCar(){
		return car_queue.size() != 0;
	}
	/**
	 * Get the list of the car.
	 * 
	 * @return Iterator<Car>
	 */
	public Iterator<Car> get_Car(){
		return car_queue.iterator();
	}
	/**
	 * Get the type of the road.
	 * 
	 * @return int
	 */
	public int get_Type(){
		return type;
	}
	
}
