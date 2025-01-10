package database

actual fun getInstantiateImpl(): AppDatabase {
    return AppDatabase::class.instantiateImpl()
}

