/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitories.impl;

import DomainModels.CuaHang;
import Utilities.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Responsitories.CuaHangRepository;
import ViewModels.CuaHangResponse;

/**
 *
 * @author hangnt
 */
public class CuaHangRepositoryImpl implements CuaHangRepository {

    @Override
    public List<CuaHangResponse> getAll() {
        String query = """
                       SELECT [Id]
                             ,[Ma]
                             ,[Ten]
                             ,[DiaChi]
                             ,[ThanhPho]
                             ,[QuocGia]
                         FROM [dbo].[CuaHang]  
                       """;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<CuaHangResponse> listCuaHang = new ArrayList<>();
            while (rs.next()) {
                CuaHangResponse cuaHangResponse = new CuaHangResponse(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
                listCuaHang.add(cuaHangResponse);
            }
            return listCuaHang;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    @Override
    public boolean add(CuaHang CuaHang){
        int check = 0 ;
        String sql ="INSERT INTO [dbo].[CuaHang]\n" +
"           ([Ma]\n" +
"           ,[Ten]\n" +
"           ,[DiaChi]\n" +
"           ,[ThanhPho]\n" +
"           ,[QuocGia])\n" +
"     VALUES\n" +
"           (?,?,?,?,?)";
        try(Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, CuaHang.getMa());
            ps.setObject(2, CuaHang.getTen());
            ps.setObject(3, CuaHang.getDiaChi());
            ps.setObject(4, CuaHang.getThanhPho());
            ps.setObject(5, CuaHang.getQuocGia());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check >0;
    }

    @Override
    public boolean delete(String id) {
        int check = 0 ; 
        String sql = "DELETE FROM [dbo].[CuaHang]\n" +
"      WHERE id = ?";
        try(Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check >0;
    }

}
