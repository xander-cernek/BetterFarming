package EventHandlers;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockGrowEvent;

public class OnGrowEventHandler implements Listener {

  @EventHandler
  public void onGrow(BlockGrowEvent event) {
    switch (event.getBlock().getType()) {
      default:
        break;
    }
  }
}
