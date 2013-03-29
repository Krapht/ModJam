package krapht.modjam;

import net.minecraftforge.common.Configuration;

public class Config {

	public int theBlockId;
	public int pokerId;

	public Config(Configuration configuration) {
		theBlockId = configuration.getBlock("TheBlock", 2860).getInt();
		pokerId = configuration.getItem("Poker", 20871).getInt();
		
		if (configuration.hasChanged()){
			configuration.save();
		}
	}

}
