package picture.of.day.model.repository;

import picture.of.day.model.entity.ImgOfDay;

import java.util.List;

public interface IPictureOfDay {
    void save(ImgOfDay img);
    List<ImgOfDay> findAll();
    ImgOfDay findOne(int id);
    void update(ImgOfDay  img);
}
