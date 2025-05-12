package net.sscaide.realismmod.block.custom;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.state.BlockState;
import net.sscaide.realismmod.block.ModBlocks;

import java.util.Random;

import static java.lang.String.valueOf;

public class WetClayBrick extends PlaceableSingleBrick {
    private int drying;
    private boolean sunlight;

    public WetClayBrick(Properties properties) {
        super(properties);
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (level.isDay() && level.canSeeSky(pos)) {
            drying++;
            sunlight = true;
            if (drying >= 21) {
                level.setBlockAndUpdate(pos, ModBlocks.DRIED_BRICK.get().defaultBlockState().setValue(FACING, state.getValue(FACING)));
            }
        } else { sunlight = false; }
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if(level.isClientSide()) {
            double d0 = (double) pos.getX() + (double) 0.5F;
            double d1 = (double) pos.getY() + 0.35;
            double d2 = (double) pos.getZ() + (double) 0.5F;
            int rng = random.nextInt(16);
            if(sunlight && rng == 0)
            {
                level.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0F, 0.0F, 0.0F);
            }
        }
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        level.destroyBlock(pos, true, entity);
    }
}
