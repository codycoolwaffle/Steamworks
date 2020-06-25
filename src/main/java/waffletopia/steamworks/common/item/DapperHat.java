package waffletopia.steamworks.common.item;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.LazyValue;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.DistExecutor;

import javax.annotation.Nullable;

import waffletopia.steamworks.client.model.dapper_hat;
import waffletopia.steamworks.common.core.SteamworksCreativeTab;
import waffletopia.steamworks.common.item.material.DapperMaterial;

public class DapperHat extends ArmorItem
{
	private final LazyValue<BipedModel<?>> model;
	
	public DapperHat()
	{
		super(new DapperMaterial(), EquipmentSlotType.HEAD, new Item.Properties().group(SteamworksCreativeTab.INSTANCE));
		this.model = DistExecutor.runForDist(() -> () -> new LazyValue<>(() -> this.provideArmorModel()),
		                                     () -> () -> null);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type)
	{
		return "steamworks:textures/model/dapper_hat.png";
	}
	
	@Nullable
	@Override
	@OnlyIn(Dist.CLIENT)
	@SuppressWarnings("unchecked")
	public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default) {
		return (A) model.getValue();
	}
	
	@OnlyIn(Dist.CLIENT)
	public BipedModel<?> provideArmorModel() {
		return new dapper_hat();
	}
	
	@Override
	public void setDamage(ItemStack stack, int damage) {
		if (damage > stack.getMaxDamage()) {
			damage = stack.getDamage();
		}
		super.setDamage(stack, damage);
	}
}