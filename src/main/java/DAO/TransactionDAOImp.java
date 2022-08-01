package DAO;

import builders.Account;
import builders.BaseTransaction;
import builders.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TransactionDAOImp {
    public List<Account> getTransactions() {
        Connection cnx=Connect.getConnection();
        List<Transaction> lc = new ArrayList<Transaction>();
        try {
            Statement newST = cnx.createStatement();
            ResultSet rs = newST.executeQuery("Select * from transaction");
            while (rs.next()) {
                Transaction cl = new BaseTransaction(rs.getInt("amount"));

                lc.add(cl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lc;
    }


    public boolean addClient(Account c) {
        Connection cnx=Connect.getConnection();
        Random rand = new Random();
        try {
            PreparedStatement newPST = cnx.prepareStatement("insert into clients values (?,?,?,?,?,?)");
            newPST.setInt(1, rand.nextInt(100000));
            newPST.setString(2, c.getNom());
            newPST.setString(3, c.getPrenom());
            newPST.setString(4, c.getEmail());
            newPST.setString(5, c.getPassword());
            newPST.setString(6, c.getAdresse());
            int success = newPST.executeUpdate();
            if (success == 1) return true;
            if (success == 0) return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateClient(Client c) {
        Connection cnx=Connect.getConnection();
        try {
            PreparedStatement newPST =
                    cnx.prepareStatement("update clients set nom=? , prenom=? where id=?");
            newPST.setString(1, c.getNom());
            newPST.setString(2, c.getPrenom());
            newPST.setInt(3, c.getId());
            int success = newPST.executeUpdate();
            if (success == 1) return true;
            if (success == 0) return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Client getClient(int idc) {
        Connection cnx=Connect.getConnection();
        Client cl = null;
        try {
            Statement newST = cnx.createStatement();
            ResultSet rs = newST.executeQuery("Select * from Clients where id =" + idc);
            while (rs.next()) {
                cl = new Client
                        (rs.getInt("id"),
                                rs.getString("nom"), rs.getString("prenom"), rs.getString("adresse"),
                                rs.getString("email"), rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cl;
    }

    @Override
    public Client getClient(String email , String password) {
        Connection cnx=Connect.getConnection();
        Client cl = null;
        try {
            Statement newST = cnx.createStatement();
            String sql = "Select * from Clients where"
                    + " email = '" + email + "' and password = '" + password + "'";
            ResultSet rs = newST.executeQuery(sql);
            while (rs.next()) {
                cl = new Client
                        (rs.getInt("id"),
                                rs.getString("nom"), rs.getString("prenom"), rs.getString("adresse"),
                                rs.getString("email"), rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cl;
    }

    @Override
    public boolean deleteClient(int idc) {
        Connection cnx=Connect.getConnection();
        try {
            PreparedStatement newPST =
                    cnx.prepareStatement("delete from clients where id=?");
            newPST.setInt(1, idc);
            int success = newPST.executeUpdate();
            if (success == 1) return true;
            if (success == 0) return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
