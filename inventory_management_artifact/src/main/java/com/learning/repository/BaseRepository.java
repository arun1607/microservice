package com.learning.repository;

import java.util.List;

/**
 * Created by amits on 27/09/15.
 */
public interface BaseRepository<T> {
    List<T> findByName(String name);
}
