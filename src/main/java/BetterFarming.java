import EventHandlers.OnDispenseEventHandler;
import EventHandlers.OnGrowEventHandler;
import EventHandlers.OnRightClickEventHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class BetterFarming extends JavaPlugin {

  @Override
  public void onEnable() {
    getServer().getPluginManager().registerEvents(new OnGrowEventHandler(), this);
    getServer().getPluginManager().registerEvents(new OnRightClickEventHandler(), this);
    getServer().getPluginManager().registerEvents(new OnDispenseEventHandler(), this);
  }
}
