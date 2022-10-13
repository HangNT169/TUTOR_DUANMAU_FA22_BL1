/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import DomainModels.MauSac;
import Responsitories.MauSacRepository;
import Responsitories.impl.MauSacRepositoryImpl;
import Services.MauSacService;
import java.util.List;

/**
 *
 * @author lucif
 */
public class MauSacServiceImpl implements MauSacService{
    
    MauSacRepository mauSacRepo = new MauSacRepositoryImpl();
    
    @Override
    public List<MauSac> getAll() {
       return mauSacRepo.getAll();
    }
}
