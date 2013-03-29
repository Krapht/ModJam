package krapht.modjam;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class TheBlockRenderer implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {

	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		
		TileEntity tile = world.getBlockTileEntity(x, y, z);
		if (!(tile instanceof TheEntity)) return false;
		
		TheEntity theEntity = (TheEntity) tile;
		
		ForgeDirection dir = theEntity.getOrientation();
		
		switch(dir){
		case DOWN:
			renderer.uvRotateBottom 	= 0;
			renderer.uvRotateTop 		= 0;
			renderer.uvRotateNorth 		= 0;	//Actually West
			renderer.uvRotateSouth 		= 0;	//Actually East
			renderer.uvRotateWest 		= 0;
			renderer.uvRotateEast 		= 0;
			break;
		case UP:
			renderer.uvRotateBottom 	= 0;
			renderer.uvRotateTop 		= 0;
			renderer.uvRotateNorth 		= 3;	//Actually West
			renderer.uvRotateSouth 		= 3;	//Actually East
			renderer.uvRotateWest 		= 3;
			renderer.uvRotateEast 		= 3;
			break;
		case NORTH:
			renderer.uvRotateBottom 	= 3;
			renderer.uvRotateTop 		= 3;
			renderer.uvRotateNorth 		= 1;	//Actually West
			renderer.uvRotateSouth 		= 2;	//Actually East
			renderer.uvRotateWest 		= 0;
			renderer.uvRotateEast 		= 0;
			break;
		case SOUTH:
			renderer.uvRotateBottom 	= 0;
			renderer.uvRotateTop 		= 0;
			renderer.uvRotateNorth 		= 2;	//Actually West
			renderer.uvRotateSouth 		= 1;	//Actually East
			renderer.uvRotateWest 		= 0;
			renderer.uvRotateEast 		= 0;
			break;
		case WEST:
			renderer.uvRotateBottom 	= 2;
			renderer.uvRotateTop 		= 1;
			renderer.uvRotateNorth 		= 0;	//Actually West
			renderer.uvRotateSouth 		= 0;	//Actually East
			renderer.uvRotateWest 		= 1;	//Actually South
			renderer.uvRotateEast 		= 2;	//Actually North
			break;
//		case EAST:
//			renderer.uvRotateBottom 	= 1;
//			renderer.uvRotateTop 		= 2;
//			renderer.uvRotateNorth 		= 2;
//			renderer.uvRotateSouth 		= 2;
//			renderer.uvRotateWest 		= 1;
//			renderer.uvRotateEast 		= 1;
//			break;			
		default:
			break;
		
		}
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
