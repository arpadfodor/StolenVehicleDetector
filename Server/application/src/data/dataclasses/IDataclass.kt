package com.arpadfodor.stolenvehicledetector.data.dataclasses

interface IDataclass{
    var key: String
    var version: Int
    var validFromUTC: String
    var validToUTC: String
}