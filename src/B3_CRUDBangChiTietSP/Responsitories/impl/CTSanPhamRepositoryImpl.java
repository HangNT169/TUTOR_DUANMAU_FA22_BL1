/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitories.impl;

import DomainModels.CTSanPham;
import DomainModels.ChucVu;
import Responsitories.CTSanPhamRepository;
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
public class CTSanPhamRepositoryImpl implements CTSanPhamRepository{

    @Override
    public List<CTSanPhamResponse> getAll() {
                String query = """
                       SELECT     dbo.ChiTietSP.Id, dbo.DongSP.Ten, dbo.ChiTietSP.NamBH, dbo.ChiTietSP.MoTa, dbo.ChiTietSP.SoLuongTon, dbo.ChiTietSP.GiaNhap, dbo.ChiTietSP.GiaBan
                       FROM        dbo.ChiTietSP INNER JOIN
                                         dbo.DongSP ON dbo.ChiTietSP.IdDongSP = dbo.DongSP.Id  
                       """;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<CTSanPhamResponse> listCTSanPham = new ArrayList<>();
            while (rs.next()) {
                CTSanPhamResponse ctSanPham = new CTSanPhamResponse(rs.getString(1),rs.getString(2) , rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getDouble(6), rs.getDouble(7));
                listCTSanPham.add(ctSanPham);
            }
            return listCTSanPham;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public CTSanPham getOne(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean add(CTSanPham ctSanPham) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(String id, CTSanPham ctSanPham) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
