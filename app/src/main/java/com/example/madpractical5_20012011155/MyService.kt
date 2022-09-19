package com.example.madpractical5_20012011155

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class MyService : Service() {

    companion object{val DATA_KEY="service"
    val DATA_VALUE="play/pause"}
    private lateinit var player: MediaPlayer

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onDestroy() {
        player.stop()
        super.onDestroy()
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if(!this::player.isInitialized){
            player=MediaPlayer.create(this,R.raw.song )

        }

        if(intent !=null) {
            val htr = intent.getStringExtra(DATA_KEY)
            if(htr== DATA_VALUE){
                if(player.isPlaying){
                    player.pause()}
                else{
                    player.start()
                }
            }
        }else{
                player.start()
        }
        return START_STICKY
    }
}