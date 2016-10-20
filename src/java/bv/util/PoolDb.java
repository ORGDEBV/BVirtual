/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bv.util;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author virtual
 */
public class PoolDb {

    public PoolDb() {
    }

    public Connection getConnection() throws NamingException {
        Connection cn = null;
        try {
            javax.sql.DataSource ds = getCnSQL2012();
            cn = ds.getConnection();
            System.out.println("Hola k ase");
        } catch (SQLException objException) {
            System.out.println("Error: " + objException.getMessage());
        }
        return cn;
    }

    private DataSource getCnSQL2012() throws NamingException {
        Context c = new InitialContext();
        return (DataSource) c.lookup("jdbc/dsSQL");
    }

}
