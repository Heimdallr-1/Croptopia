package com.epherical.croptopia.datagen;


import java.util.concurrent.CompletableFuture;

/*public class CroptopiaItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public CroptopiaItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }


    @Override
    protected void addTags(HolderLookup.Provider arg) {
        generateSaplings();
        generateBarkLogs();
        // currently, only generates air, but leaves item tag isn't used by vanilla anyway
        // generateLeaves();
        generateMisc();
        generateSeedsEatenByTag(ItemTags.CHICKEN_FOOD);
        generateSeedsEatenByTag(ItemTags.PARROT_FOOD);
    }

    protected void generateSeedsEatenByTag(TagKey<Item> key) {
        FabricTagBuilder animalFood = getOrCreateTagBuilder(key);
        for (Item seed : CroptopiaMod.seeds) {
            animalFood.add(seed);
        }
    }


    protected void generateSaplings() {
        FabricTagBuilder saplings = getOrCreateTagBuilder(ItemTags.SAPLINGS);
        for (TreeCrop crop : TreeCrop.copy()) {
            saplings.add(crop.getSaplingItem());
        }
        for (Tree crop : Tree.copy()) {
            saplings.add(crop.getSapling());
        }
    }

    protected void generateBarkLogs() {
        FabricTagBuilder burnableLog = getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN);
        for (Tree crop : Tree.copy()) {
            // add different log types to log tag of this crop
            tag(crop.getLogItemTag())
                    .add()
                    .add(reverseLookup(crop.getLog().asItem()))
                    .add(reverseLookup(crop.getStrippedLog().asItem()))
                    .add(reverseLookup(crop.getWood().asItem()))
                    .add(reverseLookup(crop.getStrippedWood().asItem()));
            // make this crop log burnable
            burnableLog.addTag(crop.getLogItemTag());
        }
    }

    protected void generateLeaves() {
        FabricTagBuilder leaves = getOrCreateTagBuilder(ItemTags.LEAVES);
        for (TreeCrop crop : TreeCrop.copy()) {
            leaves.add(crop.getLeaves().asItem());
        }
        for (Tree crop : Tree.copy()) {
            leaves.add(crop.getLeaves().asItem());
        }
    }

    protected void generateMisc() {
        FabricTagBuilder crops = getOrCreateTagBuilder(ItemTags.VILLAGER_PLANTABLE_SEEDS);
        for (Item seed : CroptopiaMod.seeds) {
            crops.add(seed);
        }
        // explicitly used as dolphin food in vanilla
        FabricTagBuilder fishes = getOrCreateTagBuilder(ItemTags.FISHES);
        fishes.add(Content.ANCHOVY.asItem());
        fishes.add(Content.CALAMARI.asItem());
        fishes.add(Content.GLOWING_CALAMARI.asItem());
        fishes.add(Content.CLAM.asItem());
        fishes.add(Content.CRAB.asItem());
        fishes.add(Content.OYSTER.asItem());
        fishes.add(Content.ROE.asItem());
        fishes.add(Content.SHRIMP.asItem());
        fishes.add(Content.TUNA.asItem());
        // fox food: all berries added by croptopia
        FabricTagBuilder foxFood = getOrCreateTagBuilder(ItemTags.FOX_FOOD);
        foxFood.add(Content.BLACKBERRY.asItem());
        foxFood.add(Content.BLUEBERRY.asItem());
        foxFood.add(Content.CRANBERRY.asItem());
        foxFood.add(Content.ELDERBERRY.asItem());
        foxFood.add(Content.RASPBERRY.asItem());
        foxFood.add(Content.STRAWBERRY.asItem());
        // piglin food: more cannibalism (which already happens in vanilla)
        FabricTagBuilder piglinFood = getOrCreateTagBuilder(ItemTags.PIGLIN_FOOD);
        piglinFood.add(Content.HAM_SANDWICH);
        piglinFood.add(Content.PEPPERONI);
        piglinFood.add(Content.PORK_AND_BEANS);
        piglinFood.add(Content.PORK_JERKY);
        piglinFood.add(Content.RAW_BACON);
        piglinFood.add(Content.COOKED_BACON.asItem());
    }

}*/
