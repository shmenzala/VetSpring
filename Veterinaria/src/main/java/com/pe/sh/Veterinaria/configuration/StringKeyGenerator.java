/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.configuration;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 *
 * @author shmen
 */
public class StringKeyGenerator implements IdentifierGenerator{

    private String sqcName;
    
    @Override
    public Serializable generate(SharedSessionContractImplementor ssci, Object o) throws HibernateException {
        Connection connection = ssci.connection();
        PreparedStatement ps = null;
        String result = "";
        
        try {
            // Oracle-specific code to query a sequence
            ps = connection.prepareStatement("SELECT " + sqcName + ".nextval AS PERSONA_PK FROM dual");
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int pk = rs.getInt("PERSONA_PK");

                // Convert to a String
                result = "CL" + Integer.toString(pk);
            }
        } catch (SQLException e) {
            throw new HibernateException("No se puede generar la Primary Key.");
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new HibernateException("incapaz de cerrar Prepared Statement.");
                }
            }
        }
        return result;
    }
    
}
