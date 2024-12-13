package uas_C14220151.app.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DaftarKesehatan(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id catatan")
    val id: Int = 0,

    @ColumnInfo(name = "tanggal dan jam")
    var tanggal: String? = null,

    @ColumnInfo(name = "berat badan")
    var berat: String? = null,

    @ColumnInfo(name = "tekanan darah")
    var tekanan: String? = null,

    @ColumnInfo(name = "catatan")
    var catatan: String? = null,
)