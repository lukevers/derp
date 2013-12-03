package com.github.lukevers.derp;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Derp extends JavaPlugin {
    
    Logger log = Logger.getLogger("Minecraft");
    ArrayList <String> list = new ArrayList <String>();
    
    @Override
    public void onDisable() {
	log.info("Derp commands disabled!");
    }
    
    @Override
    public void onEnable() {
	log.info("Derp commands enabled!");
	new CheckFile(doublederps);
    }//close onEnable
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
	new Commands(sender, cmd.getName(), sender.getName(), args, list);
	return true;
    }
    
}
