package no.resource.pack.warnings.mixin.client;

import net.minecraft.client.option.GameOptions;
import net.minecraft.resource.ResourcePackCompatibility;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(GameOptions.class)
public class OptionsMixin {

	@Redirect(
		method = "updateResourcePacks",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/server/packs/repository/PackCompatibility;isCompatible()Z"
		)
	)
	private boolean onUpdateResourcePacksRedirectIsCompatible(ResourcePackCompatibility compatibility) {
		return true;
	}

	@Redirect(
		method = "loadSelectedResourcePacks",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/server/packs/repository/PackCompatibility;isCompatible()Z"
		)
	)
	private boolean onLoadSelectedResourcePacksRedirectIsCompatible(ResourcePackCompatibility compatibility) {
		return true;
	}
}
