package krapht.modjam;

import java.io.File;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


@Mod(name = ModJam.modName, version = "1", useMetadata = false, modid = "Krapht|Modjam", dependencies = "")
@NetworkMod(channels = "modJam", packetHandler = PacketHandler.class, clientSideRequired = true, serverSideRequired = true)
public class ModJam {

	public static final String modName = "ModJam";
	public static Block theBlock;
	
	public static Item poker;
	
	@Instance
	public ModJam instance;
	
	private Config config;
	
	@PreInit
	public void PreInit(FMLPreInitializationEvent event) {
		this.config = new Config(new Configuration(new File(event.getModConfigurationDirectory(), modName + ".conf")));
		
		theBlock = new TheBlock(config.theBlockId, Material.iron)
					.setUnlocalizedName("TheBlock")
					.setCreativeTab(CreativeTabs.tabMisc);
		GameRegistry.registerBlock(theBlock, "theBlock");
		
		poker = new Item(config.pokerId){
						@Override
						@SideOnly(Side.CLIENT)
						public void updateIcons(IconRegister par1IconRegister) {
							this.iconIndex = par1IconRegister.registerIcon("modjam:poker");
						}
					}
					.setUnlocalizedName("Poker")
					.setCreativeTab(CreativeTabs.tabTools);
		GameRegistry.registerItem(poker, "Poker");
	}
	
	@Init
	public void Init(FMLInitializationEvent evt) {
		ModJamProxy.proxy.registerTileEntities();
		ModJamProxy.proxy.registerBlockRenders();
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event){
		
	}
	
	
	
}
