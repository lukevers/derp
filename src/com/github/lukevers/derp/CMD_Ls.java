package com.github.lukevers.derp;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class CMD_Ls {
	
	public CMD_Ls (CommandSender sender, ArrayList <String> doublederps){
    	sender.sendMessage(ChatColor.YELLOW + "====Possible Derps (%s refers to [player])====");
    	for (int i=0;i<doublederps.size();i++)
    		sender.sendMessage(ChatColor.RED + doublederps.get(i));
	}//close constructor
	
}//close CMD_Ls
