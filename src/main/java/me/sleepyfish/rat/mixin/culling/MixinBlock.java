package me.sleepyfish.rat.mixin.culling;

import me.sleepyfish.rat.event.EventBlockShouldSideBeRendered;
import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public class MixinBlock {

    @Inject(method = "shouldSideBeRendered", at = @At("HEAD"), cancellable = true)
    public void shouldSideBeRendered(IBlockAccess access, BlockPos pos, EnumFacing facing, CallbackInfoReturnable<Boolean> cir) {
        EventBlockShouldSideBeRendered event = new EventBlockShouldSideBeRendered(access, pos, facing);
        event.call();

        if (event.isCancelled()) {
            cir.setReturnValue(false);
        }
    }

}