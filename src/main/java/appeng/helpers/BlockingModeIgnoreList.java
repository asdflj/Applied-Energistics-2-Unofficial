package appeng.helpers;

import java.util.ArrayList;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTOreDictUnificator;

public class BlockingModeIgnoreList {

    private final static ArrayList<String> Shapes = new ArrayList<String>();
    private final static ArrayList<String> Lenses = new ArrayList<String>();
    private final static ArrayList<String> Molds = new ArrayList<String>();

    private final static ArrayList<Item> IgnoredItems = new ArrayList<Item>();

    // Name + damage value from ItemList enums
    private static String getUniqueIdentifier(ItemList item) {
        return item.getItem().getUnlocalizedName() + item.getItem().getDamage(item.get(1));
    }

    // Name + damage value from existing ItemStacks
    private static String getUniqueIdentifier(ItemStack is) {
        return is.getItem().getUnlocalizedName() + is.getItemDamage();
    }

    public static void registerIgnoredMaterials() {
        if (Loader.isModLoaded("dreamcraft")) {
            Molds.add(getUniqueIdentifier(ItemList.Shape_Mold_Bottle));

            Molds.add(getUniqueIdentifier(ItemList.Shape_Mold_Plate));
            Molds.add(getUniqueIdentifier(ItemList.Shape_Mold_Ingot));
            Molds.add(getUniqueIdentifier(ItemList.Shape_Mold_Casing));
            Molds.add(getUniqueIdentifier(ItemList.Shape_Mold_Gear));
            Molds.add(getUniqueIdentifier(ItemList.Shape_Mold_Gear_Small));
            Molds.add(getUniqueIdentifier(ItemList.Shape_Mold_Credit));
            Molds.add(getUniqueIdentifier(ItemList.Shape_Mold_Nugget));
            Molds.add(getUniqueIdentifier(ItemList.Shape_Mold_Block));
            Molds.add(getUniqueIdentifier(ItemList.Shape_Mold_Ball));
            Molds.add(getUniqueIdentifier(ItemList.Shape_Mold_Bun));
            Molds.add(getUniqueIdentifier(ItemList.Shape_Mold_Bread));
            Molds.add(getUniqueIdentifier(ItemList.Shape_Mold_Baguette));
            Molds.add(getUniqueIdentifier(ItemList.Shape_Mold_Cylinder));
            Molds.add(getUniqueIdentifier(ItemList.Shape_Mold_Anvil));
            Molds.add(getUniqueIdentifier(ItemList.Shape_Mold_Arrow));
            Molds.add(getUniqueIdentifier(ItemList.Shape_Mold_Name));
            Molds.add(getUniqueIdentifier(ItemList.Shape_Mold_Rod));
            Molds.add(getUniqueIdentifier(ItemList.Shape_Mold_Bolt));
            Molds.add(getUniqueIdentifier(ItemList.Shape_Mold_Round));
            Molds.add(getUniqueIdentifier(ItemList.Shape_Mold_Screw));
            Molds.add(getUniqueIdentifier(ItemList.Shape_Mold_Ring));
            Molds.add(getUniqueIdentifier(ItemList.Shape_Mold_Rod_Long));
            Molds.add(getUniqueIdentifier(ItemList.Shape_Mold_Rotor));
            Molds.add(getUniqueIdentifier(ItemList.Shape_Mold_Turbine_Blade));
            Molds.add(getUniqueIdentifier(ItemList.Shape_Mold_Pipe_Tiny));
            Molds.add(getUniqueIdentifier(ItemList.Shape_Mold_Pipe_Small));
            Molds.add(getUniqueIdentifier(ItemList.Shape_Mold_Pipe_Medium));
            Molds.add(getUniqueIdentifier(ItemList.Shape_Mold_Pipe_Large));
            Molds.add(getUniqueIdentifier(ItemList.Shape_Mold_Pipe_Huge));

            Shapes.add(getUniqueIdentifier(ItemList.Shape_Mold_ToolHeadDrill));
            Shapes.add(getUniqueIdentifier(ItemList.Shape_Slicer_Flat));
            Shapes.add(getUniqueIdentifier(ItemList.Shape_Slicer_Stripes));
            Shapes.add(getUniqueIdentifier(ItemList.Shape_Extruder_Bottle));
            Shapes.add(getUniqueIdentifier(ItemList.Shape_Extruder_Plate));
            Shapes.add(getUniqueIdentifier(ItemList.Shape_Extruder_Cell));
            Shapes.add(getUniqueIdentifier(ItemList.Shape_Extruder_Ring));
            Shapes.add(getUniqueIdentifier(ItemList.Shape_Extruder_Rod));
            Shapes.add(getUniqueIdentifier(ItemList.Shape_Extruder_Bolt));
            Shapes.add(getUniqueIdentifier(ItemList.Shape_Extruder_Ingot));
            Shapes.add(getUniqueIdentifier(ItemList.Shape_Extruder_Wire));
            Shapes.add(getUniqueIdentifier(ItemList.Shape_Extruder_Casing));
            Shapes.add(getUniqueIdentifier(ItemList.Shape_Extruder_Pipe_Tiny));
            Shapes.add(getUniqueIdentifier(ItemList.Shape_Extruder_Pipe_Small));
            Shapes.add(getUniqueIdentifier(ItemList.Shape_Extruder_Pipe_Medium));
            Shapes.add(getUniqueIdentifier(ItemList.Shape_Extruder_Pipe_Large));
            Shapes.add(getUniqueIdentifier(ItemList.Shape_Extruder_Pipe_Huge));
            Shapes.add(getUniqueIdentifier(ItemList.Shape_Extruder_Block));
            Shapes.add(getUniqueIdentifier(ItemList.Shape_Extruder_Sword));
            Shapes.add(getUniqueIdentifier(ItemList.Shape_Extruder_Pickaxe));
            Shapes.add(getUniqueIdentifier(ItemList.Shape_Extruder_Shovel));
            Shapes.add(getUniqueIdentifier(ItemList.Shape_Extruder_Axe));
            Shapes.add(getUniqueIdentifier(ItemList.Shape_Extruder_Hoe));
            Shapes.add(getUniqueIdentifier(ItemList.Shape_Extruder_Hammer));
            Shapes.add(getUniqueIdentifier(ItemList.Shape_Extruder_File));
            Shapes.add(getUniqueIdentifier(ItemList.Shape_Extruder_Saw));
            Shapes.add(getUniqueIdentifier(ItemList.Shape_Extruder_Gear));
            Shapes.add(getUniqueIdentifier(ItemList.Shape_Extruder_Rotor));
            Shapes.add(getUniqueIdentifier(ItemList.Shape_Extruder_Turbine_Blade));
            Shapes.add(getUniqueIdentifier(ItemList.Shape_Extruder_Small_Gear));
            Shapes.add(getUniqueIdentifier(ItemList.Shape_Extruder_ToolHeadDrill));
            Shapes.add(getUniqueIdentifier(ItemList.White_Dwarf_Shape_Extruder_Bottle));
            Shapes.add(getUniqueIdentifier(ItemList.White_Dwarf_Shape_Extruder_Plate));
            Shapes.add(getUniqueIdentifier(ItemList.White_Dwarf_Shape_Extruder_Cell));
            Shapes.add(getUniqueIdentifier(ItemList.White_Dwarf_Shape_Extruder_Ring));
            Shapes.add(getUniqueIdentifier(ItemList.White_Dwarf_Shape_Extruder_Rod));
            Shapes.add(getUniqueIdentifier(ItemList.White_Dwarf_Shape_Extruder_Bolt));
            Shapes.add(getUniqueIdentifier(ItemList.White_Dwarf_Shape_Extruder_Ingot));
            Shapes.add(getUniqueIdentifier(ItemList.White_Dwarf_Shape_Extruder_Wire));
            Shapes.add(getUniqueIdentifier(ItemList.White_Dwarf_Shape_Extruder_Casing));
            Shapes.add(getUniqueIdentifier(ItemList.White_Dwarf_Shape_Extruder_Pipe_Tiny));
            Shapes.add(getUniqueIdentifier(ItemList.White_Dwarf_Shape_Extruder_Pipe_Small));
            Shapes.add(getUniqueIdentifier(ItemList.White_Dwarf_Shape_Extruder_Pipe_Medium));
            Shapes.add(getUniqueIdentifier(ItemList.White_Dwarf_Shape_Extruder_Pipe_Large));
            Shapes.add(getUniqueIdentifier(ItemList.White_Dwarf_Shape_Extruder_Pipe_Huge));
            Shapes.add(getUniqueIdentifier(ItemList.White_Dwarf_Shape_Extruder_Block));
            Shapes.add(getUniqueIdentifier(ItemList.White_Dwarf_Shape_Extruder_Sword));
            Shapes.add(getUniqueIdentifier(ItemList.White_Dwarf_Shape_Extruder_Pickaxe));
            Shapes.add(getUniqueIdentifier(ItemList.White_Dwarf_Shape_Extruder_Shovel));
            Shapes.add(getUniqueIdentifier(ItemList.White_Dwarf_Shape_Extruder_Axe));
            Shapes.add(getUniqueIdentifier(ItemList.White_Dwarf_Shape_Extruder_Hoe));
            Shapes.add(getUniqueIdentifier(ItemList.White_Dwarf_Shape_Extruder_Hammer));
            Shapes.add(getUniqueIdentifier(ItemList.White_Dwarf_Shape_Extruder_File));
            Shapes.add(getUniqueIdentifier(ItemList.White_Dwarf_Shape_Extruder_Saw));
            Shapes.add(getUniqueIdentifier(ItemList.White_Dwarf_Shape_Extruder_Gear));
            Shapes.add(getUniqueIdentifier(ItemList.White_Dwarf_Shape_Extruder_Rotor));
            Shapes.add(getUniqueIdentifier(ItemList.White_Dwarf_Shape_Extruder_Turbine_Blade));
            Shapes.add(getUniqueIdentifier(ItemList.White_Dwarf_Shape_Extruder_Small_Gear));
            Shapes.add(getUniqueIdentifier(ItemList.White_Dwarf_Shape_Extruder_ToolHeadDrill));

            Lenses.add(getUniqueIdentifier(GTOreDictUnificator.get(OrePrefixes.lens, Materials.Emerald, 1)));
            Lenses.add(getUniqueIdentifier(GTOreDictUnificator.get(OrePrefixes.lens, Materials.Firestone, 1)));
            Lenses.add(getUniqueIdentifier(GTOreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 1)));
            Lenses.add(getUniqueIdentifier(GTOreDictUnificator.get(OrePrefixes.lens, Materials.Ruby, 1)));
            Lenses.add(getUniqueIdentifier(GTOreDictUnificator.get(OrePrefixes.lens, Materials.Sapphire, 1)));
            Lenses.add(getUniqueIdentifier(GTOreDictUnificator.get(OrePrefixes.lens, Materials.GreenSapphire, 1)));
            Lenses.add(getUniqueIdentifier(GTOreDictUnificator.get(OrePrefixes.lens, Materials.Olivine, 1)));
            Lenses.add(getUniqueIdentifier(GTOreDictUnificator.get(OrePrefixes.lens, Materials.NetherStar, 1)));
            Lenses.add(getUniqueIdentifier(GTOreDictUnificator.get(OrePrefixes.lens, Materials.Topaz, 1)));
            Lenses.add(getUniqueIdentifier(GTOreDictUnificator.get(OrePrefixes.lens, Materials.Tanzanite, 1)));
            Lenses.add(getUniqueIdentifier(GTOreDictUnificator.get(OrePrefixes.lens, Materials.Amethyst, 1)));
            Lenses.add(getUniqueIdentifier(GTOreDictUnificator.get(OrePrefixes.lens, Materials.Opal, 1)));
            Lenses.add(getUniqueIdentifier(GTOreDictUnificator.get(OrePrefixes.lens, Materials.Jasper, 1)));
            // Spinel
            Lenses.add(getUniqueIdentifier(GTOreDictUnificator.get(OrePrefixes.lens, Materials.FoolsRuby, 1)));
            Lenses.add(getUniqueIdentifier(GTOreDictUnificator.get(OrePrefixes.lens, Materials.BlueTopaz, 1)));
            Lenses.add(getUniqueIdentifier(GTOreDictUnificator.get(OrePrefixes.lens, Materials.Amber, 1)));
            Lenses.add(getUniqueIdentifier(GTOreDictUnificator.get(OrePrefixes.lens, Materials.Dilithium, 1)));
            Lenses.add(getUniqueIdentifier(GTOreDictUnificator.get(OrePrefixes.lens, Materials.Forcicium, 1)));
            Lenses.add(getUniqueIdentifier(GTOreDictUnificator.get(OrePrefixes.lens, Materials.Forcillium, 1)));
            Lenses.add(getUniqueIdentifier(GTOreDictUnificator.get(OrePrefixes.lens, Materials.Force, 1)));
            Lenses.add(getUniqueIdentifier(GTOreDictUnificator.get(OrePrefixes.lens, Materials.GarnetRed, 1)));
            Lenses.add(getUniqueIdentifier(GTOreDictUnificator.get(OrePrefixes.lens, Materials.GarnetYellow, 1)));
            Lenses.add(getUniqueIdentifier(GTOreDictUnificator.get(OrePrefixes.lens, Materials.EnderPearl, 1)));
            Lenses.add(getUniqueIdentifier(GTOreDictUnificator.get(OrePrefixes.lens, Materials.EnderEye, 1)));
            Lenses.add(getUniqueIdentifier(GTOreDictUnificator.get(OrePrefixes.lens, Materials.InfusedAir, 1)));
            Lenses.add(getUniqueIdentifier(GTOreDictUnificator.get(OrePrefixes.lens, Materials.InfusedFire, 1)));
            Lenses.add(getUniqueIdentifier(GTOreDictUnificator.get(OrePrefixes.lens, Materials.InfusedEarth, 1)));
            Lenses.add(getUniqueIdentifier(GTOreDictUnificator.get(OrePrefixes.lens, Materials.InfusedEntropy, 1)));
            Lenses.add(getUniqueIdentifier(GTOreDictUnificator.get(OrePrefixes.lens, Materials.InfusedOrder, 1)));
            Lenses.add(getUniqueIdentifier(GTOreDictUnificator.get(OrePrefixes.lens, Materials.Glass, 1)));

            IgnoredItems.add(GameRegistry.findItem("gregtech", "gt.integrated_circuit"));
            IgnoredItems.add(GameRegistry.findItem("miscutils", "item.BioRecipeSelector"));
            IgnoredItems.add(GameRegistry.findItem("miscutils", "item.T3RecipeSelector"));
            IgnoredItems.add(GameRegistry.findItem("dreamcraft", "item.ReinforcedGlassLense"));
            IgnoredItems.add(GameRegistry.findItem("dreamcraft", "item.MysteriousCrystalLens"));
            IgnoredItems.add(GameRegistry.findItem("dreamcraft", "item.RadoxPolymerLens"));
            IgnoredItems.add(GameRegistry.findItem("dreamcraft", "item.ChromaticLens"));
            IgnoredItems.add(GameRegistry.findItem("bartworks", "gt.bwMetaGeneratedlens"));
        }

        if (Loader.isModLoaded("AWWayofTime")) { // blood magic
            IgnoredItems.add(GameRegistry.findItem("AWWayofTime", "weakBloodOrb"));
            IgnoredItems.add(GameRegistry.findItem("AWWayofTime", "apprenticeBloodOrb"));
            IgnoredItems.add(GameRegistry.findItem("AWWayofTime", "magicianBloodOrb"));
            IgnoredItems.add(GameRegistry.findItem("AWWayofTime", "masterBloodOrb"));
            IgnoredItems.add(GameRegistry.findItem("AWWayofTime", "archmageBloodOrb"));
            IgnoredItems.add(GameRegistry.findItem("AWWayofTime", "transcendentBloodOrb"));

            if (Loader.isModLoaded("Avaritia")) {
                IgnoredItems.add(GameRegistry.findItem("Avaritia", "Orb_Armok"));
            }

            if (Loader.isModLoaded("ForbiddenMagic")) {
                IgnoredItems.add(GameRegistry.findItem("ForbiddenMagic", "EldritchOrb"));
            }
        }
    }

    public static boolean isIgnored(ItemStack is) {
        if (is != null) {
            String uniqueIdentifier = getUniqueIdentifier(is);
            Item item = is.getItem();

            if (IgnoredItems.contains(item) || Shapes.contains(uniqueIdentifier)
                    || Lenses.contains(uniqueIdentifier)
                    || Molds.contains(uniqueIdentifier))
                return true;
        }
        return false;
    }

}
