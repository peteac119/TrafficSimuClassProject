package Element;

import ielement.Car;

import java.awt.Color;

final class Alter_Car implements Car{

	private final Color color;
	private int length;
	private int velocity;
	private int light_pos;
	private int normal_speed;
	private int back_position;

	Alter_Car(Car_Component car_info, int position, int lightpos){
		velocity = -car_info.getVelocity();
		back_position = position;
		normal_speed = velocity;
		light_pos = lightpos;
		length = car_info.getLength();
		color = new Color((int)Math.ceil(Math.random()*255),(int)Math.ceil(Math.random()*255),(int)Math.ceil(Math.random()*255));
	}
	
	public void set_Lightpos(){
		light_pos--;
	}
	
	public int get_Lightpos(){
		if(light_pos < 0)
			light_pos = 0;
		return light_pos;
	}
	
	public int get_FrontPosition(){
    	return back_position;
    }
	
	public int get_BackPosition(){
		return back_position - length;
	}
	
	public void slowDown(){
		velocity = -1;
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
		back_position -= position;
		
	}

}
