package krapht.modjam;

import java.io.File;

import net.minecraft.block.Block;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;


@Mod(name = ModJam.modName, version = "1", useMetadata = false, modid = "Krapht|Modjam", dependencies = "")
@NetworkMod(channels = "modJam", packetHandler = PacketHandler.class, clientSideRequired = true, serverSideRequired = true)
public class ModJam {

	public static final String modName = "ModJam";
	
	public static Block theBlock;
	
	@PreInit
	public void PreInit(FMLPreInitializationEvent event) {
		var configuration  = new Configuration(new File(event.getModConfigurationDirectory(), modName + ".conf"));
		event.getModConfigurationDirectory()
	
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event){
		
	}
	
	
	
}
