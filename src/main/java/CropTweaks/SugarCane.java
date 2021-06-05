package CropTweaks;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

public class SugarCane {

  public static void applyBonemeal(Block b) {
    Block b1 = b;
    int height = 0;
    while (!b1.getRelative(BlockFace.UP).isEmpty()) {
      height++;
      if (height > 6) {
        break;
      } else if (b1.getRelative(BlockFace.UP).getType() == Material.SUGAR_CANE) {
        b1 = b1.getRelative(BlockFace.UP);
      } else {
        break;
      }
    }
    b1.getRelative(BlockFace.UP).setType(Material.SUGAR_CANE);
    b.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, b.getLocation(), 16);
  }
}
