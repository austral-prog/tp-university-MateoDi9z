package com.university;

import java.util.List;

public interface Serializable<T> {
    T serialize(List<String> params);
}
