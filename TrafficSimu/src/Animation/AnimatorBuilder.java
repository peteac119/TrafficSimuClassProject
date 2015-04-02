package Animation;

import Element.Coodinate;
import Element.Light;
import Element.Road;

/**
 * 
 * This class is a simulation builder.
 * 
 * @author pichan vasantakitkumjorn
 *
 */

public final class AnimatorBuilder {
	
	private final Simulation simu = new Simulation();
	
	/**
	 * Adding road element.
	 * 
	 * @param road
	 * @param coor
	 */
	public void addRoad(Road road, Coodinate coor){
		if(road == null || coor == null)
			return;
		simu.addRoad(road, coor);
	}
	/**
	 * Adding light element.
	 * 
	 * @param light
	 * @param coor
	 */
	public void addLight(Light light, Coodinate coor){
		if(light == null || coor == null)
			return;
		
		simu.addLight(light, coor);
	}
	
	/**
	 * Get animation object to run simulation.
	 * 
	 * @return
	 */
	public Animator getAnimator(){
		return simu;
	}
	
}
