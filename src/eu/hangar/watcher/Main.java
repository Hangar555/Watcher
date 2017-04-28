package eu.hangar.watcher;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import eu.hangar.watcher.ac.KillAura;
import eu.hangar.watcher.listeners.PlayerJoin;
import eu.hangar.watcher.listeners.PlayerLogin;
import eu.hangar.watcher.listeners.filter;

	public class Main extends JavaPlugin {

		 
public static Main plugin;


		public void onEnable(){

			
		
			plugin = this;

			  
	getCommand("pw").setExecutor(new CommandManager());
			
			PluginManager pm = Bukkit.getServer().getPluginManager();
			
			pm.registerEvents(new PlayerJoin(), this) ;	
			pm.registerEvents(new PlayerLogin(), this) ;	
			pm.registerEvents(new filter(), this) ;
			pm.registerEvents(new KillAura(), this) ;
		  
			  getConfig().options().copyDefaults(true);
			    saveConfig();
			    reloadConfig();


		}
}
