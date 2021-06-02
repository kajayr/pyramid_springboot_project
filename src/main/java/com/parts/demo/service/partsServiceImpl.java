package com.parts.demo.service;

import com.parts.demo.doa.partsDOA;
import com.parts.demo.entity.Parts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class partsServiceImpl implements partsService{
    private partsDOA partsDOA;
    @Autowired
    public partsServiceImpl(partsDOA thePartsDOA) {
        partsDOA = thePartsDOA;
    }

    @Override
    @Transactional
    public List<Parts> findAll() {
        return partsDOA.findAll();
    }

    @Override
    @Transactional
    public Parts findById(int theId) {
        return partsDOA.findById(theId);
    }

    @Override
    @Transactional
    public void add(Parts part) {
    partsDOA.add(part);
    }

    @Override
    @Transactional
    public void updatePart(Parts part) {
        partsDOA.updatePart(part);
    }

    @Override
    @Transactional
    public void delete(int theId) {
    partsDOA.delete(theId);
    }
}
