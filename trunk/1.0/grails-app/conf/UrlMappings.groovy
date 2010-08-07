class UrlMappings {

	static mappings = {
		"/$controller/$action/$id?" (parseRequest:true) {
			action = [GET:"show", PUT:"update", DELETE:"delete", POST:"create"]
		}
	}
}
