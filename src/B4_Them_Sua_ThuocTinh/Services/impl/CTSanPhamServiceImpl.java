/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import DomainModels.CTSanPham;
import Responsitories.CTSanPhamRepository;
import Responsitories.impl.CTSanPhamRepositoryImpl;
import Services.CTSanPhamService;
import ViewModels.CTSanPhamResponse;
import java.util.List;

/**
 *
 * @author lucif
 */
public class CTSanPhamServiceImpl implements CTSanPhamService{
    
    CTSanPhamRepository CTSanPhamRepo = new CTSanPhamRepositoryImpl();
    
    

    @Override
    public CTSanPham getOne(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String add(CTSanPham ctsp) {
        boolean addCTSanPham = CTSanPhamRepo.add(ctsp);
        if(addCTSanPham){
            return "Thêm thành công";
        }
        return "Thêm thất bại";
    }

    @Override
    public String update(String id, CTSanPham ctsp) {
        boolean updateCTSanPham = CTSanPhamRepo.update(id, ctsp);
        if(updateCTSanPham){
            return "Sửa thành công id"+ id ;
        }
        return "Sửa thất bại";
    }

    @Override
    public String delete(String id) {
        boolean deleteCTSanPham = CTSanPhamRepo.delete(id);
        if(deleteCTSanPham){
            return "Xóa thành công id"+ id ;
        }
        return "Xóa thất bại";
    }

    @Override
    public List<CTSanPhamResponse> getAll() {
        return CTSanPhamRepo.getAll();
    }
    
}
