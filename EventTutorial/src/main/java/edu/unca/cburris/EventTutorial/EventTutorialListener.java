package edu.unca.cburris.EventTutorial;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.*;
import java.lang.*;
/*
 * This is a sample event listener
 */
public class EventTutorialListener implements Listener {
	private final EventTutorial plugin;

	/*
	 * This listener needs to know about the plugin which it came from
	 */
	public EventTutorialListener(EventTutorial plugin) {
		// Register the listener
		plugin.getServer().getPluginManager().registerEvents(this, plugin);

		this.plugin = plugin;
	}

	/*
	 * Send the sample message to all players that join
	 */
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		event.getPlayer().sendMessage(
				this.plugin.getConfig().getString("sample.message"));
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onBlockPlace(BlockPlaceEvent event) {
		if (event.isCancelled())
			return;

		if (event.getBlock().getType() == Material.IRON_SWORD) {
			

			Player player = event.getPlayer();

			player.sendMessage(ChatColor.AQUA
					+ "Iron Sword Equipped");

			for (Player onLinePlayer : Bukkit.getServer().getOnlinePlayers()) {
				if (onLinePlayer.isOp()) {
					onLinePlayer.sendMessage(player.getName()
							+ "is ready for battle.");
				}
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		String spawn = "just got out of bed";
		String food = "is a survivor and has plenty of grub";
		Location l = event.getPlayer().getLocation();
		
		Player p = event.getPlayer();
		if (event.isBedSpawn()){
			
			System.out.println(p.getDisplayName() + spawn);
			return;
		}
			else if (!event.isBedSpawn() ) {
			p.setFoodLevel(100);
			System.out.println(p.getDisplayName() + food);
		}
			else {
			Player pn = event.getPlayer();	
			pn.sendMessage("Go fight!");
			}
	}
}
