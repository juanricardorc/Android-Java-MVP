package com.juanricardorc.mvp.data.mapper;

public interface TwoMapper<E, R, O> {
    O transformEntity(E entity);
    O transformResponse(R response);
}
