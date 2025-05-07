//CRIADO E COMENTADO POR MATHEUS DE OLIVEIRA MEDEIROS

package org.example.dao;

import org.example.infra.ConnectionFactory;
import org.example.model.Categoria;
import org.example.model.Despesa;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class DespesaDAO implements IDespesaDAO {

    // criação do metodo save

    @Override
    public Despesa save(Despesa despesa) {
        //conexão com o banco
        try (Connection connection = ConnectionFactory.getConnection()) {
            //criação da query
            String sql = "insert into despesas (descricao, valor, data, categoria) values (?, ?, ?, ?)";
            //preparando a query
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //setando os parametros
            preparedStatement.setString(1, despesa.getDescricao());
            preparedStatement.setDouble(2, despesa.getValor());
            preparedStatement.setDate(3, java.sql.Date.valueOf(despesa.getData()));
            preparedStatement.setString(4, despesa.getCategoria().toString());
            //executando
            preparedStatement.executeUpdate();
            //recuperando o id
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            //setando o id
            long generatedId = resultSet.getLong("id");
            despesa.setId(generatedId);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return despesa;
    }

    // criação do metodo update

    @Override
    public Despesa update(Despesa despesa) {
        //conexão com o banco
        try (Connection connection = ConnectionFactory.getConnection()) {
            //criação da query
            String sql = "update despesas set descricao = ?, valor = ?, data = ?, categoria = ? where id = ?";
            //preparando a query
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //setando os parametros
            preparedStatement.setString(1, despesa.getDescricao());
            preparedStatement.setDouble(2, despesa.getValor());
            preparedStatement.setDate(3, java.sql.Date.valueOf(despesa.getData()));
            preparedStatement.setString(4, despesa.getCategoria().toString());
            preparedStatement.setLong(5, despesa.getId());
            //executando
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return despesa;
    }

    // criação do metodo delete

    @Override
    public void delete(Long id) {
        //conexão com o banco
        try (Connection connection = ConnectionFactory.getConnection()) {
            //criação da query
            String sql = "delete from despesas where id = ?";

            //preparando a query
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            //executando
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    // criação do metodo findAll

    @Override
    public List<Despesa> findAll() {
        //criação da query
        String sql = "select id, descricao, data, valor, categoria from despesas";

        List<Despesa> despesas = new ArrayList<>();

        //conexão com o banco
        try (Connection connection = ConnectionFactory.getConnection()) {
            //preparando a query
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //executando
            ResultSet rs = preparedStatement.executeQuery();
            //recuperando os dados
            while (rs.next()) {
                long id = rs.getLong("id");
                String descricao = rs.getString("descricao");
                LocalDate data = rs.getDate("data").toLocalDate();
                double valor = rs.getDouble("valor");
                Categoria categoria = Categoria.valueOf(rs.getString("categoria"));

                //criando o objeto
                Despesa despesa = new Despesa(id, descricao, data, valor, categoria);
                despesas.add(despesa);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return despesas;
    }

    // criação do metodo findById

    @Override
    public Optional<Despesa> findById(Long id) {
        //criação da query
        String sql = "select id, descricao, data, valor, categoria from despesas WHERE id = ?";

         Despesa despesa = null;
        //conexão com o banco
        try (Connection connection = ConnectionFactory.getConnection()) {
            //preparando a query
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            //executando
            ResultSet rs = preparedStatement.executeQuery();
            //recuperando os dados
            while (rs.next()) {
                long pKey = rs.getLong("id");
                String descricao = rs.getString("descricao");
                LocalDate data = rs.getDate("data").toLocalDate();
                double valor = rs.getDouble("valor");
                Categoria categoria = Categoria.valueOf(rs.getString("categoria"));

                despesa = new Despesa(pKey, descricao, data, valor, categoria);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(despesa);

    }

    // criação do metodo findByCategoria

    @Override
    public List<Despesa> findByCategoria(Categoria categoria) {
        //criação da query
        String sql = "select id, descricao, data, valor, categoria from despesas where categoria = ?";

        List<Despesa> despesas = new ArrayList<>();

        //conexão com o banco
        try (Connection connection = ConnectionFactory.getConnection()) {
            //preparando a query
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, categoria.toString());
            //executando
            ResultSet rs = preparedStatement.executeQuery();
            //recuperando os dados
            while (rs.next()) {
                long id = rs.getLong("id");
                String descricao = rs.getString("descricao");
                LocalDate data = rs.getDate("data").toLocalDate();
                double valor = rs.getDouble("valor");
                Categoria cat = Categoria.valueOf(rs.getString("categoria"));

                //criando o objeto
                Despesa despesa = new Despesa(id, descricao, data, valor, cat);
                despesas.add(despesa);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return despesas;

    }
}
