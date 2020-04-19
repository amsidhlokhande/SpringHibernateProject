package com.amsidh.service;

import java.util.List;

import com.amsidh.model.Circle;

public interface CircleDao {
	public void add(Circle circle);

	public void delete(Integer id);

	public void updateCircle(Circle circle);

	public Circle getCircleById(Integer id);

	public List<Circle> getAllCircles();
    
	public Long getCircleCount();
}
