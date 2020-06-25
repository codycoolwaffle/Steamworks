package waffletopia.steamworks.common.item.material;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public class DapperMaterial implements IArmorMaterial
{
	@Override
	public int getDurability(EquipmentSlotType slotIn)
	{
		return Items.IRON_HELMET.getMaxDamage(Items.IRON_HELMET.getDefaultInstance());
	}
	
	@Override
	public int getDamageReductionAmount(EquipmentSlotType slotIn)
	{
		return 2;
	}
	
	@Override
	public int getEnchantability()
	{
		return 12;
	}
	
	@Override
	public SoundEvent getSoundEvent()
	{
		return SoundEvents.ITEM_ARMOR_EQUIP_IRON;
	}
	
	@Override
	public Ingredient getRepairMaterial()
	{
		return Ingredient.fromTag(ItemTags.getCollection()
		                                  .getOrCreate(new ResourceLocation("forge",
		                                                                    "ingots/brass")));
	}
	
	@Override
	public String getName()
	{
		return "dapper";
	}
	
	@Override
	public float getToughness()
	{
		return 0F;
	}
}
