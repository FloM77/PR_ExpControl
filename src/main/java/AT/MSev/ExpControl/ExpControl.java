package AT.MSev.ExpControl;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

public class ExpControl extends JavaPlugin {
    public static NamespacedKey key;
    public static float ExpMulitplier;
    public static Boolean ExpDrop;
    public static ExpControl config;
    @Override
    public void onEnable() {
        key = new NamespacedKey(this, this.getDescription().getName());
        config = this;

        saveDefaultConfig();

        ExpMulitplier = Float.parseFloat (getConfig().getString("ExpMulitplier"));
        ExpDrop = (Boolean) getConfig().get("ExpDrop");

        getLogger().info("ExpMulitplier set to " + ExpMulitplier + ". Exp will be dropped: " + ExpDrop.toString());

        this.getCommand("SetXpMod").setExecutor(new CommandControl());
        this.getCommand("SetXpDrop").setExecutor(new CommandControl());

        getServer().getPluginManager().registerEvents(new Handler(), this);
    }
    @Override
    public void onDisable() {

    }
}
