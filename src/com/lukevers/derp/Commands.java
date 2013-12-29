package com.lukevers.derp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;

@SuppressWarnings("serial")
    public class Commands implements Serializable {
	
	private ArrayList <String> phrases;
	private FileConfiguration config;
	
	/**
	 * Permissions
	 */
	private Permission add = new Permission("derp.add","Adds a derp to the list",PermissionDefault.OP);
	private Permission remove = new Permission("derp.remove","Removes a derp from the list",PermissionDefault.OP);
	
	/**
	 * Commands
	 * 
	 * @param sender
	 * @param cmd
	 * @param name
	 * @param args
	 * @param list
	 */
	public Commands(CommandSender sender, String cmd, String [] args, ArrayList <String> phrases, FileConfiguration config) {
	    this.phrases = phrases;
	    this.config = config;
	    if (args.length == 0) {
    		SendDerp(sender, sender.getName());
	    } else if (args.length > 0) {
    		if (args[0].equalsIgnoreCase("list"))
		    ListDerps(sender);
    		else if (args[0].equalsIgnoreCase("help"))
		    HelpDerp(sender);
    		else if (args[0].equalsIgnoreCase("add"))
		    AddDerp(sender, args);
    		else if (args[0].equalsIgnoreCase("remove")) 
		    RemoveDerp(sender, args);
    		else SendDerp(sender, args[0]);
		
	    } 
	}
	
	/**
	 * Add Derp
	 * 
	 * @param sender
	 * @param args
	 */
	private void AddDerp(CommandSender sender, String [] args) {
	    if (sender.hasPermission(this.add)) {
    		String derp = GetDerpFromArgs(args);
    		if (this.phrases.contains(derp)) {
		    sender.sendMessage(ChatColor.RED + "OH NO! This derp is already in the list!" + ChatColor.RESET);
    		} else {
		    config.set("Phrases", this.phrases);
    		}
	    } else {
    		sender.sendMessage(ChatColor.RED + "You do not have permission to do this!" + ChatColor.RESET);
	    }
	}
	
	/**
	 * Remove Derp
	 * 
	 * @param sender
	 * @param args
	 */
	private void RemoveDerp(CommandSender sender, String [] args) {
	    if (sender.hasPermission(this.remove)) {
    		String derp = GetDerpFromArgs(args);
    		if (this.phrases.contains(derp)) {
		    
    		} else {
		    sender.sendMessage(ChatColor.RED + "OH NO! This derp is not in the list!" + ChatColor.RESET);
    		}
	    } else {
    		sender.sendMessage(ChatColor.RED + "You do not have permission to do this!" + ChatColor.RESET);
	    }
	}
	
	/**
	 * Get Derp From Arguments
	 * 
	 * @param args
	 * @return derp
	 */
	private String GetDerpFromArgs(String [] args) {
	    String derp = "";
	    for (String s : args) 
		derp += s + " ";
	    return derp;
	}
	
	/**
	 * Help Derp
	 * 
	 * @param sender
	 */
	private void HelpDerp(CommandSender sender) {
	    sender.sendMessage(ChatColor.YELLOW + "== DERP HELP ==" + ChatColor.RESET);
	    sender.sendMessage(ChatColor.RED + "/derp" + ChatColor.RESET);
	    sender.sendMessage(ChatColor.RED + "/derp help" + ChatColor.RESET);
	    sender.sendMessage(ChatColor.RED + "/derp list" + ChatColor.RESET);
	    sender.sendMessage(ChatColor.RED + "/derp add [derp]" + ChatColor.RESET);
	    sender.sendMessage(ChatColor.RED + "/derp remove [derp]" + ChatColor.RESET);
	}
	
	/**
	 * List Derps
	 * 
	 * @param sender
	 */
	private void ListDerps(CommandSender sender) {
	    sender.sendMessage(ChatColor.YELLOW + "== POSSIBLE DERPS (%s refers to player) ==" + ChatColor.RESET);
	    for (String phrase : this.phrases) 
    		sender.sendMessage(ChatColor.RED + phrase + ChatColor.RESET);
	}
	
	/**
	 * Send Derp
	 * 
	 * @param sender
	 */
	private void SendDerp(CommandSender sender, String name) {
	    String derp = getRandomDerp();
	    if (derp.toLowerCase().contains("%s")) {
    		if (Bukkit.getOnlinePlayers().toString().contains(name))
		    Bukkit.getServer().broadcastMessage(String.format(derp, name));
    		else Bukkit.getServer().broadcastMessage(String.format(derp, sender.getName()));
	    } else {
    		Bukkit.getServer().broadcastMessage(derp);
	    }
	}
	
	/**
	 * Get Random Derp
	 * 
	 * @return random derp from list
	 */
	private String getRandomDerp() {
	    return this.phrases.size() > 0 ? this.phrases.get(new Random().nextInt(this.phrases.size())) : "";
	}
	
    }
