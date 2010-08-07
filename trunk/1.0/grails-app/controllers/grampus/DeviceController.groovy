package grampus

import grails.converters.JSON;

class DeviceController {

    def show = { 
		if (params.id) {
			def device = Device.get(params.id as Long)
			if (device) {
				render device as JSON
			} else {
				render (contentType:"text/json") {
					message = "no device ${params.id}!"
				}
			}
		} else {
			def devices = Device.list()
			if (devices) {
				render devices as JSON
			} else {
				render (contentType:"text/json") {
					message = "no device!"
				}
			}
		}
	}
	
	def update = {
		def device = Device.get(params.id as Long)
		if (device) {
			device.properties = params
			if (device.save()) {
				render device as JSON
			} else {
				render device.errors as JSON
			}
		} else {
			render (contentType:"text/json") {
				message = "no device ${params.id}!"
			}
		}
	}
	
	def create = {
		def device = new Device(params)
		if (device.save()) {
			render device as JSON
		} else {
			render device.errors as JSON
		}
	}
	
	def delete = {
		def device = Device.get(params.id as Long)
		if (device) {
			device.delete()
			render (contentType:"text/json") {
				message = "device ${params.id} has been deleted!"
			}
		} else {
			render (contentType:"text/json") {
				message = "no device ${params.id}!"
			}
		}
	}
}
