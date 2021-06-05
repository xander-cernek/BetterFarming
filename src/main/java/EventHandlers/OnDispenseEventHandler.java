package EventHandlers;

import CropTweaks.SugarCane;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Dispenser;
import org.bukkit.block.data.Directional;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class OnDispenseEventHandler implements Listener {

  @EventHandler
  public void onDispense(BlockDispenseEvent event) {
    Directional dispenser = (Directional) event.getBlock().getBlockData();
    BlockFace face = dispenser.getFacing();
    Block facing = event.getBlock().getRelative(face);
    switch (facing.getType()) {
      case SUGAR_CANE:
        sugarCane(event, facing);
      default:
        break;
    }
  }

  private void sugarCane(BlockDispenseEvent event, Block facing) {
    Dispenser dispenser1 = (Dispenser) event.getBlock().getState();
    Inventory inventory = dispenser1.getInventory();
    if (inventory.containsAtLeast(new ItemStack(Material.BONE_MEAL), 1)) {
      SugarCane.applyBonemeal(facing);
      inventory.removeItem(new ItemStack(Material.BONE_MEAL, 1));
    }
  }
}
