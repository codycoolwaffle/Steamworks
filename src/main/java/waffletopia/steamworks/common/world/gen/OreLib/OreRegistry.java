package waffletopia.steamworks.common.world.gen.OreLib;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;
import vazkii.arl.block.BasicBlock;

import java.util.ArrayList;


public class OreRegistry {
    public static void RegisterOre(BasicBlock block, OreGenerationStrategyBase generatorOptions) {
        ForgeRegistries.BIOMES
                .getValues()
                .stream()
                .filter(biome -> (generatorOptions.getBiomeCategories()
                        .contains(biome.getCategory()))==generatorOptions.biomesAreWhitelisted())
                .forEach(biome -> {
                    biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(
                            generatorOptions.getOreConfig())
                            .withPlacement(Placement.COUNT_RANGE.configure(generatorOptions.getCountRangeConfig()))
                    );
                });
    }
}
