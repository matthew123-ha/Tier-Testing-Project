package me.LIErZ.tierTestingProject.CustomConfigs;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class KitConfig {

    private static File file;
    private static FileConfiguration configuration;

    public void Setup(){

        file = new File(Bukkit.getServer().getPluginManager().getPlugin("Tiertestingproject").getDataFolder(), "kitconfig.yml");

        if (!file.exists()){
            try{
                file.createNewFile();
            }
            catch (IOException e){
                throw new RuntimeException(e);
            }
        }
        configuration = YamlConfiguration.loadConfiguration(file);
    }

    public FileConfiguration getKitConfig(){
        return configuration;
    }

    public static void save(){
        try{
            configuration.save(file);
        }
        catch (IOException e){
            System.out.println("Couldn't save file");
        }
    }

    public static void reload(){
        configuration = YamlConfiguration.loadConfiguration(file);
    }
}
