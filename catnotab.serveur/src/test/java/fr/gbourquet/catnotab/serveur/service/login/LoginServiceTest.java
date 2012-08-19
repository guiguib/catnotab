package fr.gbourquet.catnotab.serveur.service.login;

import junit.framework.TestCase;
import fr.gbourquet.catnotab.serveur.metier.Personne;
import fr.gbourquet.catnotab.serveur.service.LoginService;
import fr.gbourquet.catnotab.serveur.service.Exception.ServiceException;
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
 
        try {
        	Personne util = service.login("admin", "admin");
        	//test
            assertNotNull(util);
            assertNotNull(util.getNom());
            }
        catch (ServiceException e)
        {
        	fail();
        }
    }
}
