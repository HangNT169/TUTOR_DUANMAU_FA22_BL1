/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitories;

import DomainModels.CuaHang;
import ViewModels.CuaHangResponse;
import java.util.List;

/**
 *
 * @author hangnt
 */
public interface CuaHangRepository {

    List<CuaHangResponse> getAll();

    boolean add(CuaHang CuaHang);

    boolean delete(String id);

}
