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

    @Override
    void setConfiguration(Config co) {
        coordinatePositions = co.getProperty('security.coordinate.positions', List, []) as List<String>

    }
}