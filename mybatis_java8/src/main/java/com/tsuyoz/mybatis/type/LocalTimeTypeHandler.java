package com.tsuyoz.mybatis.type;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.*;
import java.time.LocalTime;

public class LocalTimeTypeHandler extends BaseTypeHandler<LocalTime> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, LocalTime time, JdbcType jdbcType) throws SQLException {
        ps.setTime(i, Time.valueOf(time));
	}

	@Override
	public LocalTime getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return toLocalTime(rs.getTime(columnName));
	}

	@Override
	public LocalTime getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return toLocalTime(rs.getTime(columnIndex));
	}

	@Override
	public LocalTime getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return toLocalTime(cs.getTime(columnIndex));
	}
	
	private LocalTime toLocalTime(Time time) {
		return time == null ? null : time.toLocalTime();
	}
}
