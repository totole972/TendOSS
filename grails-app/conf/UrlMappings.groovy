class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.${format})?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:'/index')
		"/login/auth"(view:'/index')
        "500"(view:'/error')
	}
}
