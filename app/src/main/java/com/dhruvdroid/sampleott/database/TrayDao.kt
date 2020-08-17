package com.dhruvdroid.sampleott.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.dhruvdroid.sampleott.data.Tray

//
// Created by Dhruv on 14/08/20.
//

@Dao
interface TrayDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertMovieList(movieList: List<Tray>)

//  @Query("SELECT * FROM Tray WHERE page = :page_")
//  suspend fun getMovieList(page_: Int): List<Tray>
}
