package Element;

import ielement.Agent;
import ielement.Control;
/**
 * Controller class that controls all elements in simulation.
 * 
 * @author pichan vasantakitkumjorn.
 *
 */

final class CarControl implements Agent{

	private final Control center;
	//Constructor
	CarControl(int type, int num_light, int num_road,Car_Component car_info){
		switch(type){
		case 1	: this.center = new AlterControl(num_light,num_road,car_info);	break;
		case 2	: this.center = new SimpleControl(num_light,num_road,car_info);	break;
		default : this.center = null;
		}
	}
	/**
	 * Adding road element.
	 * 
	 * @param road
	 */
	void addRoad(Road road){
		center.addRoad(road);
	}
	/**
	 * Adding light element.
	 * 
	 * @param light
	 */
	void addLight(Light light){
		center.addLight(light);
	}
	/**
	 * Start controlling all elements in the simulation.
	 */
	public void run(int runtime) {
		if(center == null)
			throw new NullPointerException();
		
		center.execute();
	}

}
