package Element;

final class CarControl implements Agent{

	private final Control center;
	
	CarControl(int type, int num_light, int num_road,Car_Component car_info){
		switch(type){
		case 1	: this.center = new AlterControl(num_light,num_road,car_info);	break;
		case 2	: this.center = new SimpleControl(num_light,num_road,car_info);	break;
		default : this.center = null;
		}
	}
	
	void addRoad(Road road){
		center.addRoad(road);
	}
	
	void addLight(Light light){
		center.addLight(light);
	}
	
	public void run(int runtime) {
		if(center == null)
			throw new NullPointerException();
		
		center.execute();
	}

}
