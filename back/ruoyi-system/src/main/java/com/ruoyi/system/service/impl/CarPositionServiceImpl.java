package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.CarPosition;
import com.ruoyi.system.service.CarPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CarPositionMapper;

import java.util.List;

@Service
public class CarPositionServiceImpl implements CarPositionService {
    @Autowired
    private CarPositionMapper CarPositionMapper;

    @Override
    public List<CarPosition> selectCarPosition(int carId) {
        return CarPositionMapper.selectCarPosition(carId);
    }

    @Override
    public List<CarPosition> selectCarPositionList() {
        return CarPositionMapper.selectCarPositionList();
    }

    @Override
    public List<CarPosition> selectCarNumIdPositionList(int carnumId) {
        return CarPositionMapper.selectCarNumIdPositionList(carnumId);
    }

    @Override
    public int insertcar(CarPosition car) {

        return CarPositionMapper.insertcar(car);
    }
}
