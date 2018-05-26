package AT.MSev.ExpControl;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import static org.bukkit.Bukkit.getLogger;

public class Handler implements Listener {
    @EventHandler
    public void OnDeath(PlayerDeathEvent e)
    {
        Player player = (Player)e.getEntity();
        float expHad = player.getTotalExperience();
        float expNew = expHad * ExpControl.ExpMulitplier;

        getLogger().info(player.getDisplayName() + " died with " + expHad + ". They will respawn with " + expNew);

        e.setNewExp((int)(expNew));

        if(!ExpControl.ExpDrop)
        {e.setDroppedExp(0);}
    }
}
