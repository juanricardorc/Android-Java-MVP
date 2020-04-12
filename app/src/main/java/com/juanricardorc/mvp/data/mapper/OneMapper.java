package com.juanricardorc.mvp.data.mapper;

public interface OneMapper<E, O> {
    O transformEntity(E response);
}
