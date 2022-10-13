/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.CTSanPham;
import ViewModels.CTSanPhamResponse;
import java.util.List;

/**
 *
 * @author lucif
 */
public interface CTSanPhamService {
    List<CTSanPhamResponse> getAll();

    CTSanPham getOne(String id);

    String add(CTSanPham ctsp);

    String update(String id, CTSanPham ctsp);

    String delete(String id);
}
