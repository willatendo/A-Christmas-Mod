package achristmasmod.server.blocks;

import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.util.entry.BlockEntry;

import achristmasmod.server.ChristmasTags;
import achristmasmod.server.util.ModUtils;
import achristmasmod.server.util.registrate.DyedBlockList;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.registries.ForgeRegistries;

public class ChristmasBlocks {
	public static final Registrate REGISTRATE = Registrate.create(ModUtils.ID).creativeModeTab(() -> CreativeModeTab.TAB_DECORATIONS).addDataGenerator(ProviderType.LANG, provider -> {
		provider.add("block.achristmasmod.present.opendate", "Can only be opened on December 25.");
		provider.add("block.achristmasmod.present.notopenable", "It's not December 25th! You've got to wait!");
		provider.add("block.achristmasmod.calendar.date", "It is %s %s %s");
	}).addDataGenerator(ProviderType.ITEM_TAGS, provider -> provider.tag(ChristmasTags.Items.GIFTS).add(Items.DIAMOND, Items.ECHO_SHARD, Items.DISC_FRAGMENT_5, Items.GOLDEN_APPLE, Items.ACACIA_BOAT, Items.GOLD_INGOT, Items.MANGROVE_PROPAGULE));

	public static final BlockEntry<CalendarBlock> CALENDAR = REGISTRATE.block("calendar", CalendarBlock::new).properties(properties -> properties.of(Material.WOOL).instabreak().noCollission().randomTicks().sound(SoundType.WOOD)).blockstate((block, provider) -> provider.horizontalBlock(block.get(), state -> provider.models().withExistingParent("calendar_" + state.getValue(CalendarBlock.FACING).getName(), provider.modLoc("block/template_calendar")).texture("calendar", provider.modLoc("block/calendar")))).recipe((block, provider) -> ShapedRecipeBuilder.shaped(block.get()).pattern("##").pattern("##").define('#', Items.PAPER).unlockedBy("has_item", provider.has(Items.PAPER)).save(provider)).item().model((block, provider) -> provider.basicItem(block.get())).build().register();
	public static final DyedBlockList<PresentBlock> PRESENT_BLOCKS = new DyedBlockList<>(dyeColour -> REGISTRATE.block(dyeColour.getName() + "_present", PresentBlock::new).properties(properties -> properties.of(Material.WOOL, dyeColour.getMaterialColor()).instabreak().sound(SoundType.WOOL)).blockstate((block, provider) -> provider.getVariantBuilder(block.get()).partialState().addModels(new ConfiguredModel(provider.models().withExistingParent(dyeColour.getName() + "_present", provider.modLoc("block/template_present")).texture("wrapping", provider.mcLoc("block/" + dyeColour.getName() + "_wool")).texture("ribbon", provider.mcLoc("block/" + dyeColour.getName() + "_terracotta"))))).recipe((block, provider) -> ShapedRecipeBuilder.shaped(block.get()).group("present").pattern("#$").pattern("$#").define('#', Items.PAPER).define('$', ForgeRegistries.ITEMS.getValue(new ResourceLocation(dyeColour.getName() + "_wool"))).unlockedBy("has_item", provider.has(ForgeRegistries.ITEMS.getValue(new ResourceLocation(dyeColour.getName() + "_wool")))).save(provider)).simpleItem().register());

	public static void init() {
	}
}
