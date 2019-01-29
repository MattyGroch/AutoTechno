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
        Channel("electroswing_hi", "Electroswing", R.drawable.electroswing),
        Channel("synthwave_hi", "Synthwave", R.drawable.synthwave),
        Channel("futuresynthpop_hi", "Future Synthpop", R.drawable.future_synthpop),
        Channel("techno_hi", "Techno", R.drawable.techno)
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
