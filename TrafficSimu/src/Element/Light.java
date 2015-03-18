package Element;

import java.awt.Color;


public final class Light implements Agent{
	
	private int time = 0;
	private int green_time;
	private int red_time;
	private Color color;
	
	Light(Light_Component light_info){
		green_time = light_info.getGreenTime() * 2;
		red_time = light_info.getRedTime() * 2;
		this.color = randomColor();
	}

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
	
	public Color getColor(){
		return color;
	}
	
	
	private Color randomColor() {
		double ran = Math.random()*2;
		if (ran > 1){
			return Color.RED;
		}else 
			return Color.GREEN;
	}
}
