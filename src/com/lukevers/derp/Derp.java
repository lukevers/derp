package com.lukevers.derp;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Derp extends JavaPlugin {
    
    private Commands c;

    @Override
    public void onDisable() {
	getLogger().info("Derp commands disabled!");
    }
    
    @Override
    public void onEnable() {
	getLogger().info("Derp commands enabled!");
	c.ReadFile();
    }
    
    @Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
	this.c = new Commands(sender, cmd.getName(), args);
	return true;
    }
}
