package waffletopia.steamworks.common.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.registries.ForgeRegistries;

public class Ore_Zinc extends OreBlock {
    public Ore_Zinc() {
        super(Properties.create(Material.ROCK).lightValue(0).harvestLevel(1).hardnessAndResistance(3f, 50f).harvestTool(ToolType.PICKAXE));
        //setRegistryName("steamworks","ore_zinc");
        //this.registerOregen();
        //new BlockItem(this.getBlock(), new Item.Properties()).setRegistryName(getBlock().getRegistryName());
    }
    public void registerOregen(){
        LOGGER.debug("Registering Oregen for Ore_Zinc");
        ForgeRegistries.BIOMES.getValues().stream()
                .filter(biome ->
                    biome.getCategory()!= Biome.Category.NETHER
                            && biome.getCategory()!=Biome.Category.THEEND)
                .forEach(
                        biome -> {
                            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                                    Feature.ORE.withConfiguration(new OreFeatureConfig(
                                            OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                            this.getDefaultState(),
                                            10
                                    )));
                        }
                );
    }
}
