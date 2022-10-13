/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import DomainModels.ChucVu;
import Responsitories.ChucVuRepository;
import Responsitories.impl.ChucVuRepositoryImpl;
import Services.ChucVuService;
import java.util.List;

/**
 *
 * @author hangnt
 */
public class ChucVuServiceImpl implements ChucVuService {

    private ChucVuRepository chucVuRepository = new ChucVuRepositoryImpl();

    @Override
    public List<ChucVu> getAll() {
        return chucVuRepository.getAll();
    }

    @Override
    public ChucVu getOne(String id) {
        return chucVuRepository.getOne(id);
    }

    @Override
    public String add(ChucVu chucVu) {
        boolean addChucVu = chucVuRepository.add(chucVu);
        if(addChucVu){
            return "Thêm thành công";
        }
        return "Thêm thất bại";
    }

    @Override
    public String update(String id, ChucVu chucVu) {
        boolean updateChucVu = chucVuRepository.update(id, chucVu);
        if(updateChucVu){
            return "Sửa thành công id"+ id ;
        }
        return "Sửa thất bại";
    }

    @Override
    public String delete(String id) {
        boolean deleteChucVu = chucVuRepository.delete(id);
        if(deleteChucVu){
            return "Xóa thành công id"+ id ;
        }
        return "Xóa thất bại";
    }

}
