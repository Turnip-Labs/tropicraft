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
import turniplabs.halplibe.mixin.accessors.BlockInterface;
import turniplabs.halplibe.mixin.accessors.CraftingManagerInterface;
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
    public static final Block tropicsPortal = new BlockPortal(tropicConfig.portal, 3, Block.sandstone.blockID, Block.fluidWaterStill.blockID).setBlockName("portal.tropics").setTexCoords(13, 12).setNotInCreativeMenu();

    public static final Block bambooBlock = BlockHelper.createBlock(new BlockBamboo(tropicConfig.bamboo), name("bamboo"), 25, 0, Block.soundGrassFootstep, 0.0f, 0.0f, 0.0f).setNotInCreativeMenu();
    public static final Block bambooPlanks = BlockHelper.createBlock(new Block(tropicConfig.bambooPlanks, Material.wood), name("planks.bamboo"), 26, 0, Block.soundWoodFootstep,2.0f,3.0f, 0.0f);
    public static final Block bambooPlanksSlab = BlockHelper.createBlock(new BlockSlab(tropicConfig.bambooPlankSlab,bambooPlanks), name("slab.planks.bamboo"),26, 0, Block.soundWoodFootstep,2.0f, 3.0f, 0.0f);
    public static final Block bambooPlanksStairs = BlockHelper.createBlock(new BlockStairs(tropicConfig.bambooPlankStairs, bambooPlanks), name("stairs.planks.bamboo"), 26, 0, Block.soundWoodFootstep, 2.0f,  3.0f, 0.0f);
    public static final Block coconut = BlockHelper.createBlock(new BlockCoconut(tropicConfig.coconut, Material.wood), name("coconut"), 27, 0, Block.soundWoodFootstep, 0.5f, 0.5f, 0.0f);
    public static final Block flowerDayFlower = BlockHelper.createBlock(new BlockFlower(tropicConfig.dayflower), name("flower.dayflower"), 28, 0, Block.soundGrassFootstep, 0.0f, 0.0f, 0.0f);
    public static final Block flowerMontbretia = BlockHelper.createBlock(new BlockFlower(tropicConfig.montbretia), name("flower.montbretia"), 29, 0, Block.soundGrassFootstep, 0.0f, 0.0f, 0.0f);
    public static final Block flowerOrchid = BlockHelper.createBlock(new BlockFlower(tropicConfig.orchid), name("flower.orchid"), 30, 0, Block.soundGrassFootstep, 0.0f, 0.0f, 0.0f);
    public static final Block headChunk = BlockHelper.createBlock(new Block(tropicConfig.chunkOHead, Material.rock), name("head"), 31, 0, Block.soundStoneFootstep, 3.0f, 6.0f, 0.0f);
    public static final Block irisBottom = BlockHelper.createBlock(new BlockIris(tropicConfig.irisBottom, false, Material.plants), name("iris"), 22, 1, Block.soundGrassFootstep, 0.0f, 0.0f, 0.0f).setNotInCreativeMenu();
    public static final Block irisTop = BlockHelper.createBlock(new BlockIris(tropicConfig.irisTop, true, Material.plants), name("iris"), 22, 0, Block.soundGrassFootstep, 0.0f, 0.0f, 0.0f).setNotInCreativeMenu();
    public static final Block leavesPalm = BlockHelper.createBlock(new BlockLeavesPalm(tropicConfig.palmLeaves, Material.leaves, true),name("leaves.palm"),25,1,Block.soundGrassFootstep,0.2f, 0.2f, 0.0f);
    public static final Block logPalm = BlockHelper.createBlock(new BlockLog(tropicConfig.palmLog), name("log.palm"),24,1, 24,1, 24,0, Block.soundWoodFootstep, 2.0f, 2.0f, 0.0f);
    public static final Block saplingPalm = BlockHelper.createBlock(new BlockSaplingPalm(tropicConfig.palmSapling), name("sapling.palm"), 26, 1, Block.soundGrassFootstep, 0.0f, 0.0f, 0.0f);
    public static final Block pineappleBottom = BlockHelper.createBlock(new BlockPineapple(tropicConfig.pineappleBottom, false, Material.plants), name("pineapple"),23, 1, Block.soundGrassFootstep, 0.0f, 0.0f, 0.0f).setNotInCreativeMenu();
    public static final Block pineappleTop = BlockHelper.createBlock(new BlockPineapple(tropicConfig.pineappleTop, true, Material.plants), name("pineapple"), 23, 0, Block.soundGrassFootstep, 0.0f, 0.0f, 0.0f).setNotInCreativeMenu();
    public static final Block sandPurified = BlockHelper.createBlock(new BlockSand(tropicConfig.purifiedSand), name("sand.purified"), 27, 1, Block.soundSandFootstep,0.5f, 0.5f, 0.0f);
    public static final Block thatch = BlockHelper.createBlock(new Block(tropicConfig.thatch, Material.plants), name("thatch"), 28, 1, Block.soundGrassFootstep, 0.6f, 0.6f, 0.0f);
    public static final Block thatchSlabs = BlockHelper.createBlock(new BlockSlab(tropicConfig.thatchSlab, thatch), name("slab.thatch"), 28, 1, Block.soundGrassFootstep, 0.6f, 0.6f, 0.0f);
    public static final Block thatchStairs = BlockHelper.createBlock(new BlockStairs(tropicConfig.thatchStairs, thatch), name("stairs.thatch"), 28, 1, Block.soundGrassFootstep, 0.6f, 0.6f, 0.0f);

    // Items
    public static final Item scaleHelmet = new ItemArmor(tropicConfig.scaleHelmet, scaleMaterial, 0).setIconCoord(18, 0).setItemName(name("armor.helmet.scale"));
    public static final Item scaleChestplate = new ItemArmor(tropicConfig.scaleChest, scaleMaterial, 1).setIconCoord(18, 1).setItemName(name("armor.chestplate.scale"));
    public static final Item scaleLeggings = new ItemArmor(tropicConfig.scaleLegs, scaleMaterial, 2).setIconCoord(18, 2).setItemName(name("armor.leggings.scale"));
    public static final Item scaleBoots = new ItemArmor(tropicConfig.scaleBoots, scaleMaterial, 3).setIconCoord(18, 3).setItemName(name("armor.boots.scale"));
    public static final Item bambooItem = new ItemSugarcane(tropicConfig.bambooItem, bambooBlock).setIconCoord(18,4).setItemName(name("bamboo"));
    public static final Item bambooMug = new Item(tropicConfig.bambooMug).setIconCoord(18,5).setItemName(name("mug"));
    public static final Item bambooMugFull = new ItemPinaColada(tropicConfig.pinaColada).setIconCoord(18,6).setItemName(name("mug.full"));
    public static final Item coconutChunk = new ItemFoodStackable(tropicConfig.coconutChunk, 2, false, 4).setIconCoord(18,7).setItemName(name("food.coconut"));
    public static final Item frogLeg = new ItemFood(tropicConfig.rawFrog, 1, true).setIconCoord(18,8).setItemName(name("food.frog.raw"));
    public static final Item frogLegCooked = new ItemFood(tropicConfig.cookedFrog,5,true).setIconCoord(18,9).setItemName(name("food.frog.cooked"));
    public static final Item frogSkin = new Item(tropicConfig.frogLeather).setIconCoord(18,10).setItemName(name("frog.skin"));
    public static final Item flowerIris = new ItemIris(tropicConfig.irisItem).setIconCoord(18,11).setItemName(name("iris"));
    public static final Item pineapple = new ItemFoodPineapple(tropicConfig.pineappleItem,2, false).setIconCoord(18,12).setItemName(name("food.pineapple"));
    public static final Item pineappleSeeds = new ItemSeedsPineapple(tropicConfig.pineappleSeeds).setIconCoord(18,13).setItemName(name("seeds.pineapple"));
    public static final Item scale = new Item(tropicConfig.scale).setIconCoord(18,14).setItemName(name("scale"));
    public static final Item shellCommon = new Item(tropicConfig.shell).setIconCoord(18,15).setItemName(name("shell.common"));
    public static final Item shellCommon2 = new Item(tropicConfig.shell2).setIconCoord(18,16).setItemName(name("shell.common"));
    public static final Item shellCommon3 = new Item(tropicConfig.shell3).setIconCoord(18,17).setItemName(name("shell.common"));
    public static final Item shellRare = new Item(tropicConfig.shell4).setIconCoord(18,18).setItemName(name("shell.rare"));
    public static final Item starfish = new Item(tropicConfig.seaStar).setIconCoord(18,19).setItemName(name("starfish"));

    static {
        ((BlockInterface) tropicsPortal).callSetBlockUnbreakable();
        ((BlockInterface) tropicsPortal).callSetStepSound(Block.soundGlassFootstep);
        ((BlockInterface) tropicsPortal).callSetLightValue(0.75f);
    }

    // Dimension
    public static final Dimension dimensionTropics = DimensionHelper.createDimension(3, name("tropics"), Dimension.overworld, 1.0f, tropicsPortal, worldTropics, 0, 128);

    @Override
    public void onInitialize() {
        config = TropicraftConfig.load(configFile);

        TextureHelper.addTextureToTerrain(MOD_ID,"bamboo.png", 25, 0);
        TextureHelper.addTextureToTerrain(MOD_ID, "bamboo_planks.png", 26, 0);
        TextureHelper.addTextureToTerrain(MOD_ID, "coconut.png", 27, 0);
        TextureHelper.addTextureToTerrain(MOD_ID, "flower_dayflower.png", 28, 0);
        TextureHelper.addTextureToTerrain(MOD_ID, "flower_montbretia.png", 29, 0);
        TextureHelper.addTextureToTerrain(MOD_ID, "flower_orchid.png",30,0);
        TextureHelper.addTextureToTerrain(MOD_ID, "head_chunk.png", 31, 0);
        TextureHelper.addTextureToTerrain(MOD_ID, "iris_bottom.png", 22, 1);
        TextureHelper.addTextureToTerrain(MOD_ID, "iris_top.png", 22, 0);
        TextureHelper.addTextureToTerrain(MOD_ID, "palm_leaves.png",25, 1);
        TextureHelper.addTextureToTerrain(MOD_ID, "palm_log_side.png", 24, 0);
        TextureHelper.addTextureToTerrain(MOD_ID, "palm_log_top.png", 24,1);
        TextureHelper.addTextureToTerrain(MOD_ID, "palm_sapling.png", 26, 1);
        TextureHelper.addTextureToTerrain(MOD_ID, "pineapple_bottom.png", 23, 1);
        TextureHelper.addTextureToTerrain(MOD_ID, "pineapple_top.png", 23, 0);
        TextureHelper.addTextureToTerrain(MOD_ID, "sand_purified.png", 27, 1);
        TextureHelper.addTextureToTerrain(MOD_ID, "thatch.png", 28, 1);

        TextureHelper.addTextureToItems(MOD_ID, "scaled_helmet.png", 18, 0);
        TextureHelper.addTextureToItems(MOD_ID, "scaled_chestplate.png", 18, 1);
        TextureHelper.addTextureToItems(MOD_ID, "scaled_leggings.png", 18, 2);
        TextureHelper.addTextureToItems(MOD_ID, "scaled_boots.png", 18, 3);
        TextureHelper.addTextureToItems(MOD_ID, "bamboo_item.png", 18, 4);
        TextureHelper.addTextureToItems(MOD_ID, "bamboo_mug.png", 18, 5);
        TextureHelper.addTextureToItems(MOD_ID, "bamboo_mug_full.png", 18, 6);
        TextureHelper.addTextureToItems(MOD_ID, "coconut_chunk.png", 18, 7);
        TextureHelper.addTextureToItems(MOD_ID, "frog_leg.png", 18, 8);
        TextureHelper.addTextureToItems(MOD_ID, "frog_leg_cooked.png", 18, 9);
        TextureHelper.addTextureToItems(MOD_ID, "frog_skin.png", 18, 10);
        TextureHelper.addTextureToItems(MOD_ID, "iris_item.png", 18,11);
        TextureHelper.addTextureToItems(MOD_ID, "pineapple.png", 18, 12);
        TextureHelper.addTextureToItems(MOD_ID, "pineapple_seeds.png", 18, 13);
        TextureHelper.addTextureToItems(MOD_ID, "scale.png", 18, 14);
        TextureHelper.addTextureToItems(MOD_ID, "shell_common.png", 18, 15);
        TextureHelper.addTextureToItems(MOD_ID, "shell_common_2.png", 18, 16);
        TextureHelper.addTextureToItems(MOD_ID, "shell_common_3.png", 18, 17);
        TextureHelper.addTextureToItems(MOD_ID, "shell_rare.png", 18, 18);
        TextureHelper.addTextureToItems(MOD_ID, "starfish.png", 18, 19);

        // Crafting
        Item.itemsList[tropicsPortal.blockID] = new ItemBlock(tropicsPortal.blockID - 16384);
        Item.itemsList[bambooBlock.blockID] = new ItemBlock(bambooBlock.blockID - 16384);
        Item.itemsList[bambooPlanks.blockID] = new ItemBlock(bambooPlanks.blockID - 16384);
        Item.itemsList[bambooPlanksSlab.blockID] = new ItemBlock(bambooPlanksSlab.blockID - 16384);
        Item.itemsList[bambooPlanksStairs.blockID] = new ItemBlock(bambooPlanksStairs.blockID - 16384);
        Item.itemsList[coconut.blockID] = new ItemBlock(coconut.blockID - 16384);
        Item.itemsList[flowerDayFlower.blockID] = new ItemBlock(flowerDayFlower.blockID - 16384);
        Item.itemsList[flowerMontbretia.blockID] = new ItemBlock(flowerMontbretia.blockID - 16384);
        Item.itemsList[flowerOrchid.blockID] = new ItemBlock(flowerOrchid.blockID - 16384);
        Item.itemsList[headChunk.blockID] = new ItemBlock(headChunk.blockID - 16384);
        Item.itemsList[irisBottom.blockID] = new ItemBlock(irisBottom.blockID - 16384);
        Item.itemsList[irisTop.blockID] = new ItemBlock(irisTop.blockID - 16384);
        Item.itemsList[leavesPalm.blockID] = new ItemBlock(leavesPalm.blockID - 16384);
        Item.itemsList[logPalm.blockID] = new ItemBlock(logPalm.blockID - 16384);
        Item.itemsList[saplingPalm.blockID] = new ItemBlock(saplingPalm.blockID - 16384);
        Item.itemsList[sandPurified.blockID] = new ItemBlock(sandPurified.blockID - 16384);
        Item.itemsList[pineappleBottom.blockID] = new ItemBlock(pineappleBottom.blockID - 16384);
        Item.itemsList[pineappleTop.blockID] = new ItemBlock(pineappleTop.blockID - 16384);
        Item.itemsList[thatch.blockID] = new ItemBlock(thatch.blockID - 16384);
        Item.itemsList[thatchSlabs.blockID] = new ItemBlock(thatchSlabs.blockID - 16384);
        Item.itemsList[thatchStairs.blockID] = new ItemBlock(thatchStairs.blockID - 16384);

        RecipeHelper.Crafting.createRecipe(bambooPlanks,1, new Object[]{"AA", "AA", 'A', bambooItem});
        RecipeHelper.Crafting.createRecipe(bambooPlanksSlab,6, new Object[]{"AAA", 'A', bambooPlanks});
        RecipeHelper.Crafting.createRecipe(bambooPlanksStairs,6, new Object[]{"A  ", "AA ", "AAA", 'A', bambooPlanks});
        RecipeHelper.Crafting.createRecipe(thatch,1, new Object[]{"AA", "AA", 'A', Item.sugarcane});
        RecipeHelper.Crafting.createRecipe(thatchSlabs, 6, new Object[]{"AAA", 'A', thatch});
        RecipeHelper.Crafting.createRecipe(thatchStairs, 6, new Object[]{"A  ", "AA ", "AAA", 'A', thatch});

        ((CraftingManagerInterface) RecipeHelper.craftingManager).callAddShapelessRecipe(new ItemStack(Item.dye, 2, 5), new Object[]{flowerIris});          // Iris == purple
        ((CraftingManagerInterface) RecipeHelper.craftingManager).callAddShapelessRecipe(new ItemStack(Item.dye, 2, 14), new Object[]{flowerMontbretia});   // Montbretia == orange
        ((CraftingManagerInterface) RecipeHelper.craftingManager).callAddShapelessRecipe(new ItemStack(Item.dye, 2, 6), new Object[]{flowerDayFlower});     // DayFlower == cyan
        ((CraftingManagerInterface) RecipeHelper.craftingManager).callAddShapelessRecipe(new ItemStack(Item.dye, 2, 9), new Object[]{flowerOrchid});        // Orchid == Pink

        ((CraftingManagerInterface) RecipeHelper.craftingManager).callAddShapelessRecipe(new ItemStack(Block.planksOakPainted, 4, 4), new Object[]{logPalm}); // yellow planks

        RecipeHelper.Crafting.createRecipe(bambooMug,1, new Object[]{"A A", "A A", "AAA", 'A', bambooItem});
        RecipeHelper.Crafting.createRecipe(scaleHelmet,1, new Object[]{"AAA", "A A", 'A', scale});
        RecipeHelper.Crafting.createRecipe(scaleChestplate,1, new Object[]{"A A", "AAA", "AAA", 'A', scale});
        RecipeHelper.Crafting.createRecipe(scaleLeggings,1, new Object[]{"AAA", "A A", "A A", 'A', scale});
        RecipeHelper.Crafting.createRecipe(scaleBoots,1, new Object[]{"A A", "A A", 'A', scale});
        RecipeHelper.Crafting.createShapelessRecipe(bambooMugFull,1,new Object[]{Item.bucketMilk, coconutChunk, pineapple, bambooMug, Item.cherry});

        RecipeHelper.smeltingManager.addSmelting(logPalm.blockID, new ItemStack(Item.coal, 1, 1));

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
