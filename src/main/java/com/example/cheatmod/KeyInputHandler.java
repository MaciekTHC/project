package com.example.cheatmod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

@Mod(modid = CheatMod.MODID, version = CheatMod.VERSION)
@SideOnly(Side.CLIENT)
public class KeyInputHandler {

    private static final String CATEGORY = "key.categories.cheatmod";
    private static final String TOGGLE_HITBOXES_DESC = "key.cheatmod.toggle_hitboxes";
    public static final net.minecraft.client.settings.KeyBinding TOGGLE_HITBOXES = new net.minecraft.client.settings.KeyBinding(TOGGLE_HITBOXES_DESC, Keyboard.KEY_H, CATEGORY);

    @EventHandler
    public void init(FMLInitializationEvent event) {
        ClientRegistry.registerKeyBinding(TOGGLE_HITBOXES);
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (TOGGLE_HITBOXES.isPressed()) {
            CheatMod.toggleHitboxes();
        }
    }
}
