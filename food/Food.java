package clashsoft.mods.morefood.food;

import static clashsoft.cslib.minecraft.item.meta.IMetaItemRecipe.CRAFTING;
import static clashsoft.cslib.minecraft.item.meta.IMetaItemRecipe.FURNACE;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import clashsoft.cslib.minecraft.item.meta.IMetaItem;
import clashsoft.mods.morefood.MoreFoodMod;
import cpw.mods.fml.common.ObfuscationReflectionHelper;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;

public class Food implements IMetaItem
{
	public static Food[]		foodTypes				= new Food[1024];
	public static List<Food>	foodList				= new ArrayList<Food>();
	
	// Vanilla Food Items
	
	public static Food			apple					= new Food((ItemFood) Items.apple, 0, null);
	public static Food			appleStomped			= new Food(36, "Stomped Apple", "apple_stomped", 4, new FoodRecipe(1, new ItemStack(Items.apple)));
	public static Food			appleGold1				= new Food((ItemFood) Items.golden_apple, 0, new FoodRecipe(CRAFTING, 1, new Object[] {
			"ggg",
			"gag",
			"ggg",
			'g',
			Items.gold_ingot,
			'a',
			Items.apple								}));
	public static Food			appleGold2				= new Food((ItemFood) Items.golden_apple, 1, new FoodRecipe(CRAFTING, 1, new Object[] {
			"ggg",
			"gag",
			"ggg",
			'g',
			Blocks.gold_block,
			'a',
			Items.apple								}));
	public static Food			appleDiamond			= new Food(37, "Diamond Apple", "apple_diamond", 8, new FoodRecipe(CRAFTING, 1, new Object[] {
			"ddd",
			"dxd",
			"ddd",
			'd',
			Items.diamond,
			'x',
			Items.apple								})).setEffects(new PotionEffect(Potion.jump.id, 600, 1), new PotionEffect(Potion.damageBoost.id, 1200, 2));
	
	public static Food			melon					= new Food((ItemFood) Items.melon, 0, null);
	public static Food			melonGold1				= new Food(Items.speckled_melon, 0, new FoodRecipe(CRAFTING, 1, new Object[] {
			"ggg",
			"gmg",
			"ggg",
			'g',
			Items.gold_nugget,
			'm',
			Items.melon								}));
	
	public static Food			potato					= new Food((ItemSeedFood) Items.potato, 0, null);
	public static Food			potatoCooked			= new Food((ItemFood) Items.baked_potato, 0, new FoodRecipe(FURNACE, 1, new ItemStack(Items.potato), 0.1F));
	public static Food			potatoStomped			= new Food(38, "Stomped Potato", "potato_stomped", 2, new FoodRecipe(1, new ItemStack(Items.potato)));
	public static Food			potatoGold1				= new Food(39, EnumChatFormatting.AQUA + "Golden Potato", "potato_gold", 5, new FoodRecipe(CRAFTING, 1, new Object[] {
			"ggg",
			"gpg",
			"ggg",
			'g',
			Items.gold_ingot,
			'p',
			Items.potato								})).setEffects(new PotionEffect(Potion.field_76444_x.id, 2400, 0));
	public static Food			potatoGold2				= new Food(40, EnumChatFormatting.LIGHT_PURPLE + "Golden Potato", "potato_gold", 7, new FoodRecipe(CRAFTING, 1, new Object[] {
			"GGG",
			"GpG",
			"GGG",
			'G',
			Blocks.gold_block,
			'p',
			Items.potato								})).setEffects(new PotionEffect(Potion.field_76444_x.id, 2400, 0), new PotionEffect(Potion.regeneration.id, 600, 4), new PotionEffect(Potion.fireResistance.id, 6000, 0));
	public static Food			potatoDiamond			= new Food(41, "Diamond Potato", "potato_diamond", 6, new FoodRecipe(CRAFTING, 1, new Object[] {
			"ddd",
			"dxd",
			"ddd",
			'd',
			Items.diamond,
			'x',
			Items.potato								})).setEffects(new PotionEffect(Potion.digSpeed.id, 600, 3), new PotionEffect(Potion.moveSpeed.id, 3000, 1));
	public static Food			poisonousPotato			= new Food((ItemFood) Items.poisonous_potato, 0, null);
	
	public static Food			carrot					= new Food((ItemSeedFood) Items.carrot, 0, null);
	public static Food			carrotCooked			= new Food(42, "Cooked Carrot", "carrot_cooked", 4, new FoodRecipe(FURNACE, 1, new ItemStack(Items.carrot), 0.1F));
	public static Food			carrotStomped			= new Food(43, "Stomped Carrot", "carrot_stomped", 2, new FoodRecipe(1, new ItemStack(Items.carrot)));
	public static Food			carrotGold1				= new Food((ItemFood) Items.golden_carrot, 0, new FoodRecipe(CRAFTING, 1, new Object[] {
			"ggg",
			"gcg",
			"ggg",
			'g',
			Items.gold_nugget,
			'c',
			Items.carrot								}));
	public static Food			carrotDiamond			= new Food(44, "Diamond Carrot", "carrot_diamond", 6, new FoodRecipe(CRAFTING, 1, new Object[] {
			"ddd",
			"dxd",
			"ddd",
			'd',
			Items.diamond,
			'x',
			Items.carrot								})).setEffects(new PotionEffect(Potion.invisibility.id, 3000, 0));
	
	public static Food			bread					= new Food((ItemFood) Items.bread, 0, new FoodRecipe(CRAFTING, 1, new Object[] {
			"www",
			'w',
			Items.wheat								}));
	public static Food			cookie					= new Food((ItemFood) Items.cookie, 0, new FoodRecipe(CRAFTING, 1, new Object[] {
			"wcw",
			'w',
			Items.wheat,
			'c',
			new ItemStack(Items.dye, 1, 3)				}));
	
	public static Food			porkRaw					= new Food((ItemFood) Items.porkchop, 0, null);
	public static Food			porkCooked				= new Food((ItemFood) Items.cooked_porkchop, 0, new FoodRecipe(FURNACE, 1, new ItemStack(Items.porkchop), 0.1F));
	public static Food			beefRaw					= new Food((ItemFood) Items.beef, 0, null);
	public static Food			beefCooked				= new Food((ItemFood) Items.cooked_beef, 0, new FoodRecipe(FURNACE, 1, new ItemStack(Items.beef), 0.1F));
	public static Food			chickenRaw				= new Food((ItemFood) Items.chicken, 0, null);
	public static Food			chickenCooked			= new Food((ItemFood) Items.cooked_chicken, 0, new FoodRecipe(FURNACE, 1, new ItemStack(Items.chicken), 0.1F));
	public static Food			fishRaw					= new Food((ItemFood) Items.fish, 0, null);
	public static Food			fishCooked				= new Food((ItemFood) Items.cooked_fished, 0, new FoodRecipe(FURNACE, 1, new ItemStack(Items.fish), 0.1F));
	
	public static Food			rottenFlesh				= new Food((ItemFood) Items.rotten_flesh, 0, null);
	public static Food			spiderEye				= new Food((ItemFood) Items.spider_eye, 0, null);
	
	public static Food			pumpkinPie				= new Food((ItemFood) Items.pumpkin_pie, 0, new FoodRecipe(1, new ItemStack(Items.egg), new ItemStack(Items.sugar), new ItemStack(Blocks.pumpkin)));
	
	public static Food			salad					= new Food(0, "Salad", "salad", 2, MoreFoodMod.saladPlant);
	public static Food			cucumber				= new Food(1, "Cucumber", "cucumber", 2, MoreFoodMod.cucumberPlant);
	public static Food			rice					= new Food(2, "Rice", "rice", 2, MoreFoodMod.ricePlant);
	public static Food			chili					= new Food(3, "Chili", "chili", 2, MoreFoodMod.chiliPlant);
	public static Food			tomato					= new Food(4, "Tomato", "tomato", 2, MoreFoodMod.tomatoPlant);
	public static Food			paprika					= new Food(5, "Paprika", "paprika", 3, MoreFoodMod.paprikaPlant);
	public static Food			onion					= new Food(6, "Onion", "onion", 3, MoreFoodMod.onionPlant);
	public static Food			pepperSeeds				= new Food(7, "Pepper Balls", "pepperballs", 0, MoreFoodMod.pepperPlant);
	public static Food			vanillaSeeds			= new Food(8, "Vanilla Seeds", "pepperballs", 0, MoreFoodMod.vanillaPlant);
	public static Food			corn					= new Food(9, "Corn", "corn", 4, MoreFoodMod.cornPlant);
	public static Food			breadslice				= new Food(10, "Bread Slice", "bread_slice", 3, new FoodRecipe(2, new ItemStack(Items.bread)));
	public static Food			toast					= new Food(11, "Toast", "toast_raw", 5, new FoodRecipe(3, breadslice.asStack()));
	public static Food			toast_toasted			= new Food(12, "Toastet Toast", "toast_toasted", 2, new FoodRecipe(1, toast.asStack(), 0.1F));
	public static Food			butter					= new Food(13, "Butter", "butter", 3, new FoodRecipe(1, new ItemStack(Items.milk_bucket), 0.2F));
	public static Food			salami					= new Food(14, "Salami", "salami", 3, new FoodRecipe(4, new ItemStack(Items.beef)));
	public static Food			cheese					= new Food(15, "Cheese", "cheese", 5, new FoodRecipe(1, butter.asStack(), new ItemStack(Items.milk_bucket), new ItemStack(Items.milk_bucket)));
	public static Food			cheese_slice			= new Food(16, "Cheese Slice", "cheese_slice", 3, new FoodRecipe(16, cheese.asStack()));
	public static Food			toast_cheese			= new Food(17, "Toast with Cheese", "toast_cheese", 5, new FoodRecipe(1, toast_toasted.asStack(), cheese_slice.asStack()));
	public static Food			toast_salami			= new Food(18, "Toast with Salami", "toast_salami", 6, new FoodRecipe(1, toast_toasted.asStack(), salami.asStack()));
	public static Food			bacon_raw				= new Food(19, "Raw Bacon Slice", "bacon_raw", 2, new FoodRecipe(3, new ItemStack(Items.porkchop), new ItemStack(Items.porkchop)));
	public static Food			bacon					= new Food(20, "Bacon", "bacon_cooked", 6, new FoodRecipe(FURNACE, 1, bacon_raw.asStack(), 0.1F));
	public static Food			pasta					= new Food(21, "Pasta", "pasta", 2, new FoodRecipe(CRAFTING, 4, new Object[] {
			"wsw",
			'w',
			Items.wheat,
			's',
			MoreFoodMod.salt							}));
	public static Food			meatball				= new Food(22, "Meat Ball", "ham", 2, new FoodRecipe(CRAFTING, 4, new Object[] {
			"bb",
			"bb",
			'b',
			Items.beef									}));
	public static Food			hamburger				= new Food(23, "Hamburger", "hamburger", 5, new FoodRecipe(CRAFTING, 1, new Object[] {
			" b ",
			"smt",
			" b ",
			'b',
			breadslice.asStack(),
			's',
			salad.asStack(),
			'm',
			meatball.asStack(),
			't',
			tomato.asStack()							}));
	public static Food			pizza					= new Food(24, "Pizza", "pizza", 0, MoreFoodMod.pizza, new FoodRecipe(CRAFTING, 1, new Object[] {
			" S ",
			"sts",
			"www",
			'S',
			salad.asStack(),
			's',
			salami.asStack(),
			't',
			tomato.asStack(),
			'w',
			new ItemStack(Items.wheat)					}));
	public static Food			fried_egg				= new Food(25, "Fried Egg", "fried_egg", 4, new FoodRecipe(FURNACE, 1, new ItemStack(Items.egg), 0.2F));
	public static Food			omelette				= new Food(26, "Omelette", "omelette", 7, new FoodRecipe(CRAFTING, 1, new Object[] {
			"eee",
			'e',
			new ItemStack(Items.egg)					}));
	public static Food			popcorn					= new Food(27, "Popcorn", "popcorn", 4, new FoodRecipe(FURNACE, 4, corn.asStack(), 0.25F));
	public static Food			popcorn_sweet			= new Food(28, "Sweet Popcorn", "popcorn", 5, new FoodRecipe(1, popcorn.asStack(), new ItemStack(Items.sugar)));
	public static Food			popcorn_salty			= new Food(29, "Salty Popcorn", "popcorn", 5, new FoodRecipe(1, popcorn.asStack(), new ItemStack(MoreFoodMod.salt)));
	public static Food			candycane				= new Food(30, "Candy cane", "candy_cane", 3, new FoodRecipe(CRAFTING, 2, new Object[] {
			"s  ",
			" s ",
			"  s",
			's',
			Items.sugar								}));
	public static Food			chocolate				= new Food(31, "Chocolate Bar", "chocolatebar", 4, new FoodRecipe(4, new ItemStack(Items.dye, 1, 3), new ItemStack(Items.dye, 1, 3), new ItemStack(Items.milk_bucket), new ItemStack(Items.sugar)));
	public static Food			chocolateCookie			= new Food(32, "Chocolate Cookie", "chocolatecookie", 2, new FoodRecipe(CRAFTING, 4, new Object[] {
			"wcw",
			'w',
			Items.wheat,
			'c',
			chocolate.asStack()						}));
	public static Food			cereals1				= new Food(33, "Cereals", "cereals_1", 0, new FoodRecipe(4, new ItemStack(Items.wheat)));
	public static Food			cereals2				= new Food(34, "Chocolate Cereals", "cereals_2", 0, new FoodRecipe(8, new ItemStack(Items.wheat), new ItemStack(Items.dye, 1, 3)));
	public static Food			honeydrop				= new Food(35, "Honey Drop", "honeydrop", 1);
	public static Food			chocolateWhite			= new Food(45, "White Chocolate Bar", "chocolatebar_white", 4, new FoodRecipe(4, butter.asStack(), new ItemStack(Items.milk_bucket), new ItemStack(Items.milk_bucket), new ItemStack(Items.sugar)));
	public static Food			chocolateCow			= new Food(46, "Cow Chocolate Bar", "chocolatebar_cow", 4, new FoodRecipe(4, new ItemStack(Items.dye, 1, 3), new ItemStack(Items.dye, 1, 3), new ItemStack(Items.milk_bucket), butter.asStack(), new ItemStack(Items.sugar)));
	public static Food			frenchfries				= new Food(47, "French Fries", "frenchfries", 5, new FoodRecipe(1, potatoCooked.asStack(), potatoCooked.asStack(), butter.asStack(), new ItemStack(Items.paper), new ItemStack(Items.dye, 1, 1)));
	
	public static Food			orange					= new Food(48, "Orange", "orange", 3, MoreFoodMod.fruitSaplings).setMetadataPlaced(0);
	public static Food			pear					= new Food(49, "Pear", "pear", 3, MoreFoodMod.fruitSaplings).setMetadataPlaced(1);
	public static Food			cherry					= new Food(50, "Cherry", "cherry", 3, MoreFoodMod.fruitSaplings).setMetadataPlaced(2);
	public static Food			strawberry				= new Food(51, "Strawberry", "strawberry", 3, MoreFoodMod.strawberryBush);
	public static Food			raspberry				= new Food(52, "Raspberry", "raspberry", 3, MoreFoodMod.raspberryBush);
	public static Food			blackberry				= new Food(53, "Blackberry", "blackberry", 3, MoreFoodMod.blackberryBush);
	public static Food			blueberry				= new Food(54, "Blueberry", "blueberry", 2, MoreFoodMod.blueberryBush);
	public static Food			redcurrant				= new Food(55, "Redcurrant", "redcurrant", 2, MoreFoodMod.redcurrantBush);
	
	public static Food			plum					= new Food(56, "Plum", "plum", 3, MoreFoodMod.fruitSaplings).setMetadataPlaced(3);
	public static Food			banana					= new Food(57, "Banana", "banana", 3, MoreFoodMod.fruitSaplings2).setMetadataPlaced(0);
	public static Food			seagrass				= new Food(58, "Sea Grass", "seagrass", 2);
	
	public static Food			icecube					= new Food(80, "Ice Cube", "icecube", 0, new FoodRecipe(4, new ItemStack(Blocks.ice)));
	public static Food			icecream				= new Food(81, "Icecream", "icecream", 0, new FoodRecipe(2, icecube.asStack(), new ItemStack(Items.snowball), new ItemStack(Items.milk_bucket)));
	public static Food			icecreamChocolate		= new Food(82, "Chocolate Icecream", "icecream_chocolate", 1, new FoodRecipe(1, chocolate.asStack(), icecream.asStack()));
	public static Food			icecreamVanilla			= new Food(83, "Vanilla Icecream", "icecream_vanilla", 1, new FoodRecipe(1, new ItemStack(MoreFoodMod.vanilla), icecream.asStack()));
	public static Food			icecreamStrawberry		= new Food(84, "Strawberry Icecream", "icecream_strawberry", 1, new FoodRecipe(1, strawberry.asStack(), icecream.asStack()));
	public static Food			icecreamCone			= new Food(85, "Icecream Cone", "icecream_cone", 2, new FoodRecipe(CRAFTING, 6, new Object[] {
			"w w",
			" w ",
			" w ",
			'w',
			Items.wheat								}));
	public static Food			icecreamConeChocolate	= new Food(86, "Chocolate Icecream", "icecream_cone_chocolate", 3, new FoodRecipe(CRAFTING, 1, new Object[] {
			"i",
			"c",
			'i',
			icecreamChocolate.asStack(),
			'c',
			icecreamCone.asStack()						}));
	public static Food			icecreamConeVanilla		= new Food(87, "Vanilla Icecream", "icecream_cone_vanilla", 3, new FoodRecipe(CRAFTING, 1, new Object[] {
			"i",
			"c",
			'i',
			icecreamVanilla.asStack(),
			'c',
			icecreamCone.asStack()						}));
	public static Food			icecreamConeStrawberry	= new Food(88, "Strawberry Icecream", "icecream_cone_strawberry", 3, new FoodRecipe(CRAFTING, 1, new Object[] {
			"i",
			"c",
			'i',
			icecreamStrawberry.asStack(),
			'c',
			icecreamCone.asStack()						}));
	public static Food			icecreamConeCV			= new Food(89, "Icecream", "icecream_cone_c_v", 4, new FoodRecipe(CRAFTING, 1, new Object[] {
			"c",
			"v",
			"C",
			'c',
			icecreamChocolate.asStack(),
			'v',
			icecreamVanilla.asStack(),
			'C',
			icecreamCone.asStack()						}));
	public static Food			icecreamConeCS			= new Food(90, "Icecream", "icecream_cone_c_s", 4, new FoodRecipe(CRAFTING, 1, new Object[] {
			"c",
			"s",
			"C",
			'c',
			icecreamChocolate.asStack(),
			's',
			icecreamStrawberry.asStack(),
			'C',
			icecreamCone.asStack()						}));
	public static Food			icecreamConeVS			= new Food(91, "Icecream", "icecream_cone_v_s", 4, new FoodRecipe(CRAFTING, 1, new Object[] {
			"v",
			"s",
			"C",
			'v',
			icecreamVanilla.asStack(),
			's',
			icecreamStrawberry.asStack(),
			'C',
			icecreamCone.asStack()						}));
	public static Food			icecreamConeCVS			= new Food(92, "Icecream", "icecream_cone_c_v_s", 5, new FoodRecipe(CRAFTING, 1, new Object[] {
			"cvs",
			" C ",
			'c',
			icecreamChocolate.asStack(),
			'v',
			icecreamVanilla.asStack(),
			's',
			icecreamStrawberry.asStack(),
			'C',
			icecreamCone.asStack()						}));
	
	static
	{
		setCategory("Vanilla Meat Items", 0x442319, porkRaw.register(), porkCooked.register(), beefRaw.register(), beefCooked.register(), chickenRaw.register(), chickenCooked.register(), fishRaw.register(), fishCooked.register(), rottenFlesh.register(), spiderEye.register());
		
		setCategory("Vanilla Fruit Items", 0x00FF00, apple.register(), appleStomped.register(), appleGold1.register(), appleGold2.register(), appleDiamond.register(), melon.register(), melonGold1.register());
		
		setCategory("Fruit Items", 0xFF0000, orange.register(), pear.register(), cherry.register(), plum.register(), banana.register(), strawberry.register(), raspberry.register(), blackberry.register(), blueberry.register(), redcurrant.register());
		
		setCategory("Vanilla Vegetables", 0xFFDB92, potato.register(), potatoCooked.register(), potatoStomped.register(), potatoGold1.register(), potatoGold2.register(), potatoDiamond.register(), poisonousPotato.register(), carrot.register(), carrotCooked.register(), carrotStomped.register(), carrotGold1.register(), carrotDiamond.register());
		
		setCategory("Vegetables", 0x008100, salad.register(), cucumber.register(), rice.register(), chili.register(), tomato.register(), paprika.register(), onion.register(), pepperSeeds.register(), vanillaSeeds.register(), corn.register(), seagrass.register());
		
		setCategory("Wheat Products", 0x906C22, bread.register(), breadslice.register(), toast.register(), toast_toasted.register(), toast_cheese.register(), toast_salami.register());
		
		setCategory("Food Products", 0xFFFF00, cheese.register(), cheese_slice.register(), bacon_raw.register(), bacon.register(), pasta.register(), meatball.register(), salami.register(), hamburger.register(), frenchfries.register(), pizza.register(), omelette.register(), pumpkinPie.register(), fried_egg.register());
		
		setCategory("Sweet Food Items", 0xEFEFEF, popcorn.register(), popcorn_sweet.register(), popcorn_salty.register(), candycane.register(), butter.register(), chocolate.register(), chocolateWhite.register(), chocolateCow.register(), cookie.register(), chocolateCookie.register(), cereals1.register(), cereals2.register());
		
		setCategory("Cold Food Items", 0xD5FEFF, icecube.register(), icecream.register(), icecreamChocolate.register(), icecreamVanilla.register(), icecreamStrawberry.register(), icecreamCone.register(), icecreamConeChocolate.register(), icecreamConeVanilla.register(), icecreamConeStrawberry.register(), icecreamConeCV.register(), icecreamConeCS.register(), icecreamConeVS.register(), icecreamConeCVS.register());
		
		Drink.init();
	}
	
	/**
	 * The item damage value the Food is represented by
	 */
	private int					foodID;
	private String				name					= "";
	private String				icon					= "";
	private int					foodValue;
	private Block				blockPlaced;
	private int					metadataPlaced;
	private boolean				isEnabled				= true;
	private FoodCategory		category				= new FoodCategory("Food Items", 0x818181);
	
	private FoodRecipe			recipe;
	private PotionEffect[]		effects					= new PotionEffect[0];
	
	protected ItemStack			stack;
	
	public Food(int id, String name, String icon, int foodValue)
	{
		this(id, name, icon, foodValue, (FoodRecipe) null);
	}
	
	public Food(int id, String name, String icon, int foodValue, FoodRecipe recipe)
	{
		this(id, name, icon, foodValue, null, recipe);
	}
	
	public Food(int id, String name, String icon, int foodValue, Block blockPlaced)
	{
		this(id, name, icon, foodValue, blockPlaced, null);
	}
	
	public Food(int id, String name, String icon, int foodValue, Block blockPlaced, FoodRecipe recipe)
	{
		this.setID(id);
		this.setName(name);
		this.setIconName(icon);
		this.foodValue = foodValue;
		this.setBlockPlaced(blockPlaced);
		this.recipe = recipe;
		
		this.stack = new ItemStack(MoreFoodMod.foods, 1, this.getID());
		
		if (id >= 0)
			foodTypes[id] = this;
	}
	
	public Food(Item item, int damage, FoodRecipe recipe)
	{
		this(-1, item.getUnlocalizedName(), getIconName(item, damage), 0, null, recipe);
		this.stack = new ItemStack(item, 1, damage);
	}
	
	public Food(ItemFood foodItem, int damage, FoodRecipe recipe)
	{
		this(-1, foodItem.getUnlocalizedName(), getIconName(foodItem, damage), 0, getPlacedBlock(foodItem, damage), recipe);
		this.stack = new ItemStack(foodItem, 1, damage);
		this.foodValue = foodItem.func_150905_g(this.stack);
	}
	
	private static String getIconName(Item item, int metadata)
	{
		try
		{
			IIcon icon = item.getIconFromDamage(metadata);
			return icon.getIconName();
		}
		catch (Throwable ex)
		{
			return ObfuscationReflectionHelper.<String, Item> getPrivateValue(Item.class, item, "iconString");
		}
	}
	
	private static Block getPlacedBlock(ItemFood item, int metadata)
	{
		if (item instanceof ItemSeedFood)
		{
			return ((ItemSeedFood) item).getPlant(null, 0, 0, 0);
		}
		return null;
	}
	
	public static Food fromItemStack(ItemStack stack)
	{
		return fromDamage(stack.getItemDamage());
	}
	
	public static Food fromDamage(int damage)
	{
		return foodTypes[damage];
	}
	
	@Override
	public Food register()
	{
		foodList.add(this);
		return this;
	}
	
	public void addRecipe()
	{
		if (this.recipe != null && this.getID() >= 0)
		{
			this.recipe.addRecipe(MoreFoodMod.foods, this.getID());
		}
	}
	
	@Override
	public EnumAction getAction()
	{
		return EnumAction.eat;
	}
	
	@Override
	public IMetaItem setEnabled(boolean enabled)
	{
		this.isEnabled = enabled;
		return this;
	}
	
	@Override
	public Food setEffects(PotionEffect... effects)
	{
		this.effects = effects;
		return this;
	}
	
	@Override
	public PotionEffect[] getEffects()
	{
		return this.effects;
	}
	
	@Override
	public ItemStack asStack()
	{
		return this.asStack(1);
	}
	
	@Override
	public ItemStack asStack(int i)
	{
		ItemStack is = this.stack;
		is.stackSize = i;
		return is;
	}
	
	@Override
	public int getFoodValue()
	{
		return this.foodValue;
	}
	
	@Override
	public void setFoodValue(int foodValue)
	{
		this.foodValue = foodValue;
	}
	
	@Override
	public Block getBlockPlaced()
	{
		return this.blockPlaced;
	}
	
	@Override
	public void setBlockPlaced(Block block)
	{
		this.blockPlaced = block;
	}
	
	@Override
	public boolean isEnabled()
	{
		return this.isEnabled;
	}
	
	@Override
	public String getName()
	{
		return this.name;
	}
	
	@Override
	public void setName(String name)
	{
		this.name = name;
	}
	
	@Override
	public String getIconName()
	{
		return this.icon;
	}
	
	@Override
	public void setIconName(String icon)
	{
		this.icon = icon;
	}
	
	@Override
	public int getID()
	{
		return this.foodID;
	}
	
	@Override
	public void setID(int foodID)
	{
		this.foodID = foodID;
	}
	
	@Override
	public FoodRecipe getRecipe()
	{
		return this.recipe;
	}
	
	public static List<Food> getDisplayList()
	{
		return foodList;
	}
	
	@Override
	public Collection<String> getDescription()
	{
		return Collections.EMPTY_LIST;
	}
	
	@Override
	public int getMetadataPlaced()
	{
		return this.metadataPlaced;
	}
	
	public Food setMetadataPlaced(int i)
	{
		this.metadataPlaced = i;
		return this;
	}
	
	public Food setCategory(FoodCategory category)
	{
		this.category = category;
		return this;
	}
	
	public FoodCategory getCategory()
	{
		return this.category;
	}
	
	public static void setCategory(String name, int color, Food... foods)
	{
		FoodCategory category = new FoodCategory(name, color);
		for (Food f : foods)
			f.setCategory(category);
	}
	
	/**
	 * Runs the static initializer of this class
	 */
	public static void init()
	{
	}
}
