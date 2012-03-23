package com.github.lukevers.derp;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Commands {

	public Commands(CommandSender sender, String cmd, String name, String [] args, ArrayList <String> doublederps) {
		if (args.length == 0) {
			new CMD_Derp(doublederps, sender, name);
		}//close args length of 0
		
		else if (args.length == 1) {
			
			if (args[0].equalsIgnoreCase("list") || args[0].equalsIgnoreCase("ls"))
				new CMD_Ls(sender, doublederps);
			
			else if (args[0].equalsIgnoreCase("reload"))
				new CMD_Reload(sender, doublederps);
			
			else if (args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("h"))
				new CMD_Help(sender);
			
			else if (args[0].equalsIgnoreCase("add"))
				sender.sendMessage(ChatColor.RED+"You must provide a derpy text!");
				
			// ---- KEEP THIS ONE LAST ----
			else new CMD_Derp(doublederps, sender, args[0]);
			
		}//close args length of 1
		
		else if (args.length >= 2) {
			new CMD_Add(sender, args, doublederps);
		}//close args length of 2
		
	}//close constructor
	
}//close Commands
