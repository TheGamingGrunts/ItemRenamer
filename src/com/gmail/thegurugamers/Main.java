/*
 * Copyright 2013 Daniel S. and all contributors
 * Do not redistribute any of the code in this project without
 * explicitly asking the owner first
 * 
 */

package com.gmail.thegurugamers;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.inventory.meta.ItemMeta;

public class Main extends JavaPlugin implements Listener {
	int i = 0;
	
	public void onEnable(){
		getCommand("item").setExecutor(new Commands());
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	public void onDisable(){
		
	}	
	
	@EventHandler
	public void onPickup(PlayerPickupItemEvent event){
		ItemStack item = event.getItem().getItemStack();
		ItemMeta meta = item.getItemMeta();
		Player p = event.getPlayer();
		
		if (!(meta.getLore() == null)){
			if (!(meta.getLore().contains(ChatColor.GREEN + "Owner: " + ChatColor.RED + p.getDisplayName()))){	
				event.setCancelled(true);
				i++;
				
				if (i < 1){
					p.sendMessage(ChatColor.RED + "You cannot pickup an item that isn't yours!");
					
				}else{
					
				}
				
			}else{
				p.sendMessage(ChatColor.AQUA + "You picked up your " + ChatColor.RED + meta.getDisplayName());
			}
		}else{
			p.sendMessage("DEBUG: no item lore :(");
		}
	}	
}