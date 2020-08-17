
package net.mcreator.eridium.item;

@EridiumModElements.ModElement.Tag
public class EridiumMultiToolItem extends EridiumModElements.ModElement {

	@ObjectHolder("eridium:eridium_multi_tool")
	public static final Item block = null;

	public EridiumMultiToolItem(EridiumModElements instance) {
		super(instance, 13);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemToolCustom() {

		}.setRegistryName("eridium_multi_tool"));
	}

	private static class ItemToolCustom extends Item {

		protected ItemToolCustom() {
			super(new Item.Properties().group(ItemGroup.TOOLS).maxDamage(802));
		}

		@Override
		public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
			Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(equipmentSlot);
			if (equipmentSlot == EquipmentSlotType.MAINHAND) {
				multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(),
						new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Tool modifier", 3f, AttributeModifier.Operation.ADDITION));
				multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(),
						new AttributeModifier(ATTACK_SPEED_MODIFIER, "Tool modifier", -3, AttributeModifier.Operation.ADDITION));

			}
			return multimap;
		}

		@Override
		public boolean canHarvestBlock(BlockState state) {
			return 5 >= state.getHarvestLevel();
		}

		@Override
		public float getDestroySpeed(ItemStack itemstack, BlockState blockstate) {
			return 10f;
		}

		@Override
		public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
			stack.damageItem(1, attacker, i -> i.sendBreakAnimation(EquipmentSlotType.MAINHAND));
			return true;
		}

		@Override
		public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
			stack.damageItem(1, entityLiving, i -> i.sendBreakAnimation(EquipmentSlotType.MAINHAND));
			return true;
		}

		@Override
		public int getItemEnchantability() {
			return 32;
		}

	}

}
