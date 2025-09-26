package com.calyrsoft.ucbp1.features.dollar.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "dollars")
data class DollarEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0, // <- autogenerado para histórico

    @ColumnInfo(name = "dollar_official")
    val dollarOfficial: String? = null,

    @ColumnInfo(name = "dollar_parallel")
    val dollarParallel: String? = null,

    @ColumnInfo(name = "dollar_usdt")
    val dollarUsdt: String? = null,

    @ColumnInfo(name= "dollar_usdc")
    val dollarUsdc: String? = null,

    @ColumnInfo(name = "timestamp")
    val timestamp: Long = 0
)