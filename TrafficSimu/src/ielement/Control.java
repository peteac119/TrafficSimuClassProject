package ielement;

import Element.Light;
import Element.Road;

public interface Control {
	void execute();
	void addRoad(Road road);
	void addLight(Light light);
}
