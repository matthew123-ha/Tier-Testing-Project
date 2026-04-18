package me.LIErZ.tierTestingProject.Duels;

import me.LIErZ.tierTestingProject.Kits.Menu.ConfirmMenu;
import me.LIErZ.tierTestingProject.Kits.Menu.EditKitMenuKits;
import me.LIErZ.tierTestingProject.Kits.SetKitSet;
import me.LIErZ.tierTestingProject.TierTestingProject;
import me.LIErZ.tierTestingProject.world.CreateWorld;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MenuListener implements Listener {
    private final TierTestingProject tierTestingProject;
    private final ChatColor DuelMenuChatColor;
    private final String DuelMenu;
    private final ChatColor DuelMenuRankedChatColor;
    private final String DuelMenuRanked;
    private final ChatColor ItemDuelMenuChatColor;
    private final ChatColor EditKitMenuChatColor;
    private final String EditKitMenu;
    private final String SetKitString;
    private final String ItemDuelMenu;


    public MenuListener(TierTestingProject tierTestingProject, ChatColor DuelMenuChatColor, String DuelMenu, ChatColor DuelMenuRankedChatColor, String DuelMenuRanked, ChatColor ItemDuelMenuChatColor, ChatColor EditKitMenuChatColor, String EditKiMenu, String SetKitString, String ItemDuelMenu) {
        this.tierTestingProject = tierTestingProject;
        this.DuelMenuChatColor = DuelMenuChatColor;
        this.DuelMenu = DuelMenu;
        this.DuelMenuRankedChatColor = DuelMenuRankedChatColor;
        this.DuelMenuRanked = DuelMenuRanked;
        this.ItemDuelMenuChatColor = ItemDuelMenuChatColor;
        this.EditKitMenuChatColor = EditKitMenuChatColor;
        this.EditKitMenu = EditKiMenu;
        this.SetKitString = SetKitString;
        this.ItemDuelMenu = ItemDuelMenu;
    }

    private static final ArrayList<Player> InQueueCrystal = new ArrayList<>();
    private static final ArrayList<Player> InQueueSword = new ArrayList<>();
    private static final ArrayList<Player> InQueueAxe = new ArrayList<>();
    private static final ArrayList<Player> InQueueMace = new ArrayList<>();
    private static final ArrayList<Player> InQueueUHC = new ArrayList<>();
    private static final ArrayList<Player> InQueueNetherite = new ArrayList<>();
    private static final ArrayList<Player> InQueueSMP = new ArrayList<>();
    private static final ArrayList<Player> InQueuePot = new ArrayList<>();
    private static final ArrayList<Player> InQueueDiamondSMP = new ArrayList<>();
    private static final ArrayList<Player> InQueueRankedCrystal = new ArrayList<>();
    private static final ArrayList<Player> InQueueRankedSword = new ArrayList<>();
    private static final ArrayList<Player> InQueueRankedAxe = new ArrayList<>();
    private static final ArrayList<Player> InQueueRankedMace = new ArrayList<>();
    private static final ArrayList<Player> InQueueRankedUHC = new ArrayList<>();
    private static final ArrayList<Player> InQueueRankedNetherite = new ArrayList<>();
    private static final ArrayList<Player> InQueueRankedSMP = new ArrayList<>();
    private static final ArrayList<Player> InQueueRankedPot = new ArrayList<>();
    private static final ArrayList<Player> InQueueRankedDiamondSMP = new ArrayList<>();
    private static final ArrayList<Player>[] arrayLists = new ArrayList[]{InQueueCrystal, InQueueSword, InQueueAxe, InQueueMace, InQueueUHC, InQueueNetherite, InQueueSMP, InQueuePot, InQueueDiamondSMP, InQueueRankedCrystal, InQueueRankedSword, InQueueRankedAxe, InQueueRankedMace, InQueueRankedUHC, InQueueRankedNetherite, InQueueRankedSMP, InQueueRankedPot, InQueueRankedDiamondSMP};


    @EventHandler
    public void onPlayerClickEvent(InventoryClickEvent event) throws IOException {
        File source = new File(Bukkit.getWorldContainer(), CreateWorld.TemplateWorld);
        File destination = new File(Bukkit.getWorldContainer(), String.valueOf(Math.random()));
        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equalsIgnoreCase(DuelMenuChatColor + DuelMenu)){
            InQueue inQueue = new InQueue(arrayLists);
            event.setCancelled(true);
            switch (event.getCurrentItem().getType()){
                case END_CRYSTAL -> inQueue.Queue(player, tierTestingProject, source, destination, "InQueueCrystal", InQueueCrystal, false);
                case DIAMOND_SWORD -> inQueue.Queue(player, tierTestingProject, source, destination, "InQueueSword", InQueueSword, false);
                case DIAMOND_AXE ->  inQueue.Queue(player, tierTestingProject, source, destination, "InQueueAxe", InQueueAxe, false);
                case MACE -> inQueue.Queue(player, tierTestingProject, source, destination, "InQueueMace", InQueueMace, false);
                case GOLDEN_APPLE -> inQueue.Queue(player, tierTestingProject, source, destination, "InQueueUHC", InQueueUHC, false);
                case NETHERITE_INGOT -> inQueue.Queue(player, tierTestingProject, source, destination, "InQueueNetherite", InQueueNetherite, false);
                case NETHERITE_CHESTPLATE -> inQueue.Queue(player, tierTestingProject, source, destination, "InQueueSMP", InQueueSMP, false);
                case SPLASH_POTION -> inQueue.Queue(player, tierTestingProject, source, destination, "InQueuePot", InQueuePot, false);
                case DIAMOND_CHESTPLATE -> inQueue.Queue(player, tierTestingProject, source, destination, "InQueueDiamondSMP", InQueueDiamondSMP, false);
            }
        }
        else if (event.getView().getTitle().equalsIgnoreCase(DuelMenuRankedChatColor + DuelMenuRanked)){
            InQueue inQueue = new InQueue(arrayLists);
            event.setCancelled(true);
            switch (event.getCurrentItem().getType()){
                case END_CRYSTAL -> inQueue.Queue(player, tierTestingProject, source, destination, "InQueueCrystal", InQueueRankedCrystal, true);
                case DIAMOND_SWORD -> inQueue.Queue(player, tierTestingProject, source, destination, "InQueueSword", InQueueRankedSword, true);
                case DIAMOND_AXE ->  inQueue.Queue(player, tierTestingProject, source, destination, "InQueueAxe", InQueueRankedAxe, true);
                case MACE -> inQueue.Queue(player, tierTestingProject, source, destination, "InQueueMace", InQueueRankedMace, true);
                case GOLDEN_APPLE -> inQueue.Queue(player, tierTestingProject, source, destination, "InQueueUHC", InQueueRankedUHC, true);
                case NETHERITE_INGOT -> inQueue.Queue(player, tierTestingProject, source, destination, "InQueueNetherite", InQueueRankedNetherite, true);
                case NETHERITE_CHESTPLATE -> inQueue.Queue(player, tierTestingProject, source, destination, "InQueueSMP", InQueueRankedSMP, true);
                case SPLASH_POTION -> inQueue.Queue(player, tierTestingProject, source, destination, "InQueuePot", InQueueRankedPot, true);
                case DIAMOND_CHESTPLATE -> inQueue.Queue(player, tierTestingProject, source, destination, "InQueueDiamondSMP", InQueueRankedDiamondSMP, true);
            }
        }
        else if (event.getView().getTitle().equalsIgnoreCase(ItemDuelMenuChatColor + SetKitString)){
            event.setCancelled(true);
            switch (event.getCurrentItem().getType()){
                case END_CRYSTAL -> SetKitSet.SetKitMenuKits("InQueueCrystal", tierTestingProject, player);
                case DIAMOND_SWORD -> SetKitSet.SetKitMenuKits("InQueueSword", tierTestingProject, player);
                case DIAMOND_AXE -> SetKitSet.SetKitMenuKits("InQueueAxe", tierTestingProject, player);
                case MACE -> SetKitSet.SetKitMenuKits("InQueueMace", tierTestingProject, player);
                case GOLDEN_APPLE -> SetKitSet.SetKitMenuKits("InQueueUHC", tierTestingProject, player);
                case NETHERITE_INGOT -> SetKitSet.SetKitMenuKits("InQueueNetherite", tierTestingProject, player);
                case NETHERITE_CHESTPLATE -> SetKitSet.SetKitMenuKits("InQueueSMP", tierTestingProject, player);
                case SPLASH_POTION -> SetKitSet.SetKitMenuKits("InQueuePot", tierTestingProject, player);
                case DIAMOND_CHESTPLATE -> SetKitSet.SetKitMenuKits("InQueueDiamondSMP", tierTestingProject, player);
            }
        }
        else if (event.getView().getTitle().equalsIgnoreCase(ItemDuelMenuChatColor + ItemDuelMenu)){
            String EditKitMenu2 = EditKitMenu;
            event.setCancelled(true);
            switch (event.getCurrentItem().getType()){
                case END_CRYSTAL -> EditKitMenuKits.KitMenu("InQueueCrystal", tierTestingProject, player, EditKitMenu2);
                case DIAMOND_SWORD -> EditKitMenuKits.KitMenu("InQueueSword", tierTestingProject, player, EditKitMenu2);
                case DIAMOND_AXE -> EditKitMenuKits.KitMenu("InQueueAxe", tierTestingProject, player, EditKitMenu2);
                case MACE -> EditKitMenuKits.KitMenu("InQueueMace", tierTestingProject, player, EditKitMenu2);
                case GOLDEN_APPLE -> EditKitMenuKits.KitMenu("InQueueUHC", tierTestingProject, player, EditKitMenu2);
                case NETHERITE_INGOT -> EditKitMenuKits.KitMenu("InQueueNetherite", tierTestingProject, player, EditKitMenu2);
                case NETHERITE_CHESTPLATE -> EditKitMenuKits.KitMenu("InQueueSMP",  tierTestingProject, player, EditKitMenu2);
                case SPLASH_POTION -> EditKitMenuKits.KitMenu("InQueuePot", tierTestingProject, player, EditKitMenu2);
                case DIAMOND_CHESTPLATE -> EditKitMenuKits.KitMenu("InQueueDiamondSMP", tierTestingProject, player, EditKitMenu2);
            }
        }
        else if (event.getView().getTitle().equalsIgnoreCase(EditKitMenuKits.color + EditKitMenu)){
            switch (event.getCurrentItem().getType()){
                case GREEN_WOOL -> ConfirmMenu.menu(player, tierTestingProject, EditKitMenu);
            }
        }
    }


    public static int InQueueCrystalNumber() {
        return InQueueCrystal.size();
    }

    public static int InQueueSwordNumber() {
        return InQueueSword.size();
    }

    public static int InQueueAxeNumber() {
        return InQueueAxe.size();
    }

    public static int InQueueMaceNumber() {
        return InQueueMace.size();
    }

    public static int InQueueUHCNumber() {
        return InQueueUHC.size();
    }

    public static int InQueueNetheriteNumber() {
        return InQueueNetherite.size();
    }

    public static int InQueueSMPNumber() {
        return InQueueSMP.size();
    }

    public static int InQueuePotNumber() {
        return InQueuePot.size();
    }

    public static int InQueueDiamondSMPNumber() {
        return InQueueDiamondSMP.size();
    }

    public static int InQueueRankedCrystalNumber() {
        return InQueueRankedCrystal.size();
    }

    public static int InQueueRankedSwordNumber() {
        return InQueueRankedSword.size();
    }

    public static int InQueueRankedAxeNumber() {
        return InQueueRankedAxe.size();
    }

    public static int InQueueRankedMaceNumber() {
        return InQueueRankedMace.size();
    }

    public static int InQueueRankedUHCNumber() {
        return InQueueRankedUHC.size();
    }

    public static int InQueueRankedNetheriteNumber() {
        return InQueueRankedNetherite.size();
    }

    public static int InQueueRankedSMPNumber() {
        return InQueueRankedSMP.size();
    }

    public static int InQueueRankedPotNumber() {
        return InQueueRankedPot.size();
    }

    public static int InQueueRankedDiamondSMPNumber() {
        return InQueueRankedDiamondSMP.size();
    }
}
