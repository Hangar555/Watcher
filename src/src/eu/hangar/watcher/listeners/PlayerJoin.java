package eu.hangar.watcher.listeners;



import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import eu.hangar.watcher.Main;

public class PlayerJoin implements Listener {
	

		@EventHandler
		public void onPlayerJoin(PlayerJoinEvent e) {
	          
	            
	            if (Main.plugin.getConfig().getBoolean("Message") != true){
	            	e.setJoinMessage(null);
	           
	            	
	            }
	            if (!e.getPlayer().hasPlayedBefore()) 
	            	if(Main.plugin.getConfig().getBoolean("Message") != false){
	          e.setJoinMessage(ChatColor.RED + "" + ChatColor.BOLD + "[Admin]" + ChatColor.RESET + " Watcher" +ChatColor.GRAY + ": " + ChatColor.WHITE + "Welcome " + e.getPlayer().getName() + " to this server");
	            	}else{
	            	
	            	}
	            
		   if (e.getPlayer().hasPlayedBefore()){
			   if(Main.plugin.getConfig().getBoolean("Message") != false){
		   
		          e.setJoinMessage(ChatColor.RED + "" + ChatColor.BOLD + "[Admin]" + ChatColor.RESET + " Watcher" +ChatColor.GRAY + ": " + ChatColor.WHITE + "Welcome back " + e.getPlayer().getName());
			   }return;
	}
	
		}
}

	



