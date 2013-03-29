package krapht.modjam;

import java.io.File;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;


@Mod(name = ModJam.modName, version = "1", useMetadata = false, modid = "Krapht|Modjam", dependencies = "")
@NetworkMod(channels = "modJam", packetHandler = PacketHandler.class, clientSideRequired = true, serverSideRequired = true)
public class ModJam {

	public static final String modName = "ModJam";
	public static Block theBlock;
	
	@Instance
	public ModJam instance;
	
	private Config config;
	
	@PreInit
	public void PreInit(FMLPreInitializationEvent event) {
		this.config = new Config(new Configuration(new File(event.getModConfigurationDirectory(), modName + ".conf")));
		
		theBlock = new TheBlock(config.theBlockId, Material.iron)
					//.setUnlocalizedName("TheBlock")
					.setCreativeTab(CreativeTabs.tabMisc);
		GameRegistry.registerBlock(theBlock, "theBlock");
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event){
		
	}
	
	
	
}
