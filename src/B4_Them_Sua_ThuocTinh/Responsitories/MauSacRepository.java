/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Responsitories;

import DomainModels.DongSanPham;
import DomainModels.MauSac;
import java.util.List;

/**
 *
 * @author lucif
 */
public interface MauSacRepository {
    
    List<MauSac> getAll();
}