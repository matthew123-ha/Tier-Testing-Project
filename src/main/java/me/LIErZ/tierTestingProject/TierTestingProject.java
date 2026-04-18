package me.LIErZ.tierTestingProject;

import me.LIErZ.tierTestingProject.Commands.EloCommand;
import me.LIErZ.tierTestingProject.Commands.InventoryViewer;
import me.LIErZ.tierTestingProject.Commands.add3;
import me.LIErZ.tierTestingProject.CustomConfigs.KitConfig;
import me.LIErZ.tierTestingProject.CustomConfigs.PlayerKits;
import me.LIErZ.tierTestingProject.Duels.HolyMenus;
import me.LIErZ.tierTestingProject.Kits.KitCommands.ShareKit;
import me.LIErZ.tierTestingProject.Listeners.CloseInventory;
import me.LIErZ.tierTestingProject.Match.Listeners.*;
import me.LIErZ.tierTestingProject.Kits.KitCommands.EditKit;
import me.LIErZ.tierTestingProject.Kits.KitCommands.SetKit;
import me.LIErZ.tierTestingProject.Duels.Commands.DuelCommand;
import me.LIErZ.tierTestingProject.Duels.Commands.OldDuelCommand;
import me.LIErZ.tierTestingProject.Duels.MenuListener;
import me.LIErZ.tierTestingProject.world.Commands.TeleportToWorld;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public final class TierTestingProject extends JavaPlugin{

    private String DuelMenu;
    private ChatColor DuelMenuChatColor;
    private String DuelMenuRanked;
    private ChatColor DuelMenuRankedChatColor;
    private String ItemDuelMenu;
    private ChatColor ItemDuelMenuChatColor;
    private String ItemDuelMenuRanked;
    private ChatColor ItemDuelMenuRankedChatColor;
    private String EditKitMenu;
    private ChatColor EditKitMenuChatColor;
    private final String SetKitString = "SetKit";
    public static final int DefaultElo = 1000;
    private HolyMenus holyMenus;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        DuelMenu = getConfig().getString("DuelMenu");
        DuelMenuChatColor = ChatColor.valueOf(getConfig().getString("DuelMenuChatColor"));
        DuelMenuRanked = getConfig().getString("DuelMenuRanked");
        DuelMenuRankedChatColor = ChatColor.valueOf(getConfig().getString("DuelMenuRankedChatColor"));
        ItemDuelMenu = getConfig().getString("ItemDuelMenu");
        ItemDuelMenuChatColor = ChatColor.valueOf(getConfig().getString("ItemDuelMenuChatColor"));
        ItemDuelMenuRanked = getConfig().getString("ItemDuelMenuRanked");
        ItemDuelMenuRankedChatColor = ChatColor.valueOf(getConfig().getString("ItemDuelMenuRankedChatColor"));
        EditKitMenu = getConfig().getString("EditKitMenu");
        EditKitMenuChatColor = ChatColor.valueOf(getConfig().getString("EditKitMenuChatColor"));
        new KitConfig().Setup();
        new PlayerKits().Setup();
        getServer().getPluginManager().registerEvents(new MenuListener(this, DuelMenuChatColor, DuelMenu, DuelMenuRankedChatColor, DuelMenuRanked, ItemDuelMenuChatColor, EditKitMenuChatColor, EditKitMenu, SetKitString, ItemDuelMenu), this);
        holyMenus = new HolyMenus(DuelMenuChatColor, DuelMenu, DuelMenuRankedChatColor, DuelMenuRanked);
        getServer().getPluginManager().registerEvents(new Interact(this, ItemDuelMenuRankedChatColor, ItemDuelMenu, ItemDuelMenuChatColor, ItemDuelMenuRanked), this);
        getServer().getPluginManager().registerEvents(new PlayerDeath(this), this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(this, DefaultElo), this);
        getServer().getPluginManager().registerEvents(new PlayerLeave(this), this);
        getServer().getPluginManager().registerEvents(new PlayerTeleport(this), this);
        getServer().getPluginManager().registerEvents(new CloseInventory(this), this);

        getCommand("elo").setExecutor(new EloCommand(this));
        getCommand("add").setExecutor(new add3(this));
        getCommand("TeleportToWorld").setExecutor(new TeleportToWorld());
        getCommand("Duel").setExecutor(new DuelCommand(this));
        getCommand("OldDuelCommand").setExecutor(new OldDuelCommand(this));
        getCommand("SetKit").setExecutor(new SetKit(this, ItemDuelMenuChatColor, SetKitString));
        getCommand("EditKit").setExecutor(new EditKit(this, ItemDuelMenuChatColor, ItemDuelMenu));
        getCommand("InventoryViewer").setExecutor(new InventoryViewer());
        getCommand("ShareKit").setExecutor(new ShareKit(this));

    }

    public HolyMenus GetHolyMenus(){
        return holyMenus;
    }

    public void PlayerJoinItems(Player player){
        player.getInventory().clear();
        ItemStack Duel = new ItemStack(Material.DIAMOND_SWORD);
        ItemStack DuelRanked = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta DuelMeta = Duel.getItemMeta();
        ItemMeta DuelRankedMeta = DuelRanked.getItemMeta();
        DuelMeta.setDisplayName(ItemDuelMenuChatColor + ItemDuelMenu);
        Duel.setItemMeta(DuelMeta);
        DuelRankedMeta.setDisplayName(ItemDuelMenuRankedChatColor + ItemDuelMenuRanked);
        DuelRanked.setItemMeta(DuelRankedMeta);
        player.getInventory().setItem(0, Duel);
        player.getInventory().setItem(1, DuelRanked);
    }
    @Override
    public void onDisable() {
        saveConfig();
    }
}
