package me.LIErZ.tierTestingProject.Duels;

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


public class HolyMenus {

    private final ChatColor DuelMenuChatColor;
    private final String DuelMenu;
    private final ChatColor DuelMenuRankedChatColor;
    private final String DuelMenuRanked;

    public HolyMenus(ChatColor DuelMenuChatColor, String DuelMenu, ChatColor DuelMenuRankedChatColor, String DuelMenuRanked) {
        this.DuelMenuChatColor = DuelMenuChatColor;
        this.DuelMenu = DuelMenu;
        this.DuelMenuRankedChatColor = DuelMenuRankedChatColor;
        this.DuelMenuRanked = DuelMenuRanked;
    }

    public void DuelMenu(Player player){
        Inventory inventory = Bukkit.createInventory(player, 36, DuelMenuChatColor + DuelMenu);

        for (int i = 0; i <= 8; i++){
            inventory.setItem(i, new ItemStack(Material.GRAY_STAINED_GLASS));
        }
        for (int i = 27; i <= 35; i++){
            inventory.setItem(i, new ItemStack(Material.GRAY_STAINED_GLASS));
        }
        inventory.setItem(26, new ItemStack(Material.GRAY_STAINED_GLASS));
        inventory.setItem(17, new ItemStack(Material.GRAY_STAINED_GLASS));
        inventory.setItem(18, new ItemStack(Material.GRAY_STAINED_GLASS));
        inventory.setItem(9, new ItemStack(Material.GRAY_STAINED_GLASS));

        ItemStack crystal;
        ItemStack Sword;
        ItemStack Axe;
        ItemStack Mace;
        ItemStack UHC;
        ItemStack Netherite;
        ItemStack SMP;
        ItemStack POT;
        ItemStack DiamondSMP;

        if (MenuListener.InQueueCrystalNumber() == 0)
            crystal = new ItemStack(Material.END_CRYSTAL, 1);
        else
            crystal = new ItemStack(Material.END_CRYSTAL, MenuListener.InQueueCrystalNumber());
        ItemMeta crystalMeta = crystal.getItemMeta();
        List<String> crystalLore = new ArrayList<>();
        crystalLore.add(ChatColor.DARK_PURPLE + "Click this to join crystal duels");
        crystalMeta.setLore(crystalLore);
        crystal.setItemMeta(crystalMeta);
        inventory.setItem(10, crystal);

        if (MenuListener.InQueueSwordNumber() == 0)
            Sword = new ItemStack(Material.DIAMOND_SWORD, 1);
        else
            Sword = new ItemStack(Material.DIAMOND_SWORD, MenuListener.InQueueSwordNumber());
        ItemMeta swordMeta = Sword.getItemMeta();
        List<String> swordLore = new ArrayList<>();
        swordLore.add(ChatColor.DARK_PURPLE + "Click this to join sword duels");
        swordMeta.setLore(swordLore);
        Sword.setItemMeta(swordMeta);
        inventory.setItem(11, Sword);

        if (MenuListener.InQueueAxeNumber() == 0)
            Axe = new ItemStack(Material.DIAMOND_AXE, 1);
        else
            Axe = new ItemStack(Material.DIAMOND_AXE, MenuListener.InQueueAxeNumber());
        ItemMeta axeMeta = Axe.getItemMeta();
        List<String> axeLore = new ArrayList<>();
        axeLore.add(ChatColor.DARK_PURPLE + "Click this to join axe duels");
        axeMeta.setLore(axeLore);
        Axe.setItemMeta(axeMeta);
        inventory.setItem(12, Axe);

        if (MenuListener.InQueueMaceNumber() == 0)
            Mace = new ItemStack(Material.MACE, 1);
        else
            Mace = new ItemStack(Material.MACE, MenuListener.InQueueMaceNumber());
        ItemMeta maceMeta = Mace.getItemMeta();
        List<String> maceLore = new ArrayList<>();
        maceLore.add(ChatColor.DARK_PURPLE + "Click this to join mace duels");
        maceMeta.setLore(maceLore);
        Mace.setItemMeta(maceMeta);
        inventory.setItem(13, Mace);

        if (MenuListener.InQueueUHCNumber() == 0)
            UHC = new ItemStack(Material.GOLDEN_APPLE, 1);
        else
            UHC = new ItemStack(Material.GOLDEN_APPLE, MenuListener.InQueueUHCNumber());
        ItemMeta UHCMeta = UHC.getItemMeta();
        List<String> UHCLore = new ArrayList<>();
        UHCLore.add(ChatColor.DARK_PURPLE + "Click this to join UHC duels");
        UHCMeta.setLore(UHCLore);
        UHC.setItemMeta(UHCMeta);
        inventory.setItem(14, UHC);

        if (MenuListener.InQueueNetheriteNumber() == 0)
            Netherite = new ItemStack(Material.NETHERITE_INGOT, 1);
        else
            Netherite = new ItemStack(Material.NETHERITE_INGOT, MenuListener.InQueueNetheriteNumber());
        ItemMeta NetheriteMeta = Netherite.getItemMeta();
        List<String> NetheriteLore = new ArrayList<>();
        NetheriteLore.add(ChatColor.DARK_PURPLE + "Click this to join Netherite duels");
        NetheriteMeta.setLore(NetheriteLore);
        Netherite.setItemMeta(NetheriteMeta);
        inventory.setItem(15, Netherite);

        if (MenuListener.InQueueSMPNumber() == 0)
            SMP = new ItemStack(Material.NETHERITE_CHESTPLATE, 1);
        else
            SMP = new ItemStack(Material.NETHERITE_CHESTPLATE, MenuListener.InQueueSMPNumber());
        ItemMeta smpMeta = SMP.getItemMeta();
        List<String> smpLore = new ArrayList<>();
        smpLore.add(ChatColor.DARK_PURPLE + "Click this to join SMP duels");
        smpMeta.setLore(smpLore);
        SMP.setItemMeta(smpMeta);
        inventory.setItem(16, SMP);

        if (MenuListener.InQueuePotNumber() == 0)
            POT =  new ItemStack(Material.SPLASH_POTION, 1);
        else
            POT = new ItemStack(Material.SPLASH_POTION, MenuListener.InQueuePotNumber());
        ItemMeta POTMeta = POT.getItemMeta();
        List<String> POTLore = new ArrayList<>();
        POTLore.add(ChatColor.DARK_PURPLE + "Click this to join POT duels");
        POTMeta.setLore(POTLore);
        POT.setItemMeta(POTMeta);
        inventory.setItem(19, POT);

        if (MenuListener.InQueueDiamondSMPNumber() == 0)
            DiamondSMP = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
        else
            DiamondSMP = new ItemStack(Material.DIAMOND_CHESTPLATE, MenuListener.InQueueDiamondSMPNumber());
        ItemMeta diamondSMPMeta = DiamondSMP.getItemMeta();
        List<String> diamondLore = new ArrayList<>();
        diamondLore.add(ChatColor.DARK_PURPLE + "Click this to join DiamondSMP duels");
        diamondSMPMeta.setLore(diamondLore);
        DiamondSMP.setItemMeta(diamondSMPMeta);
        inventory.setItem(20, DiamondSMP);

        player.openInventory(inventory);
    }

    public void DuelMenuRanked(Player player){
        Inventory inventory = Bukkit.createInventory(player, 36, DuelMenuRankedChatColor + DuelMenuRanked);

        for (int i = 0; i <= 8; i++){
            inventory.setItem(i, new ItemStack(Material.GRAY_STAINED_GLASS));
        }
        for (int i = 27; i <= 35; i++){
            inventory.setItem(i, new ItemStack(Material.GRAY_STAINED_GLASS));
        }
        inventory.setItem(26, new ItemStack(Material.GRAY_STAINED_GLASS));
        inventory.setItem(17, new ItemStack(Material.GRAY_STAINED_GLASS));
        inventory.setItem(18, new ItemStack(Material.GRAY_STAINED_GLASS));
        inventory.setItem(9, new ItemStack(Material.GRAY_STAINED_GLASS));

        ItemStack crystal;
        ItemStack Sword;
        ItemStack Axe;
        ItemStack Mace;
        ItemStack UHC;
        ItemStack Netherite;
        ItemStack SMP;
        ItemStack POT;
        ItemStack DiamondSMP;

        if (MenuListener.InQueueRankedCrystalNumber() == 0)
            crystal = new ItemStack(Material.END_CRYSTAL, 1);
        else
            crystal = new ItemStack(Material.END_CRYSTAL, MenuListener.InQueueRankedCrystalNumber());
        ItemMeta crystalMeta = crystal.getItemMeta();
        List<String> crystalLore = new ArrayList<>();
        crystalLore.add(ChatColor.DARK_PURPLE + "Click this to join crystal duels");
        crystalMeta.setLore(crystalLore);
        crystal.setItemMeta(crystalMeta);
        inventory.setItem(10, crystal);

        if (MenuListener.InQueueRankedSwordNumber() == 0)
            Sword = new ItemStack(Material.DIAMOND_SWORD, 1);
        else
            Sword = new ItemStack(Material.DIAMOND_SWORD, MenuListener.InQueueRankedSwordNumber());
        ItemMeta swordMeta = Sword.getItemMeta();
        List<String> swordLore = new ArrayList<>();
        swordLore.add(ChatColor.DARK_PURPLE + "Click this to join sword duels");
        swordMeta.setLore(swordLore);
        Sword.setItemMeta(swordMeta);
        inventory.setItem(11, Sword);

        if (MenuListener.InQueueRankedAxeNumber() == 0)
            Axe = new ItemStack(Material.DIAMOND_AXE, 1);
        else
            Axe = new ItemStack(Material.DIAMOND_AXE, MenuListener.InQueueRankedAxeNumber());
        ItemMeta axeMeta = Axe.getItemMeta();
        List<String> axeLore = new ArrayList<>();
        axeLore.add(ChatColor.DARK_PURPLE + "Click this to join axe duels");
        axeMeta.setLore(axeLore);
        Axe.setItemMeta(axeMeta);
        inventory.setItem(12, Axe);

        if (MenuListener.InQueueRankedMaceNumber() == 0)
            Mace = new ItemStack(Material.MACE, 1);
        else
            Mace = new ItemStack(Material.MACE, MenuListener.InQueueRankedMaceNumber());
        ItemMeta maceMeta = Mace.getItemMeta();
        List<String> maceLore = new ArrayList<>();
        maceLore.add(ChatColor.DARK_PURPLE + "Click this to join mace duels");
        maceMeta.setLore(maceLore);
        Mace.setItemMeta(maceMeta);
        inventory.setItem(13, Mace);

        if (MenuListener.InQueueRankedUHCNumber() == 0)
            UHC = new ItemStack(Material.GOLDEN_APPLE, 1);
        else
            UHC = new ItemStack(Material.GOLDEN_APPLE, MenuListener.InQueueRankedUHCNumber());
        ItemMeta UHCMeta = UHC.getItemMeta();
        List<String> UHCLore = new ArrayList<>();
        UHCLore.add(ChatColor.DARK_PURPLE + "Click this to join UHC duels");
        UHCMeta.setLore(UHCLore);
        UHC.setItemMeta(UHCMeta);
        inventory.setItem(14, UHC);

        if (MenuListener.InQueueRankedNetheriteNumber() == 0)
            Netherite = new ItemStack(Material.NETHERITE_INGOT, 1);
        else
            Netherite = new ItemStack(Material.NETHERITE_INGOT, MenuListener.InQueueRankedNetheriteNumber());
        ItemMeta NetheriteMeta = Netherite.getItemMeta();
        List<String> NetheriteLore = new ArrayList<>();
        NetheriteLore.add(ChatColor.DARK_PURPLE + "Click this to join Netherite duels");
        NetheriteMeta.setLore(NetheriteLore);
        Netherite.setItemMeta(NetheriteMeta);
        inventory.setItem(15, Netherite);

        if (MenuListener.InQueueRankedSMPNumber() == 0)
            SMP = new ItemStack(Material.NETHERITE_CHESTPLATE, 1);
        else
            SMP = new ItemStack(Material.NETHERITE_CHESTPLATE, MenuListener.InQueueRankedSMPNumber());
        ItemMeta smpMeta = SMP.getItemMeta();
        List<String> smpLore = new ArrayList<>();
        smpLore.add(ChatColor.DARK_PURPLE + "Click this to join SMP duels");
        smpMeta.setLore(smpLore);
        SMP.setItemMeta(smpMeta);
        inventory.setItem(16, SMP);

        if (MenuListener.InQueueRankedPotNumber() == 0)
            POT =  new ItemStack(Material.SPLASH_POTION, 1);
        else
            POT = new ItemStack(Material.SPLASH_POTION, MenuListener.InQueueRankedPotNumber());
        ItemMeta POTMeta = POT.getItemMeta();
        List<String> POTLore = new ArrayList<>();
        POTLore.add(ChatColor.DARK_PURPLE + "Click this to join POT duels");
        POTMeta.setLore(POTLore);
        POT.setItemMeta(POTMeta);
        inventory.setItem(19, POT);

        if (MenuListener.InQueueRankedDiamondSMPNumber() == 0)
            DiamondSMP = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
        else
            DiamondSMP = new ItemStack(Material.DIAMOND_CHESTPLATE, MenuListener.InQueueRankedDiamondSMPNumber());
        ItemMeta diamondSMPMeta = DiamondSMP.getItemMeta();
        List<String> diamondLore = new ArrayList<>();
        diamondLore.add(ChatColor.DARK_PURPLE + "Click this to join DiamondSMP duels");
        diamondSMPMeta.setLore(diamondLore);
        DiamondSMP.setItemMeta(diamondSMPMeta);
        inventory.setItem(20, DiamondSMP);

        player.openInventory(inventory);
    }

    public void EditKitMenu(Player player, String name, ChatColor chatColor){
        Inventory inventory = Bukkit.createInventory(player, 18, chatColor + name);

        ItemStack crystal = new ItemStack(Material.END_CRYSTAL);
        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
        ItemStack axe = new ItemStack(Material.DIAMOND_AXE);
        ItemStack mace = new ItemStack(Material.MACE);
        ItemStack UHC = new ItemStack(Material.GOLDEN_APPLE);
        ItemStack Netherite = new ItemStack(Material.NETHERITE_INGOT);
        ItemStack SMP = new ItemStack(Material.NETHERITE_CHESTPLATE);
        ItemStack POT = new ItemStack(Material.SPLASH_POTION);
        ItemStack DIAMOND_SMP = new ItemStack(Material.DIAMOND_CHESTPLATE);

        ItemMeta crystalMeta = crystal.getItemMeta();
        ItemMeta swordMeta = sword.getItemMeta();
        ItemMeta axeMeta = axe.getItemMeta();
        ItemMeta maceMeta = mace.getItemMeta();
        ItemMeta UHCMeta = UHC.getItemMeta();
        ItemMeta NetheriteMeta = Netherite.getItemMeta();
        ItemMeta SMPMeta = SMP.getItemMeta();
        ItemMeta PotMeta = POT.getItemMeta();
        ItemMeta diamondSMPMeta = DIAMOND_SMP.getItemMeta();

        List<String> crystalLore = new ArrayList<>();
        List<String> swordLore = new ArrayList<>();
        List<String> axeLore = new ArrayList<>();
        List<String> maceLore = new ArrayList<>();
        List<String> UHCLore = new ArrayList<>();
        List<String> NetheriteLore = new ArrayList<>();
        List<String> SMPLore = new ArrayList<>();
        List<String> PotLore = new ArrayList<>();
        List<String> DIAMONDSMPLore = new ArrayList<>();

        crystalLore.add(ChatColor.DARK_PURPLE + "Click this to edit the Crystal KIT");
        swordLore.add(ChatColor.DARK_PURPLE + "Click this to edit the Sword KIT");
        axeLore.add(ChatColor.DARK_PURPLE + "Click this to edit the Axe KIT");
        maceLore.add(ChatColor.DARK_PURPLE + "Click this to edit the MACE KIT");
        UHCLore.add(ChatColor.DARK_PURPLE + "Click this to edit the UHC KIT");
        NetheriteLore.add(ChatColor.DARK_PURPLE + "Click this to edit the Netherite KIT");
        SMPLore.add(ChatColor.DARK_PURPLE + "Click this to edit the SMP KIT");
        PotLore.add(ChatColor.DARK_PURPLE + "Click this to edit the POT KIT");
        DIAMONDSMPLore.add(ChatColor.DARK_PURPLE + "Click this to edit the DIAMOND SMP KIT");

        crystalMeta.setLore(crystalLore);
        swordMeta.setLore(swordLore);
        axeMeta.setLore(axeLore);
        maceMeta.setLore(maceLore);
        UHCMeta.setLore(UHCLore);
        NetheriteMeta.setLore(NetheriteLore);
        SMPMeta.setLore(SMPLore);
        PotMeta.setLore(PotLore);
        diamondSMPMeta.setLore(DIAMONDSMPLore);

        crystal.setItemMeta(crystalMeta);
        sword.setItemMeta(swordMeta);
        axe.setItemMeta(axeMeta);
        mace.setItemMeta(maceMeta);
        UHC.setItemMeta(UHCMeta);
        Netherite.setItemMeta(NetheriteMeta);
        SMP.setItemMeta(SMPMeta);
        POT.setItemMeta(PotMeta);
        DIAMOND_SMP.setItemMeta(diamondSMPMeta);

        inventory.setItem(0, crystal);
        inventory.setItem(1, sword);
        inventory.setItem(2, axe);
        inventory.setItem(3, mace);
        inventory.setItem(4, UHC);
        inventory.setItem(5, Netherite);
        inventory.setItem(6, SMP);
        inventory.setItem(7, POT);
        inventory.setItem(8, DIAMOND_SMP);

        player.openInventory(inventory);
    }
}
