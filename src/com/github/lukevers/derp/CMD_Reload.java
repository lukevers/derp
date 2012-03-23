package com.github.lukevers.derp;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class CMD_Reload {
	
	public CMD_Reload (CommandSender sender, ArrayList <String> doublederps) {
		
		if (sender.hasPermission(new Permissions().derp_reload)) {
    		doublederps.clear();
    		new AddToArrayList(doublederps);
    		sender.sendMessage("The list of derps have been reloaded!");
    		}
    	else sender.sendMessage(ChatColor.RED + "You do not have permission to do this!"); 
		
	}//close constructor
	
}//close CMD_Reload
