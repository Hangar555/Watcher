package eu.hangar.watcher.cmds;


import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import eu.hangar.watcher.CommandInfo;
import eu.hangar.watcher.GameCommand;

@CommandInfo(aliases = { "report", "r" }, description = " Report a player", op = false, usage = "  'report' or 'r' + p (must contain p  )")
public class report extends GameCommand{



	HashMap<String, Integer> Reports = new HashMap<String, Integer>();


	@Override
	
	public void onCommand(Player p, String[] args) {
		
	
if(args.length == 2){
		      
		        Player target = Bukkit.getPlayer(args[1]);
		        if (args[0].equals("p")) {
		          if (target != null)
		          {
		            if (!this.Reports.containsKey(args[1]))
		            {
		              p.sendMessage(ChatColor.BLUE + target.getName() + " was reported. Report ID " + target.getUniqueId());
		              this.Reports.put(target.getName().toString(), 1);
		            }
		            else
		            {
		              p.sendMessage(ChatColor.RED + "The player"+ target.getDisplayName().toUpperCase()+""+" was alredy reported before!" );
		              Bukkit.broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD  +"[Admin]" + ChatColor.RESET +" Watcher" + ChatColor.GRAY + ":" + ChatColor.RED  +"Player " +  target.getName().toLowerCase() +   " you have been reported twice or more times. ");
		              Bukkit.broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD  +"[Admin]" + ChatColor.RESET +" Watcher" + ChatColor.GRAY + ": " + ChatColor.RED + target.getName().toLowerCase() +   " you are under observation now!");
		              
		              for(Player staff : Bukkit.getOnlinePlayers()){
		            	  
		                  if(staff.hasPermission("watcher.staff")){
		                	  staff.sendMessage(ChatColor.GREEN + "Player " +  ChatColor.GOLD+target.getName() +ChatColor.GREEN +" with UUID: " + ChatColor.GOLD  + target.getUniqueId() + "has been reported a lot of times!");
		                  }
		       
		              }
		            }
		          }
		       
		      
	}
	}
	}
	}

	



