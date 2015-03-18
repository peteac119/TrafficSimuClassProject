package Main;

import Element.Data;
import Element.Model;
import Element.Modeler;
import Utility.UIForm;

final class StartingPoint {
	
	private final MenuMessage MESSAGE = new MenuMessage();
	private boolean isRun = false;
	private final UIForm _menu;
	private final Data value;
	
	StartingPoint(){
		_menu = new UIForm();
		value = new Data();
	}
	
	void run(){
		final String mainMessage = MESSAGE.getMainMenuMessage();
		final String subMessage  = MESSAGE.getSubMenuMessage();
		final String exitMessage = MESSAGE.getExitMenuMessage();
		
		do{
			String result = _menu.inputBox(mainMessage);
			 try {
				 int choice = Integer.parseInt(result);
				 
				 switch (choice){
				 
				 	case 1  : Modeler modeler = new Modeler(value);
				 			  Model simulation = modeler.getModel();
				 			  simulation.start();
				 			  break;
				 	case 2  : runSubMenu(subMessage);
				 			  break;
				 	case 3  : while(true){
				 			  	String output = _menu.inputBox(exitMessage);
				 			  	if (output == null || output.equals("2")){
				 			  		break;
				 			  	}else if (output.equals("1")){
				 			  		isRun = true;
				 			  		break;
				 			  	}
				 			  }
				 			  break;
				 			 
				 	default : _menu.errorMessage("Please put number between 1 and 3.");
				 }
			 }catch(NumberFormatException e){
				 _menu.errorMessage("Please put number between 1 and 3.");
			 }
			
		}while(!isRun);
	}


	private void runSubMenu(String message) {
		boolean isRun = false;
		do{
			String result = _menu.inputBox(message);
		
			if(result == null)
				return;
			
			try {
				int choice = Integer.parseInt(result);
			 
				switch (choice){
					
					case 1 : _menu.showMessage(value.toString()); 
							 break;
					case 2 : value.set_runtime(setupMenu("Enter run time (in seconds)"));
							 break;
					case 3 : int row     = setupMenu("Enter row");
							 int column  = setupMenu("Enter column");
							 value.set_grid(row, column);
							 break;
					case 4 : do{
							 	try{
							 		value.set_pattern(setupMenu("Enter pattern ( 1 = Alternative, 2 = Simple )"));
							 		break;
							 	}catch(IllegalArgumentException e){
							 		_menu.errorMessage("Please enter number between 1 and 2"); 
							 	}
							 }while(true);
							 break;
					case 5 : double min_gen = setupMenu("Enter minimum generate time (1 - 5)", 1, 5);
					         double max_gen = setupMenu("Enter maximum generate time (1 - 5)", 1, 5);
					         value.set_car_gen(min_gen, max_gen);
							 break;
					case 6 : double min_carlength = setupMenu("Enter minimum car length (5 - 15)",5,15);
			 		 		 double max_carlength = setupMenu("Enter maximum car length (5 - 15)",5,15);
			 		 		 value.set_car_length(min_carlength, max_carlength);
			 		 		 break;
					case 7 : double min_carvelo = setupMenu("Enter minimum car velocity (10 - 100)",10,100);
	 				 		 double max_carvelo = setupMenu("Enter maximum car velocity (10 - 100)",10,100);
	 				 		 value.set_car_velo(min_carvelo, max_carvelo);
	 				 		 break;
					case 8 : double min_carslow = setupMenu("Enter minimum car slow distance (5 - 10)",5,10);
	 				 		 double max_carslow = setupMenu("Enter maximum car slow distance (5 - 10)",5,10);
	 				 		 value.set_car_slow(min_carslow, max_carslow);
	 				 		 break;
					case 9 : double min_carbrake = setupMenu("Enter minimum car brake distance (1 - 4)",1,4);
	 				  		 double max_carbrake = setupMenu("Enter maximum car brake distance (1 - 4)",1,4);
	 				  		 value.set_car_brake(min_carbrake, max_carbrake);
	 				  		 break;
					case 10 : double min_greentime = setupMenu("Enter minimum green time (1 - 10)",1,10);
			  		  		  double max_greentime = setupMenu("Enter maximum green time (1 - 10)",1,10);
			  		  		  value.set_greentime(min_greentime, max_greentime);
			  		  		  break;
					case 11 : double min_redtime = setupMenu("Enter minimum red time (1 - 10)",1,10);
					  		  double max_redtime = setupMenu("Enter maximum red time (1 - 10)",1,10);
					  		  value.set_redtime(min_redtime, max_redtime);
					  		  break;
					case 12 : value.reset();
					  		  break;
					case 13 : isRun = true;
					  		  break;
					default : _menu.errorMessage("Please put number between 1 and 14.");
				}
			}catch(NumberFormatException e){
				_menu.errorMessage("Please put number between 1 and 14.");
			}catch(IllegalArgumentException e){
				_menu.errorMessage("Min value must be less than Max value.");
			}
		}while(!isRun);	
	}
	
	private int setupMenu(String message){
		int retval;
		UIForm menu = new UIForm();
		
		while(true){
			try{
				String result = menu.inputBox(message);
				retval = Integer.parseInt(result);
				if(retval <= 0){
					menu.errorMessage("Please enter positive number.");
					continue;
				}
				return retval;
			}catch(NumberFormatException e){
				menu.errorMessage("Please enter positive number.");
			}
		}	
	}
	
	private double setupMenu(String message,int min, int max){
		double retval;
		UIForm menu = new UIForm();
		
		while(true){
			try{
				String result = menu.inputBox(message);
				retval = Double.parseDouble(result);
				if(retval < min || retval > max){
					menu.errorMessage("Please enter number between " + min + " and " + max);
					continue;
				}
				return retval;
			}catch(NullPointerException e){
				menu.errorMessage("Please enter number between " + min + " and " + max);
			}
		}
	}
}
