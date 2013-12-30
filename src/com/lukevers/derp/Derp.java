package com.lukevers.derp;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Derp extends JavaPlugin {
    
    private ArrayList <String> phrases = new ArrayList <String>();
    
    @Override
    public void onDisable() {
	getLogger().info("Derp commands disabled!");
    }
    
    @Override
    public void onEnable() {
	getLogger().info("Derp commands enabled!");
    }
    
    @Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
	new Commands(sender, cmd.getName(), args, this.phrases);
	return true;
    }
}
