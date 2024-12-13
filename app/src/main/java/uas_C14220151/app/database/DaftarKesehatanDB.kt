package uas_C14220151.app.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DaftarKesehatan::class], version = 2)
abstract class DaftarKesehatanDB : RoomDatabase() {
    abstract fun daftarKesehatanDAO(): DaftarKesehatanDAO

    companion object {
        @Volatile
        private var INSTANCE: DaftarKesehatanDB? = null

        @JvmStatic
        fun getDatabase(context: Context): DaftarKesehatanDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DaftarKesehatanDB::class.java, "daftarKesehatan_db"
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}