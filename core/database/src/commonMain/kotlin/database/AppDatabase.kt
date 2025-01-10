package database

import androidx.room.Database
import androidx.room.RoomDatabase
import database.user.UserDao
import database.user.UserEntity

@Database(entities = [UserEntity::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getUserDao(): UserDao
}

const val dbFileName = "app.db"