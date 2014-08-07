package erebus;

import java.lang.reflect.Field;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import erebus.core.handler.ConfigHandler;
import erebus.item.AntTamingAmulet;
import erebus.item.ArmorGlider;
import erebus.item.BeeTamingAmulet;
import erebus.item.BlockExtractor;
import erebus.item.BottleAntiVenom;
import erebus.item.BucketAntiVenom;
import erebus.item.BucketOfBeetleJuice;
import erebus.item.CavemanClub;
import erebus.item.Compost;
import erebus.item.CompoundGoggles;
import erebus.item.EncrustedDiamond;
import erebus.item.ErebusFood;
import erebus.item.ErebusMaterial;
import erebus.item.ErebusMaterial.DATA;
import erebus.item.ErebusSpecial;
import erebus.item.ExoskeletonArmor;
import erebus.item.FlowerSeeds;
import erebus.item.HomingBeecon;
import erebus.item.HomingBeeconAdvanced;
import erebus.item.HornOfSummoning;
import erebus.item.JadeArmour;
import erebus.item.JadeAxe;
import erebus.item.JadePickaxe;
import erebus.item.JumpBoots;
import erebus.item.MaxSpeedBow;
import erebus.item.MetalIngots;
import erebus.item.NectarCollector;
import erebus.item.Paxel;
import erebus.item.Planticide;
import erebus.item.PortalActivator;
import erebus.item.ReinExoskeletonArmor;
import erebus.item.RitualDagger;
import erebus.item.RolledNewspaper;
import erebus.item.ScorpionPincer;
import erebus.item.SpawnEggs;
import erebus.item.SprayCan;
import erebus.item.SprintLeggings;
import erebus.item.WandOfAnimation;
import erebus.item.WaspDagger;
import erebus.item.WaspSword;
import erebus.item.WebSlinger;
import erebus.item.Whetstone;
import erebus.item.WoodlouseBall;
import erebus.item.bambucket.Bambucket;
import erebus.item.bambucket.BambucketAntiVenom;
import erebus.item.bambucket.BambucketBeetleJuice;
import erebus.item.block.ItemBlockDoorAmber;

public class ModItems {

	// BASIC MATERIALS
	public static final Item portalActivator = new PortalActivator().setUnlocalizedName("portalActivator").setTextureName("erebus:portalActivator");
	public static final Item erebusMaterials = new ErebusMaterial().setUnlocalizedName("erebusMaterials");
	public static final Item erebusSpecialItem = new ErebusSpecial().setUnlocalizedName("erebusSpecialItem");
	public static final Item erebusFood = new ErebusFood().setUnlocalizedName("erebusFood");
	public static final Item metalIngot = new MetalIngots();
	public static final Item turnip = new ItemSeedFood(4, 0.6F, ModBlocks.blockTurnip, Blocks.farmland).setUnlocalizedName("turnips").setTextureName("erebus:turnips");
	public static final Item sprayCan = new SprayCan().setUnlocalizedName("sprayCan").setTextureName("erebus:sprayCan");
	public static final Item wandOfAnimation = new WandOfAnimation().setUnlocalizedName("wandOfAnimation");
	public static final Item hornOfSummoning = new HornOfSummoning().setUnlocalizedName("hornOfSummoning").setTextureName("erebus:hornOfSummoning");
	public static final Item nectarCollector = new NectarCollector().setUnlocalizedName("nectarCollector").setTextureName("erebus:nectarCollector");
	public static final Item beeTamingAmulet = new BeeTamingAmulet().setUnlocalizedName("beeTamingAmulet").setTextureName("erebus:beeTamingAmulet");
	public static final Item doorAmberItem = new ItemBlockDoorAmber(ModBlocks.doorAmber).setUnlocalizedName("doorAmberItem").setTextureName("erebus:doorAmber");
	public static final Item homingBeecon = new HomingBeecon().setUnlocalizedName("homingBeecon").setTextureName("paper");
	public static final Item homingBeeconAdvanced = new HomingBeeconAdvanced().setUnlocalizedName("homingBeeconAdvanced").setTextureName("paper");

	public static final Item flowerSeeds = new FlowerSeeds().setUnlocalizedName("flowerSeeds");
	public static final Item whetstone = new Whetstone().setUnlocalizedName("whetstone").setTextureName("erebus:whetstone");
	public static final Item encrustedDiamond = new EncrustedDiamond().setUnlocalizedName("encrustedDiamond").setTextureName("erebus:encrustedDiamond");
	public static final Item antTamingAmulet = new AntTamingAmulet().setUnlocalizedName("antTamingAmulet").setTextureName("erebus:antTamingAmulet");
	public static final Item compost = new Compost();
	public static final Item planticide = new Planticide();

	// JADE STUFF
	public static final Item jadeHelmet = new JadeArmour(0).setUnlocalizedName("helmetJade").setTextureName("erebus:helmetJade");
	public static final Item jadeBody = new JadeArmour(1).setUnlocalizedName("chestplateJade").setTextureName("erebus:chestplateJade");
	public static final Item jadeLegs = new JadeArmour(2).setUnlocalizedName("leggingsJade").setTextureName("erebus:leggingsJade");
	public static final Item jadeBoots = new JadeArmour(3).setUnlocalizedName("bootsJade").setTextureName("erebus:bootsJade");
	public static final Item jadeSword = new ItemSword(ModMaterials.toolJADE).setUnlocalizedName("swordJade").setTextureName("erebus:swordJade");
	public static final Item jadePickaxe = new JadePickaxe().setUnlocalizedName("pickaxeJade").setTextureName("erebus:pickaxeJade");
	public static final Item jadeAxe = new JadeAxe().setUnlocalizedName("axeJade").setTextureName("erebus:axeJade");
	public static final Item jadeShovel = new ItemSpade(ModMaterials.toolJADE).setUnlocalizedName("shovelJade").setTextureName("erebus:shovelJade");
	public static final Item jadePaxel = new Paxel(ModMaterials.toolJADEPAXEL).setUnlocalizedName("paxelJade").setTextureName("erebus:paxelJade");
	public static final Item jadeHoe = new ItemHoe(ModMaterials.toolJADE).setUnlocalizedName("hoeJade").setTextureName("erebus:hoeJade");

	// EXOSKELETON STUFF
	public static final Item exoskeletonHelmet = new ExoskeletonArmor(0).setUnlocalizedName("helmetExo").setTextureName("erebus:helmetExo");
	public static final Item exoskeletonBody = new ExoskeletonArmor(1).setUnlocalizedName("chestplateExo").setTextureName("erebus:chestplateExo");
	public static final Item exoskeletonLegs = new ExoskeletonArmor(2).setUnlocalizedName("leggingsExo").setTextureName("erebus:leggingsExo");
	public static final Item exoskeletonBoots = new ExoskeletonArmor(3).setUnlocalizedName("bootsExo").setTextureName("erebus:bootsExo");

	public static final Item reinExoskeletonHelmet = new ReinExoskeletonArmor(0).setUnlocalizedName("exoHelmetRein").setTextureName("erebus:exoHelmetRein");
	public static final Item reinExoskeletonBody = new ReinExoskeletonArmor(1).setUnlocalizedName("exoChestplateRein").setTextureName("erebus:exoChestplateRein");
	public static final Item reinExoskeletonLegs = new ReinExoskeletonArmor(2).setUnlocalizedName("exoLeggingsRein").setTextureName("erebus:exoLeggingsRein");
	public static final Item reinExoskeletonBoots = new ReinExoskeletonArmor(3).setUnlocalizedName("exoBootsRein").setTextureName("erebus:exoBootsRein");

	// MISC WEAPONS
	public static final Item fossilClub = new CavemanClub().setFull3D().setUnlocalizedName("clubBone").setTextureName("erebus:clubBone");
	public static final Item waspSword = new WaspSword().setUnlocalizedName("waspSword").setTextureName("paper");
	public static final Item maxSpeedBow = new MaxSpeedBow().setUnlocalizedName("maxSpeedBow").setTextureName("erebus:maxSpeedBow");
	public static final Item waspDagger = new WaspDagger().setUnlocalizedName("waspDagger");
	public static final Item scorpionPincer = new ScorpionPincer().setUnlocalizedName("scorpionPincer").setTextureName("paper");
	public static final Item webSlinger = new WebSlinger().setUnlocalizedName("webSlinger").setTextureName("paper");
	public static final Item blockExtractor = new BlockExtractor().setFull3D().setUnlocalizedName("blockExtractor").setTextureName("erebus:blockExtractor");
	public static final Item woodlouseBall = new WoodlouseBall().setUnlocalizedName("woodlouseBall");
	public static final Item rolledNewspaper = new RolledNewspaper().setUnlocalizedName("rolledNewspaper").setTextureName("erebus:rolledNewspaper");
	public static final Item ritualDagger = new RitualDagger();

	// MISC ARMOR
	public static final Item reinCompoundGoggles = new CompoundGoggles(ModMaterials.armorREINEXOSKELETON, 2, 0).setUnlocalizedName("reinCompoundGoggles").setTextureName("erebus:reinCompoundGoggles");
	public static final Item compoundGoggles = new CompoundGoggles(ModMaterials.armorEXOSKELETON, 2, 0).setUnlocalizedName("compoundGoggles").setTextureName("erebus:compoundGoggles");
	public static final Item sprintLeggings = new SprintLeggings(ModMaterials.armorREINEXOSPECIAL, 2).setUnlocalizedName("sprintLeggings").setTextureName("erebus:sprintLeggings");
	public static final Item jumpBoots = new JumpBoots(ModMaterials.armorREINEXOSPECIAL, 3).setUnlocalizedName("jumpBoots").setTextureName("erebus:jumpBoots");
	public static final Item armorGlider = new ArmorGlider().setUnlocalizedName("armorGlider").setTextureName("erebus:armorGlider");
	public static final Item armorGliderPowered = new ArmorGlider().setUnlocalizedName("armorGliderPowered").setTextureName("erebus:armorGliderPowered");

	// CREATIVE
	public static final Item spawnEggs = new SpawnEggs().setUnlocalizedName("monsterPlacer").setTextureName("spawn_egg");

	// BUCKETS
	public static final Item bambucket = new Bambucket();
	public static final Item bambucketWater = new Bambucket(Blocks.flowing_water).setUnlocalizedName("bambucketWater").setTextureName("erebus:bambucketWater");
	public static final Item bambucketHoney = new Bambucket(ModBlocks.erebusHoneyBlock).setUnlocalizedName("bambucketHoney").setTextureName("erebus:bambucketHoney");
	public static final Item bambucketBeetleJuice = new BambucketBeetleJuice();
	public static final Item bambucketAntiVenom = new BambucketAntiVenom();

	public static final Item bucketAntiVenom = new BucketAntiVenom().setUnlocalizedName("bucketAntiVenom").setTextureName("erebus:bucketAntiVenom");
	public static final Item bucketBeetleJuice = new BucketOfBeetleJuice().setUnlocalizedName("bucketBeetleJuice").setTextureName("erebus:bucketBeetleJuice");
	public static final Item bucketHoney = new ItemBucket(ModBlocks.erebusHoneyBlock).setMaxStackSize(1).setContainerItem(Items.bucket).setUnlocalizedName("bucketHoney").setTextureName("erebus:bucketHoney");

	public static final Item bottleAntiVenom = new BottleAntiVenom().setUnlocalizedName("bottleAntiVenom");

	public static void init() {
		initCreativeTabs();
		registerItems();
		registerProperties();
	}

	private static void initCreativeTabs() {
		ModTabs.items.setTab(erebusMaterials, whetstone, erebusFood, turnip, encrustedDiamond);
		if (ConfigHandler.lead || ConfigHandler.silver || ConfigHandler.copper || ConfigHandler.tin || ConfigHandler.aluminium)
			ModTabs.items.setTab(metalIngot);

		ModTabs.gears.setTab(jadeHelmet, jadeBody, jadeLegs, jadeBoots, jadeSword, jadePickaxe, jadeAxe, jadeShovel, jadePaxel, jadeHoe);
		ModTabs.gears.setTab(exoskeletonHelmet, exoskeletonBody, exoskeletonLegs, exoskeletonBoots, reinExoskeletonHelmet, reinExoskeletonBody, reinExoskeletonLegs, reinExoskeletonBoots);
		ModTabs.gears.setTab(fossilClub, waspSword, waspDagger, maxSpeedBow, wandOfAnimation, scorpionPincer, webSlinger, woodlouseBall, rolledNewspaper);
		ModTabs.gears.setTab(compoundGoggles, reinCompoundGoggles, armorGlider, armorGliderPowered, sprintLeggings, jumpBoots, blockExtractor, nectarCollector);
		ModTabs.specials.setTab(portalActivator, bucketBeetleJuice, bucketHoney, erebusSpecialItem, beeTamingAmulet, homingBeecon, homingBeeconAdvanced, antTamingAmulet, sprayCan, hornOfSummoning, flowerSeeds, spawnEggs);

		// Special Case
		ModTabs.blocks.setTab(doorAmberItem);
	}

	private static void registerItems() {
		try {
			for (Field f : ModItems.class.getDeclaredFields()) {
				Object obj = f.get(null);
				if (obj instanceof Item)
					registerItem((Item) obj);
				else if (obj instanceof Item[])
					for (Item item : (Item[]) obj)
						registerItem(item);
			}
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	private static void registerItem(Item item) {
		String name = item.getUnlocalizedName();
		String[] strings = name.split("\\.");
		GameRegistry.registerItem(item, strings[strings.length - 1]);
	}

	private static void registerProperties() {
		GameRegistry.registerFuelHandler(new IFuelHandler() {

			@Override
			public int getBurnTime(ItemStack fuel) {
				return fuel.getItem() == erebusMaterials && fuel.getItemDamage() == DATA.bamboo.ordinal() ? 300 : 0;
			}
		});
	}
}