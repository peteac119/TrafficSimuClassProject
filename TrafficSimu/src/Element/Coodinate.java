package Element;


public final class Coodinate {
	private int x_coor;
	private int y_coor;
	private int width;
	private int height;
	
	Coodinate (int x_coor, int y_coor, int width, int height){
		this.x_coor = x_coor;
		this.y_coor = y_coor;
		this.width = width;
		this.height = height;
	}
	
	public int get_X(){
		return x_coor;
	}
	
	public int get_Y(){
		return y_coor;
	}
	
	public int get_Width(){
		return width;
	}
	
	public int get_Height(){
		return height;
	}

}
