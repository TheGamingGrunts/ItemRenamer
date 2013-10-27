/*
 * Copyright 2013 Daniel S. and all contributors
 * Do not redistribute any of the code in this project without
 * explicitly asking the owner first
 * 
 */

package com.gmail.thegurugamers;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public void onEnable(){
		getCommand("item").setExecutor(new Commands());
	}
	
	public void onDisable(){
		
	}	
}