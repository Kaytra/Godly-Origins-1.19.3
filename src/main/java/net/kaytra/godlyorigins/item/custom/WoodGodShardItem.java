package net.kaytra.godlyorigins.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class WoodGodShardItem extends Item {
    /*public WaterGodShardItem(Settings settings) {
        super(settings);
    }*/
    public WoodGodShardItem() {
        super(new Settings().maxCount(1).rarity(Rarity.RARE));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if(!world.isClient()) {

        }

        if(!user.isCreative()){
            stack.decrement(1);
        }
        //return super.use(world, user, hand);
        return TypedActionResult.consume(stack);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.godlyorigins.wood_god_shard_item.tooltip1").formatted(Formatting.RED));
        tooltip.add(Text.translatable("item.godlyorigins.wood_god_shard_item.tooltip2").formatted(Formatting.RED));
        tooltip.add(Text.translatable("item.godlyorigins.wood_god_shard_item.tooltip3").formatted(Formatting.RED));
        tooltip.add(Text.translatable("item.godlyorigins.wood_god_shard_item.tooltip4").formatted(Formatting.RED));
    }
}
