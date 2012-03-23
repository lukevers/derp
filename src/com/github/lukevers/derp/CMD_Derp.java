package com.github.lukevers.derp;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

public class CMD_Derp {
	
	public CMD_Derp (ArrayList <String> doublederps, CommandSender sender, String name) {
		String derp = new GetRandomDerp().getRandomDerp(doublederps);
		if (derp.toLowerCase().contains("%s"))
			if (Bukkit.getServer().getOnlinePlayers().toString().contains(name))
				Bukkit.getServer().broadcastMessage(String.format(derp, name));
			else Bukkit.getServer().broadcastMessage(String.format(derp, sender.getName()));
    	else Bukkit.getServer().broadcastMessage(derp);
	}//close constructor
	
}//close CMD_Derp
