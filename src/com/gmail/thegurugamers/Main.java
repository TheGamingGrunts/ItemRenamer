package com.gmail.thegurugamers;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public void onEnable(){
		getCommand("item").setExecutor(new Commands());
	}
	
	public void onDisable(){
		
	}	
}