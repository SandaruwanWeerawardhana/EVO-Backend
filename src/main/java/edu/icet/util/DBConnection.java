package edu.icet.util;

import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

@Component
public class DBConnection {
    private final DataSource dataSource;
    private final Connection connection;

    public DBConnection (DataSource dataSource) throws SQLException {
        this.dataSource = dataSource;
        this.connection = this.dataSource.getConnection();
    }

    public Connection getConnection () throws SQLException {
        return this.dataSource.getConnection();
    }

    @SuppressWarnings({ "unchecked" })
    public <T> T execute (final String query, Object ...binds) throws SQLException {
        final PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        final int dataLength = binds.length;

        for (int a = 0; a < dataLength; a++) {
            final Object data = binds[a];

            if (data == null) {
                preparedStatement.setNull(a + 1, Types.NULL);
            } else {
                preparedStatement.setObject(a + 1, data);
            }
        }

        if (query.replaceAll("^\\s+", "").matches("(?is)^SELECT\\b.*")) return (T) preparedStatement.executeQuery();

        return (T) ((Integer) preparedStatement.executeUpdate());
    }

    @SuppressWarnings({ "unchecked" })
    public <T, U> T execute (final String query, List<U> binds) throws SQLException {
        final PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        final int dataLength = binds.size();

        for (int a = 0; a < dataLength; a++) {
            final Object data = binds.get(a);

            if (data == null) {
                preparedStatement.setNull(a + 1, Types.NULL);
            } else {
                preparedStatement.setObject(a + 1, data);
            }
        }

        if (query.replaceAll("^\\s+", "").matches("(?is)^SELECT\\b.*")) return (T) preparedStatement.executeQuery();

        return (T) ((Integer) preparedStatement.executeUpdate());
    }

    public long executeWithGeneratedKeys (String query, Object... binds) throws SQLException {
        final PreparedStatement preparedStatement = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        final int dataLength = binds.length;

        for (int a = 0; a < dataLength; a++) {
            final Object data = binds[a];

            if (data == null) {
                preparedStatement.setNull(a + 1, Types.NULL);
            } else {
                preparedStatement.setObject(a + 1, data);
            }
        }

        final int affectedRows = preparedStatement.executeUpdate();

        if (affectedRows == 0) throw new SQLException("No rows affected.");

        final ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

        if (!generatedKeys.next()) throw new SQLException("No ID obtained.");

        return generatedKeys.getLong(1);
    }
}