package krapht.modjam;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TheEntity extends TileEntity implements IInventory {
	
	private TileEntity otherTile;
	private ForgeDirection orientation = ForgeDirection.UNKNOWN;
	
	private IInventory getInventory(){
		if (otherTile == null || otherTile.isInvalid() || !(otherTile instanceof IInventory)) return null;
		return (IInventory) otherTile;
	}
	
	public void refresh() {
		if (orientation == ForgeDirection.UNKNOWN){
			otherTile = null;
		} else {
			otherTile = this.worldObj.getBlockTileEntity(this.xCoord + orientation.offsetX, this.yCoord + orientation.offsetY, this.zCoord + orientation.offsetZ);
		}
	}
	
	public ForgeDirection getOrientation(){
		return orientation;
	}

	public void setOrientation(ForgeDirection orientation) {
		this.orientation = orientation;
		
	}

	@Override
	public int getSizeInventory() {
		if (getInventory() == null) return 0;
		return getInventory().getSizeInventory();
	}

	@Override
	public ItemStack getStackInSlot(int slotNo) {
		if (getInventory() == null) return null;
		return getInventory().getStackInSlot(slotNo);
	}

	@Override
	public ItemStack decrStackSize(int slotNo, int count) {
		if (getInventory() == null) return null;
		return getInventory().decrStackSize(slotNo, count);
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		return null;
	}

	@Override
	public void setInventorySlotContents(int slotNo, ItemStack itemstack) {
		if (getInventory() == null) return;
		getInventory().setInventorySlotContents(slotNo, itemstack);
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
		if (getInventory() == null) return 0;
		return getInventory().getInventoryStackLimit();
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		if (getInventory() == null) return false;
		return getInventory().isUseableByPlayer(entityplayer);
	}

	@Override
	public void openChest() {
		
		
	}

	@Override
	public void closeChest() {
		
	}

	@Override
	public boolean isStackValidForSlot(int slotNo, ItemStack itemstack) {
		if (getInventory() == null) return false;
		return getInventory().isStackValidForSlot(slotNo, itemstack);
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
