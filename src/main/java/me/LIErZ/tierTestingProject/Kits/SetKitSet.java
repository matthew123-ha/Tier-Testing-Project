package me.LIErZ.tierTestingProject.Kits;

import me.LIErZ.tierTestingProject.TierTestingProject;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SetKitSet {

    public static void SetKitMenuKits(String kitName, TierTestingProject tierTestingProject, Player player) {
        player.closeInventory();
        player.sendMessage(ChatColor.BLUE + "Successfully set kit");
        for (int i = 0; i <= 40; i++){
            ItemStack Item = player.getInventory().getItem(i);
            tierTestingProject.getConfig().set(kitName + "." + i, Item);
        }
    }

}