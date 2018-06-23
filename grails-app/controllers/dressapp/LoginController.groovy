package dressapp

import grails.config.Config
import grails.core.support.GrailsConfigurationAware

class LoginController extends grails.plugin.springsecurity.LoginController implements GrailsConfigurationAware {

    List<String> coordinatePositions

    def auth() {

        def conf = getConf()

        if (springSecurityService.isLoggedIn()) {
            redirect uri: conf.successHandler.defaultTargetUrl
            return
        }

        String postUrl = request.contextPath + conf.apf.filterProcessesUrl
        render view: 'auth', model: [postUrl: postUrl,
                                     rememberMeParameter: conf.rememberMe.parameter,
                                     usernameParameter: conf.apf.usernameParameter,
                                     passwordParameter: conf.apf.passwordParameter,
                                     gspLayout: conf.gsp.layoutAuth]
    }

    def showImage() {
        File file = new File('src/main/webapp/wardrobe.png') /*si le saco mas cosas al path no lo encuentra*/
        /*response es una variable propia del controller que provee groovy, hay distintos tipos, model, message, flash, cada una tiene una función diferente*/
        response.setHeader('Cache-Control', 'no-cache') /*esto creo que se puede modificar, vi distintos ejemplos con distintas cosas en el header*/
        response.contentType = '/image/jpeg' /*adaptar al tipo necesario*/
        response.outputStream << file.bytes
        response.outputStream.flush()

        /* en el .gsp se agrega la siguiente linea:
          <img src="${createLink(controller: 'home', action: 'showImage')}"/>
          */
    }

    @Override
    void setConfiguration(Config co) {
        coordinatePositions = co.getProperty('security.coordinate.positions', List, []) as List<String>

    }
}