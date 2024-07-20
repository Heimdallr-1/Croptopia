package com.epherical.croptopia.biome;

import com.epherical.croptopia.CroptopiaForge;
import com.epherical.croptopia.common.MiscNames;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.world.BiomeGenerationSettingsBuilder;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.ModifiableBiomeInfo;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.Locale;

import static com.epherical.croptopia.CroptopiaForge.createIdentifier;
import static com.epherical.croptopia.CroptopiaForge.mod;

public record SaltModifier(GenerationStep.Decoration step, Holder<PlacedFeature> features) implements BiomeModifier {
    public static final DeferredHolder<MapCodec<? extends BiomeModifier>, MapCodec<SaltModifier>> SERIALIZER =
            CroptopiaForge.BIOME_SERIALIZER.register("salt", SaltModifier::makeCodec);

    @Override
    public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if (phase == Phase.ADD && mod.config().generateSaltInWorld && !biome.is(Tags.Biomes.IS_SWAMP)) {
            BiomeGenerationSettingsBuilder generation = builder.getGenerationSettings();
            generation.addFeature(step, features);
        }
    }

    @Override
    public MapCodec<? extends BiomeModifier> codec() {
        return SERIALIZER.get();
    }

    public static MapCodec<SaltModifier> makeCodec() {
        return RecordCodecBuilder.mapCodec(builder -> builder.group(
                Codec.STRING.comapFlatMap(SaltModifier::generationStageFromString,
                        GenerationStep.Decoration::getName).fieldOf("generation_stage").forGetter(SaltModifier::step),
                PlacedFeature.CODEC.fieldOf("feature").forGetter(SaltModifier::features)
        ).apply(builder, SaltModifier::new));
    }

    private static DataResult<GenerationStep.Decoration> generationStageFromString(String name) {
        try {
            return DataResult.success(GenerationStep.Decoration.valueOf(name.toUpperCase(Locale.ROOT)));
        } catch (Exception e) {
            return DataResult.error(() ->  "Not a decoration stage: " + name);
        }
    }

    /*public static void register(DeferredRegister<BiomeModifier> biomeSerializer) {
        biomeSerializer.register("salt_disk", () -> new SaltModifier(GenerationStep.Decoration.UNDERGROUND_ORES, GeneratorRegistry.DISK_SALT_CONFIGURED));
    }*/
}
