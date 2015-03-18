package Main;

public final class MenuMessage {
	private final StringBuilder MAIN_MENU = new StringBuilder();
	private final StringBuilder SUB_MENU = new StringBuilder();
	private final StringBuilder EXIT_MENU = new StringBuilder();
	
	String getMainMenuMessage(){
		MAIN_MENU.append("Traffic Simulation \n\n");
		MAIN_MENU.append("Enter choice by number:\n");
		MAIN_MENU.append("1. Run Simulation.\n");
		MAIN_MENU.append("2. Change simulation parameter.\n");
		MAIN_MENU.append("3. Exit.\n");
		
		return MAIN_MENU.toString();
	}
	
	String getSubMenuMessage(){
		SUB_MENU.append("Enter choice by number:\n\n");
		SUB_MENU.append("1. Show current value.\n");
		SUB_MENU.append("2. Simulation runtime.\n");
		SUB_MENU.append("3. Grid size.\n");
		SUB_MENU.append("4. Set traffic pattern.\n");
		SUB_MENU.append("5. Set car entry rate.\n");
		SUB_MENU.append("6. Set car length.\n");
		SUB_MENU.append("7. Set max car velocity.\n");
		SUB_MENU.append("8. Set car stop distance.\n");
		SUB_MENU.append("9. Set car brake distance.\n");
		SUB_MENU.append("10. Set green traffic light time.\n");
		SUB_MENU.append("11. Set red traffic light time.\n");
		SUB_MENU.append("12. Reset to default value.\n");
		SUB_MENU.append("13. Return to main menu.");
		
		return SUB_MENU.toString();
	}
		
	String getExitMenuMessage(){
		EXIT_MENU.append("Are you sure?\n");
		EXIT_MENU.append("1. YES \n");
		EXIT_MENU.append("2. NO  \n");
		
		return EXIT_MENU.toString();
	}
}
