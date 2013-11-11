package com.gmail.thegurugamers;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Commands implements CommandExecutor {
	
	ChatColor red = ChatColor.DARK_RED;
	
	public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args){
		Player p = (Player) sender;
		ItemStack item = new ItemStack(p.getInventory().getItemInHand());
		ItemMeta itemMeta = item.getItemMeta();
		
		StringBuilder str = new StringBuilder();
		for (int i = 1; i < args.length; i++){
			str.append(args[i] + " ");
		}
	      
		String dname = str.toString();
		//String lname = str.toString();
	      
		if (!(item.getType() == Material.AIR)){
			itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', dname));
			//itemMeta.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', lname)));
			itemMeta.setLore(Arrays.asList(ChatColor.GREEN + "Owner: " + ChatColor.RED + p.getName()));
			item.setDurability(item.getDurability());
		}
	      
		if (sender instanceof Player){
			if (commandLabel.equalsIgnoreCase("item")) {
				if (p.hasPermission("renamer.rename")){
					if (args.length > 1){
						if (args[0].equalsIgnoreCase("rename")){
							if (!(item.getType() == Material.AIR)){
								p.getInventory().removeItem(item);
	    				  		p.sendMessage(ChatColor.AQUA + "You renamed your " + ChatColor.RED + 
	    				  				item.getType() + ChatColor.AQUA + " to " + ChatColor.WHITE + 
	    				  				ChatColor.translateAlternateColorCodes('&', dname)); 
	    				  		item.setItemMeta(itemMeta);
	    				  		p.getInventory().addItem(item);
					
							}else{
								p.sendMessage(red + "You must have an item in hand to do that!");
							}
						}else{
							
						}
	    			  
					}else{
						sender.sendMessage(red + "Not enough arguments! Try /rename <name>");
					}
	    		  
				}else{
					sender.sendMessage(red + "You don't have permission to rename your item :(");
				}
			}
	    	  
		}else{
			sender.sendMessage(red + "You must be a player in order to use that command!");
		}
	      
		return false;
	}		
}