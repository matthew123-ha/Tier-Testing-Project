package me.LIErZ.tierTestingProject.world;

import me.LIErZ.tierTestingProject.Duels.Threads.MatchStartingThread;
import me.LIErZ.tierTestingProject.Duels.Threads.SilentPlayerTeleport;
import me.LIErZ.tierTestingProject.Match.Listeners.PlayerMove;
import me.LIErZ.tierTestingProject.TierTestingProject;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.TimerTask;

public class CreateWorld {
    public static final String TemplateWorld = "Template";

    public static void CreateTheWorld(File source, File target, Player player, TierTestingProject tierTestingProject, Player targetPlayer, Boolean Ranked) throws IOException {

        Path path = Paths.get(Bukkit.getWorldContainer() + "\\plugins\\WorldGuard\\worlds" + target.getName());
        if (Files.notExists(path))
            Files.createDirectory(path);

        if (!target.exists()) target.mkdirs();
        for (String file : source.list()) {
            File srcfile = new File(source, file);
            File destFile = new File(target, file);

            if (srcfile.isDirectory())
                CreateTheWorld(srcfile, destFile, player, tierTestingProject, targetPlayer, Ranked);
            else if (!file.equals("uid.dat") && !file.equals("session.lock"))
                Files.copy(srcfile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }

        WorldCreator clone = new WorldCreator(target.getName());

        World cloneWorld = clone.createWorld();

        cloneWorld.setGameRule(GameRule.DO_MOB_SPAWNING, false);
        cloneWorld.setDifficulty(Difficulty.HARD);
        cloneWorld.setGameRule(GameRule.DO_IMMEDIATE_RESPAWN, true);
        SetDuelConfig(player, targetPlayer, tierTestingProject, target.getName(), Ranked);
        Thread thread = new Thread(new SilentPlayerTeleport(tierTestingProject, player, targetPlayer, cloneWorld));

        thread.start();
    }

    private static void SetDuelConfig(Player player, Player targetPlayer, TierTestingProject tierTestingProject, String MatchName, Boolean ranked) {
        tierTestingProject.getConfig().set(ChatColor.stripColor(player.getDisplayName()) + ".last-location", player.getLocation());
        tierTestingProject.getConfig().set(ChatColor.stripColor(targetPlayer.getDisplayName()) + ".last-location", targetPlayer.getLocation());
        tierTestingProject.getConfig().set(ChatColor.stripColor(player.getDisplayName()) + ".in-match.match", MatchName);
        tierTestingProject.getConfig().set(ChatColor.stripColor(player.getDisplayName()) + ".in-match.Boolean", true);
        tierTestingProject.getConfig().set(ChatColor.stripColor(player.getDisplayName()) + ".in-match.target", ChatColor.stripColor(targetPlayer.getDisplayName()));
        tierTestingProject.getConfig().set(ChatColor.stripColor(player.getDisplayName()) + ".in-match.ranked", ranked);
        tierTestingProject.getConfig().set(ChatColor.stripColor(targetPlayer.getDisplayName()) + ".in-match.match", MatchName);
        tierTestingProject.getConfig().set(ChatColor.stripColor(targetPlayer.getDisplayName()) + ".in-match.Boolean", true);
        tierTestingProject.getConfig().set(ChatColor.stripColor(targetPlayer.getDisplayName()) + ".in-match.target", ChatColor.stripColor(player.getDisplayName()));
        tierTestingProject.getConfig().set(ChatColor.stripColor(targetPlayer.getDisplayName()) + ".in-match.ranked", ranked);
        if (!tierTestingProject.getConfig().contains(ChatColor.stripColor(player.getDisplayName()) + ".elo")) {
            tierTestingProject.getConfig().set(ChatColor.stripColor(player.getDisplayName()) + ".elo", TierTestingProject.DefaultElo);
            tierTestingProject.saveConfig();
        }
        if (!tierTestingProject.getConfig().contains(ChatColor.stripColor(targetPlayer.getDisplayName()) + ".elo")) {
            tierTestingProject.getConfig().set(ChatColor.stripColor(targetPlayer.getDisplayName()) + ".elo", TierTestingProject.DefaultElo);
            tierTestingProject.saveConfig();
        }
        tierTestingProject.saveConfig();
    }
}
