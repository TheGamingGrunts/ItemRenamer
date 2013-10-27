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
	
	public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args){
		Player p = (Player) sender;
		ItemStack item = new ItemStack(p.getInventory().getItemInHand());
		ItemMeta itemMeta = item.getItemMeta();
		
		StringBuilder str = new StringBuilder();
	      for (int i = 0; i < args.length; i++){
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
	      
	      if (commandLabel.equalsIgnoreCase("rename")) {
	    	  if (p.hasPermission("renamer.rename")){
	    		  if (args.length > 0){
					if (sender instanceof Player) {
						if (!(item.getType() == Material.AIR)){
							p.getInventory().removeItem(p.getInventory().getItemInHand());
							p.sendMessage(ChatColor.AQUA + "You renamed your " + ChatColor.RED + 
								item.getType() + ChatColor.AQUA + " to " + ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', dname)); 
							item.setItemMeta(itemMeta);
							p.getInventory().addItem(item);
					
						}else{
							p.sendMessage(ChatColor.DARK_RED + "You must have an item in hand to do that!");
						}
				
					}else{
						sender.sendMessage(ChatColor.DARK_RED + "Must be a player to use that command!");
					}
				}else{
					sender.sendMessage(ChatColor.DARK_RED + "Not enough arguments! Try /rename <name>");
				}
				
			}else{
				sender.sendMessage(ChatColor.DARK_RED + "You don't have permission to rename that item :(");
			}
		}
		
		/*if (commandLabel.equalsIgnoreCase("setlore")){
			if (args.length > 0){
				if (sender instanceof Player){
					if (!(item == null)){
						item.setItemMeta(itemMeta);
						
					}
				}
			}
		}*/
		
		return false;
	}		

}
