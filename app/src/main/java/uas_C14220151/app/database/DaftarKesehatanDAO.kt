package uas_C14220151.app.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DaftarKesehatanDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(daftar: DaftarKesehatan)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(daftar: List<DaftarKesehatan>)

    @Query("UPDATE daftarKesehatan SET `tanggal dan jam`=:isi_tanggal, `berat badan`=:isi_berat, `tekanan darah`=:isi_tekanan, catatan=:isi_catatan WHERE `Id catatan`=:pilihid")
    fun update(isi_tanggal: String, isi_berat: String, isi_tekanan: String, isi_catatan: String, pilihid: Int)

    @Delete
    fun delete(daftar: DaftarKesehatan)

    @Query("SELECT * FROM daftarKesehatan ORDER BY `Id catatan` ASC")
    fun selectAll(): MutableList<DaftarKesehatan>

    @Query("SELECT * FROM daftarKesehatan WHERE `Id catatan`=:isi_id")
    suspend fun getItem(isi_id: Int): DaftarKesehatan
}