package edu.unca.cburris.EventTutorial;

import org.bukkit.plugin.java.JavaPlugin;

/*
 * This is the main class of the sample plug-in
 */
public class EventTutorial extends JavaPlugin {
	/*
	 * This is called when your plug-in is enabled
	 */
	EventTutorialLogger logger;

	@Override
	public void onEnable() {
		// create a logger and use it
		logger = new EventTutorialLogger(this);
		logger.info("plugin enabled");

		// save the configuration file
		saveDefaultConfig();

		// Create the SampleListener
		new EventTutorialListener(this);

		// set the command executor for sample
		this.getCommand("sample").setExecutor(
				new EventTutorialCommandExecutor(this));
	}

	/*
	 * This is called when your plug-in shuts down
	 */
	@Override
	public void onDisable() {

	}

}
