/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitories.impl;

import DomainModels.DongSanPham;
import Responsitories.DongSanPhamRepository;
import Utilities.DBConnection;
import ViewModels.CTSanPhamResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucif
 */
public class DongSanPhamRepositoryImpl implements DongSanPhamRepository{

    @Override
    public List<DongSanPham> getAll() {
                String query = """
                       SELECT [Id]
                             ,[Ma]
                             ,[Ten]
                         FROM [dbo].[DongSP] 
                       """;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<DongSanPham> listDongSanPham = new ArrayList<>();
            while (rs.next()) {
                DongSanPham dongSanPham = new DongSanPham(rs.getString(1),rs.getString(2),rs.getString(3));
                listDongSanPham.add(dongSanPham);
            }
            return listDongSanPham;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
}
