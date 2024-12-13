package uas_C14220151.app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.firestore.FirebaseFirestore
import paba.c14220151.cobafirebase.R
import uas_C14220151.app.database.DaftarKesehatanDB

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: AdapterDaftar
    private lateinit var db: DaftarKesehatanDB
    private val firestore = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = DaftarKesehatanDB.getDatabase(this)
        adapter = AdapterDaftar(mutableListOf())

        val recyclerView = findViewById<RecyclerView>(R.id.rvDaftar)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        findViewById<FloatingActionButton>(R.id.fabUpload).setOnClickListener {
            uploadDataToFirebase()
        }


        loadData()
    }

    private fun loadData() {
        val data = db.daftarKesehatanDAO().selectAll()
        adapter.isiData(data)
    }

    private fun uploadDataToFirebase() {
        val data = db.daftarKesehatanDAO().selectAll()
        for (item in data) {
            firestore.collection("daftarKesehatan")
                .document(item.id.toString())
                .set(item)
        }
    }
}