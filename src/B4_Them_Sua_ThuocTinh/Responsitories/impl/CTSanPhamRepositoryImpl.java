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
                       SELECT dbo.ChiTietSP.Id, dbo.DongSP.Ten, dbo.ChiTietSP.NamBH, dbo.ChiTietSP.MoTa, dbo.ChiTietSP.SoLuongTon, dbo.ChiTietSP.GiaNhap, dbo.ChiTietSP.GiaBan, dbo.MauSac.Ten AS Expr1
                       FROM     dbo.ChiTietSP INNER JOIN
                                         dbo.DongSP ON dbo.ChiTietSP.IdDongSP = dbo.DongSP.Id INNER JOIN
                                         dbo.MauSac ON dbo.ChiTietSP.IdMauSac = dbo.MauSac.Id
                       """;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<CTSanPhamResponse> listCTSanPham = new ArrayList<>();
            while (rs.next()) {
                CTSanPhamResponse ctSanPham = new CTSanPhamResponse(rs.getString(1),rs.getString(2) , rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getDouble(6), rs.getDouble(7),rs.getString(8));
                listCTSanPham.add(ctSanPham);
            }
            System.out.println(listCTSanPham.size());
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
        int check = 0 ;
        String sql ="INSERT INTO [dbo].[ChiTietSP]\n" +

"           ([IdDongSP]\n" +
"           ,[NamBH]\n" +
"           ,[MoTa]\n" +
"           ,[SoLuongTon]\n" +
"           ,[GiaNhap]\n" +
"           ,[GiaBan]\n" +
"           ,[IdMauSac])\n" +
"     VALUES\n" +
"           (?,?,?,?,?,?,?)";
        try(Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ctSanPham.getIdDongSP());
            ps.setObject(2, ctSanPham.getNamBH());
            ps.setObject(3, ctSanPham.getMoTa());
            ps.setObject(4, ctSanPham.getSoLuongTon());
            ps.setObject(5, ctSanPham.getGiaNhap());
            ps.setObject(6, ctSanPham.getGiaBan());
            ps.setObject(7, ctSanPham.getIdMauSac());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check >0;
    }

    @Override
    public boolean update(String id, CTSanPham ctSanPham) {
       int check = 0 ;
        String sql ="UPDATE [dbo].[ChiTietSP]\n" +
"   SET \n" +
"      [IdDongSP] = ? \n" +
"      ,[NamBH] = ?\n" +
"      ,[MoTa] = ?\n" +
"      ,[SoLuongTon] = ?\n" +
"      ,[GiaNhap] = ?\n" +
"      ,[GiaBan] = ?\n" +
      "      ,[IdMauSac] = ?\n" +
" WHERE Id= ?";
        try(Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ctSanPham.getIdDongSP());
            ps.setObject(2, ctSanPham.getNamBH());
            ps.setObject(3, ctSanPham.getMoTa());
            ps.setObject(4, ctSanPham.getSoLuongTon());
            ps.setObject(5, ctSanPham.getGiaNhap());
            ps.setObject(6, ctSanPham.getGiaBan());
            ps.setObject(7, ctSanPham.getIdMauSac());
            ps.setObject(8, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check >0;
    }

    @Override
    public boolean delete(String id) {
       int check = 0 ;
        String sql ="DELETE FROM [dbo].[ChiTietSP]\n" +
"      WHERE Id = ?";
        try(Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check >0;
    }
    
}
