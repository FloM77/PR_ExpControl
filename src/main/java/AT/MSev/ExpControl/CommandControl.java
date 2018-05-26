package AT.MSev.ExpControl;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getLogger;

public class CommandControl implements CommandExecutor {
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        ((Player)commandSender).sendMessage(ChatColor.GREEN + command.getName() + " set to " + strings[0]);
        getLogger().info(command.getName() + " set to " + strings[0]);

        if(command.getName().equals("SetXpMod"))
        {
            float mod = Float.parseFloat(strings[0]);
            ExpControl.config.getConfig().set("ExpMulitplier", mod);
            ExpControl.config.saveConfig();
            ExpControl.ExpMulitplier = mod;
            return true;
        }

        if(command.getName().equals("SetXpDrop"))
        {
            Boolean drop = Boolean.parseBoolean(strings[0]);
            ExpControl.config.getConfig().set("ExpDrop", drop);
            ExpControl.config.saveConfig();
            ExpControl.ExpDrop = drop;
            return true;
        }
        return false;
    }
}
