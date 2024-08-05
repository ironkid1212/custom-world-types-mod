package com.example.customworldtypes.gui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CustomWorldScreen extends Screen {
    private final Screen parent;
    private TextFieldWidget nameField;
    private TextFieldWidget datapackField;

    public CustomWorldScreen(Screen parent) {
        super(Text.literal("Custom World Types"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        this.client.keyboard.setRepeatEvents(true);
        this.nameField = new TextFieldWidget(this.textRenderer, this.width / 2 - 100, 60, 200, 20, Text.literal("World Type Name"));
        this.datapackField = new TextFieldWidget(this.textRenderer, this.width / 2 - 100, 100, 200, 20, Text.literal("Datapack URL"));

        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, 140, 200, 20, Text.literal("Create World Type"), button -> createCustomWorldType()));
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, 180, 200, 20, Text.literal("Cancel"), button -> this.client.setScreen(this.parent)));

        this.addSelectableChild(this.nameField);
        this.addSelectableChild(this.datapackField);
    }

    private void createCustomWorldType() {
        String worldTypeName = this.nameField.getText();
        String datapackUrl = this.datapackField.getText();
        
        // Handle world type creation logic, including downloading the datapack and saving the custom world type configuration

        this.client.setScreen(this.parent);
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 20, 0xFFFFFF);
        this.nameField.render(matrices, mouseX, mouseY, delta);
        this.datapackField.render(matrices, mouseX, mouseY, delta);
        super.render(matrices, mouseX, mouseY, delta);
    }

    @Override
    public void removed() {
        this.client.keyboard.setRepeatEvents(false);
    }
}
