package net.sscaide.realismmod.worldgen.tree;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public class SpiralTrunkPlacer extends TrunkPlacer {
    public static final MapCodec<SpiralTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(
            (inst) -> trunkPlacerParts(inst).and(inst.group(IntProvider.codec(1, 64).fieldOf("segment_height").forGetter((p_70261) -> p_70261.segmentHeight),
            IntProvider.codec(1, 64).fieldOf("segments").forGetter((p_70261) -> p_70261.segments))).apply(inst, SpiralTrunkPlacer::new));
    final private IntProvider segmentHeight;
    final private IntProvider segments;

    public SpiralTrunkPlacer(int baseHeight, int heightRandA, int heightRandB, IntProvider segmentHeight, IntProvider segments) {
        super(baseHeight, heightRandA, heightRandB);
        this.segmentHeight = segmentHeight;
        this.segments = segments;
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return ModTrunkPlacerTypes.SPIRAL_TRUNK_PLACER.get();
    }


    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> blockSetter, RandomSource random, int freeTreeHeight, BlockPos pos, TreeConfiguration config) {
        setDirtAt(level, blockSetter, random, pos.below(), config);
        BlockPos.MutableBlockPos pos$mutable = pos.mutable();
        Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);
        Random tempRandom = new Random();
        int rotationDirection = tempRandom.nextInt(2); //0=left, 1=right

        int track = 0;
        int l = this.segments.sample(random);
        for(int numSegments = 0; numSegments < l; numSegments++) {
            int k = this.segmentHeight.sample(random);
            for (int i = 0; i < freeTreeHeight && i < k; ++i) {
                this.placeLog(level, blockSetter, random, pos$mutable, config);
                pos$mutable.move(Direction.UP);
                track++;
            }
            if(numSegments < l-1) {
                pos$mutable.move(direction);
                switch(rotationDirection) {
                    case 0:
                        direction = direction.getCounterClockWise();
                        break;
                    case 1:
                        direction = direction.getClockWise();
                        break;
                }
            }
        }

        return ImmutableList.of(new FoliagePlacer.FoliageAttachment(pos$mutable.above(freeTreeHeight-4), 0, false));
    }
}
