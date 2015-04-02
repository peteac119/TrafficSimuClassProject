package Element;

import ielement.Model;

/**
 * 
 * This class will call the builder to generate model.
 * 
 * @author pichan vasantakitkumjorn
 *
 */
public class Modeler {
	
	private final ModelBuilder builder;
	//Constructor
	public Modeler(Data value){
		builder = new ModelBuilder(value);
		buildModel();
	}
	/**
	 * Get Model for a simulation.
	 * 
	 * @return Model
	 */
	public Model getModel(){
		return builder.getModel();
	}
	/**
	 * Create a model for a simulation.
	 */
	private void buildModel(){
		builder.build();
	}
}
