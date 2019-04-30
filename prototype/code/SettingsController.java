import java.util.Scanner;

public class SettingsController {
	private Settings settings;

	public SettingsController() {
		settings = new Settings();
	}

	public void initializeSettings() {
		settings.addSetting(new Setting("setting placeholder1", 10));
		settings.addSetting(new Setting("setting placeholder2", 20));
		settings.addSetting(new Setting("setting placeholder3", 30));
		settings.addSetting(new Setting("setting placeholder4", 40));
		settings.addSetting(new Setting("setting placeholder5", 50));
	}

	public void settingsMenu() {
		Scanner input = new Scanner(System.in);
		String settingsName;
		int settingsValue;

		System.out.println("Settings Menu:");
		System.out.println("Type \"help\" for commands.");

		while (true) {
			System.out.print(">>> ");
         	String command = input.nextLine();

         	switch (command.toLowerCase()) {
         		case "help":
         			help();
         			break;
         		case "show settings":
         			showSettings();
         			break;
         		case "adjust settings":
         			System.out.print("Enter the settings name: ");
         			settingsName = input.nextLine();
         			System.out.print("Enter the settings value: ");
         			settingsValue = Integer.parseInt(input.nextLine());
         			adjustSettings(settingsName, settingsValue);
         			break;
         		case "exit":
         			System.out.println("Type \"help\" for commands.");
         			return;
         		default:
         			System.out.println("Invalid command. Type \"help\" for commands.");
         	}
		}
	}

	public void showSettings() {

		if (settings.getSettingsList().length > 0) {
			
			for (Setting setting : settings.getSettingsList()) {

				System.out.println("Setting name: " + setting.getName() + "\n" 
				+ "Setting value: " + setting.getValue());
			}
		}
		else {
			System.out.println("Error - There are no settings.");
		}
	}

	public void adjustSettings(String name, int value) {

		if (containsSetting(name)) {
			
			for (Setting setting : settings.getSettingsList()) {

				if (setting.getName().equals(name)) {
					setting.setValue(value);
				}
			}
		}
		else {
			System.out.println("Error - No setting with name " + name);
		}
	}

	public boolean containsSetting(String name) {

		if (settings.getSettingsList().length > 0) {

			for (Setting setting : settings.getSettingsList()) {
				if (setting.getName().equals(name)) {
					return true;
				}
			}
			return false;
		}
		else {
			System.out.println("Error - there are no settings.");
			return false;
		}
	}

	public void help() {
		System.out.println("\nCommands: ");
		System.out.println("show settings - show the settings and their current values.");
		System.out.println("adjust settings - enter a setting name and change its value.");
		System.out.println("exit - leave settings menu.\n");

	}
}