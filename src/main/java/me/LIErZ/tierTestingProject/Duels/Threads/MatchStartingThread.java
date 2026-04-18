package me.LIErZ.tierTestingProject.Duels.Threads;

import me.LIErZ.tierTestingProject.Match.Listeners.PlayerMove;
import me.LIErZ.tierTestingProject.TierTestingProject;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

public class MatchStartingThread implements Runnable {

    private final Player player;
    private final TierTestingProject tierTestingProject;
    private final Player targetPlayer;

    public MatchStartingThread(Player player, TierTestingProject tierTestingProject, Player targetPlayer) {
        this.player = player;
        this.tierTestingProject = tierTestingProject;
        this.targetPlayer = targetPlayer;
    }

    @Override
    public void run() {
        PlayerMove move = new PlayerMove(player,  targetPlayer);
        Bukkit.getScheduler().runTask(tierTestingProject, () -> {
            tierTestingProject.getServer().getPluginManager().registerEvents(move, tierTestingProject);
        });
        try {
            for (int i = 5; i >= 0; i--) {
                if (i != 0) {
                    player.sendMessage(ChatColor.BLUE + "Match starting in " + ChatColor.RED + i);
                    targetPlayer.sendMessage(ChatColor.BLUE + "Match starting in " + ChatColor.RED + i);
                } else {
                    Bukkit.getScheduler().runTask(tierTestingProject, () -> {
                        player.sendMessage(ChatColor.BLUE + "Match started");
                        targetPlayer.sendMessage(ChatColor.BLUE + "Match started");
                        HandlerList.unregisterAll(move);
                    });
                }
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
