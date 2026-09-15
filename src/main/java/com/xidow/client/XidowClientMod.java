package com.xidow.client.gui;

import com.xidow.client.XidowClientMod;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class XidowMenuScreen extends Screen {

    public XidowMenuScreen() {
        super(Text.literal("Xidow Client Menu"));
    }

    @Override
    protected void init() {
        int centerX = this.width / 2;
        int centerY = this.height / 2;

        this.addDrawableChild(ButtonWidget.builder(
            Text.literal("Health Indicator: " + (XidowClientMod.healthIndicatorEnabled ? "§aON" : "§cOFF")),
            button -> {
                XidowClientMod.healthIndicatorEnabled = !XidowClientMod.healthIndicatorEnabled;
                button.setMessage(Text.literal("Health Indicator: " + (XidowClientMod.healthIndicatorEnabled ? "§aON" : "§cOFF")));
            }
        ).dimensions(centerX - 100, centerY - 45, 200, 20).build());

        this.addDrawableChild(ButtonWidget.builder(
            Text.literal("Hitboxes Custom: " + (XidowClientMod.hitboxesEnabled ? "§aON" : "§cOFF")),
            button -> {
                XidowClientMod.hitboxesEnabled = !XidowClientMod.hitboxesEnabled;
                button.setMessage(Text.literal("Hitboxes Custom: " + (XidowClientMod.hitboxesEnabled ? "§aON" : "§cOFF")));
            }
        ).dimensions(centerX - 100, centerY - 20, 200, 20).build());

        this.addDrawableChild(ButtonWidget.builder(
            Text.literal("Target Red Crosshair: " + (XidowClientMod.redCrosshairTarget ? "§aON" : "§cOFF")),
            button -> {
                XidowClientMod.redCrosshairTarget = !XidowClientMod.redCrosshairTarget;
                button.setMessage(Text.literal("Target Red Crosshair: " + (XidowClientMod.redCrosshairTarget ? "§aON" : "§cOFF")));
            }
        ).dimensions(centerX - 100, centerY + 5, 200, 20).build());

        this.addDrawableChild(ButtonWidget.builder(
            Text.literal("FPS Booster Engine: " + (XidowClientMod.fpsBoosterEnabled ? "§aON" : "§cOFF")),
            button -> {
                XidowClientMod.fpsBoosterEnabled = !XidowClientMod.fpsBoosterEnabled;
                button.setMessage(Text.literal("FPS Booster Engine: " + (XidowClientMod.fpsBoosterEnabled ? "§aON" : "§cOFF")));
            }
        ).dimensions(centerX - 100, centerY + 30, 200, 20).build());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        context.fill(0, 0, this.width, this.height, 0xD01A092B);

        int centerX = this.width / 2;
        int centerY = this.height / 2;

        context.fill(centerX - 130, centerY - 80, centerX + 130, centerY + 70, 0xFF800080);
        context.fill(centerX - 128, centerY - 78, centerX + 128, centerY + 68, 0xFF2A0845);

        context.drawCenteredTextWithShadow(this.textRenderer, "§d§lXidow Client", centerX, centerY - 72, 0xFF66FF);
        context.drawCenteredTextWithShadow(this.textRenderer, "§cby AmyTeAmo", centerX, centerY - 60, 0xFFB5E2);

        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
