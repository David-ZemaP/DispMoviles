package com.calyrsoft.ucbp1.features.dollar.data.source

import com.calyrsoft.ucbp1.features.dollar.data.database.dao.IDollarDao
import com.calyrsoft.ucbp1.features.dollar.domain.model.DollarModel
import kotlin.collections.map

class DollarLocalDataSource(
    val dao: IDollarDao
) {

    suspend fun insert(model: DollarModel) {}
    suspend fun insertHistory(dollarUsdt: String, dollarUsdc: String, createdAt: Long) {}

}