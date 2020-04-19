package com.amsidh.main.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.amsidh.model.Circle;
import com.amsidh.service.CircleDao;

public class CircleApplication {
	public static void main(String[] args) {
      ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
      CircleDao circleDao=context.getBean("circleDao", CircleDao.class);
/*      Circle addCircle=new Circle(4,"Fourth Circle");
      circleDao.add(addCircle);
*/     
     /* Circle circleDemo=new Circle();
      circleDemo.setId(2);
      circleDemo.setName("Second");
      circleDao.updateCircle(circleDemo);
      */
     // circleDao.delete(4);
      
      System.out.println("Number Of Circle ="+circleDao.getCircleCount());
      Circle circle=circleDao.getCircleById(2);
      System.out.println(circle.getName());
      
      List<Circle> listCircle=circleDao.getAllCircles();
      System.out.println("------------List Of Circle--------------");
      for(Circle c:listCircle)
      {
    	  System.out.println("Circle ID "+c.getId()+" And Name "+c.getName());
      }
      
	}
}
