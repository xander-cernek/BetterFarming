package EventHandlers;

import CropTweaks.SugarCane;
import lombok.extern.java.Log;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.Optional;

@Log
public class OnRightClickEventHandler implements Listener {

  @EventHandler
  public void onRightClick(PlayerInteractEvent e) {
    if (e.getHand().equals(EquipmentSlot.HAND)) {
      Player p = e.getPlayer();
      switch (p.getInventory().getItemInMainHand().getType()) {
        case BONE_MEAL:
          bonemealSwitch(e, e.getClickedBlock());
          break;
        default:
          break;
      }
    }
  }

  private void bonemealSwitch(PlayerInteractEvent e, Block block) {
    if (Optional.ofNullable(block).isPresent()) {
      switch (block.getType()) {
        case SUGAR_CANE:
          sugarCane(e, block);
          break;
        default:
          break;
      }
    }
  }

  private void sugarCane(PlayerInteractEvent event, Block block) {
    Player player = event.getPlayer();
    if (player.getInventory().getItemInMainHand().getAmount() >= 1) {
      SugarCane.applyBonemeal(block);
      player
          .getInventory()
          .getItemInMainHand()
          .setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
    }
  }
}
