package com.github.lukevers.derp;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class CMD_Help {
	
	public CMD_Help (CommandSender sender) {
		
		sender.sendMessage(ChatColor.YELLOW + "========Derp Help========");
        sender.sendMessage(ChatColor.RED + "/derp - Let everyone know that you derped");
        sender.sendMessage(ChatColor.RED + "/derp" + ChatColor.BLUE + " [player]" + ChatColor.RED + " - Let everyone know that [player] derped");
        sender.sendMessage(ChatColor.RED + "/derp h - Shows the help menu!");
        sender.sendMessage(ChatColor.RED + "/derp help - Shows the help menu!");
        sender.sendMessage(ChatColor.RED + "/derp ls - Lists all the possible derps!");
        sender.sendMessage(ChatColor.RED + "/derp list - Lists all the possible derps!");
        if (sender.hasPermission(new Permissions().derp_add))
        	sender.sendMessage(ChatColor.RED + "/derp add " + ChatColor.BLUE + "<derp text>" + ChatColor.RED + " - Add new derp text");
        if (sender.hasPermission(new Permissions().derp_reload))
        	sender.sendMessage(ChatColor.RED + "/derp reload - Reloads the list of derp texts");

		
	}//close constructor

}//close CMD_Help
