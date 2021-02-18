package com.example.springtaco.data;

import com.example.springtaco.entity.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcIngredient implements  IngreditentInterface{
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public JdbcIngredient(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return jdbcTemplate.query("select id , name , type from Ingredient",this::mapRowToIngredIngredient);
    }

    @Override
    public Ingredient findOne(String id) {
        return jdbcTemplate.queryForObject("select id,name ,type from Ingredient where id=?",this::mapRowToIngredIngredient,id);
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
       jdbcTemplate.update("insert into Ingredient(id , name , type ) values (?,?,?)",
               ingredient.getId(),ingredient.getName(),ingredient.getType().toString());
        return ingredient;
    }

    private Ingredient mapRowToIngredIngredient(ResultSet rs , int rowNum) throws SQLException {
        return new Ingredient(rs.getString("id"),rs.getString("name"),Ingredient.Type.valueOf(rs.getString("type")));
    }
}
