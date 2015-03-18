package Animation;

import Element.Coodinate;
import Element.Light;
import Element.Road;

public class AnimatorBuilder {
	
	private final Simulation simu = new Simulation();
	
	public void addRoad(Road road, Coodinate coor){
		if(road == null || coor == null)
			return;
		simu.addRoad(road, coor);
	}
	
	public void addLight(Light light, Coodinate coor){
		if(light == null || coor == null)
			return;
		
		simu.addLight(light, coor);
	}
	
	
	public Animator getAnimator(){
		return simu;
	}
	
}
