
package net.mcreator.eridium.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import net.mcreator.eridium.EridiumModElements;

@EridiumModElements.ModElement.Tag
public class EridiumtoolAxeItem extends EridiumModElements.ModElement {
	@ObjectHolder("eridium:eridiumtool_axe")
	public static final Item block = null;
	public EridiumtoolAxeItem(EridiumModElements instance) {
		super(instance, 4);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 802;
			}

			public float getEfficiency() {
				return 10f;
			}

			public float getAttackDamage() {
				return 3f;
			}

			public int getHarvestLevel() {
				return 5;
			}

			public int getEnchantability() {
				return 32;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("eridiumtool_axe"));
	}
}
