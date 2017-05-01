package eu.hangar.watcher.listeners;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import eu.hangar.watcher.Main;



public class filter implements Listener {

	  FileConfiguration config = Main.plugin.getConfig();
	  List<String> Blacklist = Main.plugin.getConfig().getStringList("Blacklist");
	 
	  @EventHandler
	  

	  
	  public void playerChatEvent(AsyncPlayerChatEvent event)
	  {
	    for (String Blacklist : this.Blacklist) {
	      if (event.getMessage().toLowerCase().contains(Blacklist.toLowerCase()))
	      {
	        event.setCancelled(true);
	        
		        
		        Bukkit.broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD  +"[Admin]"+ ChatColor.RESET +" Watcher" + ChatColor.GRAY + ": " + ChatColor.RED + event.getPlayer().getName() +   " Do not swear! ");
		        Bukkit.broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD  +"[Admin]" + ChatColor.RESET +" Watcher" + ChatColor.GRAY + ": " + ChatColor.RED + event.getPlayer().getName() +   " Bypassing the filter will result in a mute!");
	       
	        }
	        	
	        }
	      }
	    
	  }


