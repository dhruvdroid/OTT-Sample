package com.dhruvdroid.sampleott.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

//
// Created by Dhruv on 14/08/20.
//

@Dao
interface TrayDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertMovieList(movieList: List<com.dhruvdroid.data.Tray>)

//  @Query("SELECT * FROM Tray WHERE page = :page_")
//  suspend fun getMovieList(page_: Int): List<Tray>
}
