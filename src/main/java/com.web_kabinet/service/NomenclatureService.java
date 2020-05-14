package com.web_kabinet.service;

import com.web_kabinet.domain.Nomenclature;
import com.web_kabinet.repos.NomenclatureRepo;
import org.springframework.stereotype.Service;

import java.sql.*;

@Service
public class NomenclatureService {
    private NomenclatureRepo nomenclatureRepo;

    public NomenclatureService(NomenclatureRepo nomenclatureRepo) {
        this.nomenclatureRepo = nomenclatureRepo;
    }

    public Nomenclature findNomenclatureByUUID(String nomenclatureId) {

        final String user = "root";
        final String password = "0000";
        final String url = "jdbc:mysql://localhost:3306/wk_db?serverTimezone=UTC";

        Nomenclature nomenclature = null;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM nomenclature where id = (?)");
            statement.setString(1, nomenclatureId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nomenclatureName = resultSet.getString("name");
              nomenclature = new Nomenclature(nomenclatureId, nomenclatureName);
            connection.commit();
            }
            else{
                connection.rollback();
                throw new NullPointerException();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return nomenclature;
    }
}
