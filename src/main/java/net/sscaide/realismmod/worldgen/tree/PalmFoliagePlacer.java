package net.sscaide.realismmod.worldgen.tree;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class PalmFoliagePlacer extends FoliagePlacer {
    public static final MapCodec<PalmFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec((inst) -> foliagePlacerParts(inst).apply(inst, PalmFoliagePlacer::new));

    public PalmFoliagePlacer(IntProvider radius, IntProvider offset) {
        super(radius, offset);
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return ModFoliagePlacerTypes.PALM_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader level, FoliageSetter foliageSetter, RandomSource random, TreeConfiguration config, int freeTreeHeight, FoliageAttachment attachment, int i1, int i2, int i3) {
        BlockPos startPos = attachment.pos();
        Direction direction = Direction.NORTH;
        Direction altDirection;
        int radius = this.radius.sample(random);
        float diagRadius = radius/2+1; if(diagRadius != radius/2) { diagRadius += .5; }

        tryPlaceLeaf(level, foliageSetter, random, config, startPos);
        tryPlaceLeaf(level, foliageSetter, random, config, startPos.above());

        for(int i = 0; i < 4; i++) {
            BlockPos.MutableBlockPos pos$mutable = startPos.mutable();
            altDirection = direction.getClockWise();

            for(int j = 0; j < radius; j++) {
                pos$mutable.move(direction);
                tryPlaceLeaf(level, foliageSetter, random, config, pos$mutable);
            }
            pos$mutable.move(direction); pos$mutable.move(Direction.DOWN);
            tryPlaceLeaf(level, foliageSetter, random, config, pos$mutable);

            for(int k = 0; k < diagRadius; k++) {
                pos$mutable = startPos.mutable();
                pos$mutable.move(direction); pos$mutable.move(altDirection);
                tryPlaceLeaf(level, foliageSetter, random, config, pos$mutable);
            }
            pos$mutable.move(direction); pos$mutable.move(altDirection); pos$mutable.move(Direction.DOWN);
            tryPlaceLeaf(level, foliageSetter, random, config, pos$mutable);

            direction = direction.getClockWise();
        }
    }

    @Override
    public int foliageHeight(RandomSource randomSource, int i, TreeConfiguration treeConfiguration) {
        return 0;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource randomSource, int i, int i1, int i2, int i3, boolean b) {
        return false;
    }
}
