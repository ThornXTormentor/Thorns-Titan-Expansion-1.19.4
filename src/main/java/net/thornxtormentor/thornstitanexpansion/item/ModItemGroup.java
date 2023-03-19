package net.thornxtormentor.thornstitanexpansion.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.thornxtormentor.thornstitanexpansion.ThornsTitanExpansionMod;

public class ModItemGroup {
    public static ItemGroup TTEGroup;

    public static void registerItemGroups(){
        TTEGroup = FabricItemGroup.builder(new Identifier(ThornsTitanExpansionMod.MOD_ID, "ttegroup"))
                .displayName(Text.translatable("thornstitanexpansion.ttegroup"))
                .icon(() -> new ItemStack(ModItems.RAW_PERIDOT)).build();
    }
}
