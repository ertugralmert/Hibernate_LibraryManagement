package com.mert.repository;

import com.mert.entity.User;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.Optional;

public class UserRepository extends Repository<User,Long> {

    public UserRepository() {
        super(new User());
    }

    public Optional<User> findByUserName(String username){

        User user = null;
        CriteriaBuilder criteriaBuilder   = getEm().getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root);
        Predicate predicate = criteriaBuilder.equal(root.get("username"),username);
        criteriaQuery.where(predicate);
        try {
            user=getEm().createQuery(criteriaQuery).getSingleResult();
        }catch (NoResultException exception){
            System.out.println("Kullanıcı bulunamadı");
        }
        return Optional.ofNullable(user);
    }

    public Optional<User> findByUsernameAndPassword(String username, String password){
        openSS();
        User user = null;
        CriteriaBuilder criteriaBuilder   = getEm().getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root);
        Predicate predicate = criteriaBuilder.and(criteriaBuilder.equal(root.get("username"),username),criteriaBuilder.equal(root.get("password"),password));
        criteriaQuery.where(predicate);
        try {
            user=getEm().createQuery(criteriaQuery).getSingleResult();
        }catch (NoResultException exception){
            System.out.println("Kullanıcı bulunamadı");
        }
        return Optional.ofNullable(user);
    }

    public Optional<User> findByUsernameAndPasswordHQL(String username, String password){
        openSS();
        User user = null;
        String hql = "select u from User as u where u.username=:x and u.password=:y";
        TypedQuery<User> typedQuery = getEm().createQuery(hql,User.class);
        typedQuery.setParameter("x",username);
        typedQuery.setParameter("y",password);
        try {
            user=typedQuery.getSingleResult();
        }catch (NoResultException exception){
            System.out.println("Kullanıcı bulunamadı");
        }
        return Optional.ofNullable(user);
    }
}
