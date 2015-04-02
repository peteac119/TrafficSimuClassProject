package Element;

import ielement.Model;

public class ModelBuilder {
	
	private final Data data;
	private final Car_Component car_data = new Car_Component();
	private final Light_Component light_data = new Light_Component();
	private final Model_Component model_data = new Model_Component();
	
	ModelBuilder(Data data){
		this.data = data;
	}
	
	void build() {
		car_data.setup(data);
		light_data.setup(data);
		model_data.setup(data);
	}

	Model getModel() {
		return ModelFactory.getModel(car_data, light_data, model_data);
	}
	

}
