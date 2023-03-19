package net.thornxtormentor.thornstitanexpansion;

import net.fabricmc.api.ModInitializer;
import net.thornxtormentor.thornstitanexpansion.item.ModItemGroup;
import net.thornxtormentor.thornstitanexpansion.item.ModItems;
import net.thornxtormentor.thornstitanexpansion.block.ModBlocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThornsTitanExpansionMod implements ModInitializer {
	public static final String MOD_ID = "thornstitanexpansion";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		LOGGER.info("Initializing Thorns Titan Expansion");
	}
}
