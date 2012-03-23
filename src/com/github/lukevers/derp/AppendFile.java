package com.github.lukevers.derp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class AppendFile {
	
	Plugin config = Bukkit.getServer().getPluginManager().getPlugin("Derp");
	
	public AppendFile (String s, ArrayList <String> doublederps) {
        try {
        	String newstring = "";
        	for (String _oranges : doublederps) newstring+=_oranges+"\n";
            BufferedWriter out = new BufferedWriter(new FileWriter(config.getDataFolder()+File.separator+"ListOfDerps.txt"));
            out.write(newstring);
            out.close();
            }
        catch (Exception e) {
            e.printStackTrace();
            }
        }//close constructor

}//close AppendFile
