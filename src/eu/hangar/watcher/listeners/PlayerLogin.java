package eu.hangar.watcher.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import eu.hangar.watcher.Main;
import net.md_5.bungee.api.ChatColor;

public class PlayerLogin implements Listener {

    @EventHandler (priority=EventPriority.HIGHEST)
    public void onPlayerLogin( PlayerLoginEvent e)  {
    	if(e.getPlayer().isOnline()){
    		e.getPlayer().kickPlayer(ChatColor.RED + "Another player with that name is already online!");
    	}
    	if(e.getPlayer().isBanned()){
    		e.getPlayer().kickPlayer(ChatColor.RED + "You are permanently banned! if you wish to appeal go to" + ChatColor.GREEN + Main.plugin.getConfig().getString("Appeal"));
    		
    	}
    	
    }
}
