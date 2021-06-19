package com.nizamapp.dicodingsubmission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import org.w3c.dom.Text

class DetailActivity : AppCompatActivity() {

    private lateinit var tvName: TextView
    private lateinit var tvGender: TextView
    private lateinit var tvMotif: TextView
    private lateinit var tvSeries: TextView
    private lateinit var tvEpisode: TextView
    private lateinit var tvActor: TextView
    private lateinit var tvType: TextView
    private lateinit var tvDetail: TextView
    private lateinit var imgPhoto: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        tvName = findViewById(R.id.tv_name)
        tvGender = findViewById(R.id.tv_gender)
        tvMotif = findViewById(R.id.tv_motif)
        tvSeries = findViewById(R.id.tv_series)
        tvEpisode = findViewById(R.id.tv_episode)
        tvActor = findViewById(R.id.tv_actor)
        tvType = findViewById(R.id.tv_type)
        tvDetail = findViewById(R.id.tv_detail)
        imgPhoto = findViewById(R.id.img_photo)

        val name = intent.getStringExtra(Const.RAIDER_NAME)
        val gender = intent.getStringExtra(Const.RAIDER_GENDER)
        val motif = intent.getStringExtra(Const.RAIDER_MOTIF)
        val series = intent.getStringExtra(Const.RAIDER_SERIES)
        val episode = intent.getStringExtra(Const.RAIDER_EPISODE)
        val actor = intent.getStringExtra(Const.RAIDER_ACTOR)
        val type = intent.getStringExtra(Const.RAIDER_TYPE)
        val detail = intent.getStringExtra(Const.RAIDER_DETAIL)
        val img = intent.getIntExtra(Const.RAIDER_PHOTO, 0)

        tvName.text = name.toString()
        tvGender.text = gender.toString()
        tvMotif.text = motif.toString()
        tvSeries.text = series.toString()
        tvEpisode.text = episode.toString()
        tvActor.text = actor.toString()
        tvType.text = type.toString()
        tvDetail.text = detail.toString()

        Glide.with(this)
            .load(img)
            .into(imgPhoto)

        supportActionBar?.title = name
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val raider = intent.getStringExtra(Const.RAIDER_NAME)
        when (item.itemId) {
            R.id.action_favorite -> {
                Toast.makeText(this, "Favorite Anda " + raider, Toast.LENGTH_SHORT).show()
            }
            R.id.action_share -> {
//                Toast.makeText(this, "Share Anda " + raider, Toast.LENGTH_SHORT).show()

                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, "Anda berbagi informasi " + raider)
                intent.type = "text/plain"

                startActivity(Intent.createChooser(intent, Const.KAMEN_RAIDER_WIKI))
            }
        }
        return super.onOptionsItemSelected(item)
    }
}