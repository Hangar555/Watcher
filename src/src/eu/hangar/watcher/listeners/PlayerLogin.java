package eu.hangar.watcher.listeners;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import eu.hangar.watcher.Main;





public class PlayerLogin implements Listener {
	






	
		    

	  

	  
		  
		
		  
		
		 

	
    @EventHandler (priority=EventPriority.HIGHEST)
    
    public void onPlayerLogin( PlayerLoginEvent e)  {
    	if(e.getPlayer().isOnline()){
    		e.getPlayer().kickPlayer(ChatColor.RED + "Another player with that name is already online!");
    	}
        if (e.getResult() == Result.KICK_BANNED) {
           
			e.setKickMessage(ChatColor.RED + e.getPlayer().getName()  + ", you're permanently banned from " + Main.plugin.getConfig().getString("ServerName")  + "   "
					+ ChatColor.GREEN	+ " If you wish to appeal go to " + Main.plugin.getConfig().getString("Appeal")+"." + 
					  " The appeal code for permanent bans is: " + Main.plugin.getConfig().getString("PermBanCode")  );
           
             
    	
    	/*if(e.getPlayer().isBanned()){
    		e.getPlayer().kickPlayer(ChatColor.RED + "You are permanently banned! if you wish to appeal go to" + ChatColor.GREEN + Main.plugin.getConfig().getString("Appeal"));
    		*/
    	}
    
}
    }

