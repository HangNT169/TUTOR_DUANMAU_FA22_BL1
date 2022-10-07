/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitories.impl;

import DomainModels.ChucVu;
import Responsitories.ChucVuRepository;
import Utilities.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hangnt
 */
public class ChucVuRepositoryImpl implements ChucVuRepository {

    @Override
    public List<ChucVu> getAll() {
        String query = """
                       SELECT Id, Ma, Ten
                       FROM FINALASS_FPTShop_SP22_BL2_DUNGNA29.dbo.ChucVu;  
                       """;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<ChucVu> listChucVu = new ArrayList<>();
            while (rs.next()) {
                ChucVu chucVu = new ChucVu(rs.getString(1), rs.getString(2), rs.getString(3));
                listChucVu.add(chucVu);
            }
            return listChucVu;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public ChucVu getOne(String id) {
        String query = """
                       SELECT Id, Ma, Ten
                       FROM FINALASS_FPTShop_SP22_BL2_DUNGNA29.dbo.ChucVu;
                       WHERE id = ?
                       """;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ChucVu chucVu = new ChucVu(rs.getString(1), rs.getString(2), rs.getString(3));
                return chucVu;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean add(ChucVu chucVu) {
        int check = 0;
        String sql = """
                    INSERT INTO FINALASS_FPTShop_SP22_BL2_DUNGNA29.dbo.ChucVu
                    (Ma, Ten)
                    VALUES(?, ?);
                    """;

        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, chucVu.getMa());
            ps.setObject(2, chucVu.getTen());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean update(String id, ChucVu chucVu) {
        int check = 0;
        String sql = """
                    UPDATE FINALASS_FPTShop_SP22_BL2_DUNGNA29.dbo.ChucVu
                    SET Ma= ?, Ten=?
                    WHERE Id=?;
                    """;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, chucVu.getMa());
            ps.setObject(2, chucVu.getTen());
            ps.setObject(3, id);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean delete(String id) {
        int check = 0;
        String sql = """
                    DELETE FROM FINALASS_FPTShop_SP22_BL2_DUNGNA29.dbo.ChucVu
                    WHERE Id=?;
                    """;

        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

}
