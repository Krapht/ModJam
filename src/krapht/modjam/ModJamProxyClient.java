package krapht.modjam;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModJamProxyClient extends ModJamProxy {

	@Override
	public void registerTileEntities() {
		GameRegistry.registerTileEntity(TheEntity.class, "krapht.modjam.TheEntity");
	}
}
