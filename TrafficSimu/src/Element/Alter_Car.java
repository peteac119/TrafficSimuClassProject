package Element;

import ielement.Car;

import java.awt.Color;

/**
 * 
 * The car object class for alternative model type.
 * 
 * @author pichan vasantakitkumjorn
 *
 */
final class Alter_Car implements Car{

	private final Color color;
	private int length;
	private int velocity;
	private int light_pos;
	private int normal_speed;
	private int back_position;
	//Constructor
	Alter_Car(Car_Component car_info, int position, int lightpos){
		velocity = -car_info.getVelocity();
		back_position = position;
		normal_speed = velocity;
		light_pos = lightpos;
		length = car_info.getLength();
		color = new Color((int)Math.ceil(Math.random()*255),(int)Math.ceil(Math.random()*255),(int)Math.ceil(Math.random()*255));
	}
	/**
	 * Keep tracking the light position.
	 */
	public void set_Lightpos(){
		light_pos--;
	}
	/**
	 * Get the current light position.
	 * 
	 * @return int
	 */
	public int get_Lightpos(){
		if(light_pos < 0)
			light_pos = 0;
		return light_pos;
	}
	/**
	 * Get a front position of the car.
	 * 
	 * @return int
	 */
	public int get_FrontPosition(){
    	return back_position;
    }
	/**
	 * Get a back position of car.
	 * 
	 * @return int
	 */
	public int get_BackPosition(){
		return back_position - length;
	}
	/**
	 * Slow the speed of car.
	 */
	public void slowDown(){
		velocity = -1;
	}
	/**
	 * Stop the car.
	 */
	public void brake(){
		velocity = 0;
	}
	/**
	 * Increase the car speed.
	 */
	public void speedUp(){
		velocity = normal_speed;
	}
	/**
	 * Let the car drive again.
	 */
	public void drive(){
		back_position += velocity;
	}
	/**
	 * Get the length of the car.
	 * 
	 * @return int
	 */
	public int get_Length() {
		return length;
	}
	/**
	 * Get car color.
	 * 
	 * @return Color
	 */
	public Color get_Color() {
		return color;
	}
	/**
	 * Set the new position when pass a light. 
	 */
	public void set_position(int position) {
		back_position -= position;
		
	}

}
