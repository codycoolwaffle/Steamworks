package waffletopia.steamworks.common.entity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

import javax.annotation.ParametersAreNonnullByDefault;

public class EntityAlloyKiln extends TileEntity
{
	
	public EntityAlloyKiln(TileEntityType<?> tileEntityTypeIn)
	{
		super(tileEntityTypeIn);
	}
	
	@ParametersAreNonnullByDefault
	public void setInventorySlotContents(int index, ItemStack stack)
	{
	
	}
	
	@ParametersAreNonnullByDefault
	public boolean isUsableByPlayer(PlayerEntity player)
	{
		return false;
	}
	
	public void clear()
	{
	
	}
}
