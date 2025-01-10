package database

import androidx.room.RoomDatabase

expect fun createRoomDatabase(): RoomDatabase.Builder<AppDatabase>