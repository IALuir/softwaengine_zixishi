package com.ruoyi.system.service;


import com.ruoyi.system.domain.CarPosition;
import java.util.List;


public interface CarPositionService {
    public List<CarPosition> selectCarPosition(int carId);

    public List<CarPosition> selectCarPositionList();

    public List<CarPosition> selectCarNumIdPositionList(int carnumId);

    public int insertcar(CarPosition car);
}
