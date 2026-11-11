package dev.noentitytrace.mixin;

import dev.noentitytrace.NoEntityTraceClient;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerInteractionManager.class)
public abstract class ClientPlayerInteractionManagerMixin {
    @Inject(method = "attackEntity", at = @At("HEAD"), cancellable = true)
    private void noentitytrace$blockPlayerAttack(PlayerEntity player, Entity target, CallbackInfo ci) {
        if (NoEntityTraceClient.isEnabled() && target instanceof PlayerEntity) {
            ci.cancel();
        }
    }
}
