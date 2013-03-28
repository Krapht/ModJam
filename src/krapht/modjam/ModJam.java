package krapht.modjam;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(name = "BuildCraft", version = "1", useMetadata = false, modid = "Krapht|Modjam", dependencies = "")
@NetworkMod(channels = "modJam", packetHandler = PacketHandler.class, clientSideRequired = true, serverSideRequired = true)

public class ModJam {

}
