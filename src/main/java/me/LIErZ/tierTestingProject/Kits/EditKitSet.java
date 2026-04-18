package me.LIErZ.tierTestingProject.Kits;

import me.LIErZ.tierTestingProject.TierTestingProject;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class EditKitSet {

    public static void EditKit(String kitName, TierTestingProject tierTestingProject, Player player, Boolean SetKit){
        tierTestingProject.getConfig().set(ChatColor.stripColor(player.getDisplayName()) + ".kits." + kitName, "");
        for (int i = 0; i <= 40; i++){
            ItemStack Item = player.getInventory().getItem(i);
            tierTestingProject.getConfig().set(ChatColor.stripColor(player.getDisplayName()) + ".kits." + kitName + "." + i, Item);
        }
    }
}
