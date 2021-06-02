package com.parts.demo.service;

import com.parts.demo.entity.Parts;

import java.util.List;

public interface partsService {
    public List<Parts> findAll();
    public Parts findById(int theId);
    public void add(Parts part);
    public void updatePart(Parts part);
    public void delete(int theId);
}
