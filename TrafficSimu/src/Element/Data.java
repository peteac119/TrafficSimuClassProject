package Element;

/**
 * 
 * All variables in this class will be used in simulation.
 * 
 * @author pichan vasantakitkumjorn
 *
 */
public class Data {
		
		private double runtime = 60.0; 
		private int row = 2;
		private int column = 3;
		private int pattern = 1;
		private String traffic_type = "alternating";
		private double min_car_gen = 2.0;
		private double max_car_gen = 4.0;
		private double min_car_length = 10.0;
		private double max_car_length = 15.0;
		private double min_velo = 30.0;
		private double max_velo = 70.0;
		private double min_slow = 5.0;
		private double max_slow = 7.0;
		private double min_brake = 1.0;
		private double max_brake = 4.0;
		private double min_green = 5.0;
		private double max_green = 10.0;
		private double min_red = 5.0;
		private double max_red = 10.0;
		
		/**
		 * Set up running time in seconds.
		 * @param time
		 */
		public void set_runtime(double time) {
			if (time < 0)
				throw new IllegalArgumentException();
			runtime = time;
		}
		/**
		 * Set up row and column of the road.
		 * @param row
		 * @param column
		 */
		public void set_grid(int row, int column) {
			if (row <= 0 || column <= 0)
				throw new IllegalArgumentException();
			this.row = row;
			this.column = column;
		}
		/**
		 * Set uo the pattern of model in simulation.
		 * @param k
		 */
		public void set_pattern(int k) {
			if (k <= 0 || k > 2)
				throw new IllegalArgumentException();
			if(k == 1){
				pattern = k;
				traffic_type = "alternating";
			}else if (k == 2){
				pattern = k;
				traffic_type = "simple";
			}
		}
		/**
		 * Set up car generation time.
		 * 
		 * @param min
		 * @param max
		 */
		public void set_car_gen(double min, double max) {
			if (min <= 0 || max <= 0 || max < min
				|| min > 5 || max > 5)
				throw new IllegalArgumentException();
			min_car_gen = min;
			max_car_gen = max;
		}
		
		/**
		 * Set car length.
		 * 
		 * @param min
		 * @param max
		 */
		public void set_car_length(double min, double max) {
			if (min < 5 || max < 5 || max < min
				|| min > 15 || max > 15	)
				throw new IllegalArgumentException();
			min_car_length = min;
			max_car_length = max;
		}
		/**
		 * Set car speed.
		 * 
		 * @param min
		 * @param max
		 */
		public void set_car_velo(double min, double max) {
			if (min < 10  || max <  10 || max < min
				|| min > 100 || max > 100)
				throw new IllegalArgumentException();
			min_velo = min;
			max_velo = max;
		}
		/**
		 * Set distance for a car to slow down.
		 * 
		 * @param min
		 * @param max
		 */
		public void set_car_slow(double min, double max) {
			if (min < 5 || max < 5 || max < min
				|| min > 10 || max > 10)
				throw new IllegalArgumentException();
			min_slow = min;
			max_slow = max;	
		}
		/**
		 * Set distance for a car to stop.
		 * 
		 * @param min
		 * @param max
		 */
		public void set_car_brake(double min, double max) {
			if (min <= 0 || max <= 0 || max < min
				|| min > 4 || max > 4) 
				throw new IllegalArgumentException();
			min_brake = min;
			max_brake = max;	
		}
		/**
		 * Set up interval time for green light.
		 * 
		 * @param min
		 * @param max
		 */
		public void set_greentime(double min, double max) {
			if (min <= 0 || max <= 0 || max < min
				|| min > 10 || max > 10	)
				throw new IllegalArgumentException();
			min_green = min;
			max_green = max;
		}
		/**
		 * Set up interval time for red light.
		 * 
		 * @param min
		 * @param max
		 */
		public void set_redtime(double min, double max) {
			if (min <= 0 || max <= 0 || max < min
				|| min > 10 || max > 10 )
				throw new IllegalArgumentException();
			min_red = min;
			max_red = max;
		}
		/**
		 * Reset all values back to default values.
		 */
		public void reset() {
			runtime = 60.0; 
			row = 2;
			column = 3;
			pattern = 1;
			traffic_type = "alternating";
			min_car_gen = 2.0;
			max_car_gen = 4.0;
			min_car_length = 10.0;
			max_car_length = 15.0;
			min_velo = 30.0;
			max_velo = 70.0;
			min_slow = 5.0;
			max_slow = 7.0;
			min_brake = 1.0;
			max_brake = 4.0;
			min_green = 5.0;
			max_green = 10.0;
			min_red = 5.0;
			max_red = 10.0;
		}
		@Override
		public String toString(){
			StringBuilder print = new StringBuilder();
			print.append("Simulation run time (seconds)		[" + runtime + "]\n");
			print.append("Grid size (number of roads)		[row=" + row + ",column=" + column + "]\n");
			print.append("Traffic pattern					[" + traffic_type + "]\n");
			print.append("Car entry rate (seconds/car)		[min=" + min_car_gen + ",max="+ max_car_gen + "]\n");
			print.append("Car length (meters)				[min=" + min_car_length + ",max="+ max_car_length + "]\n");
			print.append("Car maximum velocity (meters/seconds)	[min=" + min_velo + ",max="+ max_velo + "]\n");
			print.append("Car stop distance (meters)		[min=" + min_slow + ",max="+ max_slow + "]\n");
			print.append("Car brake distance (meters)		[min=" + min_brake + ",max="+ max_brake + "]\n");
			print.append("Traffic light green time (seconds)	[min=" + min_green + ",max="+ max_green + "]\n");
			print.append("Traffic light red time (seconds)	[min=" + min_red + ",max="+ max_red + "]\n");
			return print.toString();
		}
		/**
		 * Get running time.
		 * @return double
		 */
		double get_runtime() {
			return runtime;
		}
		/**
		 * Get number of rows.
		 * 
		 * @return int
		 */
		int get_row() {
			return row;
		}
		/**
		 * Get number of column.
		 * 
		 * @return int
		 */
		int get_column() {
			return column;
		}
		/**
		 * Get pattern of model.
		 * 
		 * @return int
		 */
		int get_pattern() {
			return pattern;
		}
		/**
		 * Get minimum car length.
		 * 
		 * @return double
		 */
		double get_min_carlength(){
			return min_car_length;
		}
		/**
		 * Get maximum car length.
		 * 
		 * @return double
		 */
		double get_max_carlength(){
			return max_car_length;
		}
		/**
		 * Get minimum interval time for car generation.
		 * 
		 * @return double
		 */
		double get_min_cargendelay(){
			return min_car_gen;
		}
		/**
		 * Get maximum interval time for car generation.
		 * 
		 * @return double
		 */
		double get_max_cargendelay(){
			return max_car_gen;
		}
		/**
		 * Get minimum speed of car.
		 * 
		 * @return double
		 */
		double get_min_velo(){
			double minvelo = min_velo / 10;
			return minvelo;
		}
		/**
		 * Get maximum speed of car.
		 * 
		 * @return double
		 */
		double get_max_velo(){
			double maxvelo = max_velo/10;
			return maxvelo;
		}
		/**
		 * Get minimum distance of car for slowing down.
		 * 
		 * @return double
		 */
		double get_min_slowdis(){
			return min_slow;
		}
		/**
		 * Get maximum distance of car for slowing down.
		 * 
		 * @return double
		 */
		double get_max_slowdis(){
			return max_slow;
		}
		/**
		 * Get minimum distance of car for brake.
		 * 
		 * @return double
		 */
		double get_min_brakedis(){
			return min_brake;
		}
		/**
		 * Get maximum distance of car for brake.
		 * 
		 * @return double
		 */
		double get_max_brakedis(){
			return max_brake;
		}
		/**
		 * Get minimum interval time for green light.
		 * 
		 * @return double
		 */
		double get_min_greentime(){
			return min_green;
		}
		/**
		 * Get maximum interval time for green light.
		 * 
		 * @return double
		 */
		double get_max_greentime(){
			return max_green;
		}
		/**
		 * Get minimum interval time for red light.
		 * 
		 * @return double
		 */
		double get_min_redtime(){
			return min_red;
		}
		/**
		 * Get maximum interval time for red light.
		 * 
		 * @return double
		 */
		double get_max_redtime(){
			return max_red;
		}
	
}
