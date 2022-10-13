/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import DomainModels.DongSanPham;
import Responsitories.DongSanPhamRepository;
import Responsitories.impl.DongSanPhamRepositoryImpl;
import Services.DongSanPhamService;
import java.util.List;

/**
 *
 * @author lucif
 */
public class DongSanPhamServiceImpl implements DongSanPhamService{

    DongSanPhamRepository DongSPRepo = new DongSanPhamRepositoryImpl();
    
    @Override
    public List<DongSanPham> getAll() {
       return DongSPRepo.getAll();
    }
    
}
