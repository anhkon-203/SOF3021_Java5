package com.example.sof3011_java5.service;

import com.example.sof3011_java5.entities.NSX;
import com.example.sof3011_java5.models.NSXViewModel;

import java.util.List;
import java.util.UUID;

public interface NSXService {

    public List<NSXViewModel> getAll();
    public NSX getById(UUID id);
    public boolean saveOrUpdate(NSXViewModel nsxViewModel);
    public boolean deleteById(UUID id);

    public String maNSXCount();


}
