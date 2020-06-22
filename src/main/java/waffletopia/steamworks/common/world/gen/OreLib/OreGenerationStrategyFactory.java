package waffletopia.steamworks.common.world.gen.OreLib;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import sun.security.krb5.Config;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class OreGenerationStrategyFactory {


    private GeneratedOreGenerationStrategy strategy;
    private boolean validated = false;

    public OreGenerationStrategyFactory() {
        strategy = new GeneratedOreGenerationStrategy();
    }

    public OreGenerationStrategyFactory withSize(int size){
        strategy.size = size;
        return this;
    }
    public OreGenerationStrategyFactory withCountRangeConfig(CountRangeConfig config) {
        strategy.setTries(config.count);
        strategy.setBottomOffset(config.bottomOffset);
        strategy.setTopOffset(config.topOffset);
        strategy.setMaximumHeight(config.maximum);
        return this;
    }

    public OreGenerationStrategyFactory withOreFeatureConfiguration(OreFeatureConfig config) {
        strategy.setConfiguration(config);
        return this;
    }
    public OreGenerationStrategyFactory withBiomes(Biome.Category ... biomes){
        return this.withBiomes(true, biomes);
    }
    public OreGenerationStrategyFactory withBiomes(boolean whitelisted, Biome.Category ... biomes) {
        strategy.biomeWhitelisted = whitelisted;
        strategy.BiomeCategories.addAll(Arrays.asList(biomes));
        return this;
    }
    public OreGenerationStrategyFactory withBiomeBlacklist(Biome.Category ... biomes){
        return this.withBiomes(false, biomes);
    }
    /*
    public OreGenerationStrategyFactory validate() {
        if
        ((!Objects.isNull(strategy)
                && (strategy.tries != -1
                && strategy.bottomOffset != -1
                && strategy.topOffset != -1
                && strategy.maximumHeight != -1
                && strategy.size != -1
                && strategy.configuration != null))
        ) {
            validated = true;
        } else {
            throw new IllegalStateException("Make sure to set *everything*. You're either missing the OreFeatureConfig or the CountRangeConfig.");
        }
        return this;
    }*/

    public GeneratedOreGenerationStrategy getStrategy() {
        return strategy;
    }

    public class GeneratedOreGenerationStrategy extends OreGenerationStrategyBase {
        private boolean biomeWhitelisted = false;
        private List<Biome.Category> BiomeCategories;
        private int tries = -1;
        private int bottomOffset = -1;
        private int topOffset = -1;
        private int maximumHeight = -1;
        private int size = -1;

        public GeneratedOreGenerationStrategy(){
            BiomeCategories = new ArrayList<Biome.Category>();
        }

        public void setTries(int tries) {
            this.tries = tries;
        }

        public void setBottomOffset(int bottomOffset) {
            this.bottomOffset = bottomOffset;
        }

        public void setTopOffset(int topOffset) {
            this.topOffset = topOffset;
        }

        public void setMaximumHeight(int maximumHeight) {
            this.maximumHeight = maximumHeight;
        }

        public void setConfiguration(OreFeatureConfig configuration) {
            this.configuration = configuration;
        }

        private OreFeatureConfig configuration;

        @Override
        public int getSize() {
            return 0;
        }

        @Override
        public List<Biome.Category> getBiomeCategories() {
            return BiomeCategories;
        }

        @Override
        public boolean biomesAreWhitelisted() {
            return biomeWhitelisted;
        }

        @Override
        public OreFeatureConfig getOreConfig() {
            return configuration;
        }

        @Override
        public CountRangeConfig getCountRangeConfig() {
            return new CountRangeConfig(tries, bottomOffset, topOffset, maximumHeight);
        }
    }
}
