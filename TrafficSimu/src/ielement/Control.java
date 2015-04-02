package ielement;

import Element.Light;
import Element.Road;

/**
 * Interface for simulation controller.
 * 
 * @author pichan vasantakitkumjorn
 *
 */

public interface Control {
	void execute();
	void addRoad(Road road);
	void addLight(Light light);
}
