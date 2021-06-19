package com.nizamapp.dicodingsubmission

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private lateinit var rvRaider: RecyclerView
    private val list: ArrayList<Raider> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvRaider = findViewById(R.id.rv_activity_main)
        rvRaider.setHasFixedSize(true)

        list.addAll(RaiderData.listData)
        populateData();
    }

    private fun populateData() {
        rvRaider.layoutManager = GridLayoutManager(this,2)
        val listRaiderAdapter = ListRaiderAdapter(list)
        rvRaider.adapter = listRaiderAdapter

        listRaiderAdapter.setOnItemClickCallback(object : ListRaiderAdapter.OnItemClickcallback {
            override fun onItemClicked(data: Raider) {
                selectedData(data)
            }

        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(itemId: Int) {
        when(itemId) {
            R.id.action_about -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun selectedData(raider: Raider) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(Const.RAIDER_NAME, Const.KAMEN_RAIDER + raider.name)
        intent.putExtra(Const.RAIDER_GENDER, raider.gender)
        intent.putExtra(Const.RAIDER_MOTIF, raider.motif)
        intent.putExtra(Const.RAIDER_SERIES, raider.series)
        intent.putExtra(Const.RAIDER_EPISODE, raider.episode)
        intent.putExtra(Const.RAIDER_ACTOR, raider.actor)
        intent.putExtra(Const.RAIDER_PHOTO, raider.photo)
        intent.putExtra(Const.RAIDER_DETAIL, raider.detail)
        intent.putExtra(Const.RAIDER_TYPE, raider.type)
        startActivity(intent)
    }

    override fun onBackPressed() {
//        finish();
//        super.onBackPressed()

        AlertDialog.Builder(this)
            .setMessage("Anda yakin ingin keluar?")
            .setCancelable(false)
            .setPositiveButton("OK",
                DialogInterface.OnClickListener { dialog, id -> finish() })
            .setNegativeButton("BATAL", null)
            .show()
    }
}