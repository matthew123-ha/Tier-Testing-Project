package me.LIErZ.tierTestingProject.Duels;

import me.LIErZ.tierTestingProject.TierTestingProject;
import me.LIErZ.tierTestingProject.world.CreateWorld;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class InQueue {

    private final ArrayList<Player>[] arrayLists;

    public InQueue(ArrayList<Player>[] arrayLists) {
        this.arrayLists = arrayLists;
    }

    public void Queue(Player player, TierTestingProject tierTestingProject, File source, File destination, String name, ArrayList<Player> InQueue, Boolean Ranked) throws IOException {
        player.closeInventory();
        if (!InQueue.contains(player)) {
            SetFalse(player);
            InQueue.add(player);
            if (InQueue.size() > 1) {
                Random random = new Random();
                int i = random.nextInt(InQueue.size());
                while (InQueue.get(i) == player) {
                    i = random.nextInt(InQueue.size());
                }
                Player targetPlayer = InQueue.get(i);
                CreateWorld.CreateTheWorld(source, destination, player, tierTestingProject, targetPlayer, Ranked);
                InQueue.remove(targetPlayer);
                InQueue.remove(player);
                player.sendMessage(ChatColor.BLUE + "Match Found");
                targetPlayer.sendMessage(ChatColor.BLUE + "Match Found");
                if (!tierTestingProject.getConfig().contains(player.getDisplayName() + ".kits." + name)){
                    for(int i1 = 0; i1 <= 40; i1++){
                        ItemStack kit = tierTestingProject.getConfig().getItemStack(name + "." + i1);
                        player.getInventory().setItem(i1, kit);
                    }
                }
                else{
                    for (int i1 = 0; i1 <= 40; i1++){
                        ItemStack itemStack = tierTestingProject.getConfig().getItemStack(player.getDisplayName() + ".Kits." + name + "." + i1);
                        player.getInventory().setItem(i1, itemStack);
                    }
                }
                if (!tierTestingProject.getConfig().contains(targetPlayer.getDisplayName() + ".kits." + name)){
                    for(int i1 = 0; i1 <= 40; i1++){
                        ItemStack kit = tierTestingProject.getConfig().getItemStack(name + "." + i1);
                        targetPlayer.getInventory().setItem(i1, kit);
                    }
                }
                else{
                    for (int i1 = 0; i1 <= 40; i1++){
                        ItemStack itemStack = tierTestingProject.getConfig().getItemStack(targetPlayer.getDisplayName() + ".Kits." + name + "." + i1);
                        targetPlayer.getInventory().setItem(i1, itemStack);
                    }
                }
            }
            player.sendMessage(ChatColor.GREEN + "You have been successfully added to the queue");
        } else {
            SetFalse(player);
            player.sendMessage(ChatColor.RED + "You have been successfully removed from the queue");
        }
    }
    public void SetFalse(Player player) {
        for (int i = 0; i < arrayLists.length; i++) {
            arrayLists[i].remove(player);
        }
    }
}
