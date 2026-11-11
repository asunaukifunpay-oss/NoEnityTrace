package dev.noentitytrace;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public final class NoEntityTraceClient implements ClientModInitializer {
    private static KeyBinding toggleKey;
    private static boolean enabled;

    @Override
    public void onInitializeClient() {
        toggleKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.noentitytrace.toggle",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_RIGHT_BRACKET,
                "category.noentitytrace"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (toggleKey.wasPressed()) {
                // Keep this utility confined to a local singleplayer world.
                if (!client.isInSingleplayer()) {
                    client.player.sendMessage(Text.literal("NoEntityTrace works only in singleplayer."), true);
                    enabled = false;
                    continue;
                }

                enabled = !enabled;
                if (client.player != null) {
                    client.player.sendMessage(Text.literal("NoEntityTrace: " + (enabled ? "ON" : "OFF")), true);
                }
            }

            if (!client.isInSingleplayer()) {
                enabled = false;
            }
        });
    }

    public static boolean isEnabled() {
        return enabled;
    }
}
