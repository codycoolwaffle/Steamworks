package waffletopia.steamworks.common.block;

public class SWBlocks
{
	public static OreZinc oreZinc;
	public static OreCopper oreCopper;
	public static BlockCopper blockCopper;
	public static BlockZinc blockZinc;
	public static void blockSetup()
	{
		oreZinc = new OreZinc();
		oreCopper = new OreCopper();
		blockCopper = new BlockCopper();
		blockZinc = new BlockZinc();
	}
}
