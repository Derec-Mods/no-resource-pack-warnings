package no.resource.pack.warnings.mixin.client;

import net.minecraft.client.gui.screen.pack.PackListWidget.ResourcePackEntry;
import net.minecraft.resource.ResourcePackCompatibility;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ResourcePackEntry.class)
public class PackEntryMixin {

	@Redirect(
		method = "render",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/server/packs/repository/PackCompatibility;isCompatible()Z"
		)
	)
	private boolean onRenderRedirectIsCompatible(ResourcePackCompatibility compatibility) {
		return true;
	}

	@Redirect(
		method = "handlePackSelection",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/server/packs/repository/PackCompatibility;isCompatible()Z"
		)
	)
	private boolean onMouseClickedRedirectIsCompatible(ResourcePackCompatibility compatibility) {
		return true;
	}
}
