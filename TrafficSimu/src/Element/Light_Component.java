package Element;

/**
 * 
 * This class will collect all variables from user input and be used for Light creation only.
 * 
 * @author pichan vasantakitkumjorn
 *
 */

final class Light_Component {

	private double min_green_time;
	private double min_red_time;
	private double max_green_time;
	private double max_red_time;
	/**
	 * Set up all variables.
	 * @param data
	 */
	 void setup(Data data) {
		 // All min values
		min_red_time = data.get_min_redtime();
		min_green_time = data.get_min_greentime();
		// All max values 
		max_red_time = data.get_max_redtime();
		max_green_time = data.get_max_greentime();
	}
	/**
	 *  Get time interval for green light.
	 *  
	 * @return int
	 */
	int getGreenTime(){
		final int greentime = (int) Math.ceil(min_green_time + (Math.random() * (max_green_time - min_green_time)));
		return greentime;
	}
	/**
	 *  Get time interval for red light.
	 *  
	 * @return int
	 */
	int getRedTime(){
		final int redtime = (int) Math.ceil(min_red_time + (Math.random() * (max_red_time - min_red_time)));
		return redtime;
	}

}
