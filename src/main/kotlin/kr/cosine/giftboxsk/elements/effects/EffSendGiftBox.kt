package kr.cosine.giftboxsk.elements.effects

import ch.njol.skript.Skript
import ch.njol.skript.lang.Effect
import ch.njol.skript.lang.Expression
import ch.njol.skript.lang.SkriptParser
import ch.njol.util.Kleenean
import kr.cosine.giftboxsk.data.GiftBox
import kr.hqservice.giftbox.api.GiftBoxAPI
import org.bukkit.entity.Player
import org.bukkit.event.Event

class EffSendGiftBox : Effect() {

    companion object {
        init {
            Skript.registerEffect(
                EffSendGiftBox::class.java,
                "gift %giftbox% to %players%"
            )
        }
    }

    private val giftBoxFactory by lazy { GiftBoxAPI.getFacto() }
    private val giftBoxService by lazy { GiftBoxAPI.getBoxService() }

    private lateinit var expressionGiftBox: Expression<GiftBox>
    private lateinit var expressionPlayers: Expression<Player>

    override fun execute(event: Event) {
        val giftBox = expressionGiftBox.getSingle(event) ?: return
        val players = expressionPlayers.getArray(event) ?: return
        val realGiftBox = giftBoxFactory.of(giftBox.display, giftBox.lore, *giftBox.itemStacks.toTypedArray())
        players.forEach {
            giftBoxService.send(it.uniqueId, realGiftBox)
        }
    }

    override fun toString(event: Event?, debug: Boolean): String? = expressionPlayers.toString(event, debug)

    @Suppress("unchecked_cast")
    override fun init(exprs: Array<out Expression<*>>, matchedPattern: Int, isDelayed: Kleenean, parseResult: SkriptParser.ParseResult): Boolean {
        expressionGiftBox = exprs[0] as Expression<GiftBox>
        expressionPlayers = exprs[1] as Expression<Player>
        return true
    }
}