package com.lukevers.derp;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Derp extends JavaPlugin {
    
    private ArrayList <String> phrases = new ArrayList <String>();
    private FileConfiguration config;
    
    @Override
    public void onDisable() {
	getLogger().info("Derp commands disabled!");
	saveConfig();
    }
    
    @Override
    public void onEnable() {
	getLogger().info("Derp commands enabled!");
	config = getConfig();
	reloadConfig();
    }
    
    @Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
	reloadConfig();
	new Commands(sender, cmd.getName(), args, this.phrases, this.config);
	saveConfig();
	return true;
    }
}
