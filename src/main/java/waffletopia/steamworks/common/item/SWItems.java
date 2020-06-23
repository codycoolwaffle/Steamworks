package waffletopia.steamworks.common.item;

public class SWItems {
	public static ingotZinc ingotZinc;
	public static ingotCopper ingotCopper;
	public static void doSetup(){
		ingotZinc = new ingotZinc();
		ingotCopper = new ingotCopper();
	}
}
