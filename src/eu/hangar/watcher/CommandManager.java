package eu.hangar.watcher;

import java.util.ArrayList;
import java.util.Collections;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;


import eu.hangar.watcher.cmds.report;




public class CommandManager implements CommandExecutor{
	private ArrayList<GameCommand> cmds;
	
	protected CommandManager(){

		cmds = new ArrayList<>();
		cmds.add(new report());

		}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args){
		
		if(!(sender instanceof Player)){
			sender.sendMessage(ChatColor.RED + "You are not a player!");
			return true;
		}
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("PW")){
			if(args.length==0){
				for (GameCommand gcmd : cmds){
					CommandInfo info = gcmd.getClass().getAnnotation(CommandInfo.class);
					p.sendMessage(ChatColor.GOLD + "/pw (" + StringUtils.join(" ", info.aliases(), " ").trim() + ", )" + "Usage - (" + info.usage() + ")" + ChatColor.GOLD + "Command Info" + info.description() );
					}
				return true;
			}
			GameCommand wanted = null;
			for (GameCommand gcmd : cmds){
				CommandInfo info = gcmd.getClass().getAnnotation(CommandInfo.class);
				for (String alias : info.aliases()){
					if(alias.equals(args[0])){
						wanted = gcmd;
					}
				}
					
				}
			if (wanted ==  null){
				p.sendMessage(ChatColor.RED + "Could not find command.");
				return true;
			};	
			if (wanted.getClass().getAnnotation(CommandInfo.class).op() && !p.isOp()) {
				p.sendMessage(ChatColor.RED + "You don't have permission to use this command.");
				return true;
			}

			ArrayList<String> newArgs = new ArrayList<String>();
			Collections.addAll(newArgs, args);
			newArgs.remove(0);
			args = newArgs.toArray(new String[newArgs.size()]);
			
			wanted.onCommand(p, args);
		}

		return true;
	}

}