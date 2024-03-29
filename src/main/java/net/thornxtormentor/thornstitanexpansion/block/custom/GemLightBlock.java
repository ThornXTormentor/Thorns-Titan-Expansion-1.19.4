package net.thornxtormentor.thornstitanexpansion.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RodBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.VerticallyAttachableBlockItem;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class GemLightBlock extends RodBlock {

    public GemLightBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.UP));
    }
    private static VoxelShape Y_SHAPE = Block.createCuboidShape(4, 0, 4, 12, 12, 12);
    private static VoxelShape Z_SHAPE = Block.createCuboidShape(4, 4, 0, 12, 12, 12);
    private static VoxelShape X_SHAPE = Block.createCuboidShape(0, 4, 4, 12, 12, 12);
    private static VoxelShape NEG_Y_SHAPE = Block.createCuboidShape(4, 4, 4, 12, 16, 12);
    private static VoxelShape NEG_Z_SHAPE = Block.createCuboidShape(4, 4, 4, 12, 12, 16);
    private static VoxelShape NEG_X_SHAPE = Block.createCuboidShape(4, 4, 4, 16, 12, 12);

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if(state.get(FACING).getAxis() == Direction.Axis.Z && state.get(FACING).getDirection() == Direction.AxisDirection.POSITIVE) return Z_SHAPE;
        if(state.get(FACING).getAxis() == Direction.Axis.X && state.get(FACING).getDirection() == Direction.AxisDirection.POSITIVE) return X_SHAPE;
        if(state.get(FACING).getAxis() == Direction.Axis.Y && state.get(FACING).getDirection() == Direction.AxisDirection.POSITIVE) return Y_SHAPE;
        if(state.get(FACING).getAxis() == Direction.Axis.Z && state.get(FACING).getDirection() == Direction.AxisDirection.NEGATIVE) return NEG_Z_SHAPE;
        if(state.get(FACING).getAxis() == Direction.Axis.X && state.get(FACING).getDirection() == Direction.AxisDirection.NEGATIVE) return NEG_X_SHAPE;
        if(state.get(FACING).getAxis() == Direction.Axis.Y && state.get(FACING).getDirection() == Direction.AxisDirection.NEGATIVE) return NEG_Y_SHAPE;
        return Y_SHAPE;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction direction = ctx.getSide();
        BlockState blockState = ctx.getWorld().getBlockState(ctx.getBlockPos().offset(direction.getOpposite()));
        if (blockState.isOf(this) && blockState.get(FACING) == direction) {
            return this.getDefaultState().with(FACING, direction.getOpposite());
        }
        return this.getDefaultState().with(FACING, direction);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        Direction direction = state.get(FACING);
        double d = (double)pos.getX() + 0.55 - (double)(random.nextFloat() * 0.1f);
        double e = (double)pos.getY() + 0.55 - (double)(random.nextFloat() * 0.1f);
        double f = (double)pos.getZ() + 0.55 - (double)(random.nextFloat() * 0.1f);
        double g = 0.4f - (random.nextFloat() + random.nextFloat()) * 0.4f;
        if (random.nextInt(5) == 0) {
            world.addParticle(ParticleTypes.END_ROD, d + (double)direction.getOffsetX() * g, e + (double)direction.getOffsetY() * g, f + (double)direction.getOffsetZ() * g, random.nextGaussian() * 0.005, random.nextGaussian() * 0.005, random.nextGaussian() * 0.005);
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public PistonBehavior getPistonBehavior(BlockState state) {
        return PistonBehavior.NORMAL;
    }
}
