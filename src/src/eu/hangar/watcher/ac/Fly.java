package eu.hangar.watcher.ac;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffectType;



public class Fly implements Listener {
	
	  @EventHandler
	    public void onFlyHack(PlayerMoveEvent e) {
	        Player player = e.getPlayer();   

	            if((e.getTo().getY() - e.getFrom().getY()) >= 1.5) {
	                player.teleport(e.getFrom());
	            }
	            }
	        //The following thing doesn't work. But, eh, it's cool
	    
	@EventHandler
	public void Flying(PlayerMoveEvent e){
		Player p = e.getPlayer();
		if(!p.isOp()){
			if(!p.hasPermission("watcher.fly.bypass")){
				if(p.getGameMode().equals(0)){

				if(!p.getAllowFlight() == false){
				if(p.isFlying()){
					if(!p.hasPotionEffect(PotionEffectType.JUMP)){
						if(!p.hasPotionEffect(PotionEffectType.LEVITATION)){
							p.kickPlayer(ChatColor.RED + "Kicked for Flying by Watcher");
						}return;
					}return;
				}return;
			}return;
		}return;
	}return;
}return;
		
	}
	}
