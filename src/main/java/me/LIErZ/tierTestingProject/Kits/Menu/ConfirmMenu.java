package me.LIErZ.tierTestingProject.Kits.Menu;

import me.LIErZ.tierTestingProject.TierTestingProject;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogRecord;

public class ConfirmMenu {

    public static final String ConfirmMenuTitle = "Are you suree????";
    public static final ChatColor ConfirmMenuColor = ChatColor.GREEN;

    public static void menu(Player player, TierTestingProject tierTestingProject, String name){
        Inventory inventory = Bukkit.createInventory(player, 27, ConfirmMenuColor + ConfirmMenuTitle);

        ItemStack confirm = new ItemStack(Material.GREEN_WOOL);
        ItemStack deny = new ItemStack(Material.RED_WOOL);
        ItemMeta confirmItemMeta = confirm.getItemMeta();
        ItemMeta denyItemMeta = deny.getItemMeta();
        confirmItemMeta.setDisplayName("Are you sure?");
        denyItemMeta.setDisplayName("Deny");
        List<String> confirmLore = new ArrayList<>();
        List<String> denyLore = new ArrayList<>();
        confirmLore.add("Click this to change your kit");
        denyLore.add("Click this to deny your changes");
        denyItemMeta.setLore(denyLore);
        confirmItemMeta.setLore(confirmLore);
        confirm.setItemMeta(confirmItemMeta);
        deny.setItemMeta(denyItemMeta);

        inventory.setItem(12, deny);
        inventory.setItem(14, confirm);

        player.openInventory(inventory);
    }

}
