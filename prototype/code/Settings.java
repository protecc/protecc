import java.util.Arrays;

public class Settings {

	private Setting[] settingsList;

	public Settings() {
		settingsList = new Setting[0];
	}

	public void addSetting(Setting newSetting) {
		settingsList = Arrays.copyOf(settingsList, settingsList.length + 1);
		settingsList[settingsList.length - 1] = newSetting;
	}

	public Setting[] getSettingsList() {
		return settingsList;
	}
}