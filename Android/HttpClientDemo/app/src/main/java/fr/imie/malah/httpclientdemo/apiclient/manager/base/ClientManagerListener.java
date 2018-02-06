package fr.imie.malah.httpclientdemo.apiclient.manager.base;

import fr.imie.malah.httpclientdemo.apiclient.manager.model.ClientManagerResult;

/**
 * Created by malah on 12/12/17.
 */

public interface ClientManagerListener {
    void fireResponse(ClientManagerResult result);
}
