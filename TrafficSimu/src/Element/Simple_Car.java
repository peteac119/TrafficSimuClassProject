package Element;

import java.awt.Color;


final class Simple_Car implements Car{
	private final Color color = new Color((int)Math.ceil(Math.random()*255),(int)Math.ceil(Math.random()*255),(int)Math.ceil(Math.random()*255));
	private int light_pos = 0;
	private int length;
	private int velocity;
	private int normal_speed;
	private int back_position;

	Simple_Car(Car_Component car_info, int position){
		velocity = car_info.getVelocity();
		back_position = position;
		normal_speed = velocity;
		length = car_info.getLength();
	}
	
	public void set_Lightpos(){
		light_pos++;
	}
	
	public int get_Lightpos(){
		return light_pos;
	}
	
	public int get_FrontPosition(){
    	return back_position + length;
    }
	
	public int get_BackPosition(){
		return back_position;
	}
	
	public void slowDown(){
		velocity = 1;
	}
	
	public void brake(){
		velocity = 0;
	}
	
	public void speedUp(){
		velocity = normal_speed;
	}
	
	public void drive(){
		back_position += velocity;
	}

	public int get_Length() {
		return length;
	}

	public Color get_Color() {
		return color;
	}

	public void set_position(int position) {
		back_position += position;
	}
	
}
