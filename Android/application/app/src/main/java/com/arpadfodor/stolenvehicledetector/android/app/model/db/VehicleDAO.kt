package com.arpadfodor.stolenvehicledetector.android.app.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arpadfodor.stolenvehicledetector.android.app.model.db.dataclasses.Vehicle

@Dao
interface VehicleDAO {

    @Query("SELECT * FROM ${ApplicationDB.VEHICLE_TABLE_NAME}")
    fun getAll(): List<Vehicle>?

    @Query("SELECT * FROM ${ApplicationDB.VEHICLE_TABLE_NAME} WHERE license_id=:id ")
    fun getByLicenseId(id: String): List<Vehicle>?

    @Query("DELETE FROM ${ApplicationDB.VEHICLE_TABLE_NAME}")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg vehicle: Vehicle)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vehicle_list: List<Vehicle>)

}