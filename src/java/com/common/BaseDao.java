package com.common;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class BaseDao {

	@Autowired
	private SqlSession sqlSession;

	public <T> T findOne(String statement) {
		return this.sqlSession.<T> selectOne(statement);
	}

	public <T> T findOne(String statement, Object parameter) {
		return this.sqlSession.<T> selectOne(statement, parameter);
	}

	public boolean exists(String statement, Object parameter) {
		return true;
	}

	public <K, V> Map<K, V> selectMap(String statement, String mapKey) {
		return this.sqlSession.<K, V> selectMap(statement, mapKey);
	}

	public <K, V> Map<K, V> selectMap(String statement, Object parameter,
			String mapKey) {
		return this.sqlSession.<K, V> selectMap(statement, parameter, mapKey);
	}

	public <K, V> Map<K, V> selectMap(String statement, Object parameter,
			String mapKey, int start, int length) {
		RowBounds rowBounds = new RowBounds(start, length);
		return this.sqlSession.<K, V> selectMap(statement, parameter, mapKey,rowBounds);
	}

	/**
	 * 
	 * @param statement
	 * @param paramsMap
	 * @return
	 */
	public <E> List<E> findList(String statement, Map<String, Object> paramsMap) {
		return this.sqlSession.selectList(statement, paramsMap);
	}

	public <E> List<E> findList(String statement,
			Map<String, Object> paramsMap, int start, int length) {
		RowBounds rowBounds = new RowBounds(start, length);
		return this.sqlSession.<E> selectList(statement, paramsMap, rowBounds);
	}

	public <E> List<E> findList(String statement) {
		return this.sqlSession.<E> selectList(statement);
	}

	public <E> List<E> findList(String statement, Object parameter) {
		return this.sqlSession.<E> selectList(statement, parameter);
	}

	public <E> List<E> findList(String statement, Object parameter, int start,
			int length) {
		RowBounds rowBounds = new RowBounds(start, length);
		return this.sqlSession.<E> selectList(statement, parameter, rowBounds);
	}

	public int create(String statement) {
		return this.sqlSession.insert(statement);
	}

	public int create(String statement, Object parameter) {
		return this.sqlSession.insert(statement, parameter);
	}

	public int update(String statement) {
		return this.sqlSession.update(statement);
	}

	public int update(String statement, Object parameter) {
		return this.sqlSession.update(statement, parameter);
	}

	public int delete(String statement) {
		return this.sqlSession.delete(statement);
	}

	public int delete(String statement, Object parameter) {
		return this.sqlSession.delete(statement, parameter);
	}

}
