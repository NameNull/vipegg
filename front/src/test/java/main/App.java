package main;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * 招股金服
 * CopyRight : www.zhgtrade.com
 * Author : 林超（362228416@qq.com）
 * Date： 2016-06-22 16:42
 */
public class App {

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        int port = 8880;
        if (args.length > 0) {
            port = Integer.valueOf(args[0]);
        }

        ServletContextHandler servletContext = new ServletContextHandler();
        servletContext.setContextPath("/");

        Server server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(port);
        server.setConnectors(new Connector[] { connector });
        WebAppContext webapp = new WebAppContext();
        webapp.setContextPath("/");

        webapp.setWar("front/src/main/webapp");

//        webapp.setClassLoader(Thread.currentThread().getContextClassLoader());
        webapp.setConfigurationDiscovered(true);
        webapp.setParentLoaderPriority(true);

        HandlerCollection handlerCollection = new HandlerCollection();
        handlerCollection.setHandlers(new Handler[]{webapp, new DefaultHandler()});

        Configuration.ClassList classlist = Configuration.ClassList.setServerDefault( server );
        classlist.addBefore("org.eclipse.jetty.webapp.JettyWebXmlConfiguration", "org.eclipse.jetty.annotations.AnnotationConfiguration" );

        webapp.setAttribute(
                "org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern",
                ".*/[^/]*servlet-api-[^/]*\\.jar$|.*/javax.servlet.jsp.jstl-.*\\.jar$|.*/[^/]*taglibs.*\\.jar$" );


        // save jetty session to mongo
        /*MongoClient mongoClient = new MongoClient("192.168.0.118");
        DBCollection sessions = mongoClient.getDB("test").getCollection("sessions");
        MongoSessionIdManager mongoSessionIdManager = new MongoSessionIdManager(server, sessions);
        mongoSessionIdManager.setWorkerName("node1");
        mongoSessionIdManager.setScavengePeriod(1800);
        server.setSessionIdManager(mongoSessionIdManager);
        MongoSessionManager mongoMgr = new MongoSessionManager();
        mongoMgr.setSessionIdManager(mongoSessionIdManager);
        webapp.setSessionHandler(new SessionHandler(mongoMgr));*/
        server.setHandler(handlerCollection);

        server.start();
        System.out.printf("server started take %d ms, open your in browser http://localhost:%d\n", (System.currentTimeMillis() - startTime), port);
        server.join();

    }

}
