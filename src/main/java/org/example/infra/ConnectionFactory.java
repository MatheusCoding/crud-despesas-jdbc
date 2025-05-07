//CRIADO E COMENTADO POR MATHEUS DE OLIVEIRA MEDEIROS
package org.example.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    //Conexão com o banco de dados PostgreSQL

public class ConnectionFactory {
    private ConnectionFactory() {}
        public static Connection getConnection() {
            try{
                return DriverManager.getConnection("jdbc:postgresql://localhost:5432/DespesasDB", "postgres", "postgres");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
}
