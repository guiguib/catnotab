package fr.gbourquet.catnotab.serveur.service.login;

import junit.framework.TestCase;
import fr.gbourquet.catnotab.serveur.metier.Personne;
import fr.gbourquet.catnotab.serveur.service.login.LoginService;
import fr.gbourquet.catnotab.serveur.util.BeanFactory;


public class LoginServiceTest extends TestCase {
	 
    private LoginService service;
 
    public LoginServiceTest(){
    }
 
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
 
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        
        service = (LoginService) BeanFactory.getInstance().getService("loginService");
    }
 
    public void testGetUtilisateur(){
 
        Personne util = service.login("identifiant", "12345");
        
        //test
        assertNotNull(util);
        assertNotNull(util.getNom());
        assertEquals(0,util.getIdPersonne().intValue());
                
    }
}
