package waffletopia.steamworks.common.world.gen;

import com.sun.media.jfxmedia.logging.Logger;
import net.minecraft.block.Block;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;
import waffletopia.steamworks.common.block.Ore;

/**
 * @author cScot (on github)
 */

public class CustomOreGeneration {
    @SubscribeEvent
    public static void setupOreGenerator(RegistryEvent.Register<Block> event){
        ForgeRegistries.BIOMES
                .getValues()
                .stream()
                .forEach(biome ->{
                    biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(
                            new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ore.ore_zinc.getDefaultState(), 10)
                    ).withPlacement(Placement.COUNT_RANGE.configure(
                           new CountRangeConfig(40,50,128,129)
                    )));
        });
    }
}
