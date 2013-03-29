package krapht.modjam;

import cpw.mods.fml.common.SidedProxy;


public class ModJamProxy {
	@SidedProxy(clientSide = "krapht.modjam.ModJamProxyClient", serverSide = "krapht.modjam.ModJamProxy")
	public static ModJamProxy proxy;
	
	public void registerTileEntities(){
		
	}
}
