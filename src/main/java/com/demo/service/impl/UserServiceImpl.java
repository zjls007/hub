package com.demo.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.UniversalDao;
import com.demo.entity.User;
import com.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UniversalDao universalDao;
	
	@Override
	public User getUserByUserName(String userName) {
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.eq("userName", userName));
		List<User> list = universalDao.findByCriteria(criteria);
		if (!list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
	
}
