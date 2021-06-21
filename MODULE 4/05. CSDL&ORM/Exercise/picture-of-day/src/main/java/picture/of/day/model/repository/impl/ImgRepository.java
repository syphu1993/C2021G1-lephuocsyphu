package picture.of.day.model.repository.impl;

import org.springframework.stereotype.Repository;
import picture.of.day.model.entity.ImgOfDay;
import picture.of.day.model.repository.IPictureOfDay;

import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
public class ImgRepository implements IPictureOfDay {
    @Override
    public void save(ImgOfDay img) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(img);
        entityTransaction.commit();
    }

    @Override
    public List<ImgOfDay> findAll() {
        return BaseRepository.entityManager.createQuery("select i from ImgOfDay i",ImgOfDay.class).getResultList();
    }

    @Override
    public ImgOfDay findOne(int id) {
        return BaseRepository.entityManager.find(ImgOfDay.class,id);
    }

    @Override
    public void update(ImgOfDay img) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(img);
        entityTransaction.commit();
    }

}
