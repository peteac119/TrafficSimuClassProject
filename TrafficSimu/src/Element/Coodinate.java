package Element;

/**
 * 
 * This class is used to plot and draw each object on the frame.
 * 
 * @author pichan vasantakitkumjorn
 *
 */
public final class Coodinate {
	private int x_coor;
	private int y_coor;
	private int width;
	private int height;
	//Constructor
	Coodinate (int x_coor, int y_coor, int width, int height){
		this.x_coor = x_coor;
		this.y_coor = y_coor;
		this.width = width;
		this.height = height;
	}
	/**
	 * Get X coordinate.
	 * 
	 * @return int
	 */
	public int get_X(){
		return x_coor;
	}
	/**
	 * Get Y coordinate.
	 * 
	 * @return int
	 */
	public int get_Y(){
		return y_coor;
	}
	/**
	 * Get width.
	 * 
	 * @return int
	 */
	public int get_Width(){
		return width;
	}
	/**
	 * Get height.
	 * 
	 * @return int
	 */
	public int get_Height(){
		return height;
	}

}
