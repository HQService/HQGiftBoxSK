package kr.cosine.giftboxsk.data

import org.bukkit.inventory.ItemStack

data class GiftBox(
    val display: String,
    val lore: List<String>,
    val itemStacks: List<ItemStack>
)