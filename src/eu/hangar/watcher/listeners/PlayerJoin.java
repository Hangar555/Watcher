package eu.hangar.watcher.listeners;



import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
	

		@EventHandler
		public void onPlayerJoin(PlayerJoinEvent e) {
	          
	            
	            if (e.getPlayer().hasPermission("pw.join.null")){
	            	e.setJoinMessage(null);
	            }
	            if (e.getPlayer().hasPermission("pw.join.bypass")){
	            	
	            }
	            if (!e.getPlayer().hasPlayedBefore()) 
	          e.setJoinMessage(ChatColor.RED + "" + ChatColor.BOLD + "[Admin]" + ChatColor.RESET + " Watcher" +ChatColor.GRAY + ": " + ChatColor.WHITE + "Welcome " + e.getPlayer().getName() + " to this server");
	        
	            
		   if (e.getPlayer().hasPlayedBefore()) 
		          e.setJoinMessage(ChatColor.RED + "" + ChatColor.BOLD + "[Admin]" + ChatColor.RESET + " Watcher" +ChatColor.GRAY + ": " + ChatColor.WHITE + "Welcome back " + e.getPlayer().getName());
		
	}
	
		}

	



