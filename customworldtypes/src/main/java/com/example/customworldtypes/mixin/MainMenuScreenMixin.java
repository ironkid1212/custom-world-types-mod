package com.example.customworldtypes.mixin;

import com.example.customworldtypes.CustomWorldTypesMod;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class MainMenuScreenMixin {
    @Inject(at = @At("HEAD"), method = "initWidgetsNormal(II)V")
    private void initWidgetsNormal(int y, int spacingY, CallbackInfo ci) {
        this.addButton(new ButtonWidget(
            this.width / 2 - 100,
            this.height / 4 + 48 + 24 * 2,
            200,
            20,
            Text.literal("Custom World Types"),
            button -> this.client.setScreen(new CustomWorldScreen(this))
        ));
    }
}
