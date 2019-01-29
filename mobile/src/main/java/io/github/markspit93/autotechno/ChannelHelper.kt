package io.github.markspit93.autotechno

import android.content.Context
import android.graphics.BitmapFactory
import android.support.v4.media.MediaBrowserCompat.MediaItem
import android.support.v4.media.MediaDescriptionCompat

object ChannelHelper {

    private val channelList = listOf(
        Channel("hardtechno_hi", "Hard Techno", R.drawable.hard_techno),
        Channel("handsup_hi", "Hands Up", R.drawable.hands_up),
        Channel("electrohouse_hi", "Electro House", R.drawable.electro_house),
        Channel("electroswing_hi", "Electro Swing", R.drawable.electro_swing),
        Channel("synthwave_hi", "Synthwave", R.drawable.synthwave),
        Channel("futuresynthpop_hi", "Future Synthpop", R.drawable.future_synthpop),
        Channel("techno_hi", "Techno", R.drawable.techno),
        Channel("classictrance_hi", "Classic Trance", R.drawable.classic_trance),
        Channel("edm_hi", "EDM Hits", R.drawable.edm),
        Channel("nightcore_hi", "Nightcore", R.drawable.nightcore),
        Channel("classiceurodance_hi", "Classic EuroDance", R.drawable.classic_eurodance),
        Channel("eurodance_hi", "EuroDance", R.drawable.eurodance),
        Channel("bigroomhouse_hi", "Big Room House", R.drawable.big_room_house),
        Channel("epictrance_hi", "Epic Trance", R.drawable.epic_trance),
        Channel("hardstyle_hi", "Hardstyle", R.drawable.hardstyle),
        Channel("vocaltrance_hi", "Vocal Trance", R.drawable.vocal_trance),
        Channel("harddance_hi", "Hard Dance", R.drawable.hard_dance),
        Channel("electropop_hi", "Electropop", R.drawable.electropop),
        Channel("trance_hi", "Trance", R.drawable.trance),
        Channel("hardcore_hi", "Hardcore", R.drawable.hardcore),
        Channel("clubdubstep_hi", "Club Dubstep", R.drawable.club_dubstep),
        Channel("dubstep_hi", "Dubstep", R.drawable.dubstep),
        Channel("trap_hi", "Trap", R.drawable.trap),
        Channel("classicvocaltrance_hi", "Classic Vocal Trance", R.drawable.classic_vocal_trance),
        Channel("bassnjackinhouse_hi", "Bass & Jackin' House", R.drawable.bass_n_jackin_house),
        Channel("glitchhop_hi", "Glitch Hop", R.drawable.glitch_hop)
    )

    fun createListing(context: Context): ArrayList<MediaItem> {
        val mediaDescListing = arrayListOf<MediaItem>()

        channelList.forEach {
            val mediaDesc = MediaDescriptionCompat.Builder()
                    .setMediaId(it.mediaId)
                    .setTitle(it.title)
                    .setSubtitle("DI.FM")
                    .setIconBitmap(BitmapFactory.decodeResource(context.resources, it.imageRes))
                    .build()

            mediaDescListing.add(MediaItem(mediaDesc, MediaItem.FLAG_PLAYABLE))
        }

        return mediaDescListing
    }

    fun getChannelForId(mediaId: String): Channel {
        channelList.forEach {
            if (mediaId == it.mediaId) {
                return it
            }
        }

        return channelList[0]
    }

    fun getNextMediaId(currentMediaId: String): String {
        channelList.indexOf(getChannelForId(currentMediaId)).let {
            return if (it == channelList.lastIndex) {
                channelList[0].mediaId
            } else {
                channelList[it + 1].mediaId
            }
        }
    }

    fun getPreviousMediaId(currentMediaId: String): String {
        channelList.indexOf(getChannelForId(currentMediaId)).let {
            return if (it == 0) {
                channelList[channelList.lastIndex].mediaId
            } else {
                channelList[it - 1].mediaId
            }
        }
    }
}
