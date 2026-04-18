package me.LIErZ.tierTestingProject.Duels.Threads;

import me.LIErZ.tierTestingProject.TierTestingProject;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class SilentPlayerTeleport implements Runnable {

    private final TierTestingProject tierTestingProject;
    private final Player player;
    private final Player targetPlayer;
    private final World cloneWorld;

    public SilentPlayerTeleport(TierTestingProject tierTestingProject, Player player, Player targetPlayer, World cloneWorld) {
        this.tierTestingProject = tierTestingProject;
        this.player = player;
        this.targetPlayer = targetPlayer;
        this.cloneWorld = cloneWorld;
    }

    @Override
    public void run() {
        try {
            for (int i = 2; i >= 0; i--) {
                if (i == 0) {
                    Bukkit.getScheduler().runTask(tierTestingProject, () -> {
                        player.teleport(new Location(cloneWorld, 1118, 122, 864));
                        targetPlayer.teleport(new Location(cloneWorld, 1118, 122, 922, 180, cloneWorld.getSpawnLocation().getPitch()));
                    });
                    Thread thread2 = new Thread(new MatchStartingThread(player, tierTestingProject, targetPlayer));
                    thread2.start();
                }
                Thread.sleep(1000);
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
