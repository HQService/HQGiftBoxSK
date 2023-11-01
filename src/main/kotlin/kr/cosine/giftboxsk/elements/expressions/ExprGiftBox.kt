package kr.cosine.giftboxsk.elements.expressions

import ch.njol.skript.Skript
import ch.njol.skript.lang.Expression
import ch.njol.skript.lang.ExpressionType
import ch.njol.skript.lang.SkriptParser
import ch.njol.skript.lang.util.SimpleExpression
import ch.njol.util.Kleenean
import kr.cosine.giftboxsk.data.GiftBox
import org.bukkit.event.Event
import org.bukkit.inventory.ItemStack

class ExprGiftBox : SimpleExpression<GiftBox>() {

    companion object {
        init {
            Skript.registerExpression(
                ExprGiftBox::class.java,
                GiftBox::class.java,
                ExpressionType.SIMPLE,
                "giftbox named %string% with lore %strings% with item %itemstacks%",
                "giftbox named %string% with item %itemstacks%"
            )
        }
    }

    private lateinit var expressionDisplay: Expression<String>
    private var expressionLore: Expression<String>? = null
    private lateinit var expressionItemStacks: Expression<ItemStack>

    override fun get(event: Event): Array<GiftBox> {
        val display = expressionDisplay.getSingle(event) ?: "선물"
        val lore = expressionLore?.getArray(event)?.toList() ?: emptyList()
        val itemStacks = expressionItemStacks.getArray(event).toList()
        val giftBox = GiftBox(display, lore, itemStacks)
        return arrayOf(giftBox)
    }

    override fun isSingle(): Boolean = true

    override fun getReturnType(): Class<out GiftBox> = GiftBox::class.java

    override fun toString(event: Event?, debug: Boolean): String? = expressionDisplay.toString(event, debug)

    @Suppress("unchecked_cast")
    override fun init(exprs: Array<out Expression<*>>, matchedPattern: Int, isDelayed: Kleenean, parseResult: SkriptParser.ParseResult): Boolean {
        expressionDisplay = exprs[0] as Expression<String>
        if (exprs.size == 3) {
            expressionLore = exprs[1] as? Expression<String>
        }
        expressionItemStacks = exprs.last() as Expression<ItemStack>
        return true
    }
}