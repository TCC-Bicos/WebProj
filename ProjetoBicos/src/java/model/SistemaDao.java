package model;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class SistemaDao {

    private EntityManagerFactory conn;
    private EntityManager manager;

    public void conectar() {
        conn = Persistence.createEntityManagerFactory("ProjetoBicosPU");
        manager = conn.createEntityManager();
    }

    public void desconectar() {
        manager.close();
        conn.close();
    }

    public String salvarUser(Tblusuario user) {
        conectar();
        try {
            manager.getTransaction().begin();
            manager.persist(user);
            manager.getTransaction().commit();
            return "salvou";
        } catch (Exception e) {
            return e.getMessage();
        } finally {
            desconectar();
        }
    }

    public String salvarFree(Tblfreelancer Fr) {
        conectar();
        try {
            manager.getTransaction().begin();
            manager.persist(Fr);
            manager.getTransaction().commit();
            return "salvou";
        } catch (Exception e) {
            return e.getMessage();
        } finally {
            desconectar();
        }
    }
    
    public Tblfreelancer buscarFreeId(int idFr) {
        conectar();
        try {
            TypedQuery<Tblfreelancer> query = manager.createNamedQuery("Tblfreelancer.findByIdFr", Tblfreelancer.class);
            query.setParameter("idFr", idFr);
            Tblfreelancer fr = query.getSingleResult();
            return fr;
        } catch (NoResultException ex) {
            return null;
        } finally {
            desconectar();
        }
    }
    
    public List<Tblanunfr> findAllAnunFr() {
        conectar();
        try {
            TypedQuery<Tblanunfr> query = manager.createNamedQuery("Tblanunfr.findAll", Tblanunfr.class);
            List<Tblanunfr> listaAnunFr = query.getResultList();
            return listaAnunFr;
        } catch (NoResultException ex) {
            return null;
        } finally {
            desconectar();
        }
    }
    

    public Tblusuario validarLogin(String eml, String sen) {
        conectar();
        try {
            TypedQuery<Tblusuario> query = manager.createNamedQuery("Tblusuario.findByEmailLogin", Tblusuario.class);
            query.setParameter("email", eml);
            query.setParameter("senha", sen);
            Tblusuario user = query.getSingleResult();
            return user;
        } catch (NoResultException ex) {
            return null;
        } finally {
            desconectar();
        }
    }

    public Tblfreelancer validarLoginFr(String eml, String sen) {
        conectar();
        try {
            TypedQuery<Tblfreelancer> query = manager.createNamedQuery("Tblfreelancer.findByEmailLogin", Tblfreelancer.class);
            query.setParameter("email", eml);
            query.setParameter("senha", sen);
            Tblfreelancer Fr = query.getSingleResult();
            return Fr;
        } catch (NoResultException ex) {
            return null;
        } finally {
            desconectar();
        }
    }

    public Tblusuario buscarUser(String nom, String eml) {
        conectar();
        try {
            TypedQuery<Tblusuario> query = manager.createNamedQuery("Tblusuario.findByEmailNome", Tblusuario.class);
            query.setParameter("nome", nom);
            query.setParameter("email", eml);
            Tblusuario user = query.getSingleResult();
            return user;
        } catch (NoResultException ex) {
            return null;
        } finally {
            desconectar();
        }
    }

    public Tblusuario buscarUserId(int idUser) {
        conectar();
        try {
            TypedQuery<Tblusuario> query = manager.createNamedQuery("Tblusuario.findByIdUser", Tblusuario.class);
            query.setParameter("idUser", idUser);
            Tblusuario user = query.getSingleResult();
            return user;
        } catch (NoResultException ex) {
            return null;
        } finally {
            desconectar();
        }
    }

    public Tblfreelancer buscarFree(String nom, String eml) {
        conectar();
        try {
            TypedQuery<Tblfreelancer> query = manager.createNamedQuery("Tblfreelancer.findByEmailNome", Tblfreelancer.class);
            query.setParameter("nome", nom);
            query.setParameter("email", eml);
            Tblfreelancer fr = query.getSingleResult();
            return fr;
        } catch (NoResultException ex) {
            return null;
        } finally {
            desconectar();
        }
    }

    public Tblusuario alterarUser(Tblusuario usu, String email_antigo) {
        conectar();
        try {
            TypedQuery<Tblusuario> query = manager.createNamedQuery("Tblusuario.findByEmailUser", Tblusuario.class);
            query.setParameter("email", email_antigo);
            Tblusuario user = query.getSingleResult();
            user.setNomeUser(usu.getNomeUser());
            user.setEmailUser(usu.getEmailUser());
            user.setSenhaUser(usu.getSenhaUser());
            user.setTelUser(usu.getTelUser());
            user.setImgUser(usu.getImgUser());
            user.setDescUser(usu.getDescUser());
            manager.getTransaction().begin();
            manager.merge(user);
            manager.getTransaction().commit();
            return user;
        } catch (Exception e) {
            //manager.getTransaction().rollback();
            return null;
        } finally {
            desconectar();
        }
    }
      
    
        public int alterarAnunUser(int id, String n, String t, String desc, double p, String r, Date d) {
        conectar();
        try {
            //TypedQuery<Tblanunuser> query = manager.createNamedQuery("Tblanunuser.findByIdAnunUser", Tblanunuser.class);
            Tblanunuser an = manager.find(Tblanunuser.class, id);
           // query.setParameter("id", id);
            //Tblanunuser an = query.getSingleResult();
            Tbltiposervico ts = an.getNomeServ();
            ts.setNomeServ(n);
            an.setNomeServ(ts);
            an.setTituloAnunUser(t);
            an.setDescAnunUser(desc);
            an.setPrecoAnunUser(p);
            an.setRequisitosAnunUser(r);
            an.setDataAnunUser(d);
            manager.getTransaction().begin();
            manager.merge(an);
            manager.getTransaction().commit();
            return 1;
        } catch (Exception e) {
            //manager.getTransaction().rollback();
            return 0;
        } finally {
            desconectar();
        }
    }
    

    public Tblusuario buscarUserEmlAntigo(String eml) {
        conectar();
        try {
            TypedQuery<Tblusuario> query = manager.createNamedQuery("Tblusuario.findByEmailUser", Tblusuario.class);
            query.setParameter("email", eml);
            Tblusuario user = query.getSingleResult();
            return user;
        } catch (NoResultException ex) {
            return null;
        } finally {
            desconectar();
        }
    }
    
        public Tblfreelancer buscarUserEmlAntigoFr(String eml) {
        conectar();
        try {
            TypedQuery<Tblfreelancer> query = manager.createNamedQuery("Tblfreelancer.findByEmailFr", Tblfreelancer.class);
            query.setParameter("email", eml);
            Tblfreelancer fr = query.getSingleResult();
            return fr;
        } catch (NoResultException ex) {
            return null;
        } finally {
            desconectar();
        }
    }
    

    public String salvarAnunUser(Tblanunuser anunUser) {
        conectar();
        try {
            manager.getTransaction().begin();
            manager.persist(anunUser);
            manager.getTransaction().commit();
            return "salvou";
        } catch (Exception e) {
            return e.getMessage();
        } finally {
            desconectar();
        }
    }

    public String salvarAnunFree(Tblanunfr anunFr) {
        conectar();
        try {
            manager.getTransaction().begin();
            manager.persist(anunFr);
            manager.getTransaction().commit();
            return "salvou";
        } catch (Exception e) {
            return e.getMessage();
        } finally {
            desconectar();
        }
    }

    public Tblanunuser buscarAnun(int id) {
        conectar();
        try {
            //Tblusuario tbId = new Tblusuario();
            //tbId.setIdUser(id);
            TypedQuery<Tblanunuser> query = manager.createNamedQuery("Tblanunuser.findByIdAnunUser", Tblanunuser.class);
            query.setParameter("id", id);
            Tblanunuser anunUser = query.getSingleResult();
            return anunUser;
        } catch (NoResultException ex) {
            return null;
        } finally {
            desconectar();
        }
    }

    public List<Tblanunfr> buscarAnunFr(String pesquisa) {
        conectar();
        try {
            TypedQuery<Tblanunfr> query = manager.createNamedQuery("Tblanunfr.findByTituloAnunFr", Tblanunfr.class);
            query.setParameter("tituloAnunFr", "%" + pesquisa + "%");
            List<Tblanunfr> anunFrList = query.getResultList();
            return anunFrList;
        } catch (NoResultException ex) {
            return null;
        } finally {
            desconectar();
        }
    }

    public List<Tblanunuser> buscarAnunIdUser(int id) {
        conectar();
        try {
            Tblusuario idUser = new Tblusuario();
            idUser.setIdUser(id);
            TypedQuery<Tblanunuser> query = manager.createNamedQuery("Tblanunuser.findByIdUser", Tblanunuser.class);
            query.setParameter("id", idUser);
            List<Tblanunuser> listaAnunUser = query.getResultList();
            return listaAnunUser;
        } catch (NoResultException ex) {
            return null;
        } finally {
            desconectar();
        }
    }

    public List<Tblanunuser> findAllAnunUser() {
        conectar();
        try {
            TypedQuery<Tblanunuser> query = manager.createNamedQuery("Tblanunuser.findAll", Tblanunuser.class);
            List<Tblanunuser> listaAnunUser = query.getResultList();
            return listaAnunUser;
        } catch (NoResultException ex) {
            return null;
        } finally {
            desconectar();
        }
    }

    public Tblanunfr buscarAnunFree(int id) {
        conectar();
        try {
            TypedQuery<Tblanunfr> query = manager.createNamedQuery("Tblanunfr.findByIdAnunFr", Tblanunfr.class);
            query.setParameter("id", id);
            Tblanunfr anunFr = query.getSingleResult();
            return anunFr;
        } catch (NoResultException ex) {
            return null;
        } finally {
            desconectar();
        }
    }

    public List<Tblanunfr> buscarAnunIdFree(int id) {
        conectar();
        try {
            Tblfreelancer idFr = new Tblfreelancer();
            idFr.setIdFr(id);
            TypedQuery<Tblanunfr> query = manager.createNamedQuery("Tblanunfr.findByIdFr", Tblanunfr.class);
            query.setParameter("id", idFr);
            List<Tblanunfr> listaAnunFr = query.getResultList();
            return listaAnunFr;
        } catch (NoResultException ex) {
            return null;
        } finally {
            desconectar();
        }
    }
    
    public String salvarAnunUserFr(Tblanunuserfr anunUserFr) {
        conectar();
        try {
            manager.getTransaction().begin();
            manager.persist(anunUserFr);
            manager.getTransaction().commit();
            return "salvou";
        } catch (Exception e) {
            return e.getMessage();
        } finally {
            desconectar();
        }
    }
        
       public String salvarPrjAnunUser(Tblprojanunuser prjAnunUser) {
        conectar();
        try {
            manager.getTransaction().begin();
            manager.persist(prjAnunUser);
            manager.getTransaction().commit();
            return "salvou";
        } catch (Exception e) {
            return e.getMessage();
        } finally {
            desconectar();
        }
    }
       
       public String salvarNotiFU(TblnotifU notifU) {
        conectar();
        try {
            manager.getTransaction().begin();
            manager.persist(notifU);
            manager.getTransaction().commit();
            return "salvou";
        } catch (Exception e) {
            return e.getMessage();
        } finally {
            desconectar();
        }
    }
       
       public List<TblnotifU> buscarNotiUser(int id) {
        conectar();
        try {
            Tblanunuserfr idAnunUserFr = new Tblanunuserfr();
            idAnunUserFr.setIdAnunUserFr(id);
            TypedQuery<TblnotifU> query = manager.createNamedQuery("TblnotifU.findByIdAnunUserFr", TblnotifU.class);
            query.setParameter("id", idAnunUserFr);
            List<TblnotifU> listaNotifU = query.getResultList();
            return listaNotifU;
        } catch (NoResultException ex) {
            return null;
        } finally {
            desconectar();
        }
    } 
       
       public String salvarAnunFrUser(Tblanunfruser anunFrUser) {
        conectar();
        try {
            manager.getTransaction().begin();
            manager.persist(anunFrUser);
            manager.getTransaction().commit();
            return "salvou";
        } catch (Exception e) {
            return e.getMessage();
        } finally {
            desconectar();
        }
    }
        
       public String salvarPrjAnunFr(Tblprojanunfr prjAnunFr) {
        conectar();
        try {
            manager.getTransaction().begin();
            manager.persist(prjAnunFr);
            manager.getTransaction().commit();
            return "salvou";
        } catch (Exception e) {
            return e.getMessage();
        } finally {
            desconectar();
        }
    }
       
       public String salvarNotiUF(TblnotiuF notiuF) {
        conectar();
        try {
            manager.getTransaction().begin();
            manager.persist(notiuF);
            manager.getTransaction().commit();
            return "salvou";
        } catch (Exception e) {
            return e.getMessage();
        } finally {
            desconectar();
        }
    }
       
       public List<TblnotiuF> buscarNotiFr(int id) {
        conectar();
        try {
            Tblanunfruser idAnunFrUser = new Tblanunfruser();
            idAnunFrUser.setIdAnunFrUser(id);
            TypedQuery<TblnotiuF> query = manager.createNamedQuery("TblnotiuF.findByIdAnunFrUser", TblnotiuF.class);
            query.setParameter("id", idAnunFrUser);
            List<TblnotiuF> listaNotiuF = query.getResultList();
            return listaNotiuF;
        } catch (NoResultException ex) {
            return null;
        } finally {
            desconectar();
        }
    }
       
       public List<Tblanunuserfr> findAllAnunUserFr(int id) {
        conectar();
        try {
            Tblfreelancer idFr = new Tblfreelancer();
            idFr.setIdFr(id);
            TypedQuery<Tblanunuserfr> query = manager.createNamedQuery("Tblanunuserfr.findByIdFr", Tblanunuserfr.class);
            query.setParameter("idFr", idFr);
            List<Tblanunuserfr> listaAnunUserFr = query.getResultList();
            return listaAnunUserFr;
        } catch (NoResultException ex) {
            return null;
        } finally {
            desconectar();
        }
    }
    
    
    /*
    public String salvarOferta(TblofertauF ofertaUser) {
        conectar();
        try {
            manager.getTransaction().begin();
            manager.persist(ofertaUser);
            manager.getTransaction().commit();
            return "salvou";
        } catch (Exception e) {
            return e.getMessage();
        } finally {
            desconectar();
        }
    }


    public Login verificarLogin(String emailFuncionario) {
        conectar();
        Login dadosLoginFuncionario = manager.find(Login.class, emailFuncionario);
        desconectar();
        return dadosLoginFuncionario;
    }

    public void desconectar() {
        manager.close();
        conn.close();
    }

    public int salvarDepartamento(Departamento dep) {
        conectar();
        try {
            manager.getTransaction().begin();
            manager.persist(dep);
            manager.getTransaction().commit();
            return 1;
        } catch (EntityExistsException | RollbackException e) {
            return 2;
        } catch (Exception e) {
            return 3;
        } finally {
            desconectar();
        }
    }

    public int salvarFuncionario(Funcionario func) {
        conectar();
        try {
            manager.getTransaction().begin();
            manager.persist(func);
            manager.getTransaction().commit();
            return 1;
        } catch (EntityExistsException | RollbackException e) {
            return 2;
        } catch (Exception e) {
            return 3;
        } finally {
            desconectar();
        }
    }

    public List<Departamento> buscaDepartamentos() {
        conectar();
        try {
            TypedQuery<Departamento> query = manager.createNamedQuery("Departamento.findAll", Departamento.class);
            List<Departamento> departamentos = query.getResultList();
            return departamentos;
        } catch (NoResultException ex) {
            return null;
        } finally {
            desconectar();
        }
    }

    public List<Funcionario> buscaFuncionarios() {
        conectar();
        try {
            TypedQuery<Funcionario> query = manager.createNamedQuery("Funcionario.findAll", Funcionario.class);
            List<Funcionario> funcionarios = query.getResultList();
            return funcionarios;
        } catch (NoResultException ex) {
            return null;
        } finally {
            desconectar();
        }
    }

    public int excluirDepartamento(String nomeDep) {
        conectar();
        try {
            //localiza o departamento que queremos excluir
            Departamento dep = new Departamento();
            dep = manager.find(Departamento.class, nomeDep);
            //Exclui o departamento localizado
            manager.getTransaction().begin();
            manager.remove(dep);
            manager.getTransaction().commit();
            return 1;
        } catch (Exception ex) {
            return 2;
        } finally {
            desconectar();
        }

    }
     */
}
