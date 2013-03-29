package krapht.modjam;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class TheBlockRenderer implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {

	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		
		TileEntity tile = world.getBlockTileEntity(x, y, z);
		if (!(tile instanceof TheEntity)) return false;
		
		
		
		
		renderer.uvRotateNorth = 3;
		renderer.uvRotateTop = 1;
		renderer.renderStandardBlock(block, x, y, z);
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory() {
		return false;
	}

	@Override
	public int getRenderId() {
		return TheBlock.renderType;
	}

}
