package Element;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import Animation.Animator;
import Animation.AnimatorBuilder;


final class SimpleModel extends Observable implements Model{

	private final AnimatorBuilder builder = new AnimatorBuilder();
	private final List<Agent> agent = new ArrayList<Agent>();
	private final Light_Component light_info;
	private final Car_Component car_info;
	private final Animator animator;
	private final Light[][] light;
	private final int FIX_VALUE = 10;
	private final int HORIZONTAL = 2;
	private final int VERTICAL = 1;
	private final int LENGTH = 150;
	private final int SIMPLE = 2;
	private final int runtime;
	
	SimpleModel(Car_Component car_info, Light_Component light_info, Model_Component model_info) {
		this.light = new Light[model_info.getColumn()][model_info.getRow()];
		this.runtime = model_info.getRuntime();
		this.light_info = light_info;
		this.car_info = car_info;
		
		build(model_info.getRow(), model_info.getColumn());
		animator = builder.getAnimator();
		super.addObserver(animator);
	}
	
	public void start() {
		for (int i=0; i < runtime; i++) {
			
			for(Agent a: agent){
				a.run(i);
			}
			super.setChanged();
		    super.notifyObservers();
		   
		}
		animator.dispose();
	}
	
	private void build(int row, int column){
		buildLight(row,column);
		buildVerRoad(row,column);
		buildHoriRoad(row,column);
	}

	private void buildHoriRoad(int row, int column) {
		int x_coor = 0;
		int y_coor = 150;
		int num_road = column + 1;
		
		for (int hori = 0; hori < row; hori++){
			
			CarControl control = new CarControl(SIMPLE,column,num_road,car_info);
			for(int j = 0; j < num_road; j++){
				int endpoint = x_coor + LENGTH;
				Road road = new Road(FIX_VALUE,endpoint,HORIZONTAL);
				Coodinate road_coor = new Coodinate(x_coor,y_coor,LENGTH,FIX_VALUE);
				builder.addRoad(road, road_coor);
				control.addRoad(road);
				if (j == 0){
					CarGen car_gen = new CarGen(x_coor,SIMPLE,road,car_info,column);
					agent.add(car_gen);
				}
				
				if(j != column){
					control.addLight(light[j][hori]);
				}
				
				x_coor += LENGTH + FIX_VALUE;
			}
			agent.add(control);
			x_coor = 0;
			y_coor = y_coor + 160;
		}
	}

	private void buildVerRoad(int row, int column) {
		int x_coor = 150;
		int y_coor = 0;
		int num_road = row + 1;
		
		for (int ver = 0;  ver < column; ver++){
			CarControl control = new CarControl(SIMPLE,row,num_road,car_info);
			for(int j = 0; j < num_road; j++){
				int endpoint = y_coor + LENGTH;
				Road road = new Road(FIX_VALUE,endpoint,VERTICAL);
				Coodinate road_coor = new Coodinate(x_coor,y_coor,FIX_VALUE,LENGTH);
				builder.addRoad(road, road_coor);
				control.addRoad(road);
				if (j == 0){
					CarGen car_gen = new CarGen(y_coor,SIMPLE,road,car_info,row);
					agent.add(car_gen);
				}
				if(j != row){
					control.addLight(light[ver][j]);
				}
				y_coor += LENGTH + FIX_VALUE;
			}
			agent.add(control);
			y_coor = 0;
			x_coor = x_coor + 160;
		}
	}

	private void buildLight(int row,int column) {
		int x_coor = 150;
		int y_coor = 0;
		
		for (int pos = 0;  pos < column; pos++){
			for(int j = 0; j < row; j++){
			    int light_pos = y_coor + LENGTH;
				light[pos][j] = new Light(light_info);
				agent.add(light[pos][j]);
				Coodinate light_coor = new Coodinate(x_coor, light_pos,FIX_VALUE,FIX_VALUE);
				builder.addLight(light[pos][j], light_coor);
				y_coor += LENGTH + FIX_VALUE;
			}
			y_coor = 0;
			x_coor = x_coor + 160;
		}
	}
}
