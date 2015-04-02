package Animation;

import ielement.Car;

import java.awt.Color;
import java.awt.Graphics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Element.Coodinate;
import Element.Road;
import Element.Light;

/**
 * 
 * This class will manage, generate and show the traffic simulation on the screen. 
 * 
 * @author pichan vasantakitkumjorn
 *
 */

final class Simulation implements Animator{
	
	private final List<Element<Road>> road = new ArrayList<Element<Road>>();
	private final List<Element<Light>> light = new ArrayList<Element<Light>>();
	private final Painter paint = new Painter();
	private final JFrame frame = new JFrame();
	//Constructor
	Simulation(){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				frame.setSize(1024,720);
				frame.setTitle("Traffic Simulation");
				frame.add(paint);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
	/**
	 * Add road element.
	 * @param road
	 * @param coor
	 */
	void addRoad(Road road, Coodinate coor){
		this.road.add(new Element<Road>(road,coor));
	}
	/**
	 * Add light element.
	 * @param light
	 * @param coor
	 */
	void addLight(Light light, Coodinate coor){
		this.light.add(new Element<Light>(light,coor));
	}
	/**
	 * Terminate simulator.
	 */
	public void dispose() {
		frame.dispose();
	}
	/**
	 * For Observer class to update all element in the simulation.
	 */
	public void update(final Observable model, Object ignored) {
		//This method will put run() to other Thread, but it still can work with the main Thread.  
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				paint.repaint();
			}
		});
		
		//If use invokeLater(), try block will be executed first. Then invokeLater() will run later.
		try {
			Thread.currentThread();
			Thread.sleep(75);
	    } catch (InterruptedException e) {}
		
		
	}
	/**
	 * Inner class that wraps all elements into one type.
	 * @author pete
	 *
	 * @param <Type>
	 */
	private class Element<Type>{
		
		private final Type data;
		private final Coodinate coor;
		
		Element(Type input, Coodinate coor){
			data = input;
			this.coor = coor;
		}
	}
	/**
	 * 
	 * The class that draws all elements on the frame.
	 * 
	 * @author pichan vasantakitkumjorn.
	 *
	 */
	private class Painter extends JPanel{
		
		private static final long serialVersionUID = 1L;
		
		public void paint(Graphics g) {
			g.setColor(Color.gray);
			
			for(Element<Road> r: road){
				g.fillRect(r.coor.get_X(),r.coor.get_Y(), r.coor.get_Width(), r.coor.get_Height());
			}
			
			for(Element<Light> l: light){
				g.setColor(l.data.getColor());
				g.fillOval(l.coor.get_X(), l.coor.get_Y(), l.coor.get_Width(), l.coor.get_Height());
			}
			
			for(Element<Road> r: road){
				if(r.data.get_Type() == 1){
					Iterator<Car> list_car = r.data.get_Car();
					while(list_car.hasNext()){
						Car car = list_car.next();
						g.setColor(car.get_Color());
						g.fillOval(r.coor.get_X(), car.get_BackPosition(), 10, car.get_Length());
					}
				}else{
					Iterator<Car> list_car = r.data.get_Car();
					while(list_car.hasNext()){
						Car car = list_car.next();
						g.setColor(car.get_Color());
						g.fillOval(car.get_BackPosition(),r.coor.get_Y() , car.get_Length(), 10);
					}
				}		
			}
		}
	}
}
