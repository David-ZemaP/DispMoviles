package com.calyrsoft.ucbp1.features.dollar.data.mapper

import com.calyrsoft.ucbp1.features.dollar.data.database.entity.DollarEntity
import com.calyrsoft.ucbp1.features.dollar.domain.model.DollarModel

fun DollarEntity.toModel(): DollarModel {
    return DollarModel(
        dollarOfficial = dollarOfficial,
        dollarParallel = dollarParallel,
        dollarUsdt = dollarUsdt,
        dollarUsdc = dollarUsdc,
        timestamp = timestamp
    )
}

fun DollarModel.toEntity() = DollarEntity(
    // id autogenerado -> no lo seteamos
    dollarOfficial = dollarOfficial,
    dollarParallel = dollarParallel,
    dollarUsdt = dollarUsdt,
    dollarUsdc = dollarUsdc,
    timestamp = timestamp
)