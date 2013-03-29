package krapht.modjam;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TheBlock extends BlockContainer {

	@SideOnly(Side.CLIENT)
	private Icon target;
	@SideOnly(Side.CLIENT)
	private Icon other;
	
	public TheBlock(int blockId, Material par2Material) {
		super(blockId, par2Material);
 
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TheEntity();
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float par7, float par8, float par9) {
		if (player.inventory.getCurrentItem() != null){
			if (player.inventory.getCurrentItem().getItem() == ModJam.poker){
				((TheEntity)world.getBlockTileEntity(x, y, z)).setOrientation(ForgeDirection.VALID_DIRECTIONS[side]);
				world.markBlockForRenderUpdate(x, y, z);
				return true;
			}
		}

		if (player.isSneaking()){
			System.out.println("Sneaky!");
		}
		return false;
		//return super.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer,
		//par6, par7, par8, par9);
	}
	
	@Override
	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player) {
		if (player.isSneaking()){
			System.out.println("Sneaky!");
		}
		super.onBlockClicked(world, x, y, z, player);
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int par5) {
		super.onNeighborBlockChange(world, x, y, z, par5);
		TileEntity tile = world.getBlockTileEntity(x, y, z);
		if (tile instanceof TheEntity){
			((TheEntity)tile).refresh();
		}
		
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getBlockTextureFromSideAndMetadata(int side, int meta) {
		return other;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getBlockTexture(IBlockAccess world, int x, int y, int z, int side) {
		ForgeDirection orientation = ForgeDirection.VALID_DIRECTIONS[side];
		TileEntity tile = world.getBlockTileEntity(x, y, z);
		if (tile instanceof TheEntity){
			if (((TheEntity)tile).getOrientation() == orientation){
				return target;
			}
			return other;
		}
		return other;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		target = par1IconRegister.registerIcon("modjam:target");
		other = par1IconRegister.registerIcon("modjam:other");
	}
}
