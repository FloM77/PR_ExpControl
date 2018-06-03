package AT.MSev.ExpControl;

import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import static org.bukkit.Bukkit.getLogger;

public class Handler implements Listener {
    @EventHandler
    public void OnDeath(PlayerDeathEvent e)
    {
        Player player = (Player)e.getEntity();
        EXP exp = new EXP(player);
        float expHad = exp.getTotalExperience();
        float expNew = expHad * ExpControl.ExpMulitplier;

        e.setDroppedExp(0);

        if(!ExpControl.ExpDrop) {
            e.setNewExp((int) (expNew));
            getLogger().info(player.getDisplayName() + " died with " + expHad + ". They will respawn with " + expNew);
        }
        else
        {
            ExperienceOrb orb = player.getWorld().spawn(player.getLocation(), ExperienceOrb.class);
            orb.setExperience((int) (expNew));
            getLogger().info(player.getDisplayName() + " died with " + expHad + ". They will drop " + expNew);
        }
    }
}
