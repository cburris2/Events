package edu.unca.rbruce.EventTutorial;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.google.common.base.Joiner;

/*
 * This is a sample CommandExectuor
 */
public class EventTutorialCommandExecutor implements CommandExecutor {
	private final EventTutorial plugin;

	/*
	 * This command executor needs to know about its plugin from which it came
	 * from
	 */
	public EventTutorialCommandExecutor(EventTutorial plugin) {
		this.plugin = plugin;
	}

	/*
	 * On command set the sample message
	 */
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (sender.hasPermission("sample.message") && args.length > 0) {
			this.plugin.getConfig().set("sample.message",
					Joiner.on(' ').join(args));
			return true;
		} else {
			return false;
		}
	}

}
