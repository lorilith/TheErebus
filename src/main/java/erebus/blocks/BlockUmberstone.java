package erebus.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import erebus.ModBlocks;
import erebus.ModBlocks.IHasCustomItem;
import erebus.ModBlocks.ISubBlocksBlock;
import erebus.ModTabs;
import erebus.api.IErebusEnum;
import erebus.items.block.ItemBlockEnum;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockUmberstone extends Block implements IHasCustomItem, ISubBlocksBlock {

	public static final PropertyEnum<EnumType> TYPE = PropertyEnum.create("type", EnumType.class);

	public BlockUmberstone() {
		super(Material.ROCK);
		setHardness(1.5F);
		setResistance(10.0F);
		setHarvestLevel("pickaxe", 0);
		setCreativeTab(ModTabs.BLOCKS);
		setDefaultState(blockState.getBaseState().withProperty(TYPE, EnumType.UMBERSTONE));
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(TYPE, EnumType.values()[meta]);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		EnumType type = state.getValue(TYPE);
		return type.ordinal();
	}

	@Override
	public int damageDropped(IBlockState state) {
		return getMetaFromState(state) == 0 ? 1 : getMetaFromState(state);
	}
	
	@Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        return new ItemStack(Item.getItemFromBlock(this), 1, state.getValue(TYPE).ordinal());
    }

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { TYPE });
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
		if (tab == ModTabs.BLOCKS)
			for (EnumType type : EnumType.values())
				list.add(new ItemStack(this, 1, type.ordinal()));
	}

	@Override
	public void onPlayerDestroy(World world, BlockPos pos, IBlockState state) {
		EntityPlayer player = world.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 40, false);
		if (player != null) {
			// TODO player.triggerAchievement(ModAchievements.umberstone);
		}
	}

	@Override
	public ItemBlock getItemBlock() {
		return ItemBlockEnum.create(this, EnumType.class);
	}

	@Override
	public List<String> getModels() {
		List<String> models = new ArrayList<String>();
		for (EnumType type : EnumType.values())
			models.add(type.getName());
		return models;
	}

	public enum EnumType implements IErebusEnum {

		UMBERSTONE,
		UMBERCOBBLE,
		UMBERCOBBLE_MOSSY,
		UMBERCOBBLE_WEBBED,
		UMBERSTONE_BRICKS,
		UMBERTILE_SMOOTH,
		UMBERTILE_SMOOTH_SMALL;

		@Override
		public ItemStack createStack(int size) {
			return new ItemStack(ModBlocks.UMBERSTONE, size, ordinal());
		}

		@Override
		public String getName() {
			return name().toLowerCase(Locale.ENGLISH);
		}
	}
}