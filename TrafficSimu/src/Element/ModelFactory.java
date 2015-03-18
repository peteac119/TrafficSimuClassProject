package Element;

final class ModelFactory {
	private ModelFactory(){}
	
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
