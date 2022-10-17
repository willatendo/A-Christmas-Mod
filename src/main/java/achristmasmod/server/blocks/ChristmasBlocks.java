package achristmasmod.server.blocks;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.util.entry.BlockEntry;

import achristmasmod.server.ChristmasTags;
import achristmasmod.server.util.ModCalendar;
import achristmasmod.server.util.ModUtils;
import achristmasmod.server.util.registrate.DyedBlockList;
import net.minecraft.core.Direction;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.registries.ForgeRegistries;

public class ChristmasBlocks {
	public static final Registrate REGISTRATE = Registrate.create(ModUtils.ID).creativeModeTab(() -> CreativeModeTab.TAB_DECORATIONS).addDataGenerator(ProviderType.LANG, provider -> {
		provider.add("block.achristmasmod.present.opendate", "Can only be opened on December 25.");
		provider.add("block.achristmasmod.present.notopenable", "It's not December 25th! You've got to wait!");
		provider.add("block.achristmasmod.calendar.date", "It is %s %s %s");
		provider.add("jei.achristmasmod.gifts", "Gifts");

		for (int i = 0; i < 12; i++) {
			String month = new ModCalendar(Calendar.getInstance()).getMonth(i);
			provider.add("block.achristmasmod.calendar." + month, Arrays.stream(month.toLowerCase(Locale.ROOT).split("_")).map(StringUtils::capitalize).collect(Collectors.joining(" ")));
		}
	}).addDataGenerator(ProviderType.ITEM_TAGS, provider -> {
		provider.tag(ChristmasTags.Items.GIFTS).add(Items.DIAMOND, Items.ECHO_SHARD, Items.DISC_FRAGMENT_5, Items.GOLDEN_APPLE, Items.ACACIA_BOAT, Items.GOLD_INGOT, Items.MANGROVE_PROPAGULE);
		provider.copy(ChristmasTags.Blocks.PRESENTS, ChristmasTags.Items.PRESENTS);
	});

	public static final BlockEntry<CalendarBlock> CALENDAR = REGISTRATE.block("calendar", CalendarBlock::new).properties(properties -> properties.of(Material.WOOL).instabreak().noCollission().sound(SoundType.WOOD)).blockstate((block, provider) -> provider.horizontalBlock(block.get(), blockState -> provider.models().withExistingParent("calendar_" + blockState.getValue(CalendarBlock.FACING).getName(), provider.modLoc("block/template_calendar")).texture("calendar", provider.modLoc("block/calendar")))).recipe((block, provider) -> ShapedRecipeBuilder.shaped(block.get()).pattern("##").pattern("##").define('#', Items.PAPER).unlockedBy("has_item", provider.has(Items.PAPER)).save(provider)).item().model((block, provider) -> provider.basicItem(block.get())).build().register();
	public static final DyedBlockList<PresentBlock> PRESENT_BLOCKS = new DyedBlockList<>(dyeColour -> REGISTRATE.block(dyeColour.getName() + "_present", PresentBlock::new).properties(properties -> properties.of(Material.WOOL, dyeColour.getMaterialColor()).instabreak().sound(SoundType.WOOL)).tag(ChristmasTags.Blocks.PRESENTS).blockstate((block, provider) -> provider.getVariantBuilder(block.get()).partialState().addModels(new ConfiguredModel(provider.models().withExistingParent(dyeColour.getName() + "_present", provider.modLoc("block/template_present")).texture("wrapping", provider.mcLoc("block/" + dyeColour.getName() + "_wool")).texture("ribbon", provider.mcLoc("block/" + dyeColour.getName() + "_terracotta"))))).recipe((block, provider) -> ShapedRecipeBuilder.shaped(block.get()).group("present").pattern("#$").pattern("$#").define('#', Items.PAPER).define('$', ForgeRegistries.ITEMS.getValue(new ResourceLocation(dyeColour.getName() + "_wool"))).unlockedBy("has_item", provider.has(ForgeRegistries.ITEMS.getValue(new ResourceLocation(dyeColour.getName() + "_wool")))).save(provider)).simpleItem().register());
	public static final BlockEntry<FairyLightsBlock> MULTI_COLOR_FAIRY_LIGHTS = REGISTRATE.block("multi_color_fairy_lights", FairyLightsBlock::new).properties(properties -> properties.of(Material.WOOL).instabreak().noCollission().lightLevel(blockState -> 6).sound(SoundType.WOOL)).recipe((block, provider) -> ShapelessRecipeBuilder.shapeless(block.get(), 8).requires(Items.RED_DYE).requires(Items.GREEN_DYE).requires(Items.CYAN_DYE).requires(Items.PURPLE_DYE).requires(Items.STRING).requires(Blocks.REDSTONE_LAMP).unlockedBy("has_item", provider.has(Blocks.REDSTONE_LAMP)).save(provider))
			.blockstate((block, provider) -> provider.getMultipartBuilder(block.get())
			.part().modelFile(provider.models().withExistingParent(block.getName(), provider.modLoc("block/template_fairy_lights")).renderType("cutout").texture("fairy_light", provider.modLoc("block/multi_color_fairy_lights"))).addModel().condition(FairyLightsBlock.PROPERTY_BY_DIRECTION.get(Direction.NORTH), true).end()
			.part().modelFile(provider.models().withExistingParent(block.getName(), provider.modLoc("block/template_fairy_lights")).renderType("cutout").texture("fairy_light", provider.modLoc("block/multi_color_fairy_lights"))).rotationY(90).addModel().condition(FairyLightsBlock.PROPERTY_BY_DIRECTION.get(Direction.EAST), true).end()
			.part().modelFile(provider.models().withExistingParent(block.getName(), provider.modLoc("block/template_fairy_lights")).renderType("cutout").texture("fairy_light", provider.modLoc("block/multi_color_fairy_lights"))).rotationY(180).addModel().condition(FairyLightsBlock.PROPERTY_BY_DIRECTION.get(Direction.SOUTH), true).end()
			.part().modelFile(provider.models().withExistingParent(block.getName(), provider.modLoc("block/template_fairy_lights")).renderType("cutout").texture("fairy_light", provider.modLoc("block/multi_color_fairy_lights"))).rotationY(270).addModel().condition(FairyLightsBlock.PROPERTY_BY_DIRECTION.get(Direction.WEST), true).end()
			).item().model((block, provider) -> provider.getBuilder(block.getName()).parent(new ModelFile.UncheckedModelFile("item/generated")).texture("layer0", provider.modLoc("block/" + block.getName()))).build().register();

	public static void init() {
	}
}
