package Element;

/**
 * 
 * This class will collect all variables from user input and be used for Model creation only.
 * 
 * @author pichan vasantakitkumjorn
 *
 */

final class Model_Component {

	private int type;
	private int row;
	private int column;
	private int runtime;
	private final int MILLIS_SECOND = 1000;
	private final int SLEEP_TIME = 75; 		
	/**
	 * Set up all variables.
	 * @param data
	 */
	void setup(Data data) {
		type = data.get_pattern();
		row = data.get_row();
		column = data.get_column();
		runtime = (int)data.get_runtime();
		runtime = (runtime * MILLIS_SECOND)/SLEEP_TIME;
	}
	/**
	 * Get the type of model.
	 * 
	 * @return int
	 */
	int getType() {
		return type;
	}
	/**
	 * Get number of row.
	 * 
	 * @return int
	 */
	int getRow() {
		return row;
	}
	/**
	 * Get number of column.
	 * 
	 * @return int
	 */
	int getColumn() {
		return column;
	}
	/**
	 * Get running time.
	 * 
	 * @return int
	 */
	int getRuntime() {
		return runtime;
	}

}
