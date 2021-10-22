package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import utils.HibernateUtils;


/**
 * Application Lifecycle Listener implementation class HibernateManager
 *
 */
@WebListener
public class HibernateManager implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public HibernateManager() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
      System.out.println("in destory of listener");
      HibernateUtils.getSf().close();
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	 System.out.println("in initial of listener");
    	HibernateUtils.getSf();
    }
	
}
