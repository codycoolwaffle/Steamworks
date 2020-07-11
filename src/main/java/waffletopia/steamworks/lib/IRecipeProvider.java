package waffletopia.steamworks.lib;

import net.minecraft.data.IFinishedRecipe;

import java.util.function.Consumer;

public interface IRecipeProvider
{
	void registerRecipes(Consumer<IFinishedRecipe> consumer);
}
