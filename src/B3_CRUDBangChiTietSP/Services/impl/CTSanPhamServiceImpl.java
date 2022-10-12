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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String update(String id, CTSanPham ctsp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<CTSanPhamResponse> getAll() {
        return CTSanPhamRepo.getAll();
    }
    
}
