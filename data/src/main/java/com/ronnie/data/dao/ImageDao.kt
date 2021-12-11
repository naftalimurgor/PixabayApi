package com.ronnie.data.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ronnie.domain.Image

@Dao
interface ImageDao {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertAll(users: List<Image>)

  @Query("SELECT * FROM image_table WHERE searchTerm LIKE :query")
  fun queryImages(query: String): PagingSource<Int, Image>

  @Query("DELETE FROM image_table")
  suspend fun clearAll()

}