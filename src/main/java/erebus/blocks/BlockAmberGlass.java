package erebus.blocks;

import java.util.Random;

import erebus.ModTabs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockAmberGlass extends Block {

    public static final PropertyBool CONNECTED_DOWN = PropertyBool.create("connected_down");
    public static final PropertyBool CONNECTED_UP = PropertyBool.create("connected_up");
    public static final PropertyBool CONNECTED_NORTH = PropertyBool.create("connected_north");
    public static final PropertyBool CONNECTED_SOUTH = PropertyBool.create("connected_south");
    public static final PropertyBool CONNECTED_WEST = PropertyBool.create("connected_west");
    public static final PropertyBool CONNECTED_EAST = PropertyBool.create("connected_east");

	public BlockAmberGlass() {
		super(Material.GLASS);
		this.setDefaultState(this.blockState.getBaseState().withProperty(CONNECTED_DOWN, Boolean.FALSE).withProperty(CONNECTED_EAST, Boolean.FALSE).withProperty(CONNECTED_NORTH, Boolean.FALSE).withProperty(CONNECTED_SOUTH, Boolean.FALSE).withProperty(CONNECTED_UP, Boolean.FALSE).withProperty(CONNECTED_WEST, Boolean.FALSE));
		setHardness(1.5F);
		setLightOpacity(1);
		setResistance(10.0F);
		setSoundType(SoundType.GLASS);
		setCreativeTab(ModTabs.BLOCKS);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
		if (tab == ModTabs.BLOCKS)
			list.add(new ItemStack(this, 1, 0));
	}

	@Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(this);
	}

	@Override
	public int quantityDropped(Random rand) {
		return 1;
	}

	@Override
	public int damageDropped(IBlockState state) {
		return 0;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getRenderLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}

	@Override
	@SideOnly(Side.CLIENT)
	@SuppressWarnings("deprecation")
	public boolean shouldSideBeRendered(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side) {
		IBlockState iblockstate = world.getBlockState(pos.offset(side));
		Block block = iblockstate.getBlock();
		return block == this ? false : super.shouldSideBeRendered(state, world, pos, side);
	}

    @Override
    public int getMetaFromState (IBlockState state) {
    	return 0;
    }

    @Override
    public IBlockState getActualState (IBlockState state, IBlockAccess world, BlockPos position) {
        return state.withProperty(CONNECTED_DOWN, this.isSideConnectable(world, position, EnumFacing.DOWN)).withProperty(CONNECTED_EAST, this.isSideConnectable(world, position, EnumFacing.EAST)).withProperty(CONNECTED_NORTH, this.isSideConnectable(world, position, EnumFacing.NORTH)).withProperty(CONNECTED_SOUTH, this.isSideConnectable(world, position, EnumFacing.SOUTH)).withProperty(CONNECTED_UP, this.isSideConnectable(world, position, EnumFacing.UP)).withProperty(CONNECTED_WEST, this.isSideConnectable(world, position, EnumFacing.WEST));
    }

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { CONNECTED_DOWN, CONNECTED_UP, CONNECTED_NORTH, CONNECTED_SOUTH, CONNECTED_WEST, CONNECTED_EAST});
	}

    private boolean isSideConnectable (IBlockAccess world, BlockPos pos, EnumFacing side) {
    	final IBlockState stateConnection = world.getBlockState(pos.offset(side));
        return (stateConnection == null) ? false : stateConnection.getBlock() == this;
    }
}