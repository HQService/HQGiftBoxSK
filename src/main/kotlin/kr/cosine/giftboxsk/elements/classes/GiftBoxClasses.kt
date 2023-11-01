package kr.cosine.giftboxsk.elements.classes

import ch.njol.skript.classes.ClassInfo
import ch.njol.skript.classes.Parser
import ch.njol.skript.expressions.base.EventValueExpression
import ch.njol.skript.lang.ParseContext
import ch.njol.skript.registrations.Classes
import kr.cosine.giftboxsk.data.GiftBox

class GiftBoxClasses {

    companion object {
        init {
            Classes.registerClass(ClassInfo(GiftBox::class.java, "giftbox")
                .user("giftbox")
                .name("GiftBox")
                .since("1.0.0")
                .defaultExpression(EventValueExpression(GiftBox::class.java))
                .parser(object : Parser<GiftBox>() {

                    override fun canParse(context: ParseContext): Boolean = false

                    override fun toString(giftBox: GiftBox, flags: Int): String = toVariableNameString(giftBox)

                    override fun toVariableNameString(giftBox: GiftBox): String = giftBox.display
                })
            )
        }
    }
}