package com.gmail.thegurugamers;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public void onEnable(){
		getCommand("rename").setExecutor(new Commands());
	}
	
	public void onDisable(){
		
	}	
}