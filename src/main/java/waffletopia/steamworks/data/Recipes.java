package waffletopia.steamworks.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.annotation.ParametersAreNonnullByDefault;

import waffletopia.steamworks.lib.IRecipeProvider;

public class Recipes extends RecipeProvider
{
	public static List<IRecipeProvider> providers;
	
	public Recipes(DataGenerator in)
	{
		super(in);
		providers = new ArrayList<IRecipeProvider>();
	}
	
	@Override
	@ParametersAreNonnullByDefault
	protected void registerRecipes(Consumer<IFinishedRecipe> consumer)
	{
		recipeRegistrationEvent(consumer);
	}
	
	private void recipeRegistrationEvent(Consumer<IFinishedRecipe> consumer)
	{
		for(IRecipeProvider v : providers)
		{
			v.registerRecipes(consumer);
		}
	}
}
