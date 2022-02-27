package com.github.fabiodelabruna.citiesapi.model;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;
import org.postgresql.geometric.PGpoint;
import org.springframework.data.geo.Point;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PointType implements UserType {

    @Override
    public int[] sqlTypes() {
        return new int[]{java.sql.Types.OTHER};
    }

    @Override
    public Class<?> returnedClass() {
        return Point.class;
    }

    @Override
    public boolean equals(final Object x, final Object y) throws HibernateException {
        return false;
    }

    @Override
    public int hashCode(final Object x) throws HibernateException {
        return 0;
    }

    @Override
    public Object nullSafeGet(final ResultSet rs, final String[] names, final SharedSessionContractImplementor session,
                              final Object owner) throws HibernateException, SQLException {
    /* 1st
    final Object object = rs.getObject(names[0]);
    final Double[] points = StringLocationUtils.transform(object.toString());
    return new Point(points[0], points1);*/

        /* 2nd */
        final PGpoint value = (PGpoint) rs.getObject(names[0]);
        return new Point(value.x, value.y);
    }

    @Override
    public void nullSafeSet(final PreparedStatement st, final Object value, final int index,
                            final SharedSessionContractImplementor session)
            throws HibernateException, SQLException {
    }

    @Override
    public Object deepCopy(final Object value) throws HibernateException {
        return null;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(final Object value) throws HibernateException {
        return null;
    }

    @Override
    public Object assemble(final Serializable cached, final Object owner) throws HibernateException {
        return null;
    }

    @Override
    public Object replace(final Object original, final Object target, final Object owner) throws HibernateException {
        return null;
    }

}
