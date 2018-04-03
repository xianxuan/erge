package com.jmjk.dao;

import org.springframework.stereotype.Repository;

import com.jmjk.dao.base.BaseDao;
import com.jmjk.entity.TCount;

@Repository("countDao")
public class CountDao extends BaseDao<TCount> {

}
