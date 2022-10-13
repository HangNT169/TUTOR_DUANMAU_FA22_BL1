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
                       FROM FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041.dbo.ChucVu;  
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
                       FROM FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041.dbo.ChucVu;
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
    public boolean add(ChucVu chucVu){
        int check = 0 ;
        String sql ="INSERT INTO [dbo].[ChucVu]\n" +
"           ([Ma]\n" +
"           ,[Ten])\n" +
"     VALUES\n" +
"           (?,?)";
        try(Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, chucVu.getMa());
            ps.setObject(2, chucVu.getTen());
            check = ps.executeUpdate();
            //Nếu câu query thành công thì check =1
            //Trả ra 1 khi thành công và 0 khi thất bại
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        //Nếu thành công thì check >1 
            //return 1>0; = return true;
        //Nếu thất bại thì check 0=0
            //Return 0>0 ; = return false;
        return check >0;
    }

    @Override
    public boolean update(String id, ChucVu chucVu) {
        int check = 0 ; 
        String sql = "UPDATE [dbo].[ChucVu]\n" +
"   SET [Ma] = ? \n" +
"      ,[Ten] = ?\n" +
" WHERE id = ?";
        try(Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, chucVu.getMa());
            ps.setObject(2, chucVu.getTen());
            ps.setObject(3, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check >0;
    }

    @Override
    public boolean delete(String id) {
        int check = 0 ; 
        String sql = "DELETE FROM [dbo].[ChucVu]\n" +
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
