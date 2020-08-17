
package net.mcreator.eridium.item;

@EridiumModElements.ModElement.Tag
public class EridiumArmorItem extends EridiumModElements.ModElement {

	@ObjectHolder("eridium:eridium_armor_helmet")
	public static final Item helmet = null;

	@ObjectHolder("eridium:eridium_armor_chestplate")
	public static final Item body = null;

	@ObjectHolder("eridium:eridium_armor_leggings")
	public static final Item legs = null;

	@ObjectHolder("eridium:eridium_armor_boots")
	public static final Item boots = null;

	public EridiumArmorItem(EridiumModElements instance) {
		super(instance, 13);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 25;
			}

			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{2, 4, 4, 3}[slot.getIndex()];
			}

			public int getEnchantability() {
				return 9;
			}

			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}

			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "eridium_armor";
			}

			public float getToughness() {
				return 3f;
			}
		};

		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)) {

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "eridium:textures/models/armor/eridiumarmor_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

		}.setRegistryName("eridium_armor_helmet"));

		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)) {

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "eridium:textures/models/armor/eridiumarmor_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

		}.setRegistryName("eridium_armor_chestplate"));

		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)) {

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "eridium:textures/models/armor/eridiumarmor_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

		}.setRegistryName("eridium_armor_leggings"));

		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)) {

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "eridium:textures/models/armor/eridiumarmor_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

		}.setRegistryName("eridium_armor_boots"));
	}

}
