package me.LIErZ.tierTestingProject.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class InventoryViewer implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 3){
            Player player = Bukkit.getPlayerExact(args[0]);
            if (player != null){
                int number = Integer.parseInt(args[1]);
                if (number <= 6 && number > 0) {
                    Inventory inventory = Bukkit.createInventory(player, Integer.parseInt(args[1]) * 9, args[2]);

                    player.openInventory(inventory);
                }
            }
        }
        else{
            if (sender instanceof Player player){
                player.sendMessage("/InventoryViewer (Player) (3) (Name)");
            }
        }

        return true;
    }
}
