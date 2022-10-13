/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitories;

import DomainModels.ChucVu;
import java.util.List;

/**
 *
 * @author hangnt
 */
public interface ChucVuRepository {

    List<ChucVu> getAll();

    ChucVu getOne(String id);

    boolean add(ChucVu chucVu);

    boolean update(String id, ChucVu chucVu);

    boolean delete(String id);

}
