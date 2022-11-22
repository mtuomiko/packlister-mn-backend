package com.mtuomiko.packlister.dao.repository
//
//import jakarta.inject.Singleton
//import org.hibernate.Session
//import javax.persistence.EntityManager
//import javax.persistence.PersistenceContext
//
///**
// * Avoiding save functions, based on hibernate-types Spring Repository.
// * @see <a href="https://github.com/vladmihalcea/hibernate-types/blob/master/hibernate-types-60/src/main/java/com/vladmihalcea/spring/repository/HibernateRepositoryImpl.java">HibernateRepositoryImpl.java</a>
// */
//@Singleton
//class HibernateRepositoryImpl<T>(
////    @PersistenceContext
//    private val entityManager: EntityManager
//) : HibernateRepository<T> {
//    override fun <S : T> persist(entity: S): S {
//        entityManager.persist(entity)
//        return entity
//    }
//
//    override fun <S : T> persistAndFlush(entity: S): S {
//        persist(entity)
//        entityManager.flush()
//        return entity
//    }
//
//    override fun <S : T> persistAll(entities: Iterable<S>) = entities.map { persist(it) }
//
//    override fun <S : T> persistAllAndFlush(entities: Iterable<S>): List<S> {
//        val result = entities.map { persist(it) }
//        entityManager.flush()
//        return result
//    }
//
//    override fun <S : T> update(entity: S): S {
//        session().update(entity)
//        return entity
//    }
//
//    override fun <S : T> updateAll(entities: Iterable<S>) = entities.map { update(it) }
//
//    // improve: batch size operations with flush?
//
//    fun session(): Session = entityManager.unwrap(Session::class.java)
//}
//
