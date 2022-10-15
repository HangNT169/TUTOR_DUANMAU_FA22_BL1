/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import DomainModels.CuaHang;
import Responsitories.impl.CuaHangRepositoryImpl;
import java.util.List;
import Responsitories.CuaHangRepository;
import Services.CuaHangService;
import ViewModels.CuaHangResponse;

/**
 *
 * @author hangnt
 */
public class CuaHangServiceImpl implements CuaHangService {

    private CuaHangRepository CuaHangRepository = new CuaHangRepositoryImpl();

    @Override
    public List<CuaHangResponse> getAll() {
        return CuaHangRepository.getAll();
    }

    @Override
    public String add(CuaHang CuaHang) {
        boolean addCuaHang = CuaHangRepository.add(CuaHang);
        if(addCuaHang){
            return "Thêm thành công";
        }
        return "Thêm thất bại";
    }

    @Override
    public String delete(String id) {
        boolean deleteCuaHang = CuaHangRepository.delete(id);
        if(deleteCuaHang){
            return "Xóa thành công id"+ id ;
        }
        return "Xóa thất bại";
    }

}
