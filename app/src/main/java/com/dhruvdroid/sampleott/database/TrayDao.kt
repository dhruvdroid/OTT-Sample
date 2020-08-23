package com.dhruvdroid.sampleott.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.dhruvdroid.sampleott.data.Tray

//
// Created by Dhruv on 23/08/20.
//

@Dao
interface TrayDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertMovieList(movieList: List<Tray>)

}
