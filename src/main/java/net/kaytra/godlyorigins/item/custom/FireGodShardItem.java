package net.kaytra.godlyorigins.item.custom;


import io.github.apace100.origins.component.OriginComponent;
import io.github.apace100.origins.networking.ModPackets;
import io.github.apace100.origins.origin.Origin;
import io.github.apace100.origins.origin.OriginLayer;
import io.github.apace100.origins.origin.OriginLayers;
import io.github.apace100.origins.registry.ModComponents;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FireGodShardItem extends Item {
    public FireGodShardItem() {
        super(new Settings().maxCount(1).rarity(Rarity.RARE));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if(!world.isClient()) {
            /*OriginComponent originComponent = ModComponents.ORIGIN.get(user);
            Identifier targetLayer = new Identifier("godlyorigins", "deity");
            OriginLayer originLayer = OriginLayers.getLayer(targetLayer);

            //PacketByteBuf buffer = new PacketByteBuf(Unpooled.buffer());

            if (originLayer.isEnabled()) originComponent.setOrigin(originLayer, Origin.EMPTY);*/
        }
        if(!user.isCreative()){
            stack.decrement(1);
        }
        //return super.use(world, user, hand);
        return TypedActionResult.consume(stack);
    }

/*  Bless Robin for this
    https://discord.com/channels/734127708488859831/838871885709705237/1067878313835630733
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if(!world.isClient) {
            Identifier targetLayer = new Identifier("origins-classes", "class");
            OriginLayer originLayer = OriginLayers.getLayer(targetLayer);

            OriginComponent originComponent = ModComponents.ORIGIN.get(user);
            PacketByteBuf buffer = new PacketByteBuf(Unpooled.buffer());

            if (originLayer.isEnabled()) originComponent.setOrigin(originLayer, Origin.EMPTY);

            originComponent.checkAutoChoosingLayers(user, false);
            originComponent.sync();

            buffer.writeBoolean(false);
            ServerPlayNetworking.send(user, ModPackets.OPEN_ORIGIN_SCREEN, buffer);

        }
        if(!user.isCreative()) {
            stack.decrement(1);
        }
        return TypedActionResult.consume(stack);
    }
    */
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.godlyorigins.fire_god_shard_item.tooltip1").formatted(Formatting.RED));
        tooltip.add(Text.translatable("item.godlyorigins.fire_god_shard_item.tooltip2").formatted(Formatting.RED));
        tooltip.add(Text.translatable("item.godlyorigins.fire_god_shard_item.tooltip3").formatted(Formatting.RED));
        tooltip.add(Text.translatable("item.godlyorigins.fire_god_shard_item.tooltip4").formatted(Formatting.RED));
    }
}
