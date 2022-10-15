/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.CuaHang;
import ViewModels.CuaHangResponse;
import java.util.List;

/**
 *
 * @author hangnt
 */
public interface CuaHangService {

    List<CuaHangResponse> getAll();

    String add(CuaHang CuaHang);

    String delete(String id);
    
}
