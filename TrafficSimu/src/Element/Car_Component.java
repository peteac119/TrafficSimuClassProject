package Element;

/**
 * 
 * This class will collect all variables from user input and be used for Car creation only.
 * 
 * @author pichan vasantakitkumjorn
 *
 */
final class Car_Component {
	
	private double min_car_velo;
	private double min_car_length;
	private double min_car_gen;
	private double min_car_slow;
	private double min_car_brake;
	private double max_car_velo;
	private double max_car_length;
	private double max_car_gen;
	private double max_car_slow;
	private double max_car_brake;
	/**
	 * Set up all variables.
	 * @param data
	 */
	void setup(Data data){
		//All min values
		min_car_velo   = data.get_min_velo();
		min_car_length = data.get_min_carlength();
		min_car_gen    = data.get_min_cargendelay();
		min_car_slow   = data.get_min_slowdis();
		min_car_brake  = data.get_min_brakedis();
		//All max values
		max_car_velo   = data.get_max_velo();
		max_car_length = data.get_max_carlength();
		max_car_gen    = data.get_max_cargendelay();
		max_car_slow   = data.get_max_slowdis();
		max_car_brake  = data.get_max_brakedis();
		
	}
	/**
	 * Get the normal speed of car.
	 * 
	 * @return int
	 */
	int getVelocity(){
		int velo = (int) Math.ceil(min_car_velo + (Math.random() * (max_car_velo - min_car_velo)));
		return velo;
	}
	/**
	 * Get the length of car.
	 * 
	 * @return int
	 */
	int getLength(){
		int carlength = (int) Math.ceil(min_car_length + (Math.random() * (max_car_length - min_car_length)));
		return carlength;
	}
	/**
	 * Get the distance that car has to slow down.
	 * 
	 * @return int
	 */
	int getSlowDistance(){
		int slowdis = (int) Math.ceil(min_car_slow + (Math.random() * (max_car_slow - min_car_slow)));
		return slowdis;
	}
	/**
	 * Get the distance that car has to brake.
	 * 
	 * @return int
	 */
	int getBrakeDistance(){
		int brakedis = (int) Math.ceil(min_car_brake + (Math.random() * (max_car_brake - min_car_brake)));
		return brakedis;
	}
	/**
	 * Get the time interval that car will be generated.
	 * 
	 * @return int
	 */
	int getGenerateTime(){
		int gentime = (int) Math.ceil(min_car_gen + (Math.random() * (max_car_gen - min_car_gen)));
		return gentime;
	}
	
}
