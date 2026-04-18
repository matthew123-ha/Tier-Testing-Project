package me.LIErZ.tierTestingProject.Kits.KitCommands;

import me.LIErZ.tierTestingProject.TierTestingProject;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class KitMenu {

    public static void KitMenu(String kitName, TierTestingProject tierTestingProject, Player player, Boolean SetKit) {
        Inventory inventory = Bukkit.createInventory(player, 45, ChatColor.GREEN + kitName);
        if (!SetKit) {
            if (tierTestingProject.getConfig().contains(ChatColor.stripColor(player.getDisplayName()) + ".kits." + kitName)) {
                for (int i = 0; i <= 40; i++) {
                    ItemStack itemStack = tierTestingProject.getConfig().getItemStack(ChatColor.stripColor(player.getDisplayName()) + ".kits." + kitName + "." + i);
                    inventory.setItem(i, itemStack);
                }
            }
            else{
                for (int i = 0; i <= 40; i++) {
                    ItemStack itemStack = tierTestingProject.getConfig().getItemStack(kitName + "." + i);
                    inventory.setItem(i, itemStack);
                }
            }
        }
        else{
            for (int i = 0; i <= 40; i++){
                ItemStack itemStack = tierTestingProject.getConfig().getItemStack(kitName + "." + i);
                inventory.setItem(i, itemStack);
            }
        }
    }
}
