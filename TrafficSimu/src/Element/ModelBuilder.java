package Element;

import ielement.Model;

/**
 * 
 * Builder class that calls factory class to generate model.
 * 
 * @author pichan vasantakitkumjorn
 *
 */
public class ModelBuilder {
	
	private final Data data;
	private final Car_Component car_data = new Car_Component();
	private final Light_Component light_data = new Light_Component();
	private final Model_Component model_data = new Model_Component();
	//Constructor
	ModelBuilder(Data data){
		this.data = data;
	}
	/**
	 * Set up all components and pass them to factory class for creating model.
	 */
	void build() {
		car_data.setup(data);
		light_data.setup(data);
		model_data.setup(data);
	}
	/**
	 * Get model based on set up values.
	 * 
	 * @return Model
	 */
	Model getModel() {
		return ModelFactory.getModel(car_data, light_data, model_data);
	}
	

}
