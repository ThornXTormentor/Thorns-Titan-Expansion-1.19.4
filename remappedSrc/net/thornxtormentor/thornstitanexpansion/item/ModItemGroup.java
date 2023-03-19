package net.thornxtormentor.thornstitanexpansion.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.thornxtormentor.thornstitanexpansion.ThornsTitanExpansionMod;

public class ModItemGroup {
    public static final ItemGroup TTEGROUP = FabricItemGroupBuilder.build(new Identifier(ThornsTitanExpansionMod.MOD_ID, "ttegroup"), () -> new ItemStack(ModItems.PERIDOT));
}
