package com.example.cheatmod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class CheatModMenu extends GuiScreen {

    private static final int BUTTON_ID = 0;

    @Override
    public void initGui() {
        super.initGui();
        this.buttonList.add(new GuiButton(BUTTON_ID, this.width / 2 - 100, this.height / 2 - 24, 200, 20, getButtonText()));
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        if (button.id == BUTTON_ID) {
            CheatMod cheatMod = new CheatMod(); // Utwórz instancję CheatMod
            cheatMod.toggleHitboxes(); // Wywołaj metodę na instancji
            button.displayString = getButtonText();
        }
    }

    private String getButtonText() {
        return "Toggle Hitboxes: " + (CheatMod.showHitboxes ? "ON" : "OFF");
    }

    @SubscribeEvent
    public static void onGuiOpen(GuiScreenEvent.InitGuiEvent.Post event) {
        if (event.getGui() instanceof GuiMainMenu) {
            event.getButtonList().add(new GuiButton(1000, 10, 10, 200, 20, "Cheat Mod Menu"));
        }
    }

    @SubscribeEvent
    public static void onButtonClick(GuiScreenEvent.ActionPerformedEvent.Post event) {
        if (event.getButton().id == 1000) {
            Minecraft.getMinecraft().displayGuiScreen(new CheatModMenu());
        }
    }
}
