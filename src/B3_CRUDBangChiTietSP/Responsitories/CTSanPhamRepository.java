/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Responsitories;

import DomainModels.CTSanPham;
import ViewModels.CTSanPhamResponse;
import java.util.List;

/**
 *
 * @author lucif
 */
public interface CTSanPhamRepository {
    
    List<CTSanPhamResponse> getAll();

    CTSanPham getOne(String id);

    boolean add(CTSanPham ctSanPham);

    boolean update(String id, CTSanPham ctSanPham);

    boolean delete(String id);
    
}
