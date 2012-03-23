package com.github.lukevers.derp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class AddToArrayList {
	
	Plugin config = Bukkit.getServer().getPluginManager().getPlugin("Derp");
	
	public AddToArrayList(ArrayList <String> doublederps) { 
        try {
            FileInputStream fstream = new FileInputStream(config.getDataFolder()+File.separator+"ListOfDerps.txt"); 
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                doublederps.add(strLine);
                }
            in.close();
            fstream.close();
            br.close();
            } 
        catch (Exception e) {
            e.printStackTrace();
            }
         }//close constructor
	
}//close AddToArrayList
