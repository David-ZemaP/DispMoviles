package com.calyrsoft.ucbp1.features.dollar.data.repository

import com.calyrsoft.ucbp1.features.dollar.data.database.dao.IDollarDao
import com.calyrsoft.ucbp1.features.dollar.data.database.entity.DollarEntity
import com.calyrsoft.ucbp1.features.dollar.data.mapper.toModel
import com.calyrsoft.ucbp1.features.dollar.data.source.DollarLocalDataSource
import com.calyrsoft.ucbp1.features.dollar.data.source.RealTimeRemoteDataSource
import com.calyrsoft.ucbp1.features.dollar.domain.model.DollarModel
import com.calyrsoft.ucbp1.features.dollar.domain.repository.IDollarRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class DollarRepository(
    private val realTimeRemoteDataSource: RealTimeRemoteDataSource,
    private val dao: IDollarDao
) : IDollarRepository {

    override suspend fun getDollar(): Flow<DollarModel> = flow {
        // Emitir último registro local (si existe)
        dao.getLatest()?.let { last ->
            emit(last.toModel())
        }

        // Escuchar remoto, guardar histórico y emitir a la UI
        realTimeRemoteDataSource.getDollarUpdates().collect { remote ->
            val entity = DollarEntity(
                dollarOfficial = remote.dollarOfficial,
                dollarParallel = remote.dollarParallel,
                dollarUsdt = remote.dollarUsdt,  // USDT al histórico
                dollarUsdc = remote.dollarUsdc,  // USDC al histórico
                timestamp = System.currentTimeMillis()
            )
            dao.insert(entity)   // guarda una nueva fila (histórico)
            emit(remote.copy(timestamp = entity.timestamp)) // emite con ts actual
        }
    }
}