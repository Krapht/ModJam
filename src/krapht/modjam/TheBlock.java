package krapht.modjam;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
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
	
	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7,	float par8, float par9) {
		if (par5EntityPlayer.isSneaking()){
			System.out.println("Sneaky!");
		}
		return false;
		//return super.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer,
		//par6, par7, par8, par9);
	}
	
	@Override
	public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer) {
		if (par5EntityPlayer.isSneaking()){
			System.out.println("Sneaky!");
		}
		super.onBlockClicked(par1World, par2, par3, par4, par5EntityPlayer);
	}

}
