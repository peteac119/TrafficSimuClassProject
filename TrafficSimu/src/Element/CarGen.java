package Element;

final class CarGen implements Agent{

	private Car_Component car_info;
	private final Road road;
	private final int time_gen;
	private final int car_pos;
	private final int car_type;
	private final int light_pos;
	
	CarGen(int car_pos, int car_type, Road road, Car_Component car_info, int lightpos){
		this.time_gen = car_info.getGenerateTime() * 2;
		this.car_info = car_info;
		this.car_type = car_type;
		this.car_pos = car_pos;
		this.light_pos = lightpos;
		this.road = road;
		
		if(car_type == 1)
			road.add_Car(new Alter_Car(car_info,car_pos,light_pos));
		else
			road.add_Car(new Simple_Car(car_info,car_pos));
	}
	
	public void run(int runtime) {
		if(runtime % time_gen == 0){
			switch(car_type){
			
			case 1 : Car new_alcar = new Alter_Car(car_info,car_pos,light_pos);
					 if(new_alcar.get_BackPosition() < road.get_LastCar().get_FrontPosition())
					 	return;
					 else
						 road.add_Car(new_alcar);
					 break;
					 
			case 2 : Car new_simcar = new Simple_Car(car_info,car_pos);
			 		 if(new_simcar.get_FrontPosition() > road.get_LastCar().get_BackPosition())
			 			 return;
			 		 else
			 			 road.add_Car(new_simcar);
			 		 break;
			}
		}
	}
}
