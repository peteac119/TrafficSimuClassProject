package Element;

import ielement.Car;
import ielement.Control;

import java.awt.Color;
import java.util.Iterator;


final class SimpleControl implements Control{
	
	private final int LIGHT_LENGTH = 10;
	private final CarQueue[] queue; 
	private final Light[] light;
	private final Road[] road;
	private final int SLOW;
	private final int BRAKE;
	private int light_rank = 0;
	private int road_rank = 0;
	
	
	
	SimpleControl(int num_light, int num_road, Car_Component car_info){
		this.light = new Light[num_light];
		this.road = new Road[num_road];
		this.queue = new CarQueue[num_light];
		for(int i = 0; i< queue.length ; i++){
			queue[i] = new CarQueue();
		}
		SLOW = car_info.getSlowDistance();
		BRAKE = car_info.getBrakeDistance();
	}
	
	public void execute() {
		for(Road r : road){
			Iterator<Car> car = r.get_Car();
			while(car.hasNext()){
				CheckCollision(car);
				CheckLight(r);
				GoThroughInter(r.get_Length() + LIGHT_LENGTH);
			}		
		}
		Sink(road[road.length-1]);
	}

	private void CheckCollision(Iterator<Car> car) {
			Car frontcar = car.next();
			frontcar.drive();
			while(car.hasNext()){
			Car backcar = car.next();
			int distance = frontcar.get_BackPosition() - backcar.get_FrontPosition();
				if(distance <= SLOW){
					backcar.slowDown();
				}else if (distance <= BRAKE){
					backcar.brake();
				}else if(distance > SLOW) {
					backcar.speedUp();
					backcar.drive();
				}else if(distance > BRAKE){
					backcar.slowDown();
					backcar.drive();
				}
					frontcar = backcar;
			}
	}
	
	private void CheckLight(Road road) {
		Car car = road.get_FirstCar();
		int lightpos = car.get_Lightpos();
		int front_position = car.get_FrontPosition();
		int endpoint = road.get_Length();
		
		if(road.get_Type() == 1 && car.get_Lightpos() < light.length){
		
			if (front_position >= endpoint
					&& light[lightpos].getColor() ==  Color.RED){
				car.brake();
			}else if (front_position >= endpoint
						&& light[lightpos].getColor() !=  Color.RED){
				car.speedUp();
				car.drive();
				car.set_position(LIGHT_LENGTH);
				queue[car.get_Lightpos()].addCar(car);
				car.set_Lightpos();
				road.remove_Car();
				if (road.hasCar())
					road.get_FirstCar().speedUp();
			}
		}else if (road.get_Type() == 2 && car.get_Lightpos() < light.length){
			
			if (front_position >= endpoint
					&& light[lightpos].getColor() ==  Color.GREEN){
				car.brake();
			}else if(front_position >= endpoint
					&& light[lightpos].getColor() !=  Color.GREEN){
				car.speedUp();
				car.drive();
				car.set_position(LIGHT_LENGTH);
				queue[car.get_Lightpos()].addCar(car);
				car.set_Lightpos();
				road.remove_Car();
				if (road.hasCar())
					road.get_FirstCar().speedUp();
			}
		}
	}
	
	private void GoThroughInter(int startPoint) {
		
		for(CarQueue carqueue: queue){
		
			Iterator<Car> list_car = carqueue.getCar();
		
			if(list_car.hasNext()){
				Car back_car = list_car.next();
				if(!road[back_car.get_Lightpos()].get_Car().hasNext()){
					road[back_car.get_Lightpos()].add_Car(back_car);
					carqueue.removeCar();
				}else{
					Car front_car = road[back_car.get_Lightpos()].get_LastCar();
					int distance = front_car.get_BackPosition() - back_car.get_FrontPosition();
					
					if(distance > back_car.get_Length()){
						road[back_car.get_Lightpos()].add_Car(back_car);
						carqueue.removeCar();
					}
				}
			}
		}
	}
	
	private void Sink(Road road) {
		if(road.hasCar()){
			Car frontCar = road.get_FirstCar();
			if(frontCar.get_FrontPosition() >= road.get_Length())
				road.remove_Car();
			if(road.hasCar())
				road.get_FirstCar().speedUp();
		}
	}

	public void addRoad(Road road) {
		if (road_rank == this.road.length){
			return;
		}
		this.road[road_rank] = road;
		road_rank++;
	}

	public void addLight(Light light) {
		if (light_rank == this.light.length){
			return;
		}
		this.light[light_rank] = light;
		light_rank++;
	}
}
