package turniplabs.tropicraft;

import io.github.prismwork.prismconfig.api.PrismConfig;
import io.github.prismwork.prismconfig.api.config.DefaultSerializers;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.src.*;
import net.minecraft.src.material.ArmorMaterial;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.*;
import turniplabs.halplibe.mixin.accessors.BlockAccessor;
import turniplabs.halplibe.mixin.accessors.CraftingManagerAccessor;
import turniplabs.tropicraft.block.*;
import turniplabs.tropicraft.config.TropicraftConfig;
import turniplabs.tropicraft.entity.*;
import turniplabs.tropicraft.entity.model.*;
import turniplabs.tropicraft.entity.render.*;
import turniplabs.tropicraft.item.*;
import turniplabs.tropicraft.world.*;

import java.io.File;

public class Mod_Tropicraft implements ModInitializer {
    public static final String MOD_ID = "tropicraft";
    public static BiomeGenVolcano biomeVolcano;
    public static BiomeGenTropics biomeTropics;
    public static WorldType worldTropics;
    public static TropicraftConfig.Config config;

    private static final File configFile = FabricLoader.getInstance().getConfigDir().resolve("tropicraftConfig.json5").toFile();

    public static String name(String name) {
        return Mod_Tropicraft.MOD_ID + "." + name;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static void info(Object obj) { LOGGER.info(String.valueOf(obj)); }
    public static void warn(Object obj) { LOGGER.warn(String.valueOf(obj)); }

    static File content;
    static TropicraftConfig.Config tropicConfig = PrismConfig.getInstance().serialize(
            TropicraftConfig.Config.class,
            content = configFile,
            DefaultSerializers.getInstance().json5(TropicraftConfig.Config.class)
    );

    // Materials
    public static final ArmorMaterial scaleMaterial = ArmorHelper.createArmorMaterial("scale", 200, 30.0f, 0.0f, 120.0f, 0.0f);

    // Blocks
    public static final Block tropicsPortal = new BlockPortal(tropicConfig.portal, 3, Block.brickSandstone.blockID, Block.fluidWaterStill.blockID).setBlockName("portal.tropics").setTexCoords(13, 12).setNotInCreativeMenu();

    public static final Block bambooBlock = BlockHelper.createBlock(MOD_ID, new BlockSugarcane(tropicConfig.bamboo), "bamboo", "bamboo.png", Block.soundGrassFootstep, 0.0f, 0.0f, 0.0f).setNotInCreativeMenu();
    public static final Block bambooPlanks = BlockHelper.createBlock(MOD_ID, new Block(tropicConfig.bambooPlanks, Material.wood), "planks.bamboo", "bamboo_planks.png", Block.soundWoodFootstep, 2.0f, 3.0f, 0.0f);
    public static final Block bambooPlanksSlab = BlockHelper.createBlock(MOD_ID, new BlockSlab(tropicConfig.bambooPlankSlab, bambooPlanks), "slab.planks.bamboo", "bamboo_planks.png", Block.soundWoodFootstep, 2.0f, 3.0f, 0.0f);
    public static final Block bambooPlanksStairs = BlockHelper.createBlock(MOD_ID, new BlockStairs(tropicConfig.bambooPlankStairs, bambooPlanks), "stairs.planks.bamboo", "bamboo_planks.png", Block.soundWoodFootstep, 2.0f, 3.0f, 0.0f);
    public static final Block coconut = BlockHelper.createBlock(MOD_ID, new BlockCoconut(tropicConfig.coconut, Material.wood), "coconut", "coconut.png", Block.soundWoodFootstep, 0.5f, 0.5f, 0.0f);
    public static final Block dayFlower = BlockHelper.createBlock(MOD_ID, new BlockFlower(tropicConfig.dayflower), "flower.dayflower", "flower_dayflower.png", Block.soundGrassFootstep, 0.0f, 0.0f, 0.0f);
    public static final Block montbretia = BlockHelper.createBlock(MOD_ID, new BlockFlower(tropicConfig.montbretia), "flower.montbretia", "flower_montbretia.png", Block.soundGrassFootstep, 0.0f, 0.0f, 0.0f);
    public static final Block orchid = BlockHelper.createBlock(MOD_ID, new BlockFlower(tropicConfig.orchid), "flower.orchid", "flower_orchid.png", Block.soundGrassFootstep, 0.0f, 0.0f, 0.0f);
    public static final Block headChunk = BlockHelper.createBlock(MOD_ID, new Block(tropicConfig.chunkOHead, Material.rock), "head", "head_chunk.png", Block.soundStoneFootstep, 3.0f, 6.0f, 0.0f);
    public static final Block irisBottom = BlockHelper.createBlock(MOD_ID, new BlockIris(tropicConfig.irisBottom, false, Material.plants), "iris", "iris_bottom.png", Block.soundGrassFootstep, 0.0f, 0.0f, 0.0f).setNotInCreativeMenu();
    public static final Block irisTop = BlockHelper.createBlock(MOD_ID, new BlockIris(tropicConfig.irisTop, true, Material.plants), "iris", "iris_top.png", Block.soundGrassFootstep, 0.0f, 0.0f, 0.0f).setNotInCreativeMenu();
    public static final Block leavesPalm = BlockHelper.createBlock(MOD_ID, new BlockLeavesPalm(tropicConfig.palmLeaves, Material.leaves, false), "leaves.palm", "palm_leaves.png", Block.soundGrassFootstep, 0.2f, 0.2f, 0.0f);
    public static final Block logPalm = BlockHelper.createBlock(MOD_ID, new BlockLog(tropicConfig.palmLog), "log.palm", "palm_log.png", "palm_log.png", "palm_log_sides.png", Block.soundWoodFootstep, 2.0f, 3.0f, 0.0f);
    public static final Block saplingPalm = BlockHelper.createBlock(MOD_ID, new BlockSaplingPalm(tropicConfig.palmSapling), "sapling.palm", "palm_sapling.png", Block.soundGrassFootstep, 0.0f, 0.0f, 0.0f);
    public static final Block pineappleBottom = BlockHelper.createBlock(MOD_ID, new BlockPineapple(tropicConfig.pineappleBottom, false, Material.plants), "pineapple", "pineapple_bottom.png", Block.soundGrassFootstep, 0.0f, 0.0f, 0.0f).setNotInCreativeMenu();
    public static final Block pineappleTop = BlockHelper.createBlock(MOD_ID, new BlockPineapple(tropicConfig.pineappleTop, true, Material.plants), "pineapple", "pineapple_top.png", Block.soundGrassFootstep, 0.0f, 0.0f, 0.0f).setNotInCreativeMenu();
    public static final Block sandPurified = BlockHelper.createBlock(MOD_ID, new BlockSand(tropicConfig.purifiedSand), "sand.purified", "sand_purified.png", Block.soundSandFootstep, 0.5f, 0.5f, 0.0f);
    public static final Block thatch = BlockHelper.createBlock(MOD_ID, new Block(tropicConfig.thatch, Material.grass), "thatch", "thatch.png", Block.soundGrassFootstep, 0.6f, 0.6f, 0.0f);
    public static final Block thatchSlabs = BlockHelper.createBlock(MOD_ID, new BlockSlab(tropicConfig.thatchSlab, thatch), "slab.thatch", "thatch.png", Block.soundGrassFootstep, 0.6f, 0.6f, 0.0f);
    public static final Block thatchStairs = BlockHelper.createBlock(MOD_ID, new BlockStairs(tropicConfig.thatchStairs, thatch), "slab.thatch", "thatch.png", Block.soundGrassFootstep, 0.6f, 0.6f, 0.0f);

    // Items
    public static final Item bambooItem = ItemHelper.createItem(MOD_ID, new ItemSugarcane(tropicConfig.bambooItem, bambooBlock), "bamboo", "bamboo_item.png");
    public static final Item bambooMug = ItemHelper.createItem(MOD_ID, new Item(tropicConfig.bambooMug), "mug", "bamboo_mug.png");
    public static final Item bambooMugFull = ItemHelper.createItem(MOD_ID, new ItemPinaColada(tropicConfig.pinaColada), "mug.full", "bamboo_mug_full.png");
    public static final Item coconutChunk = ItemHelper.createItem(MOD_ID, new ItemFoodStackable(tropicConfig.coconutChunk, 2, false, 4), "food.coconut", "coconut_chunk.png");
    public static final Item frogLeg = ItemHelper.createItem(MOD_ID, new ItemFood(tropicConfig.rawFrog, 1, true), "food.frog.raw", "frog_leg.png");
    public static final Item frogLegCooked = ItemHelper.createItem(MOD_ID, new ItemFood(tropicConfig.cookedFrog, 5, true), "food.frog.cooked", "frog_leg_cooked.png");
    public static final Item frogSkin = ItemHelper.createItem(MOD_ID, new Item(tropicConfig.frogLeather), "frog.skin", "frog_skin.png");
    public static final Item flowerIris = ItemHelper.createItem(MOD_ID, new Item(tropicConfig.frogLeather), "iris", "iris_item.png");
    public static final Item pineapple = ItemHelper.createItem(MOD_ID, new ItemFood(tropicConfig.pineappleItem, 2, false), "food.pineapple", "pineapple.png");
    public static final Item pineappleSeeds = ItemHelper.createItem(MOD_ID, new ItemSeedsPineapple(tropicConfig.pineappleSeeds), "seeds.pineapple", "pineapple_seeds.png");
    public static final Item scale = ItemHelper.createItem(MOD_ID, new Item(tropicConfig.scale), "scale", "scale.png");
    public static final Item scaleHelmet = ItemHelper.createItem(MOD_ID, new ItemArmor(tropicConfig.scaleHelmet, scaleMaterial, 0), "armor.helmet.scale", "scaled_helmet.png");
    public static final Item scaleChestplate = ItemHelper.createItem(MOD_ID, new ItemArmor(tropicConfig.scaleChest, scaleMaterial, 1), "armor.chestplate.scale", "scaled_chestplate.png");
    public static final Item scaleLeggings = ItemHelper.createItem(MOD_ID, new ItemArmor(tropicConfig.scaleLegs, scaleMaterial, 2), "armor.leggings.scale", "scaled_leggings.png");
    public static final Item scaleBoots = ItemHelper.createItem(MOD_ID, new ItemArmor(tropicConfig.scaleBoots, scaleMaterial, 3), "armor.boots.scale", "scaled_boots.png");
    public static final Item shellCommon = ItemHelper.createItem(MOD_ID, new Item(tropicConfig.shell), "shell.common", "shell_common.png");
    public static final Item shellCommon2 = ItemHelper.createItem(MOD_ID, new Item(tropicConfig.shell2), "shell.common", "shell_common_2.png");
    public static final Item shellCommon3 = ItemHelper.createItem(MOD_ID, new Item(tropicConfig.shell3), "shell.common", "shell_common_3.png");
    public static final Item shellRare = ItemHelper.createItem(MOD_ID, new Item(tropicConfig.shell4), "shell.rare", "shell_rare.png");
    public static final Item starfish = ItemHelper.createItem(MOD_ID, new Item(tropicConfig.seaStar), "starfish", "starfish.png");

    static {
        ((BlockAccessor) tropicsPortal).callSetBlockUnbreakable();
        ((BlockAccessor) tropicsPortal).callSetStepSound(Block.soundGlassFootstep);
        ((BlockAccessor) tropicsPortal).callSetLightValue(0.75f);
    }

    // Dimension
    public static final Dimension dimensionTropics = DimensionHelper.createDimension(3, name("tropics"), Dimension.overworld, 1.0f, tropicsPortal, worldTropics, 0, 128);

    @Override
    public void onInitialize() {
        config = TropicraftConfig.load(configFile);

        RecipeHelper.Crafting.createRecipe(bambooPlanks,4, new Object[]{"AA", "AA", 'A', bambooItem});
        RecipeHelper.Crafting.createRecipe(bambooPlanksSlab,6, new Object[]{"AAA", 'A', bambooPlanks});
        RecipeHelper.Crafting.createRecipe(bambooPlanksStairs,6, new Object[]{"A  ", "AA ", "AAA", 'A', bambooPlanks});
        RecipeHelper.Crafting.createRecipe(thatch,4, new Object[]{"AA", "AA", 'A', Item.sugarcane});
        RecipeHelper.Crafting.createRecipe(thatchSlabs, 6, new Object[]{"AAA", 'A', thatch});
        RecipeHelper.Crafting.createRecipe(thatchStairs, 6, new Object[]{"A  ", "AA ", "AAA", 'A', thatch});

        ((CraftingManagerAccessor) RecipeHelper.craftingManager).callAddShapelessRecipe(new ItemStack(Item.dye, 2, 5), new Object[]{flowerIris});          // Iris == purple
        ((CraftingManagerAccessor) RecipeHelper.craftingManager).callAddShapelessRecipe(new ItemStack(Item.dye, 2, 14), new Object[]{montbretia});   // Montbretia == orange
        ((CraftingManagerAccessor) RecipeHelper.craftingManager).callAddShapelessRecipe(new ItemStack(Item.dye, 2, 6), new Object[]{dayFlower});     // DayFlower == cyan
        ((CraftingManagerAccessor) RecipeHelper.craftingManager).callAddShapelessRecipe(new ItemStack(Item.dye, 2, 9), new Object[]{orchid});        // Orchid == Pink

        ((CraftingManagerAccessor) RecipeHelper.craftingManager).callAddShapelessRecipe(new ItemStack(Block.planksOakPainted, 4, 4), new Object[]{logPalm}); // yellow planks

        RecipeHelper.Crafting.createRecipe(bambooMug,1, new Object[]{"A A", "A A", "AAA", 'A', bambooItem});
        RecipeHelper.Crafting.createRecipe(scaleHelmet,1, new Object[]{"AAA", "A A", 'A', scale});
        RecipeHelper.Crafting.createRecipe(scaleChestplate,1, new Object[]{"A A", "AAA", "AAA", 'A', scale});
        RecipeHelper.Crafting.createRecipe(scaleLeggings,1, new Object[]{"AAA", "A A", "A A", 'A', scale});
        RecipeHelper.Crafting.createRecipe(scaleBoots,1, new Object[]{"A A", "A A", 'A', scale});
        RecipeHelper.Crafting.createShapelessRecipe(bambooMugFull,1,new Object[]{Item.bucketMilk, coconutChunk, pineapple, bambooMug, Item.cherry});

        RecipeHelper.smeltingManager.addSmelting(logPalm.blockID, new ItemStack(Item.coal, 1, 1));
        RecipeHelper.smeltingManager.addSmelting(frogLeg.itemID, new ItemStack(frogLegCooked, 1));

        // Entities
        EntityHelper.createEntity(EntityFrog.class, new RenderFrog(new ModelFrog(), 0.3f),1000, name("frog"));
        EntityHelper.createEntity(EntityFrogPoisonBlue.class, new RenderFrogPoisonBlue(new ModelFrog(), 0.3f), 1001, name("frogPoisonBlue"));
        EntityHelper.createEntity(EntityFrogPoisonRed.class, new RenderFrogPoisonRed(new ModelFrog(), 0.3f), 1002, name("frogPoisonRed"));
        EntityHelper.createEntity(EntityFrogPoisonYellow.class, new RenderFrogPoisonYellow(new ModelFrog(), 0.3f), 1003, name("frogPoisonYellow"));
        EntityHelper.createEntity(EntityIguana.class, new RenderIguana(new ModelIguana(), 0.4f), 1004, name("iguana"));
        EntityHelper.createEntity(EntityMoyai.class, new RenderMoyai(new ModelMoyai(),0.5f), 1005, name("moyai"));
        EntityHelper.createEntity(EntityStarfishBlue.class, new RenderStarfishBlue(new ModelStarfish(), 0.3f), 1006, name("starfishBlue"));
        EntityHelper.createEntity(EntityStarfishPink.class, new RenderStarfishPink(new ModelStarfish(), 0.3f), 1007, name("starfishPink"));
        EntityHelper.createEntity(EntityStarfishYellow.class, new RenderStarfishYellow(new ModelStarfish(), 0.3f), 1008, name("starfishYellow"));
        EntityHelper.createEntity(EntityVervet.class, new RenderVervet(new ModelVervet(), 0.5f), 1009, name("vervet"));
    }
}
