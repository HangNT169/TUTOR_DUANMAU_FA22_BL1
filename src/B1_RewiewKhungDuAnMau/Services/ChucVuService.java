/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.ChucVu;
import java.util.List;

/**
 *
 * @author hangnt
 */
public interface ChucVuService {

    List<ChucVu> getAll();

    ChucVu getOne(String id);

    String add(ChucVu chucVu);

    String update(String id, ChucVu chucVu);

    String delete(String id);
    
}
