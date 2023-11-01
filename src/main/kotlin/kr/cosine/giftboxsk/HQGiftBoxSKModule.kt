package kr.cosine.giftboxsk

import ch.njol.skript.Skript
import kr.hqservice.framework.bukkit.core.HQBukkitPlugin
import kr.hqservice.framework.global.core.component.Component
import kr.hqservice.framework.global.core.component.HQModule
import java.io.IOException

@Component
class HQGiftBoxSKModule(
    private val plugin: HQBukkitPlugin
) : HQModule {

    override fun onEnable() {
        val addon = Skript.registerAddon(plugin)
        try {
            addon.loadClasses("kr.cosine.giftboxsk", "elements")
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}