package eu.hangar.watcher.cmds;


import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import eu.hangar.watcher.CommandInfo;
import eu.hangar.watcher.GameCommand;
import eu.hangar.watcher.Main;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;

@CommandInfo(aliases = { "ban", "b" }, description = " Permban a player", op = false, usage = " 'ban' or 'b'")
public class ban extends GameCommand {
	public  HashMap<String, Integer> Bans = new HashMap<String, Integer>();

	
	
	@Override
	public void onCommand(Player p, String[] args) {
	
    if (p.hasPermission("watcher.ban")) {
        if (args.length == 2) {
        	  
       
        Player target = Bukkit.getServer().getPlayer(args[0]);
        OfflinePlayer offline = p.getServer().getOfflinePlayer(args[0]);
        if (target == null) {
           	  offline.setBanned(true); 
        this.Bans.put(offline.getUniqueId().toString(), 1);
            if(Main.plugin.getConfig().getBoolean("Message") == true){
            p.sendMessage(ChatColor.GREEN  + "Player banned succesfully");
            return;
        }else{
        	p.sendMessage(ChatColor.RED + " [Admin] " + ChatColor.RESET + " Watcher: " +ChatColor.GREEN + "The player " + offline.getName()+ " was banned succesfully");
        }
        if (target.isOp()) {
        	 p.sendMessage(ChatColor.RED + " [Admin] " + ChatColor.RESET + " Watcher: " +ChatColor.GRAY + "Tip:  You cannot ban OPERATORS (OPs)!");
            return;
        }
        target.kickPlayer(ChatColor.RED
        		+ "You have been banned  !");
        this.Bans.put(target.getUniqueId().toString(), 1);
        target.setBanned(true);
        if(Main.plugin.getConfig().getBoolean("Message") ==true){
       Bukkit.broadcastMessage(ChatColor.RED + " [Admin] " + ChatColor.RESET + " Watcher: " +ChatColor.GRAY + "The player " + target.getName()+ " was banned " );
    }else{
    	p.sendMessage(ChatColor.RED + " [Admin] " + ChatColor.RESET + " Watcher: " +ChatColor.GREEN + "The player " + target.getName()+ " was banned succesfully");
    }

    }

		
	}
}
	}
}
