package Element;

import ielement.Agent;

import java.awt.Color;

/**
 * Light element in the simulation.
 * 
 * @author pichan vasantakitkumjorn
 *
 */
public final class Light implements Agent{
	
	private int time = 0;
	private int green_time;
	private int red_time;
	private Color color;
	//Constructor
	Light(Light_Component light_info){
		green_time = light_info.getGreenTime() * 2;
		red_time = light_info.getRedTime() * 2;
		this.color = randomColor();
	}
	/**
	 * Change the color based on set up time.
	 */
	public void run(int runtime){
		
		int check_time = runtime - time;
		
		if(check_time >= red_time && color == Color.RED){
			color = Color.GREEN;
			time = runtime;
		}else if(check_time >= green_time && color == Color.GREEN){
			color = Color.RED;
			time = runtime;
		}
		
	}
	/**
	 * Get current light color.
	 * 
	 * @return Color
	 */
	public Color getColor(){
		return color;
	}
	
	/**
	 * Random color when this object is created.
	 * 
	 * @return Color
	 */
	private Color randomColor() {
		double ran = Math.random()*2;
		if (ran > 1){
			return Color.RED;
		}else 
			return Color.GREEN;
	}
}
