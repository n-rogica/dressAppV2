package dressapp.users

import grails.testing.gorm.DomainUnitTest
import grails.testing.web.controllers.ControllerUnitTest
import grails.validation.ValidationException
import spock.lang.*

class BodyDescriptionControllerSpec extends Specification implements ControllerUnitTest<BodyDescriptionController>, DomainUnitTest<BodyDescription> {

    def populateValidParams(params) {
        assert params != null

        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
        assert false, "TODO: Provide a populateValidParams() implementation for this generated test suite"
    }

    void "Test the index action returns the correct model"() {
        given:
        controller.bodyDescriptionService = Mock(BodyDescriptionService) {
            1 * list(_) >> []
            1 * count() >> 0
        }

        when:"The index action is executed"
        controller.index()

        then:"The model is correct"
        !model.bodyDescriptionList
        model.bodyDescriptionCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
        controller.create()

        then:"The model is correctly created"
        model.bodyDescription!= null
    }

    void "Test the save action with a null instance"() {
        when:"Save is called for a domain instance that doesn't exist"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'POST'
        controller.save(null)

        then:"A 404 error is returned"
        response.redirectedUrl == '/bodyDescription/index'
        flash.message != null
    }

    void "Test the save action correctly persists"() {
        given:
        controller.bodyDescriptionService = Mock(BodyDescriptionService) {
            1 * save(_ as BodyDescription)
        }

        when:"The save action is executed with a valid instance"
        response.reset()
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'POST'
        populateValidParams(params)
        def bodyDescription = new BodyDescription(params)
        bodyDescription.id = 1

        controller.save(bodyDescription)

        then:"A redirect is issued to the show action"
        response.redirectedUrl == '/bodyDescription/show/1'
        controller.flash.message != null
    }

    void "Test the save action with an invalid instance"() {
        given:
        controller.bodyDescriptionService = Mock(BodyDescriptionService) {
            1 * save(_ as BodyDescription) >> { BodyDescription bodyDescription ->
                throw new ValidationException("Invalid instance", bodyDescription.errors)
            }
        }

        when:"The save action is executed with an invalid instance"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'POST'
        def bodyDescription = new BodyDescription()
        controller.save(bodyDescription)

        then:"The create view is rendered again with the correct model"
        model.bodyDescription != null
        view == 'create'
    }

    void "Test the show action with a null id"() {
        given:
        controller.bodyDescriptionService = Mock(BodyDescriptionService) {
            1 * get(null) >> null
        }

        when:"The show action is executed with a null domain"
        controller.show(null)

        then:"A 404 error is returned"
        response.status == 404
    }

    void "Test the show action with a valid id"() {
        given:
        controller.bodyDescriptionService = Mock(BodyDescriptionService) {
            1 * get(2) >> new BodyDescription()
        }

        when:"A domain instance is passed to the show action"
        controller.show(2)

        then:"A model is populated containing the domain instance"
        model.bodyDescription instanceof BodyDescription
    }

    void "Test the edit action with a null id"() {
        given:
        controller.bodyDescriptionService = Mock(BodyDescriptionService) {
            1 * get(null) >> null
        }

        when:"The show action is executed with a null domain"
        controller.edit(null)

        then:"A 404 error is returned"
        response.status == 404
    }

    void "Test the edit action with a valid id"() {
        given:
        controller.bodyDescriptionService = Mock(BodyDescriptionService) {
            1 * get(2) >> new BodyDescription()
        }

        when:"A domain instance is passed to the show action"
        controller.edit(2)

        then:"A model is populated containing the domain instance"
        model.bodyDescription instanceof BodyDescription
    }


    void "Test the update action with a null instance"() {
        when:"Save is called for a domain instance that doesn't exist"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'PUT'
        controller.update(null)

        then:"A 404 error is returned"
        response.redirectedUrl == '/bodyDescription/index'
        flash.message != null
    }

    void "Test the update action correctly persists"() {
        given:
        controller.bodyDescriptionService = Mock(BodyDescriptionService) {
            1 * save(_ as BodyDescription)
        }

        when:"The save action is executed with a valid instance"
        response.reset()
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'PUT'
        populateValidParams(params)
        def bodyDescription = new BodyDescription(params)
        bodyDescription.id = 1

        controller.update(bodyDescription)

        then:"A redirect is issued to the show action"
        response.redirectedUrl == '/bodyDescription/show/1'
        controller.flash.message != null
    }

    void "Test the update action with an invalid instance"() {
        given:
        controller.bodyDescriptionService = Mock(BodyDescriptionService) {
            1 * save(_ as BodyDescription) >> { BodyDescription bodyDescription ->
                throw new ValidationException("Invalid instance", bodyDescription.errors)
            }
        }

        when:"The save action is executed with an invalid instance"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'PUT'
        controller.update(new BodyDescription())

        then:"The edit view is rendered again with the correct model"
        model.bodyDescription != null
        view == 'edit'
    }

    void "Test the delete action with a null instance"() {
        when:"The delete action is called for a null instance"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'DELETE'
        controller.delete(null)

        then:"A 404 is returned"
        response.redirectedUrl == '/bodyDescription/index'
        flash.message != null
    }

    void "Test the delete action with an instance"() {
        given:
        controller.bodyDescriptionService = Mock(BodyDescriptionService) {
            1 * delete(2)
        }

        when:"The domain instance is passed to the delete action"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'DELETE'
        controller.delete(2)

        then:"The user is redirected to index"
        response.redirectedUrl == '/bodyDescription/index'
        flash.message != null
    }
}






