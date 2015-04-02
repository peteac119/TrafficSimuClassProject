package ielement;

import java.awt.Color;

public interface Car {
	
	void set_position(int position);
	void set_Lightpos();
	int get_Lightpos();
	int get_FrontPosition();
	int get_BackPosition();
	int get_Length();
	void slowDown();
	void brake();
	void speedUp();
	void drive();
	Color get_Color();
}
