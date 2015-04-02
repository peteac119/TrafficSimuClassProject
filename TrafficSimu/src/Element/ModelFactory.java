package Element;

import ielement.Model;

/**
 * 
 * Factory class that generates model and send back to main class.
 * 
 * @author pichan vasantakitkumjorn
 *
 */
final class ModelFactory {
	private ModelFactory(){}
	/**
	 * Generate model for simulation based on set up values.
	 * 
	 * @param car_info
	 * @param light_info
	 * @param model_info
	 * @return Model
	 */
	public static Model getModel(Car_Component car_info,
								 Light_Component light_info,
								 Model_Component model_info){
		
		switch (model_info.getType()){
			case 1 : return new AlterModel(car_info,light_info,model_info);	
			case 2 : return new SimpleModel(car_info,light_info, model_info);
			default: return null;
		}
	}

}
