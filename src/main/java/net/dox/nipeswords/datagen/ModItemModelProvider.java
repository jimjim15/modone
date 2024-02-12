package net.dox.nipeswords.datagen;
import net.dox.nipeswords.item.items;
import net.dox.nipeswords.nipesWords;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, nipesWords.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(items.NIPES);
        simpleItem(items.RAW_NIPES);
        simpleItem(items.MONEY);
       // handheldItem(items.NIPES_SHOVEL);
        //handheldItem(items.NIPES_AXE);
        //handheldItem(items.NIPES_PICKAXE);
        handheldItem(items.NIPES_HOE);

        withExistingParent(items.BURGER_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(items.SKIBIDI_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(nipesWords.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(nipesWords.MOD_ID,"item/" + item.getId().getPath()));
    }
}