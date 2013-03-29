package krapht.modjam;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TheEntity extends TileEntity implements IInventory {
	
	private IInventory otherInventory;
	private ForgeDirection orientation = ForgeDirection.UNKNOWN;
	
	private TileEntity getOtherTile(){
		
	}

	@Override
	public int getSizeInventory() {
		if (!(otherInventory instanceof IInventory)) return 0;
		return otherInventory.getSizeInventory();
	}

	@Override
	public ItemStack getStackInSlot(int slotNo) {
		if (!(otherInventory instanceof IInventory)) return null;
		return otherInventory.getStackInSlot(slotNo);
	}

	@Override
	public ItemStack decrStackSize(int slotNo, int count) {
		if (!(otherInventory instanceof IInventory)) return null;
		return otherInventory.decrStackSize(slotNo, count);
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		return null;
	}

	@Override
	public void setInventorySlotContents(int slotNo, ItemStack itemstack) {
		if (!(otherInventory instanceof IInventory)) return;
		otherInventory.setInventorySlotContents(slotNo, itemstack);
	}

	@Override
	public String getInvName() {
		return null;
	}

	@Override
	public boolean isInvNameLocalized() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		if (!(otherInventory instanceof IInventory)) return 0;
		return otherInventory.getInventoryStackLimit();
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		if (!(otherInventory instanceof IInventory)) return false;
		return otherInventory.isUseableByPlayer(entityplayer);
	}

	@Override
	public void openChest() {
		
		
	}

	@Override
	public void closeChest() {
		
	}

	@Override
	public boolean isStackValidForSlot(int slotNo, ItemStack itemstack) {
		if (!(otherInventory instanceof IInventory)) return false;
		return otherInventory.isStackValidForSlot(slotNo, itemstack);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		if (tag.hasKey("orientation")){
			orientation = ForgeDirection.VALID_DIRECTIONS[tag.getInteger("orientation")];
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		if (orientation != ForgeDirection.UNKNOWN){
			tag.setInteger("orientation", orientation.ordinal());
		}
	}

}
