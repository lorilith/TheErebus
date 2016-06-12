package erebus.items;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import erebus.ModItems;
import erebus.ModMaterials;
import erebus.ModTabs;
import erebus.items.ItemMaterials.EnumType;

public class ItemArmorExoskeleton extends ItemArmor {

	public ItemArmorExoskeleton(EntityEquipmentSlot slot) {
		super(ModMaterials.ARMOR_EXOSKELETON, 2, slot);
		setCreativeTab(ModTabs.GEAR);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public String getArmorTexture(ItemStack is, Entity entity, EntityEquipmentSlot slot, String type) {
		if (is.getItem() == ModItems.EXOSKELETON_LEGGINGS)
			return "erebus:textures/models/armor/exoskeleton_2.png";
		else
			return "erebus:textures/models/armor/exoskeleton_1.png";
	}

	@Override
	public boolean getIsRepairable(ItemStack armour, ItemStack material) {
		return material.getItem() == ModItems.MATERIALS && material.getItemDamage() == EnumType.PLATE_EXO.ordinal();
	}
}