package com.github.lukevers.derp;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class CMD_Add {

	public CMD_Add (CommandSender sender, String [] args, ArrayList <String> doublederps) {
		if (sender.hasPermission(new Permissions().derp_add)) {
    		String toAdd="";
            for (int i=1;i<args.length;i++)
                toAdd+=" "+args[i];
            toAdd=toAdd.substring(1);
            if (!doublederps.contains(toAdd)) {
                doublederps.add(toAdd);
                new AppendFile(toAdd, doublederps);
                sender.sendMessage(toAdd+" was added to the list of derps!");
            	}
            else sender.sendMessage("Derp! This derpy text has already been added to the list!");
    		}
    	else sender.sendMessage(ChatColor.RED + "You do not have permission to do this!");   

	}//close constructor

}//close CMD_Add
