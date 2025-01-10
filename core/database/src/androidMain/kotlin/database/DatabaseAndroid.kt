package database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import org.koin.java.KoinJavaComponent.getKoin

actual fun createRoomDatabase(): RoomDatabase.Builder<AppDatabase> {
    val context: Context = getKoin().get()
    val dbFile = context.getDatabasePath(dbFileName)
    return Room.databaseBuilder<AppDatabase>(
        context = context,
        name = dbFile.absolutePath,
    )
}