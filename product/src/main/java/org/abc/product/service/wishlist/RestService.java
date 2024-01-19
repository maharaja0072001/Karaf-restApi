package org.abc.product.service.wishlist;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import org.apache.cxf.BusFactory;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

import org.abc.product.controller.wishlist.WishlistController;

@Component
public class RestService {

    private Server server;

    @Activate
    public void activate() throws Exception {
        JAXRSServerFactoryBean bean = new JAXRSServerFactoryBean();

        bean.setAddress("/wishlist");
        bean.setBus(BusFactory.getDefaultBus());
        bean.setProvider(new JacksonJsonProvider());
        bean.setServiceBean(WishlistController.getInstance());
        server = bean.create();
    }

    @Deactivate
    public void deactivate() throws Exception {
        if (server != null) {
            server.destroy();
        }
    }
}