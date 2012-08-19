package fr.gbourquet.catnotab.dao;

import org.apache.ibatis.session.SqlSession;

public class DaoFactory {
	/**
	 * SqlSession.
	 */
	private SqlSession sqlSession;

	/**
	 * Setter de sqlSession.
	 * 
	 * @param sqlSession
	 *            SqlSession
	 */
	public final void setSqlSession(final SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	/**
	 * Getter de sqlSession.
	 * 
	 * @return sqlSession
	 */
	public final SqlSession getSqlSession() {
		return sqlSession;
	}

	public final PersonneMapper getPersonneDAO() {
		try {
			PersonneMapper mapper = sqlSession.getMapper(PersonneMapper.class);
			return mapper;
		} finally {
			sqlSession.close();
		}
	}
}
