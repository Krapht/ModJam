package krapht.modjam;

import net.minecraftforge.common.Configuration;

public class Config {

	public int theBlockId;

	public Config(Configuration configuration) {
		theBlockId = configuration.getBlock("TheBlock", 2860).getInt();
		
		if (configuration.hasChanged()){
			configuration.save();
		}
	}

}
