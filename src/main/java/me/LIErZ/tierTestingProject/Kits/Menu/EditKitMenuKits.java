package me.LIErZ.tierTestingProject.Kits.Menu;

import me.LIErZ.tierTestingProject.TierTestingProject;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EditKitMenuKits {

    public static final ChatColor color = ChatColor.YELLOW;

    public static void KitMenu(String name, TierTestingProject tierTestingProject, Player player, String EditKitMenu) {
        Inventory inventory = Bukkit.createInventory(player, 45, ChatColor.GOLD + EditKitMenu);
        ItemStack Confirm = new ItemStack(Material.GREEN_WOOL);
        ItemStack Deny = new ItemStack(Material.RED_WOOL);
        ItemStack Reset = new ItemStack(Material.YELLOW_WOOL);

        ItemMeta confirmItemMeta = Confirm.getItemMeta();
        ItemMeta denyItemMeta = Deny.getItemMeta();
        ItemMeta resetItemMeta = Reset.getItemMeta();

        confirmItemMeta.setDisplayName(ChatColor.GREEN + "Click to Confirm");
        denyItemMeta.setDisplayName(ChatColor.RED + "Click to Deny");
        resetItemMeta.setDisplayName(ChatColor.YELLOW + "Click to Reset to defaults");

        Confirm.setItemMeta(confirmItemMeta);
        Deny.setItemMeta(denyItemMeta);
        Reset.setItemMeta(resetItemMeta);

        inventory.setItem(44, Deny);
        inventory.setItem(43,  Reset);
        inventory.setItem(42, Confirm);

        if (tierTestingProject.getConfig().contains(name)) {
            if (!tierTestingProject.getConfig().contains(player.getDisplayName() + ".Kits." + name)) {
                for (int i = 0; i <= 40; i++) {
                    ItemStack kit = tierTestingProject.getConfig().getItemStack(name + "." + i);
                    inventory.setItem(i, kit);
                }
            }
            else {
                for (int i = 0; i <= 40; i++){
                    ItemStack kit = tierTestingProject.getConfig().getItemStack(player.getDisplayName() + ".Kits." + name + "." + i);
                    inventory.setItem(i, kit);
                }
            }
        }

        tierTestingProject.getConfig().set(player.getDisplayName() + ".in-KitEditMenu", name);
        tierTestingProject.saveConfig();

        player.openInventory(inventory);
    }

    public static void ResetKitMenu(String name, TierTestingProject tierTestingProject, Player player, String EditKitMenu) {
        Inventory inventory = Bukkit.createInventory(player, 45, ChatColor.GOLD + EditKitMenu);
        for (int i = 0; i <= 40; i++){
            ItemStack kit = tierTestingProject.getConfig().getItemStack(name + "." + i);
            inventory.setItem(i, kit);
        }
    }
}