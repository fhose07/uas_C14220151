package uas_C14220151.app

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
//import kotlinx.android.synthetic.main.activity_tambah_daftar.*
import paba.c14220151.cobafirebase.R
import uas_C14220151.app.database.DaftarKesehatan
import uas_C14220151.app.database.DaftarKesehatanDB

class TambahDaftarActivity : AppCompatActivity() {
    private lateinit var db: DaftarKesehatanDB
    lateinit var etBerat: EditText
    lateinit var etTekanan: EditText
    lateinit var etCatatan: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_daftar)

        db = DaftarKesehatanDB.getDatabase(this)
        val _btnTambah = findViewById<Button>(R.id.btnTambah)

        _btnTambah.setOnClickListener {
            val berat = etBerat.text.toString()
            val tekanan = etTekanan.text.toString()
            val catatan = etCatatan.text.toString()
            val tanggal = System.currentTimeMillis().toString()

            val data = DaftarKesehatan(tanggal = tanggal, berat = berat, tekanan = tekanan, catatan = catatan)
            db.daftarKesehatanDAO().insert(data)
            finish()
        }
    }
}