package com.calyrsoft.ucbp1.features.dollar.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.calyrsoft.ucbp1.features.dollar.data.database.entity.DollarEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface IDollarDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(dollar: DollarEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<DollarEntity>)

    @Query("SELECT * FROM dollars ORDER BY timestamp DESC")
    suspend fun getAllOrderByTimestampDesc(): List<DollarEntity>

    @Query("SELECT * FROM dollars ORDER BY timestamp DESC LIMIT 1")
    suspend fun getLatest(): DollarEntity?

    // Observables (opcional)
    @Query("SELECT * FROM dollars ORDER BY timestamp DESC LIMIT 1")
    fun observeLatest(): Flow<DollarEntity?>

    @Query("SELECT * FROM dollars ORDER BY timestamp DESC")
    fun observeAll(): Flow<List<DollarEntity>>

    // Mantenimiento (opcional)
    @Query("DELETE FROM dollars WHERE timestamp < :beforeTs")
    suspend fun deleteOlderThan(beforeTs: Long)

    @Query("DELETE FROM dollars")
    suspend fun deleteAll()
}