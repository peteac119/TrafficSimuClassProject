package Element;

import ielement.Agent;
import ielement.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import Animation.Animator;
import Animation.AnimatorBuilder;

/**
 * 
 * This class generates a alternative model simulation.
 * 
 * @author pichan vasantakitkumjorn
 *
 */

final class AlterModel extends Observable implements Model{

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
	private final int ALTER = 1;
	private final int runtime;
	//Constructor
	AlterModel(Car_Component car_info, Light_Component light_info, Model_Component model_info) {
		this.light = new Light[model_info.getColumn()][model_info.getRow()];
		this.runtime = model_info.getRuntime();
		this.light_info = light_info;
		this.car_info = car_info;
		
		build(model_info.getRow(), model_info.getColumn());
		animator = builder.getAnimator();
		super.addObserver(animator);
	}
	/**
	 * Start running simulation based on running time.
	 */
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
	/**
	 * Create all element for simulation.
	 * 
	 * @param row
	 * @param column
	 */
	private void build(int row, int column){
		build_Light(row,column);
		buildVerRoad(row,column);
		buildHoriRoad(row,column);
	}
	/**
	 * Create horizontal road.
	 * @param row
	 * @param column
	 */
	private void buildHoriRoad(int row, int column) {
		int x_coor = 0;
		int y_coor = 150;
		int num_road = column + 1;
		int type;
		int endpoint;
		
		for (int hori = 0; hori < row; hori++){
			if(hori % 2 == 0){
				type = SIMPLE;
			}else{
				type = ALTER;
			}
			
			CarControl control = new CarControl(type,column,num_road,car_info);
			for(int j = 0; j < num_road; j++){
				
				if(type == SIMPLE)
					endpoint = x_coor + LENGTH;
				else
					endpoint = x_coor;
				
				Road road = new Road(FIX_VALUE,endpoint,HORIZONTAL);
				Coodinate road_coor = new Coodinate(x_coor,y_coor,LENGTH,FIX_VALUE);
				builder.addRoad(road, road_coor);
				control.addRoad(road);
				
				if (j == 0 && type == SIMPLE){
					CarGen car_gen = new CarGen(x_coor,type,road,car_info,column);
					agent.add(car_gen);
				}else if (j == num_road - 1 && type == ALTER){
					CarGen car_gen = new CarGen(x_coor + LENGTH ,type,road,car_info,column);
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
	/**
	 * Create vertical road.
	 * @param row
	 * @param column
	 */
	private void buildVerRoad(int row, int column) {
		int x_coor = 150;
		int y_coor = 0;
		int num_road = row + 1;
		int type;
		int endpoint;
		
		for (int ver = 0;  ver < column; ver++){
			if(ver % 2 == 0){
				type = SIMPLE;
			}else{
				type = ALTER;
			}
			CarControl control = new CarControl(type,row,num_road,car_info);
			
			for(int j = 0; j < num_road; j++){
				
				if(type == SIMPLE)
					endpoint = y_coor + LENGTH;
				else
					endpoint = y_coor;
				
			
				Road road = new Road(FIX_VALUE,endpoint,VERTICAL);
				Coodinate road_coor = new Coodinate(x_coor,y_coor,FIX_VALUE,LENGTH);
				builder.addRoad(road, road_coor);
				control.addRoad(road);
				if (j == 0 && type == SIMPLE){
					CarGen car_gen = new CarGen(y_coor,type,road,car_info,row);
					agent.add(car_gen);
				}else if (j == num_road - 1 && type == ALTER){
					CarGen car_gen = new CarGen(y_coor + LENGTH ,type,road,car_info,row);
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
	/**
	 * Set all light positions.
	 * @param row
	 * @param column
	 */
	private void build_Light(int row, int column){
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
