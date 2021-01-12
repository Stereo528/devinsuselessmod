// 🦀 CRAB IN THE CODE 🦀

package dev.hiitsdevin.devinsuselessmod;

import com.mojang.blaze3d.platform.GlStateManager;
import dev.hiitsdevin.devinsuselessmod.client.DevinsuselessmodClient;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.kyrptonaught.customportalapi.CustomPortalApiRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Devinsuselessmod implements ModInitializer {

    //TODO:
    // - Add a custom biome consistent of the prototype texture blocks - Work in Progress ✅
    // - Figure out how to make fence and wall textures
    // - Figure out custom building generation
    // - Learn how to make commands
    // - Learn how to make a GUI
    // - Make some sort of a new "chest" like thing

    // FIXME: Fix Cjab's creeper.properties random entities file - Done ✅

    String PrototypePastelVersion = "Devin's Useless Mod - Development Build v0.1.0";
    String PrototypePastelDistribution = "If this build isn't public, and you got it from Devin, please do not redistribute!";
    int yOffset = 5; //to be used soon for text render

    @Override
    public void onInitialize() {

        HudRenderCallback.EVENT.register((matrices, delta) -> {
            MinecraftClient.getInstance().textRenderer
                    .drawWithShadow(matrices, PrototypePastelVersion, 1, 1, 0xFFFFFFFF);
        });

        HudRenderCallback.EVENT.register((matrices, delta) -> {
            MinecraftClient.getInstance().textRenderer
                    .drawWithShadow(matrices, PrototypePastelDistribution, 1, 11, 0xFFFFFFFF);
        });

        CustomPortalApiRegistry.addPortal(Blocks.BLACK, new Identifier("devin", "devin"), 63, 63, 63);
        CustomPortalApiRegistry.addPortal(Blocks.RED, new Identifier("devin", "devin"), 253,174,187);

        // modularity who
        // each separate class for organizational reasons, this is great
        Items.init();
        Blocks.init();
    }
}
