package com.example.demo.service;

import java.util.Optional;

public interface IGeneralService<T>{
    Iterable<T> findAll();
}
