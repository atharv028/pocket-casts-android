package au.com.shiftyjelly.pocketcasts.repositories.playback

import android.content.Context
import androidx.media3.common.Player
import au.com.shiftyjelly.pocketcasts.preferences.Settings
import au.com.shiftyjelly.pocketcasts.repositories.user.StatsManager
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PlayerFactoryImpl @Inject constructor(
    private val settings: Settings,
    private val statsManager: StatsManager,
    @ApplicationContext private val context: Context,
) : PlayerFactory {

    override fun createCastPlayer(
        onPlayerEvent: (PocketCastsPlayer, PlayerEvent) -> Unit,
        player: Player,
    ): PocketCastsPlayer =
        CastPlayer(
            context = context,
            onPlayerEvent = onPlayerEvent,
            player = player,
        )

    override fun createSimplePlayer(
        onPlayerEvent: (PocketCastsPlayer, PlayerEvent) -> Unit,
        player: Player,
    ): PocketCastsPlayer =
        SimplePlayer(
            settings = settings,
            statsManager = statsManager,
            context = context,
            onPlayerEvent = onPlayerEvent,
            player = player,
        )
}
