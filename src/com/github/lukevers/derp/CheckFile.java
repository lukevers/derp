package com.github.lukevers.derp;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class CheckFile {
	
	Plugin config = Bukkit.getServer().getPluginManager().getPlugin("Derp");
	File f = new File(config.getDataFolder()+File.separator+"ListOfDerps.txt");
	File f2 = new File(config.getDataFolder()+File.separator+"config.yml");
	
	public CheckFile (ArrayList <String> doublederps) {
		if (!f.exists()) {
			try {
				config.saveConfig();
				f.createNewFile();
				FileOutputStream fos = new FileOutputStream(config.getDataFolder()+File.separator+"ListOfDerps.txt");
				String LOLDERPP = "%s derped!\nNo one derps as hard as %s!";
				fos.write(LOLDERPP.getBytes());
				fos.close();
				new AddToArrayList(doublederps);
				f2.delete();
				}//close try try try
			catch (Exception e) {} //exceptions can kiss my ass
		}//close not existant if yeah booo

	}//close constructor
	
}// close CheckFile
