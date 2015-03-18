package Element;

final class Model_Component {

	private int type;
	private int row;
	private int column;
	private int runtime;
	private final int MILLIS_SECOND = 1000;
	private final int SLEEP_TIME = 75; 		
	
	void setup(Data data) {
		type = data.get_pattern();
		row = data.get_row();
		column = data.get_column();
		runtime = (int)data.get_runtime();
		runtime = (runtime * MILLIS_SECOND)/SLEEP_TIME;
	}

	int getType() {
		return type;
	}

	int getRow() {
		return row;
	}

	int getColumn() {
		return column;
	}
	
	int getRuntime() {
		return runtime;
	}

}
