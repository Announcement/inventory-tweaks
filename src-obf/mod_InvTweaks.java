import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;

/**
 * @author Jimeo Wan (jimeo.wan at gmail.com)
 * @version 1.0 (1.5_01)
 * Website: {@link http://wan.ka.free.fr/?invtweaks}
 * Source code: {@link https://github.com/jimeowan/minecraft-mod-inventory-tweaks}
 * 
 */
public class mod_InvTweaks extends BaseMod {
	
	private InvTweaks instance;
	private static final px myKey = new px("Sort inventory", Keyboard.KEY_R);
    
    public mod_InvTweaks() {
    	
    	// Register customizable sort key
    	ModLoader.RegisterKey(this, myKey, true);
    	
    	// Register OnTickInGame event
    	ModLoader.SetInGameHook(this, true, true);
    	
    	instance = new InvTweaks(ModLoader.getMinecraftInstance());
    }
    
	@Override
	public String Version() {
		return "1.0 (1.5_01)";
	}
    
	/**
	 * Sort inventory
	 */
    public final void KeyboardEvent(px keybinding)
    {
    	instance.onSortButtonPressed();
    }
    
    public void OnTickInGame(Minecraft minecraft)
    {
    	instance.onTick();
    }
}
