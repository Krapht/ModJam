package krapht.modjam;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TheBlock extends BlockContainer {

	public TheBlock(int blockId, Material par2Material) {
		super(blockId, par2Material);
 
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TheEntity();
	}

}
