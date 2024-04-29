package com.dao.impl;

import com.entity.Country;
import com.dao.inter.AbstractDao;
import com.dao.inter.CountryDaoInter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import lombok.SneakyThrows;

public class CountryDaoImpl extends AbstractDao implements CountryDaoInter {

    @SneakyThrows
    private Country getCountry(ResultSet rs){
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String nationality = rs.getString("nationality");

        return new Country(id, name, nationality);
    }
    
    @Override
    public List<Country> getAllCountry() {
        List<Country> res = new ArrayList<>();

        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select * from country");
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                Country u = getCountry(rs);

                res.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return res;
    }
}
