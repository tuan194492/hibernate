package com.example.demo3.dao;

import com.example.demo3.model.Lop;

import java.util.List;

public interface LopDAO {
    List<Lop> getAllLop();
    void themLop(Lop lop);
    void xoaLop(Lop lop);
    Lop getLopById(int id);
    void updateLop(Lop lop);
}
