package Element;


public class Modeler {
	
	private final ModelBuilder builder;
	
	public Modeler(Data value){
		builder = new ModelBuilder(value);
		buildModel();
	}
	
	public Model getModel(){
		return builder.getModel();
	}
	
	private void buildModel(){
		builder.build();
	}
}
